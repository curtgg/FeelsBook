package schoolwork.uofa.curtisgoud.feelsbook;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class FeelItem extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    private FeelingController feelingController;
    private Feel selectedFeeling;

    private Button saveButton;
    private Button dateButton;
    private TextView feelingText;
    private TextView dateText;
    private EditText feelingEditText;

    private Date newDate = new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feel_item);

        saveButton = (Button) findViewById(R.id.buttonSave);
        dateButton = (Button) findViewById(R.id.buttonEditDate);
        feelingText = (TextView) findViewById(R.id.feelingText);
        dateText = (TextView) findViewById(R.id.dateText);
        feelingEditText = (EditText) findViewById(R.id.feelingEditText);

        feelingController = new FeelingController(this);

        int FeelIdx = getIntent().getExtras().getInt("ARG_IDX");
        selectedFeeling = feelingController.getFeelingByIdx(FeelIdx);
        Log.d("FeelingOut",selectedFeeling.toString());
        initView();
    }

    public void initView(){
        feelingText.setText(feelingController.getFeelingType(selectedFeeling));
        dateText.setText(feelingController.getFeelingDateString(selectedFeeling));
        feelingEditText.setText(feelingController.getFeelingMessage(selectedFeeling));

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFeel();
            }
        });

        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editDate();
            }
        });
    }

    public void saveFeel(){
        feelingController.setFeelingMessage(selectedFeeling,feelingEditText.getText().toString());
        //TODO:feelingController.setDate();
        Toast.makeText(this,"Changes Saved!",Toast.LENGTH_SHORT).show();
    }

    //TODO: Credit for Picker https://developer.android.com/guide/topics/ui/controls/pickers
    public void editDate(){
        Calendar cal = Calendar.getInstance();
        int year = cal.get(cal.YEAR);
        int month = cal.get(cal.MONTH);
        int day = cal.get(cal.DAY_OF_MONTH);
        DatePickerDialog datePicker = new DatePickerDialog(this,this,year,month,day);
        datePicker.show();
    }

    public void updateDate(){
        feelingController.setDate(selectedFeeling,newDate);
        initView();
    }

    @Override
    @SuppressWarnings("deprecation")
    //TODO: Credit, chaining of two pickers https://www.youtube.com/watch?v=a_Ap6T4RlYU
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(cal.HOUR);
        int minute = cal.get(cal.MINUTE);
        newDate.setYear(year);
        newDate.setMonth(month);
        newDate.setDate(dayOfMonth);

        TimePickerDialog timePicker = new TimePickerDialog(this,this,hour,minute,true);
        timePicker.show();
    }

    @Override
    @SuppressWarnings("deprecation")
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        newDate.setHours(hourOfDay);
        newDate.setMinutes(minute);
        updateDate();
    }
}
