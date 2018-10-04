package schoolwork.uofa.curtisgoud.feelsbook;

//Help with stringification of Enumerables was obtained here:
//https://stackoverflow.com/questions/3978654/best-way-to-create-enum-of-strings

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
