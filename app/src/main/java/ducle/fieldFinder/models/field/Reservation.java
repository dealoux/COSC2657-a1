package ducle.fieldFinder.models.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ducle.fieldFinder.models.Entity;
import ducle.fieldFinder.models.user.Customer;

public class Reservation extends Entity {
    public final static List<String> STATUS_LIST = new ArrayList<>(
            Arrays.asList("Pending", "Fulfilled", "Cancelled")
    );

    public final static List<String> TIME_SLOTS = new ArrayList<>(
            Arrays.asList("7:00", "9:00", "11:00", "13:00", "15:00", "17:00", "19:00", "21:00")
    );

    private Customer customer;
    private Field field;
    private String slot;
    private String cost;
    private String status;

    public Reservation(String id, Customer customer, Field field, String slot, String cost) {
        super("REV_" + id);
        this.customer = customer;
        this.field = field;
        this.slot = slot;
        this.cost = cost;
        this.status = STATUS_LIST.get(0);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Field getField() {
        return field;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCost() {
        return cost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
