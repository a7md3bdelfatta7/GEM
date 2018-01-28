package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import brainwaves.gem.Map;
import brainwaves.gem.R;
import brainwaves.gem.data.ArtifactsContract;

public class IndividualTourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_tour);

        ArtifactsContract artifact=new ArtifactsContract(getApplicationContext());
        ArrayList<String> arts=artifact.getSelectedArtifacts();
        LinearLayout contentView=(LinearLayout)findViewById(R.id.artifact_content);

        for(int i=0;i<arts.size();i++) {
            ImageButton img = (ImageButton) contentView.findViewWithTag(arts.get(i));
            img.setVisibility(View.VISIBLE);
        }



    }



    public void viewMap(View v){
        Intent intent=new Intent(IndividualTourActivity.this,Map.class);
        startActivity(intent);
    }

    public void startTour(View v){
        Toast.makeText(this, "Tour Started", Toast.LENGTH_SHORT).show();
    }

    public void buildTour(View v){
        LinearLayout tourDetials=(LinearLayout)findViewById(R.id.tour_details);
        tourDetials.setVisibility(View.GONE);

        LinearLayout tourOptions=(LinearLayout)findViewById(R.id.tour_option);
        tourOptions.setVisibility(View.VISIBLE);

    }





}
