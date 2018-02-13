package brainwaves.gem;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v7.app.ActionBar;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;


/**
 * Created by AhmedMiohamed on 1/22/2018.
 */

public class MyApp extends Application {
// Put the onCreate code as you obtained from the post link you reffered

    private Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=getApplicationContext();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/century_gothic_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        loadDefaultLang();
    }

    void loadDefaultLang(){
        SharedPreferences sharedPref = context.getSharedPreferences(context.getResources().getString(R.string.gem_pref_key),Context.MODE_PRIVATE);
        String lang=sharedPref.getString(context.getResources().getString(R.string.app_lang_key),getString(R.string.app_default_lang));
        setLocale(lang);
    }
    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

}