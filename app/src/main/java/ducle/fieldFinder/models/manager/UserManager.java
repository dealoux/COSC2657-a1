package ducle.fieldFinder.models.manager;

import ducle.fieldFinder.models.user.*;

public class UserManager{
    private Manager<Owner> ownerManager;
    private Manager<Customer> customerManager;

    public UserManager(){
        ownerManager = new Manager<>();
        customerManager = new Manager<>();
    }

    public Manager<Owner> getOwnerManager() {
        return ownerManager;
    }

    public Manager<Customer> getCustomerManager() {
        return customerManager;
    }

    public String addOwner(Owner owner){
        return ownerManager.add(owner);
    }

    public String addCustomer(Customer customer){
        return customerManager.add(customer);
    }

    public String nextOwnerId(){
        return "OWN_" + String.format("%04d", ownerManager.getMap().size() + 1);
    }

    public String nextCustomerId(){
        return "CUS_" + String.format("%04d", customerManager.getMap().size() + 1);
    }

    /**
     * This function searches all maps to try and find the user with the given id.
     * Returns the User instance if found, otherwise returns null
     * @param username username for searching
     * */
    public User searchUserByUsername(String username){
        for(Customer user : customerManager.getMap().values()){
            if(user.getUsername().equals(username)){
                return user;
            }
        }

        for(Owner user : ownerManager.getMap().values()){
            if(user.getUsername().equals(username)){
                return user;
            }
        }

        return null;
    }

    /**
     * This function validate the given login credentials.
     * Returns the User instance if found, otherwise returns null
     * @param username
     * @param password
     * */
    public User validateLogin(String username, String password){
        User result = null;
        User user = searchUserByUsername(username);

        if(user != null && user.getPassword().equals(password)){
            result = user;
        }

        return result;
    }

    public String print(){
        return ownerManager.print() + customerManager.print();
    }
}
