package ducle.fieldFinder.models.user;

import ducle.fieldFinder.models.field.Centre;
import ducle.fieldFinder.models.manager.Manager;

public class Owner extends User{
    private Manager<Centre> centreManager;

    public Owner(String id, String fName, String lName, String address, String phone, String username, String password) {
        super("OWN_" + id, fName, lName, address, phone, username, password);
        this.centreManager = new Manager<>();
    }

    public Manager<Centre> getCentreManager() {
        return centreManager;
    }
}
