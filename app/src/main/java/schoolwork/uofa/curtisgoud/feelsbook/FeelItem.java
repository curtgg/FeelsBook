package schoolwork.uofa.curtisgoud.feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class FeelItem extends AppCompatActivity {

    private FeelingController feelingController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feel_item);

        feelingController = new FeelingController();

        int FeelIdx = getIntent().getExtras().getInt("ARG_IDX");
        Feel feel = feelingController.getFeelingByIdx(FeelIdx);
        Log.d("FeelingOut",feel.toString());
    }
}
