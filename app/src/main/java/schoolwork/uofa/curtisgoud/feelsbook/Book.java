package schoolwork.uofa.curtisgoud.feelsbook;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Book extends AppCompatActivity {

    private ListView moodList;
    private FeelingController feelingController;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feels:
                    ViewController.newActivity(Book.this,Feels.class);
                    return true;
                case R.id.navigation_book:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("Feelsbook","creted");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        BottomNavigationView nav = (BottomNavigationView) findViewById(R.id.navigationMenu);
        moodList = (ListView) findViewById(R.id.moodList);
        feelingController = new FeelingController();
        feelingController.setAdapter(moodList);
        nav.setSelectedItemId(R.id.navigation_book);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        moodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Open page of specific item
                ViewController.newActivity(Book.this,FeelItem.class,(int)id);
            }
        });
    }

}
