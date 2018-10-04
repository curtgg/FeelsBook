package schoolwork.uofa.curtisgoud.feelsbook;

import android.app.Activity;
import android.content.Context;
import android.media.effect.Effect;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class FeelingController {

    private static ArrayList<Feel> feelings = null;
    private static ArrayAdapter<Feel> feelAdapter;
    private static HashMap<EFeeling,Integer> feelingCount;

    public static Context context;
    public FeelingController(Activity activity){
        //First time run.. init
        if(feelings == null) {
            feelings = new ArrayList<>();
            feelingCount = new HashMap<EFeeling,Integer>(){ //Initialize Dict with Enums
                {
                    put(EFeeling.LOVE,0);
                    put(EFeeling.JOY,0);
                    put(EFeeling.SADNESS,0);
                    put(EFeeling.SURPRISE,0);
                    put(EFeeling.ANGER,0);
                    put(EFeeling.FEAR,0);
                }
            };
            feelings = IOController.loadFromDisk();
            feelAdapter = new ArrayAdapter<Feel>(activity, R.layout.list_layout, feelings);
            this.countFeels();
            feelAdapter.notifyDataSetChanged();
        }
    }

    public FeelingController(){

    }

    public String getFeelingType(Feel feel){
        return feel.getFeelingString();
    }

    public String getFeelingMessage(Feel feel){
        return feel.getFeelingText();
    }

    public String getFeelingDateString(Feel feel){
        return feel.getDateString();
    }

    public static ArrayList<Feel> getFeelings() {
        return feelings;
    }

    public void setFeelingMessage(Feel feel, String message){
        feel.setFeelingText(message);
        IOController.saveToDisk(feelings);
        feelAdapter.notifyDataSetChanged();

    }

    public void setDate(Feel feel,Date date){
        feel.setDate(date);
        IOController.saveToDisk(feelings);
        feelAdapter.notifyDataSetChanged();
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
        addFeelCount(Fl);
        IOController.saveToDisk(feelings);
        feelAdapter.notifyDataSetChanged();
        Log.d("Feelsbook","new feeling! " + Fl.getFeelingText());
    }

    public void removeFeel(int idx){
        this.removeFeelCount(feelings.get(idx));
        feelings.remove(idx);
        IOController.saveToDisk(feelings);
        feelAdapter.notifyDataSetChanged();
    }

    public void setAdapter(ListView listV){
        listV.setAdapter(feelAdapter);
        feelAdapter.notifyDataSetChanged();
    }

    public int getFeelCount(EFeeling ef){
        return feelingCount.get(ef);
    }

    private void countFeels(){
        for(Feel f: feelings){
            int c = feelingCount.get(f.getFeelingType());
            c = c+1;
            feelingCount.put(f.getFeelingType(),c);
        }
    }

    private void addFeelCount(Feel f){
        int c = feelingCount.get(f.getFeelingType());
        c = c+1;
        feelingCount.put(f.getFeelingType(),c);
    }

    private void removeFeelCount(Feel f){
        int c = feelingCount.get(f.getFeelingType());
        c = c-1;
        feelingCount.put(f.getFeelingType(),c);
    }


}
