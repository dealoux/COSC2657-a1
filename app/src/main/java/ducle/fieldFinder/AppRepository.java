package ducle.fieldFinder;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Properties;

import ducle.fieldFinder.models.manager.UserManager;
import ducle.fieldFinder.models.user.Owner;

public class AppRepository {
    private static AppRepository instance;
    private UserManager userManager;
    private Properties configProps;

    private AppRepository(){
        userManager = new UserManager();

        initOwner();
//        try {
//            configProps = new Properties();
//            configProps.load(new FileInputStream("src/main/assets/config.properties"));
//            initOwner();
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
    private void initOwner() {
        ArrayList<String> lines = new ArrayList<>();
        readFile(lines, "owners.txt");

        for(String line: lines){
            String[] data = line.trim().split("\\s*,\\s*");
            Log.d("addowner", userManager.add(new Owner(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7])));
        }

        Log.d("printUser", userManager.toString());
    }

    private void readFile(ArrayList<String> lines, String fileName){
        File directory = new File("/data/user/0/ducle.fieldFinder/files");
        File file = new File(directory, fileName);
        FileInputStream inputStream = null;
        try{
            lines.clear();
            inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
