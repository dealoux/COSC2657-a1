package ducle.fieldFinder.models.user;

import java.util.Date;

import ducle.fieldFinder.models.field.Field;
import ducle.fieldFinder.models.manager.ReservationManager;

public class Customer extends User {
    private ReservationManager reservationManager;

    public Customer(String id, String fName, String lName, String address, String phone, String username, String password) {
        super("CUS_" + id, fName, lName, address, phone, username, password);
        this.reservationManager = new ReservationManager();
    }

    public ReservationManager getReservationManager() {
        return reservationManager;
    }

    public String makeReservation(Field field, String slot, Date date){
        String result = "Failed to make reservation";
        return result;
    }
}
