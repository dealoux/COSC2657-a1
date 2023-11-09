package ducle.fieldFinder.models.user;

import ducle.fieldFinder.models.field.Field;
import ducle.fieldFinder.models.field.Reservation;
import ducle.fieldFinder.models.manager.Manager;

public class Customer extends User {
    private Manager<Reservation> reservationManager;

    public Customer(String id, String fName, String lName, String address, String phone, String username, String password) {
        super("CUS_" + id, fName, lName, address, phone, username, password);
        this.reservationManager = new Manager<>();
    }

    public Manager<Reservation> getReservationManager() {
        return reservationManager;
    }

    public String makeReservation(Field field, String slot){
        String result = "Failed to make reservation";
        return result;
    }

    public String cancelReservation(String id){
        String result = "Failed to cancel reservation";
        return result;
    }
}
