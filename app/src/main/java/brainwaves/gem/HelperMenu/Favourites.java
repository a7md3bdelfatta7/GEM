package brainwaves.gem.HelperMenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.ArrayList;

import brainwaves.gem.R;
import brainwaves.gem.data.ArtifactsFavourite;

public class Favourites extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_favourites);
        ArtifactsFavourite artifactFavourite=new ArtifactsFavourite(getApplicationContext());
        ArrayList<String> listedArtifacts = artifactFavourite.getSelectedArtifacts();
    }
}
