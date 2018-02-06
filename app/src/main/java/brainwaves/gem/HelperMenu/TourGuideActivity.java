package brainwaves.gem.HelperMenu;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Toast;

import brainwaves.gem.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TourGuideActivity extends AppCompatActivity {

    String[] tours={
            "Ahmed Samir","","Eslam Elnagger","","Manal Mahmoud",
            "Marwan Khaled","Sara Mourad"
    };
    RadioGroup tour_list;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tour_guide);
        getSupportActionBar().setTitle("Tour Guide");
        tour_list=(RadioGroup)findViewById(R.id.tour_list);

    }

    public void getTourGuide(View v){
        tour_list=(RadioGroup)findViewById(R.id.tour_list);
        int id=tour_list.getCheckedRadioButtonId();
        id=id%7;
        if(id==0){
            id=7;
        }

        if(id!=-1) {
            String x = tours[id - 1];
            Toast.makeText(this, x + " on the way", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Please Select Tour Guide.", Toast.LENGTH_SHORT).show();
        }
    }



}
