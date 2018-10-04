package schoolwork.uofa.curtisgoud.feelsbook;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import android.app.Activity;
import android.content.Context;
import android.widget.ArrayAdapter;

import com.google.gson.reflect.TypeToken;


public class IOController {

    static ArrayList<Feel> loadFromDisk(){
        try{
            FileInputStream fis = FeelingController.context.openFileInput("feels");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type typeList = new TypeToken<ArrayList<Feel>>(){}.getType();
            return gson.fromJson(reader,typeList);
        } catch(Exception e){

        }
        return null;
    }

    static void saveToDisk(ArrayList<Feel> feels){
        try{
            FileOutputStream fos = FeelingController.context.openFileOutput("feels",0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(feels,osw);
            osw.close();
        } catch(Exception e){

        }
    }
}
