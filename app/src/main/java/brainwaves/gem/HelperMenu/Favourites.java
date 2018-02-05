package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

import brainwaves.gem.R;
import brainwaves.gem.data.ArtifactsFavourite;

public class Favourites extends AppCompatActivity {

    int []artifactsIDs = {R.id.artifact_1,R.id.artifact_2,R.id.artifact_3,
            R.id.artifact_4,R.id.artifact_5,R.id.artifact_6,R.id.artifact_7,R.id.artifact_8,R.id.artifact_9,
            R.id.artifact_10,R.id.artifact_11,R.id.artifact_12,R.id.artifact_13,R.id.artifact_14,R.id.artifact_15,R.id.artifact_16,
            R.id.artifact_17,R.id.artifact_18,R.id.artifact_19,R.id.artifact_20,R.id.artifact_21,R.id.artifact_22};

    int []artifactsSource = {R.drawable.highlight_i,
            R.drawable.highlight_ii,
            R.drawable.highlight_iii,
            R.drawable.highlight_iv,
            R.drawable.highlight_v,
            R.drawable.highlight_xv,
            R.drawable.highlight__i,
            R.drawable.highlight__ii,
            R.drawable.highlight__iii,
            R.drawable.highlight__iv,
            R.drawable.highlight__v,
            R.drawable.highlight__xv,
            R.drawable.staff_i,
            R.drawable.staff_ii,
            R.drawable.staff_iii,
            R.drawable.staff_iv,
            R.drawable.staff_v,
            R.drawable.staff_xv,
            R.drawable.staff__i,
            R.drawable.staff__ii,
            R.drawable.staff__iii,
            R.drawable.staff__iv,
            R.drawable.staff__v,
            R.drawable.staff__iii,
            R.drawable.staff__xv
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_favourites);
        ArtifactsFavourite artifactFavourite=new ArtifactsFavourite(getApplicationContext());
        ArrayList<String> listedArtifacts = artifactFavourite.getSelectedArtifacts();


        if(!listedArtifacts.isEmpty()){
            for(int i=0;i<listedArtifacts.size();i++){
                ImageButton imgBtn = (ImageButton) findViewById(artifactsIDs[i]);
                imgBtn.setImageResource(artifactsSource[Integer.parseInt(listedArtifacts.get(i))-1]);
                imgBtn.setTag(artifactsIDs[Integer.parseInt(listedArtifacts.get(i))-1]);
                imgBtn.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    public void onResume(){
        super.onResume();
        ArtifactsFavourite artifactFavourite=new ArtifactsFavourite(getApplicationContext());
        ArrayList<String> listedArtifacts = artifactFavourite.getSelectedArtifacts();

        if(!listedArtifacts.isEmpty()){
            for(int i=0;i<listedArtifacts.size();i++){
                ImageButton imgBtn = (ImageButton) findViewById(artifactsIDs[i]);
                imgBtn.setImageResource(artifactsSource[Integer.parseInt(listedArtifacts.get(i))-1]);
                imgBtn.setTag(artifactsIDs[Integer.parseInt(listedArtifacts.get(i))-1]);
                imgBtn.setVisibility(View.VISIBLE);
            }
        }

    }
    public void addArtifactDetails(View v) {
        Intent intent = new Intent(Favourites.this,
                ArtifactsActivity.class);

        intent.putExtra("id",""+v.getTag());
        startActivity(intent);
    }
}
