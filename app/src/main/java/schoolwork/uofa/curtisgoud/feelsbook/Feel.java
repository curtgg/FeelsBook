package schoolwork.uofa.curtisgoud.feelsbook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Feel {
    private EFeeling EFeeling;
    private Date timestamp;
    private String feelingText;

    Feel(EFeeling f, String text){
        this.EFeeling =f;
        this.timestamp = new Date();
        this.feelingText = text;
    }

    public String getFeelingText(){
        return feelingText;
    }

    public void setFeelingText(String s){
        this.feelingText = s;
    }

    @Override
    public String toString(){
        //TODO: ENSURE PROPER DATE FORMAT
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        return "\n" + format.format(timestamp) + "\n" + EFeeling.toString() + "\n";
    }
}
