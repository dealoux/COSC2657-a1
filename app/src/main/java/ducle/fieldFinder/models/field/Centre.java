package ducle.fieldFinder.models.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ducle.fieldFinder.models.Entity;
import ducle.fieldFinder.models.manager.Manager;
import ducle.fieldFinder.models.user.Owner;

public class Centre extends Entity {
    public final static List<String> STATUS_LIST = new ArrayList<>(
            Arrays.asList("Open", "Closed")
    );

    private String name;
    private Owner owner;
    private String address;
    private String phone;
    private String status;
    private Manager<Field> fieldManager;

    public Centre(String id, String name, Owner owner, String address, String phone, String status) {
        super("CTR_" + id);
        this.name = name;
        this.owner = owner;
        this.address = address;
        this.phone = phone;
        this.status = status;
        this.fieldManager = new Manager<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner getOwner() {
        return owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Manager<Field> getFieldManager() {
        return fieldManager;
    }
}
