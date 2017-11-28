package se1app.applicationcore.customercomponent;

import java.util.List;
import java.util.Optional;

/**
 * Created by srs on 12.12.15.
 */
public interface CustomerComponentInterface {
    /**
     * Liefert alle Customer.
     * @return Liste von Customer, leere Liste, falls keine Customer vorhanden.
     */
    List<Customer> getAllCustomers();

    /**
     * Löscht einen Customer.
     */
    void deleteCustomer(int positiveCustomerId);

    /**
     * Sucht einen Customer.
     */
    Optional<Customer> getCustomer(int positiveCustomerId);

    /**
     * Fügt der Komponente einen Customer hinzu.
     */
    void addCustomer(Customer newCustomer);

    /**
     * Ändert einen vorhandenen Customer.
     */
    void updateCustomer(Customer newCustomer);

    /**
     * Fügt einem Customer eine neue Reservierung hinzu.
     * @param newReservation neue Reservierung, die hinzugefügt werden soll; muss einen
     *                       (vorhandenen oder neuen) Film (Movie) enthalten.
     */
    void addReservation(int positiveCustomerId, Reservation newReservation) throws CustomerNotFoundException;
}
