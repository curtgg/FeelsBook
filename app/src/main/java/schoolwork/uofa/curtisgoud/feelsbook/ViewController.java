package schoolwork.uofa.curtisgoud.feelsbook;

import android.content.Intent;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;


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
}
