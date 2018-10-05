package schoolwork.uofa.curtisgoud.feelsbook;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Date;

//This singular class is used to represent feelings
//And is categorized by an EFeeling. This allows us to save
//on creating 6 different classes for each Feel

public class Feel implements Comparable<Feel> {
    private EFeeling EFeeling;
    private Date timestamp;
    private String feelingText;

    Feel(EFeeling f, String text){
        this.EFeeling =f;
        this.timestamp = new Date();
        this.feelingText = text;
    }

    Feel(){

    }

    public String getFeelingText(){
        return feelingText;
    }

    public void setFeelingText(String s){
        this.feelingText = s;
    }

    public void setDate(Date date){
        this.timestamp = date;
    }

    public Date getFeelDate(){
        return this.timestamp;
    }

    public EFeeling getFeelingType(){
        return this.EFeeling;
    }

    public String getDateString(){
        //TODO: Credit http://tutorials.jenkov.com/java-date-time/parsing-formatting-dates.html
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        return format.format(timestamp);
    }

    public String getFeelingString(){
        return EFeeling.toString();
    }

    @Override
    public String toString(){
        return "\n" + getDateString() + "\n" + getFeelingString() + "\n";
    }

    @Override
    public int compareTo(Feel o) {
        return o.getFeelDate().compareTo(this.getFeelDate());
    }
}
