package brainwaves.gem.HelperMenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import brainwaves.gem.R;

public class MembershipActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_membership);
        final CheckBox checked = (CheckBox) findViewById(R.id.membership_checkbox_i);
        final CheckBox checked_ii = (CheckBox) findViewById(R.id.membership_checkbox_ii);
        final CheckBox checked_iii = (CheckBox) findViewById(R.id.membership_checkbox_iii);
        Button submitButton = (Button) findViewById(R.id.membership_submit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(checked.isChecked()){
                    Toast.makeText(getApplicationContext(),"Thanks for submitting 3 Months",Toast.LENGTH_LONG).show();
                }else if(checked_ii.isChecked()){
                    Toast.makeText(getApplicationContext(),"Thanks for submitting 6 Months",Toast.LENGTH_LONG).show();
                }else if(checked_iii.isChecked()){
                    Toast.makeText(getApplicationContext(),"Thanks for submitting 1 Year",Toast.LENGTH_LONG).show();
                }
                // Code here executes on main thread after user presses button
            }
        });

    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
