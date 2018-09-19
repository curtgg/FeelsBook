package schoolwork.uofa.curtisgoud.feelsbook;

import android.content.Intent;
import android.content.Context;


public final class ViewController {

    public static boolean newActivity(Context context,Class activityClass){
        Intent intent = new Intent(context, activityClass);
        try{
            context.startActivity(intent);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}
