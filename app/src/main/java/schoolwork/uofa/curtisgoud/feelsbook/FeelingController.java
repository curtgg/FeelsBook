package schoolwork.uofa.curtisgoud.feelsbook;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class FeelingController {

    private static ArrayList<Feel> feelings = null;
    private static ArrayAdapter<Feel> feelAdapter;

    public FeelingController(Activity activity){
        if(feelings == null) {
            feelings = new ArrayList<>();
            feelAdapter = new ArrayAdapter<Feel>(activity, R.layout.list_layout, feelings);
            //TODO: LOAD FROM DISK, FILL FEELINGS
        }
    }

    public FeelingController(){

    }

    public void setFeelingMessage(Feel feel,String message){
        feel.setFeelingText(message);
    }

    public Feel getFeelingByIdx(int idx){
        if(idx < 0){ //call with neg arg to get most recent element
            ////This handles the case when the user
            //Is prompted if he would like to add a message after creating a feeling
            return feelings.get(feelings.size()-1);
        }
        return feelings.get(idx);
    }

    public void addNewFeeling(EFeeling feel, String text){
        Feel Fl = new Feel(feel,text);
        feelings.add(Fl);
        feelAdapter.notifyDataSetChanged();
        Log.d("Feelsbook","new feeling! " + Fl.getFeelingText());
    }

    public void setAdapter(ListView listV){
        listV.setAdapter(feelAdapter);
        feelAdapter.notifyDataSetChanged();
    }
}
