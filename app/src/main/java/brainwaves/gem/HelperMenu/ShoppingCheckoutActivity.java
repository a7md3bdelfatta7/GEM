package brainwaves.gem.HelperMenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import brainwaves.gem.R;

/**
 * Created by Hossam on 1/24/2018.
 */

public class ShoppingCheckoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_shipping_checkout);
        final Button button = (Button) findViewById(R.id.checkout_btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Done.",Toast.LENGTH_LONG).show();
                // Code here executes on main thread after user presses button
            }
        });
    }
}