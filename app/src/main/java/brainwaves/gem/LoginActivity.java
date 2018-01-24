package brainwaves.gem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import brainwaves.gem.data.GemDbHelper;
import brainwaves.gem.data.UserContract;
import brainwaves.gem.data.UserContract.UserEntry;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {

    private SQLiteDatabase mDb;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);



        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/gothicb0_bold.ttf");
        Button signInButton=(Button)findViewById(R.id.signin_button);
        signInButton.setTypeface(custom_font);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userName=(EditText)findViewById(R.id.username_edittext);
                EditText password=(EditText)findViewById(R.id.password_edittext);
                UserContract user= new UserContract(getApplicationContext());

                boolean userExist=user.isExist(userName.getText().toString(),password.getText().toString());
                if(userExist){
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                    SharedPreferences sharedPref = getSharedPreferences("login_pref",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("LOGGED_IN",true);
                    editor.commit();
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    ActivityCompat.finishAffinity(LoginActivity.this);

                }else{
                    TextView resultMessage=(TextView)findViewById(R.id.resultMessage);
                    resultMessage.setText("Wrong User Name or Password");
                }
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
