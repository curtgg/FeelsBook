package schoolwork.uofa.curtisgoud.feelsbook;

import android.content.Context;
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
                    ViewController.newActivity(Feels.this,Book.class);
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


        initListeners();
    }

    @Override
    protected void onStart(){
        super.onStart();
        FeelingController.context = this;
        feelingController = new FeelingController(this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        lovePanel = (EditText) findViewById(R.id.feelsLove);
        surprisePanel = (EditText) findViewById(R.id.feelsSurprise);
        fearPanel = (EditText) findViewById(R.id.feelsFear);
        joyPanel = (EditText) findViewById(R.id.feelsJoy);
        sadnessPanel = (EditText) findViewById(R.id.feelsSadness);
        angerPanel = (EditText) findViewById(R.id.feelsAnger);

        lovePanel.setText(EFeeling.LOVE.toString() + ": " + feelingController.getFeelCount(EFeeling.LOVE));
        surprisePanel.setText(EFeeling.SURPRISE.toString() + ": " + feelingController.getFeelCount(EFeeling.SURPRISE));
        fearPanel.setText(EFeeling.FEAR.toString() + ": " + feelingController.getFeelCount(EFeeling.FEAR));
        joyPanel.setText(EFeeling.JOY.toString() + ": " + feelingController.getFeelCount(EFeeling.JOY));
        sadnessPanel.setText(EFeeling.SADNESS.toString() + ": " + feelingController.getFeelCount(EFeeling.SADNESS));
        angerPanel.setText(EFeeling.ANGER.toString() + ": " + feelingController.getFeelCount(EFeeling.ANGER));

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
                ViewController.newActivity(Feels.this,Book.class);
                return;
            }
        });
        AlertDialog dialog = builder.create();
        builder.show();
    }

}
