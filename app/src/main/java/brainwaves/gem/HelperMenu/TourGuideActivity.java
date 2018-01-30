package brainwaves.gem.HelperMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import brainwaves.gem.R;

public class TourGuideActivity extends AppCompatActivity {

    String[] tours={
            "Ahmed Samir","","Eslam Elnagger","","Manal Mahmoud",
            "Marwan Khaled","Sara Mourad"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_guide);
    }

    public void getTourGuide(View v){
        RadioGroup tour_list=(RadioGroup)findViewById(R.id.tour_list);
        int id=tour_list.getCheckedRadioButtonId();
        String x=tours[id-1];
        Toast.makeText(this,x+" on the way", Toast.LENGTH_SHORT).show();
    }



}
