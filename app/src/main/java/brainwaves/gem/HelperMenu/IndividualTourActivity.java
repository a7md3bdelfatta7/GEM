package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import brainwaves.gem.Map;
import brainwaves.gem.R;

public class IndividualTourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_tour);
    }

    public void viewMap(View v){
        Intent intent=new Intent(IndividualTourActivity.this,Map.class);
        startActivity(intent);
    }

    public void startTour(View v){
        Toast.makeText(this, "Tour Started", Toast.LENGTH_SHORT).show();
    }

}
