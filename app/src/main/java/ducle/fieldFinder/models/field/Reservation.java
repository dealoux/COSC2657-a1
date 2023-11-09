package ducle.fieldFinder.models.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private Date date; // up to 7 days from today
    private String timeslot;
    private String cost;
    private String status;

    public Reservation(String id, Customer customer, Field field, Date date, String timeslot, String cost) {
        super("REV_" + id);
        this.customer = customer;
        this.field = field;
        this.date = date;
        this.timeslot = timeslot;
        this.cost = cost;
        this.status = STATUS_LIST.get(0);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
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
