package ducle.fieldFinder.models.manager;

import java.util.ArrayList;
import java.util.List;

import ducle.fieldFinder.models.user.*;

public class UserManager extends Manager<User>{
    /**
     * This function returns a list of all Customer instances in the map
     */
    public List<Customer> getRegularList(){
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
    public List<Owner> getVIPList(){
        List<Owner> result = new ArrayList<>();

        for(User user : map.values()){
            if(user instanceof Owner){
                result.add((Owner) user);
            }
        }

        return result;
    }
}
