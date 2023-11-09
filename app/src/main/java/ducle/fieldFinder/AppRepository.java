package ducle.fieldFinder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Scanner;

import ducle.fieldFinder.models.manager.UserManager;

public class AppRepository {
    private static AppRepository instance;
    private UserManager userManager;

    private Properties configProps;

    private AppRepository(){
        userManager = new UserManager();

        try {
            configProps = new Properties();
            configProps.load(new FileInputStream("config.properties"));
            initOwner();
        } catch (Exception e){
            System.out.println("Database files not found");
            e.printStackTrace();
        }
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

    /**
     * This function reads and loads the owner input/database file
     * */
    private void initOwner() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(configProps.getProperty("INPUT_PATH")+configProps.getProperty("OWNER_DATA")));
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();


        }
    }
}
