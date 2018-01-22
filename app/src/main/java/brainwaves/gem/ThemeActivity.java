package brainwaves.gem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class ThemeActivity extends Activity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_theme);

        /* New Handler to start the Menu-Activity
         * and close this Splash-Screen after some seconds.*/
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                /* Create an Intent that will start the Menu-Activity. */
                Intent mainIntent = new Intent(ThemeActivity.this,ChooseLangActivity.class);
                ThemeActivity.this.startActivity(mainIntent);
                ThemeActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
