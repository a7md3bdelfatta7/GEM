package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;

import brainwaves.gem.R;

public class VisitDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_visit_details);
        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
//        ImageView img = (ImageView) findViewById(R.id.visit_details_img);
//        switch (id){
//            case "1":
//                img.setImageResource(R.drawable.visit_i);
//                break;
//            case "2":
//                img.setImageResource(R.drawable.visit_ii);
//                break;
//            case "3":
//                img.setImageResource(R.drawable.visit_iii);
//                break;
//        }
    }
}
