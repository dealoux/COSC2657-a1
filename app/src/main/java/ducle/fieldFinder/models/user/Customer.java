package ducle.fieldFinder.models.user;

import java.util.Date;

import ducle.fieldFinder.models.field.Field;
import ducle.fieldFinder.models.manager.ReservationManager;

public class Customer extends User {
    private ReservationManager reservationManager;

    public Customer(String id, String fName, String lName, String address, String phone, String dob, String username, String password) {
        super(id, fName, lName, address, phone, dob, username, password);
        prefixId("CUS");
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
