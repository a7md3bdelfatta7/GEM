package brainwaves.gem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import brainwaves.gem.R;

public class ChooseUserType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose_user_type);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/gothicb0_bold.ttf");

        Button signinButton=(Button)findViewById(R.id.signin_button);
        Button newVisitorButton=(Button)findViewById(R.id.new_visitor_button);

        signinButton.setTypeface(custom_font);
        newVisitorButton.setTypeface(custom_font);

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChooseUserType.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        newVisitorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ChooseUserType.this,RegisterationActivity.class);
                startActivity(intent);
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
