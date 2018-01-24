package brainwaves.gem;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import java.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringDef;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import brainwaves.gem.data.GemDbHelper;
import brainwaves.gem.data.UserContract;
import  brainwaves.gem.data.UserContract.UserEntry;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RegisterationActivity extends AppCompatActivity {

    private SQLiteDatabase mDb;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registeration);



        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/gothicb0_bold.ttf");

        Button signUpButton=(Button)findViewById(R.id.signup_button);
        signUpButton.setTypeface(custom_font);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, years);
        final Spinner yearSpinner = (Spinner)findViewById(R.id.year_spinner);
        yearSpinner.setAdapter(adapter);

        ArrayList<String> months = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            months.add(Integer.toString(i));
        }
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, months);
        final Spinner monthSpinner = (Spinner)findViewById(R.id.month_spinner);
        monthSpinner.setAdapter(monthsAdapter);

        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }
        ArrayAdapter<String> daysAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, days);
        final Spinner daySpinner = (Spinner)findViewById(R.id.day_spinner);
        daySpinner.setAdapter(daysAdapter);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userName=(EditText)findViewById(R.id.username_edittext);
                EditText password=(EditText)findViewById(R.id.password_edittext);
                EditText name=(EditText)findViewById(R.id.name_edittext);
                EditText nationality=(EditText)findViewById(R.id.nationality_edittext);
                String birthDate=daySpinner.getSelectedItem().toString();
                birthDate +="-"+monthSpinner.getSelectedItem().toString();
                birthDate +="-"+ yearSpinner.getSelectedItem().toString();

                UserContract user=new UserContract(getApplicationContext());
                if(!user.isUserNameExist(userName.getText().toString())){
                    long result=user.addNewUser(userName.getText().toString(),password.getText().toString(),name.getText().toString(),
                    birthDate,nationality.getText().toString());
                    Intent intent=new Intent(RegisterationActivity.this,MainActivity.class);
                    SharedPreferences sharedPref = getSharedPreferences("login_pref",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("LOGGED_IN",true);
                    editor.commit();
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                    ActivityCompat.finishAffinity(RegisterationActivity.this);
                }else{
                    TextView resultMessage=(TextView)findViewById(R.id.resultMessage);
                    resultMessage.setText("UserName is exist! try another one");
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
