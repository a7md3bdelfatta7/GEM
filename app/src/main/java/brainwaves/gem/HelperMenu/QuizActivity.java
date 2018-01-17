package brainwaves.gem.HelperMenu;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import brainwaves.gem.R;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);
        final Button button = (Button) findViewById(R.id.thirdAnswer);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                button.setBackgroundColor(Color.GREEN);
                // Code here executes on main thread after user presses button
            }
        });
    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
