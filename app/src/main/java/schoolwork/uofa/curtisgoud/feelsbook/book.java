package schoolwork.uofa.curtisgoud.feelsbook;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class book extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_feels:
                    ViewController.newActivity(book.this,Feels.class);
                    return true;
                case R.id.navigation_book:
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        BottomNavigationView nav = (BottomNavigationView) findViewById(R.id.navigationMenu);
        nav.setSelectedItemId(R.id.navigation_book);
        nav.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }
}
