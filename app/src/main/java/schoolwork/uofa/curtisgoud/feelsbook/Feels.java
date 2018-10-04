package schoolwork.uofa.curtisgoud.feelsbook;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feels extends AppCompatActivity {


    private EditText lovePanel;
    private EditText surprisePanel;
    private EditText fearPanel;
    private EditText joyPanel;
    private EditText sadnessPanel;
    private EditText angerPanel;


    private EFeeling selectedEFeeling;

    private FeelingController feelingController;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feels:
                    return true;
                case R.id.navigation_book:
                    ViewController.newActivity(Feels.this,book.class);
                    return true;
            }
            return false;
        }
    };

    private void initListeners(){
        Button buttonSurprise = (Button) findViewById(R.id.buttonSurprise);
        Button buttonAnger = (Button) findViewById(R.id.buttonAnger);
        Button buttonFear = (Button) findViewById(R.id.buttonFear);
        Button buttonJoy = (Button) findViewById(R.id.buttonJoy);
        Button buttonLove = (Button) findViewById(R.id.buttonLove);
        Button buttonSadness = (Button) findViewById(R.id.buttonSadness);

        buttonSurprise.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                feelingController.addNewFeeling(EFeeling.SURPRISE,"");
                newFeelingAlert();
            }
        });

        buttonAnger.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                feelingController.addNewFeeling(EFeeling.ANGER,"");
                newFeelingAlert();
            }
        });

        buttonFear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                feelingController.addNewFeeling(EFeeling.FEAR,"");
                newFeelingAlert();
            }
        });

        buttonJoy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                feelingController.addNewFeeling(EFeeling.JOY,"");
                newFeelingAlert();
            }
        });

        buttonLove.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                feelingController.addNewFeeling(EFeeling.LOVE,"");
                newFeelingAlert();
            }
        });

        buttonSadness.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                feelingController.addNewFeeling(EFeeling.SADNESS,"");
                newFeelingAlert();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feels);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigationMenu);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //TODO: PASS IN UI ELEMENT TO ATTACH TO ADAPTER
        lovePanel = (EditText) findViewById(R.id.feelsLove);
        surprisePanel = (EditText) findViewById(R.id.feelsSurprise);
        fearPanel = (EditText) findViewById(R.id.feelsFear);
        joyPanel = (EditText) findViewById(R.id.feelsJoy);
        sadnessPanel = (EditText) findViewById(R.id.feelsSadness);
        angerPanel = (EditText) findViewById(R.id.feelsAnger);

        initListeners();
    }

    @Override
    protected void onStart(){
        super.onStart();
        feelingController = new FeelingController(this);
    }

    //Info on Alerts obtained here:
    //https://developer.android.com/guide/topics/ui/dialogs#java
    private void newFeelingAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Feeling Added!");
        builder.setMessage("Would you like to add a message to the feeling?");
        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ViewController.newActivity(Feels.this,FeelItem.class,-1);
            }
        });

        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //No action
                return;
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }
}
