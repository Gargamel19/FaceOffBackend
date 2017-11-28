package se1app.applicationcore.customercomponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se1app.applicationcore.moviecomponent.MovieComponentInterface;
import se1app.applicationcore.moviecomponent.MovieNotFoundException;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerComponent implements CustomerComponentInterface {

    // Autowiring durch Constructor-Injection
    private CustomerRepository customerRepository;
    // Autowiring durch Constructor-Injection
    private MovieComponentInterface movieComponentInterface;

    @Autowired
    public CustomerComponent(CustomerRepository customerRepository, MovieComponentInterface movieComponentInterface)
    {
        this.customerRepository = customerRepository;

        // die Abhängigkeit zu der benutzten MovieComponent wird durch Constructor-Injection gesetzt
        this.movieComponentInterface = movieComponentInterface;
    }

    @Override
    public List<Customer> getAllCustomers()
    {
        return customerRepository.findAll();
    }

    @Override
    public void deleteCustomer(int positiveCustomerId)
    {
        if (positiveCustomerId <= 0) {
            throw new IllegalArgumentException("CustomerId must be > 0");
        }
        customerRepository.delete(positiveCustomerId);
    }

    @Override
    public Optional<Customer> getCustomer(int positiveCustomerId)
    {
        if (positiveCustomerId <= 0) {
            throw new IllegalArgumentException("CustomerId must be > 0");
        }
        return Optional.ofNullable(customerRepository.findOne(positiveCustomerId));
    }

    @Override
    public void addCustomer(Customer newCustomer)
    {
        if (newCustomer == null) {
            throw new IllegalArgumentException("Customer must not be null");
        }
        customerRepository.save(newCustomer);
    }

    @Override
    public void updateCustomer(Customer existingCustomer)
    {
        if (existingCustomer == null) {
            throw new IllegalArgumentException("Customer must not be null");
        }
        if (existingCustomer.getId() == 0) {
            throw new IllegalArgumentException("Customer must exist");
        }
        customerRepository.save(existingCustomer);
    }

    @Override
    public void addReservation(int positiveCustomerId, Reservation newReservation) throws CustomerNotFoundException {
        if (positiveCustomerId <= 0) {
            throw new IllegalArgumentException("CustomerId must be > 0");
        }
        if (newReservation == null) {
            throw new IllegalArgumentException("Reservation must not be null");
        }
        if (newReservation.getMovie() == null) {
            throw new IllegalArgumentException("Movie of reservation must not be null");
        }

        Customer customer = customerRepository.findOne(positiveCustomerId);
        if (customer == null) {
            throw new CustomerNotFoundException(positiveCustomerId);
        }
        customer.addReservation(newReservation);
        customerRepository.save(customer);

        // hier rufen wir Funktionalität der MovieComponent auf
        try {
            movieComponentInterface.increaseReservationStatistics(newReservation.getMovie().getTitle());
        }
        catch(MovieNotFoundException ex) {
            // kann nicht passieren, da der Film oben (bei customerRepository.save(customer)) angelegt wird, falls er noch nicht existiert
        }
    }
}
