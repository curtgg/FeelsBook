package schoolwork.uofa.curtisgoud.feelsbook;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import com.google.gson.Gson;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.google.gson.reflect.TypeToken;

//This controller manages solely the read/write of feelings to disk
//This class was separation from the controller to allow
//separation of concerns

public class IOController {


    //Read and write assistance was obtained through the
    //Course labs (Citation #5)
    static ArrayList<Feel> loadFromDisk(){
        try{
            FileInputStream fis = FeelingController.context.openFileInput("feels");
            BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
            Gson gson = new Gson();
            Type typeList = new TypeToken<ArrayList<Feel>>(){}.getType();
            return gson.fromJson(reader,typeList);
        } catch(Exception e){
            Log.d("FeelsIOException",e.toString());
        }
        return new ArrayList<Feel>();
    }

    static void saveToDisk(ArrayList<Feel> feels){
        try{
            FileOutputStream fos = FeelingController.context.openFileOutput("feels",0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(feels,osw);
            osw.close();
        } catch(Exception e){
            Log.d("FeelsIOException",e.toString());
        }
    }
}
