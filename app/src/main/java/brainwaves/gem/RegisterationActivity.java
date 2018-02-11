package brainwaves.gem;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringDef;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
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

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterationActivity extends AppCompatActivity {

    private SQLiteDatabase mDb;
    CallbackManager callbackManager = CallbackManager.Factory.create();
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


        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/gothicb0_bold.ttf");

        Button signUpButton = (Button) findViewById(R.id.signup_button);
        signUpButton.setTypeface(custom_font);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, years);
        final Spinner yearSpinner = (Spinner) findViewById(R.id.year_spinner);
        yearSpinner.setAdapter(adapter);

        ArrayList<String> months = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            months.add(Integer.toString(i));
        }
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, months);
        final Spinner monthSpinner = (Spinner) findViewById(R.id.month_spinner);
        monthSpinner.setAdapter(monthsAdapter);

        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }
        ArrayAdapter<String> daysAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, days);
        final Spinner daySpinner = (Spinner) findViewById(R.id.day_spinner);
        daySpinner.setAdapter(daysAdapter);


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText userName = (EditText) findViewById(R.id.username_edittext);
                EditText password = (EditText) findViewById(R.id.password_edittext);
                EditText name = (EditText) findViewById(R.id.name_edittext);
                EditText nationality = (EditText) findViewById(R.id.nationality_edittext);
                String birthDate = daySpinner.getSelectedItem().toString();
                birthDate += "-" + monthSpinner.getSelectedItem().toString();
                birthDate += "-" + yearSpinner.getSelectedItem().toString();

                UserContract user = new UserContract(getApplicationContext());


                if (!user.isUserNameExist(userName.getText().toString())) {
                    long result = user.addNewUser(userName.getText().toString(), password.getText().toString(), name.getText().toString(),
                            birthDate, nationality.getText().toString());
                    if (result > 0) {
                        if (user.login(userName.getText().toString(), password.getText().toString())) {
                            Intent intent = new Intent(RegisterationActivity.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                            ActivityCompat.finishAffinity(RegisterationActivity.this);
                        }
                    }
                } else {
                    TextView resultMessage = (TextView) findViewById(R.id.resultMessage);
                    resultMessage.setText("UserName is exist! try another one");
                }


            }
        });



//        try {
//            PackageInfo info = getPackageManager().getPackageInfo(
//                    "brainwaves.gem",
//                    PackageManager.GET_SIGNATURES);
//            for (Signature signature : info.signatures) {
//                MessageDigest md = MessageDigest.getInstance("SHA");
//                md.update(signature.toByteArray());
//                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//
//        } catch (NoSuchAlgorithmException e) {
//
//        }





    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }






}
