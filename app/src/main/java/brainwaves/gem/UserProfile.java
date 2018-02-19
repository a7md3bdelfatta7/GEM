package brainwaves.gem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import brainwaves.gem.data.UserContract;

public class UserProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Context context;
    Spinner yearSpinner;
    Spinner monthSpinner;
    Spinner daySpinner;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_profile);
        context=getApplicationContext();

        EditText name=(EditText)findViewById(R.id.name_edittext);
        name.setText(UserContract.fullName);

        EditText nationality=(EditText)findViewById(R.id.nationality_edittext);
        nationality.setText(UserContract.nationality);

        String x=UserContract.currency_index;
        initDateSpinner();


        Spinner spinner = (Spinner) findViewById(R.id.lang_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lang_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        final Spinner currencySpinner = (Spinner) findViewById(R.id.currency_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> currencyAdapter = ArrayAdapter.createFromResource(this,
                R.array.currency_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        currencyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        currencySpinner.setAdapter(currencyAdapter);
        currencySpinner.setSelection(Integer.parseInt(UserContract.currency_index));

        View profileHeader=(View)findViewById(R.id.profileHeader);
        TextView fullName=(TextView)profileHeader.findViewById(R.id.full_name);
        TextView userDetails=(TextView)profileHeader.findViewById(R.id.user_details);
        fullName.setText(UserContract.fullName);
        userDetails.setText(UserContract.nationality+"-"+UserContract.birthDate);

        Button saveProfileBtn=(Button)findViewById(R.id.save_profile_btn);
        saveProfileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText name = (EditText) findViewById(R.id.name_edittext);
                EditText nationality = (EditText) findViewById(R.id.nationality_edittext);
                String birthDate = daySpinner.getSelectedItem().toString();
                birthDate += "/" + monthSpinner.getSelectedItem().toString();
                birthDate += "/" + yearSpinner.getSelectedItem().toString();

                UserContract user = new UserContract(getApplicationContext());

                if(name.getText().toString().equals("") ||
                        nationality.getText().toString().equals("")){
                    TextView resultMessage = (TextView) findViewById(R.id.resultMessage);
                    resultMessage.setVisibility(View.VISIBLE);
                    resultMessage.setText(getString(R.string.registration_message));
                }else {
                        UserContract.fullName=name.getText().toString();
                        UserContract.nationality=nationality.getText().toString();
                        UserContract.birthDate=birthDate;
                        UserContract.currency_index=String.valueOf(currencySpinner.getSelectedItemId());
                        int result = user.editUser();
                        if (result>0) {
                            Intent intent = new Intent(UserProfile.this,MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            startActivity(intent);
                        }
                }
            }
        });

        String []currencies=context.getResources().getStringArray(R.array.currency_array);
        String currency=currencies[Integer.parseInt(UserContract.currency_index)];
        Toast.makeText(context,currency, Toast.LENGTH_SHORT).show();
    }


    void initDateSpinner(){

        String[] date_tokens=UserContract.birthDate.split("/");
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.black_spinner_item, years);
        yearSpinner = (Spinner) findViewById(R.id.year_spinner);


        yearSpinner.setAdapter(adapter);
        yearSpinner.setSelection(years.indexOf(date_tokens[2]));

        ArrayList<String> months = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            months.add(Integer.toString(i));
        }
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this, R.layout.black_spinner_item, months);
        monthSpinner = (Spinner) findViewById(R.id.month_spinner);
        monthSpinner.setAdapter(monthsAdapter);
        monthSpinner.setSelection(months.indexOf(date_tokens[1]));
        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }
        ArrayAdapter<String> daysAdapter = new ArrayAdapter<String>(this, R.layout.black_spinner_item, days);
        daySpinner = (Spinner) findViewById(R.id.day_spinner);
        daySpinner.setAdapter(daysAdapter);
        daySpinner.setSelection(days.indexOf(date_tokens[0]));

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(i==1){
            swapLang();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }

    void swapLang(){
        Locale locale=Locale.getDefault();
        String lang=locale.getLanguage().split("_")[0];

        if(lang.equals("ar")){
            setLocale("en");
        }else if(lang.equals("en")){
            setLocale("ar");
        }
    }

    public void setLocale(String lang) {

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        saveSharedPreference(lang);
        Intent refresh = new Intent(this, UserProfile.class);
        startActivity(refresh);
        finish();

    }


    void saveSharedPreference(String lang){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getResources().
                getString(R.string.gem_pref_key), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getResources().getString(R.string.app_lang_key),lang);
        editor.commit();
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

}
