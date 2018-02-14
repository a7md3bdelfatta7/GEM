package brainwaves.gem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class UserProfile extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        context=getApplicationContext();

        initSpinner();

        Spinner spinner = (Spinner) findViewById(R.id.lang_spinner);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lang_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);




    }

    void initSpinner(){
        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.black_spinner_item, years);
        final Spinner yearSpinner = (Spinner) findViewById(R.id.year_spinner);
        yearSpinner.setAdapter(adapter);

        ArrayList<String> months = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            months.add(Integer.toString(i));
        }
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this, R.layout.black_spinner_item, months);
        final Spinner monthSpinner = (Spinner) findViewById(R.id.month_spinner);
        monthSpinner.setAdapter(monthsAdapter);

        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }
        ArrayAdapter<String> daysAdapter = new ArrayAdapter<String>(this, R.layout.black_spinner_item, days);
        final Spinner daySpinner = (Spinner) findViewById(R.id.day_spinner);
        daySpinner.setAdapter(daysAdapter);
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
