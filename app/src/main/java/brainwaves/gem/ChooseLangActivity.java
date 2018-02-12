package brainwaves.gem;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.VideoView;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ChooseLangActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.choose_lang);
        context=getApplicationContext();
      //  Locale.getDefault().getDisplayLanguage();

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/gothicb0_bold.ttf");

        final VideoView videoView = (VideoView)findViewById(R.id.mainSponsor);
        final LinearLayout chooseLang = (LinearLayout) findViewById(R.id.activity_login);
        final RelativeLayout chooseLangAd = (RelativeLayout) findViewById(R.id.chooseLangAd);
        Spinner spinner = (Spinner) findViewById(R.id.lang_spinner);


        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.lang_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Button nextButton=(Button)findViewById(R.id.nextButton);
        nextButton.setTypeface(custom_font);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ChooseLangActivity.this,ChooseUserType.class);
                startActivity(intent);
            }
        });
        Intent intent=getIntent();
        if(intent.getStringExtra("purpose")==null){
            videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+R.raw.startupad));
            //videoView.setMediaController(new MediaController(this));
            videoView.requestFocus();
            videoView.start();

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    chooseLangAd.setVisibility(View.GONE);
                    chooseLang.setVisibility(View.VISIBLE);
                    //Do something after 100ms
                }
            }, 5000);
        }else{
            chooseLangAd.setVisibility(View.GONE);
            chooseLang.setVisibility(View.VISIBLE);
        }

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
        Intent refresh = new Intent(this, ChooseLangActivity.class);
        refresh.putExtra("purpose","changeLang");
        startActivity(refresh);
        finish();


    }


    void saveSharedPreference(String lang){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getResources().
                getString(R.string.gem_pref_key),Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString(context.getResources().getString(R.string.app_lang_key),lang);
        editor.commit();


    }





}
