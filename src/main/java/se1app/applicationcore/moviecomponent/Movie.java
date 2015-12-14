package se1app.applicationcore.moviecomponent;

import javax.persistence.*;

/**
 * Created by srs on 08.12.15.
 */
@Entity
public class Movie {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique=true)
    private String title;

    private Integer numberOfReservations = 0;

    public Movie()
    {
    }

    public Movie(String title)
    {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void increaseReservationStatistics() {
        numberOfReservations++;
    }

    public Integer getNumberOfReservations() {
        return numberOfReservations;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Movie){
            Movie toCompare = (Movie) o;
            return this.id.equals(toCompare.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return String.format(
                "Movie[id=%d, title='%s']",
                id, title);
    }
}
