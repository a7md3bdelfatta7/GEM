package brainwaves.gem;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Spinner;
import android.widget.VideoView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ChooseLangActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.choose_lang);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/gothicb0_bold.ttf");

        final VideoView videoView = (VideoView)findViewById(R.id.mainSponsor);
        final LinearLayout chooseLang = (LinearLayout) findViewById(R.id.activity_login);
        final LinearLayout chooseLangAd = (LinearLayout) findViewById(R.id.chooseLangAd);
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

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

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
}
