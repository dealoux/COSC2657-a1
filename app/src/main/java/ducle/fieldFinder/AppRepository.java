package ducle.fieldFinder;

import static ducle.fieldFinder.models.utils.ModelUtils.readFile;
import static ducle.fieldFinder.models.utils.ModelUtils.splitTrimLine;

import android.util.Log;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Properties;

import ducle.fieldFinder.models.field.Centre;
import ducle.fieldFinder.models.field.Field;
import ducle.fieldFinder.models.field.Reservation;
import ducle.fieldFinder.models.manager.UserManager;
import ducle.fieldFinder.models.user.Customer;
import ducle.fieldFinder.models.user.Owner;

public class AppRepository {
    private static AppRepository instance;
    private UserManager userManager;
    private Properties configProps;

    private AppRepository(){
        userManager = new UserManager();

        initData();
//        try {
//            configProps = new Properties();
//            configProps.load(new FileInputStream("src/main/assets/config.properties"));
//            initData();
//        }
//        catch (IOException e){
//            System.out.println("Config files not found");
//            e.printStackTrace();
//        }
    }

    /**
     * This function returns the static instance of AppRepository Singleton class
     * */
    public static AppRepository Instance(){
        if(instance == null){
            instance = new AppRepository();
        }

        return instance;
    }

    public UserManager getUserManager() {
        return userManager;
    }

    /**
     * This function reads and loads the owner input/database file
     * */
    private void initData() {
        ArrayList<String> lines = new ArrayList<>();
        readFile(lines, "/data/user/0/ducle.fieldFinder/files", "data.txt");
        ListIterator<String> iterator = lines.listIterator();

        while(iterator.hasNext()){
            String[] data = splitTrimLine(iterator.next());
            String id = data[0];

            if(id.startsWith("OWN")){
                Owner owner = new Owner(id, data[1], data[2], data[3], data[4], data[5], data[6], data[7]);

                int numCentres = Integer.parseInt(data[8]);
                // add centres
                for(int i=0; i < numCentres; i++){
                    data = splitTrimLine(iterator.next());
                    Centre centre = new Centre(data[0], data[1], owner, data[2], data[3], data[4]);

                    int numFields = Integer.parseInt(data[5]);
                    // add fields
                    for(int j=0; j < numFields; j++){
                        data = splitTrimLine(iterator.next());
                        Field field = new Field(data[0], centre, data[1], Float.parseFloat(data[2]), Float.parseFloat(data[3]), Float.parseFloat(data[4]));
                        Log.d("addfield", centre.getFieldManager().add(field));
                    }

                    Log.d("addcentre", owner.getCentreManager().add(centre));
                }
                Log.d("addowner", userManager.add(owner));
            }
            else if(id.startsWith("CUS")) {
                Customer customer = new Customer(id, data[1], data[2], data[3], data[4], data[5], data[6], data[7]);

                int numReservations = Integer.parseInt(data[8]);
                // add reservations
                for (int i = 0; i < numReservations; i++) {
                    data = splitTrimLine(iterator.next());
                    Reservation reservation = new Reservation(data[0], customer, findField(data[1]), data[2], data[3], data[4]);
                    Log.d("addreservation", customer.getReservationManager().add(reservation));
                }

                Log.d("addcustomer", userManager.add(customer));
            }
        }
        Log.d("printUser", userManager.toString());
    }

    /**
     * This function returns the list of all centres
     * */
    public ArrayList<Centre> centresList(){
        ArrayList<Centre> centres = new ArrayList<>();
        for(Owner owner: userManager.getOwnerList()){
            for(Centre centre: owner.getCentreManager().getMap().values()){
                centres.add(centre);
            }
        }
        return centres;
    }

    /**
     * This function returns the list of all fields
     * */
    public ArrayList<Field> fieldsList(){
        ArrayList<Field> fields = new ArrayList<>();
        for(Owner owner: userManager.getOwnerList()){
            for(Centre centre: owner.getCentreManager().getMap().values()){
                for(Field field: centre.getFieldManager().getMap().values()){
                    fields.add(field);
                }
            }
        }
        return fields;
    }

    public Field findField(String id){
        for(Owner owner: userManager.getOwnerList()){
            for(Centre centre: owner.getCentreManager().getMap().values()){
                for(Field field: centre.getFieldManager().getMap().values()){
                    if(field.getId().equals(id)){
                        return field;
                    }
                }
            }
        }
        return null;
    }
}
