package ducle.fieldFinder.models.manager;

import java.util.ArrayList;
import java.util.Collection;

import ducle.fieldFinder.models.field.Field;
import ducle.fieldFinder.models.field.Reservation;
import ducle.fieldFinder.models.user.Customer;

public class ReservationManager {
    private Manager<Reservation> manager;

    public ReservationManager(){
        manager = new Manager<>();
    }

    public Manager<Reservation> getManager() {
        return manager;
    }

    public String addReservation(Reservation reservation, Customer customer, Field field){
        customer.getReservationManager().add(reservation);
        field.getReservationManager().add(reservation);
        return manager.add(reservation);
    }

    public String cancelReservation(String id){
        Reservation reservation = manager.get(id);

        if(reservation == null){
            return "Reservation " + id + " not found";
        }

        reservation.getField().getReservationManager().remove(reservation.getId());
        reservation.getCustomer().getReservationManager().remove(reservation.getId());
        manager.remove(reservation.getId());
        reservation.setStatus("Cancelled");
        return "Reservation " + reservation.getId() + " cancelled";
    }

    /**
     * This methods return a list of reservation(s) matching the given status from the given collection
     * @param reservationList reservation collection to filter
     * @param status ["Pending", "Fulfilled", "Cancelled"]
     * */
    public ArrayList<Reservation> filterReservation(Collection<Reservation> reservationList, String status){
        ArrayList<Reservation> result = new ArrayList<>();

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
    public ArrayList<Reservation> filterReservation(String status){
        return filterReservation(manager.getMap().values(), status);
    }
}
