package ducle.fieldFinder.models.manager;

import java.util.ArrayList;
import java.util.List;

import ducle.fieldFinder.models.user.*;

public class UserManager extends Manager<User>{
    /**
     * This function returns a list of all Customer instances in the map
     */
    public List<Customer> getCustomerList(){
        List<Customer> result = new ArrayList<>();

        for(User user : map.values()){
            if(user instanceof Customer){
                result.add((Customer) user);
            }
        }

        return result;
    }

    /**
     * This function returns a list of Owner instances in the map
     */
    public List<Owner> getOwnerList(){
        List<Owner> result = new ArrayList<>();

        for(User user : map.values()){
            if(user instanceof Owner){
                result.add((Owner) user);
            }
        }

        return result;
    }

    /**
     * This function searches all maps to try and find the user with the given id.
     * Returns the User instance if found, otherwise returns null
     * @param username username for searching
     * */
    public User searchUserByUsername(String username){
        User result = null;

        for(User user : map.values()){
            if(user.getUsername().equals(username)){
                result = user;
                break;
            }
        }

        return result;
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

    @Override
    public String toString() {
        return "UserManager{" +
                "map=" + map +
                '}';
    }
}
