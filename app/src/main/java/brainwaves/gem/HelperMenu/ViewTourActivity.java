package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import brainwaves.gem.HelperClasses.ExpandableListAdapter;
import brainwaves.gem.Map;
import brainwaves.gem.R;
import brainwaves.gem.data.TourContract;

public class ViewTourActivity extends AppCompatActivity {


    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    ArrayList<String> tourArtifacts;
    HashMap<String,List<String>> listDataChild;
    int i;

    String []statues={
            "TUT ANKAMUN MASK","Sphinx of Amenhotep the Second","Anubis Carrying the Moon Disk","Shawabti of Tutankhamun","Crocodile God Sobek",
            "Goddess Isis Nursing Her Son Horus","Outer Coffin of Queen Meritamun","Bust of Amenemhat the Third in Priestly Costume",
            "Gold Mask Mummy Cover of King Psusennes the First",
            "Gold Cover of Psusennes' Mummy","Queen Hatshepsut Offering to Osiris","Fragments of Standing Statue of a King","Statue 12"
    };

    ArrayList<String> tour_artifacts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_details_tour);

        ActionBar actionBar=getSupportActionBar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.event_title_layout);
        TextView actionBarTitle=(TextView)findViewById(R.id.action_bar_title);

        Intent intent=getIntent();
        String tourName=intent.getStringExtra("tourName");

        actionBarTitle.setText(tourName);


        TourContract tour=new TourContract(getApplicationContext());
        String tourId=tour.getTourByName(tourName);
        tourArtifacts=tour.getTourArtifacts(tourId);


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        // preparing list data
        prepareListData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
        for(int j=0;j<i;j++) {
            expListView.expandGroup(j);
        }

    }



    public void viewMap(View v){
        Intent intent=new Intent(ViewTourActivity.this,TourMap.class);
        startActivity(intent);
    }

    public void startTour(View v){
        Toast.makeText(this, "Tour Started", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        // Adding child data
        List<String> hall1 = new ArrayList<String>();
        List<String> hall2 = new ArrayList<String>();
        List<String> hall3 = new ArrayList<String>();
        List<String> hall4 = new ArrayList<String>();


        for(String artifact:tourArtifacts){
            int artifactId=Integer.parseInt(artifact);
            if (artifactId>=1 && artifactId<=3) {
                hall1.add(statues[artifactId-1]);
            }else if(artifactId>=4 && artifactId<=6){
                hall2.add(statues[artifactId-1]);
            }else if(artifactId>=7 && artifactId<=9){
                hall3.add(statues[artifactId-1]);
            }else if(artifactId>=10 && artifactId<=12){
                hall4.add(statues[artifactId-1]);
            }
        }


        i=0;

        if(hall1.size()>0) {
            listDataHeader.add("Hall 1");
            listDataChild.put(listDataHeader.get(i), hall1); // Header, Child data
            i++;
        }
        if(hall2.size()>0) {
            listDataHeader.add("Hall 2");
            listDataChild.put(listDataHeader.get(i), hall2);
            i++;
        }
        if(hall3.size()>0) {
            listDataHeader.add("Hall 3");
            listDataChild.put(listDataHeader.get(i), hall3);
            i++;
        }
        if(hall4.size()>0) {
            listDataHeader.add("Hall 4");
            listDataChild.put(listDataHeader.get(i), hall4);
            i++;
        }


    }






}
