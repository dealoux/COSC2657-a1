package ducle.fieldFinder.models.user;

import ducle.fieldFinder.models.field.Centre;
import ducle.fieldFinder.models.manager.Manager;

public class Owner extends User{
    private Manager<Centre> centreManager;

    public Owner(String id, String fName, String lName, String address, String phone, String dob, String username, String password) {
        super(id, fName, lName, address, phone, dob, username, password);
        prefixId("OWN");
        this.centreManager = new Manager<>();
    }

    public Manager<Centre> getCentreManager() {
        return centreManager;
    }

    @Override
    public String print(){
        return super.print() + ", " + centreManager.getMap().size() + "\n" + centreManager.print();
    }
}
