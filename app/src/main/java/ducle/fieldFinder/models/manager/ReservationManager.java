package ducle.fieldFinder.models.manager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ducle.fieldFinder.models.field.Field;
import ducle.fieldFinder.models.field.Reservation;
import ducle.fieldFinder.models.user.Customer;

public class ReservationManager extends Manager<Reservation> {
    /**
     * This methods return a list of reservation(s) matching the given status from the given collection
     * @param reservationList reservation collection to filter
     * @param status ["Pending", "Fulfilled", "Cancelled"]
     * */
    public List<Reservation> filterReservation(Collection<Reservation> reservationList, String status){
        List<Reservation> result = new ArrayList<>();

        for(Reservation reservation : reservationList){
            if(reservation.getStatus().equalsIgnoreCase(status)){
                result.add(reservation);
            }
        }

        return result;
    }

    /**
     * This methods return a list of reservation(s) matching the given status
     * @param status ["Pending", "Fulfilled", "Cancelled"]
     * */
    public List<Reservation> filterReservation(String status){
        return filterReservation(map.values(), status);
    }

    public String cancelReservation(String id){
        String result = "Failed to cancel reservation";
        return result;
    }
}
