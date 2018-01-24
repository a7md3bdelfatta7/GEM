package brainwaves.gem.HelperMenu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import brainwaves.gem.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ArtifactsActivity extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_artifacts_details);

        ActionBar actionBar=getSupportActionBar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.artifacts_actionbar);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        ImageView img = (ImageView) findViewById(R.id.artifact_details);
        switch (Integer.parseInt(id)){
            case R.id.artifact_1:
                img.setImageResource(R.drawable.highlight_i);
                break;
            case R.id.artifact_2:
                img.setImageResource(R.drawable.highlight_ii);
                break;
            case R.id.artifact_3:
                img.setImageResource(R.drawable.highlight_iii);
                break;
            case R.id.artifact_4:
                img.setImageResource(R.drawable.highlight_iv);
                break;
            case R.id.artifact_5:
                img.setImageResource(R.drawable.highlight_v);
                break;
            case R.id.artifact_6:
                img.setImageResource(R.drawable.highlight_xv);
                break;
            case R.id.artifact_7:
                img.setImageResource(R.drawable.highlight__i);
                break;
            case R.id.artifact_8:
                img.setImageResource(R.drawable.highlight__ii);
                break;
            case R.id.artifact_9:
                img.setImageResource(R.drawable.highlight__iii);
                break;
            case R.id.artifact_10:
                img.setImageResource(R.drawable.highlight__iv);
                break;
            case R.id.artifact_11:
                img.setImageResource(R.drawable.highlight__v);
                break;
            case R.id.artifact_12:
                img.setImageResource(R.drawable.highlight__xv);
                break;
        }
    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
