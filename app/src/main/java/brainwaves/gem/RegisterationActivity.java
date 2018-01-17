package brainwaves.gem;

import android.graphics.Typeface;
import java.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class RegisterationActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registeration);

        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/gothicb0_bold.TTF");

        Button signUpButton=(Button)findViewById(R.id.signup_button);
        signUpButton.setTypeface(custom_font);

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item, years);
        Spinner spinYear = (Spinner)findViewById(R.id.year_spinner);
        spinYear.setAdapter(adapter);

        ArrayList<String> months = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            months.add(Integer.toString(i));
        }
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, months);
        Spinner monthSpinner = (Spinner)findViewById(R.id.month_spinner);
        monthSpinner.setAdapter(monthsAdapter);

        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }
        ArrayAdapter<String> daysAdapter = new ArrayAdapter<String>(this, R.layout.spinner_item, days);
        Spinner daySpinner = (Spinner)findViewById(R.id.day_spinner);
        daySpinner.setAdapter(daysAdapter);







    }


}
