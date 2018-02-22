package brainwaves.gem.HelperMenu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import brainwaves.gem.HelperClasses.ExpandableListAdapter;
import brainwaves.gem.MainActivity;
import brainwaves.gem.R;
import brainwaves.gem.data.TourContract;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Tour extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    ListView tourListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tour);
        getSupportActionBar().setTitle(getResources().getString(R.string.tour_activity_title));

        tourListView=(ListView)findViewById(R.id.user_tour_list);

        TourContract tours=new TourContract(getApplicationContext());
        ArrayList<String> allTours =tours.getAllTours();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, allTours);
        tourListView.setAdapter(adapter);

        // ListView Item Click Listener
        tourListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;
                String  itemValue    = (String) tourListView.getItemAtPosition(position);
                Intent intent =new Intent(Tour.this,ViewTourActivity.class);
                intent.putExtra("tourName",itemValue);
                startActivity(intent);
               // finish();
            }

        });

    }


    @Override
    protected void onResume() {

        TourContract tours=new TourContract(getApplicationContext());
        ArrayList<String> allTours =tours.getAllTours();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, allTours);
        tourListView.setAdapter(adapter);
        super.onResume();
    }

    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }


    public void create_tour(View v){

        LinearLayout tourTypeContainer=(LinearLayout)findViewById(R.id.tour_type_container);
        tourTypeContainer.setVisibility(View.VISIBLE);
    }
    
    public void createTourDetails(View v){
        
        int id=v.getId();
        
        Intent intent = null;
        
        switch (id){
            case R.id.individual_tour_button:
                intent=new Intent(Tour.this, IndividualTourActivity.class);
                break;
            case R.id.group_tour_button:
                intent=new Intent(Tour.this, GroupTourActivity.class);
                break;
            case R.id.guide_tour_button:
                intent=new Intent(Tour.this, TourGuideActivity.class);
                break;
        }
        startActivity(intent);
    }
}
