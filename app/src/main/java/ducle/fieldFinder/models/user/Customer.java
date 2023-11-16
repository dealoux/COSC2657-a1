package ducle.fieldFinder.models.user;

import ducle.fieldFinder.models.field.Reservation;
import ducle.fieldFinder.models.manager.Manager;

public class Customer extends User {
    private Manager<Reservation> reservationManager;

    public Customer(String id, String fName, String lName, String address, String phone, String dob, String username, String password) {
        super(id, fName, lName, address, phone, dob, username, password);
        prefixId("CUS");
        this.reservationManager = new Manager<>();
    }

    public Manager<Reservation> getReservationManager() {
        return reservationManager;
    }
}
