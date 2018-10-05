package schoolwork.uofa.curtisgoud.feelsbook;

import android.content.Intent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

//This class allows a static means of changing Views with only
//a single line of code. It expects specific View classes that are
//permissible to be passed in through use of Generics

public final class ViewController {

    public static <T extends AppCompatActivity> boolean  newActivity(Context context,Class<T> activityClass){
        Intent intent = new Intent(context, activityClass);
        try{
            context.startActivity(intent);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public static <T extends AppCompatActivity> boolean  newActivity(Context context,Class<T> activityClass,int f){
        Intent intent = new Intent(context, activityClass);
        //TODO: Android documentation
        intent.putExtra("ARG_IDX",f);
        try{
            context.startActivity(intent);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
