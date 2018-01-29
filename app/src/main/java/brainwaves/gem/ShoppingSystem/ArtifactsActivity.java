package brainwaves.gem.ShoppingSystem;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import brainwaves.gem.HelperMenu.shoppingDetailsActivity;
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
        setContentView(R.layout.activity_artifacts);
    }
    public void shoppingDetails(View v){
        Intent intent = new Intent(ArtifactsActivity.this,
                shoppingDetailsActivity.class);
        intent.putExtra("id",""+v.getId());
        startActivity(intent);
    }
}
