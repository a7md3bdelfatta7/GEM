package brainwaves.gem;

import android.app.Application;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.HashMap;

import static brainwaves.gem.TypefaceUtil.*;

/**
 * Created by AhmedMiohamed on 1/22/2018.
 */

public class MyApp extends Application {
// Put the onCreate code as you obtained from the post link you reffered


    @Override
    public void onCreate() {
        super.onCreate();
        TypefaceUtil.overrideFont(getApplicationContext(), "SERIF", "fonts/gothicb0_bold.ttf");
    }
}