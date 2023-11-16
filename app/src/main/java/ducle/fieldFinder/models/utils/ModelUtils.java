package ducle.fieldFinder.models.utils;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class ModelUtils {
    /**
     * This function reads and loads the given file
     * */
    public static void readFile(ArrayList<String> lines, String path, String fileName){
        File directory = new File(path);
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

    /**
     * This function split and trim the given line
     * */
    public static String[] splitTrimLine(String line){
        String result[] = line.trim().split("\\s*,\\s*");
        for(String s : result){
            Log.d("splitTrimLine", s);
        }
        return result;
    }
}
