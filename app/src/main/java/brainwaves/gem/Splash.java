package brainwaves.gem;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;

import java.util.Locale;

import brainwaves.gem.data.UserContract;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Splash extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 1000;
    private Context context;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
       // setLocal();
        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        context=getApplicationContext();
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {

                loadDefaultLang();
                SharedPreferences sharedPref = getSharedPreferences(getResources().getString(R.string.gem_pref_key),MODE_PRIVATE);
                boolean loggedIn = sharedPref.getBoolean(getResources().getString(R.string.logged_in_key),false);
                Intent mainIntent;
                if(loggedIn){
                    UserContract user=new UserContract(getApplicationContext());
                    user.loadSharedPreferences();
                    mainIntent = new Intent(Splash.this, MainActivity.class);

                }else{
                    mainIntent= new Intent(Splash.this, ChooseLangActivity.class);
                }
                Splash.this.startActivity(mainIntent);
                Splash.this.finish();


            }
        }, SPLASH_DISPLAY_LENGTH);
    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }

    public void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }


    void loadDefaultLang(){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getResources().getString(R.string.gem_pref_key),Context.MODE_PRIVATE);
        String lang=sharedPref.getString(context.getResources().getString(R.string.app_lang_key),getString(R.string.app_default_lang));
        setLocale(lang);
    }





}
