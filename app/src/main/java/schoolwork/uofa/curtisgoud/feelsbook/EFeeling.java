package schoolwork.uofa.curtisgoud.feelsbook;


//This enumerable is used in the Feel class to categorize the
//Types of feels, allowing us to have a single class to represent feelings
//The added functions allow increased flexibility and usage


//Help with stringification of Enumerables was obtained here:
//https://stackoverflow.com/questions/3978654/best-way-to-create-enum-of-strings
//#Reference 1 in Citations
public enum EFeeling {
    LOVE("Love"),
    JOY("Joy"),
    SURPRISE("Surprise"),
    ANGER("Anger"),
    SADNESS("Sadness"),
    FEAR("Fear")
    ;

    private String feelText;

    EFeeling(String text){
        this.feelText = text;
    }

    @Override
    public String toString() {
        return feelText;
    }

}
