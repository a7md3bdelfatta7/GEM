package brainwaves.gem.HelperMenu;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import brainwaves.gem.HelperClasses.ExpandableListAdapter;
import brainwaves.gem.R;

public class Tour extends AppCompatActivity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tour);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.expandGroup(1);
        expListView.expandGroup(2);



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
        listDataHeader.add("Ground Level");
        listDataHeader.add("1st level");
        listDataHeader.add("2nd level");
        listDataHeader.add("3rd level");
        listDataHeader.add("4th level");

        // Adding child data
        List<String> level0 = new ArrayList<String>();
        level0.add("The Shawshank Redemption");
        level0.add("The Godfather");
        level0.add("The Godfather: Part II");


        List<String> level1 = new ArrayList<String>();
        level1.add("The Conjuring");
        level1.add("Despicable Me 2");
        level1.add("Turbo");
        level1.add("Grown Ups 2");

        List<String> level2 = new ArrayList<String>();
        level2.add("2 Guns");
        level2.add("The Smurfs 2");
        level2.add("The Spectacular Now");



        List<String> level3 = new ArrayList<String>();
        level3.add("2 Guns");
        level3.add("The Smurfs 2");
        level3.add("The Spectacular Now");

        List<String> level4 = new ArrayList<String>();
        level4.add("2 Guns");
        level4.add("The Smurfs 2");
        level4.add("The Spectacular Now");




        listDataChild.put(listDataHeader.get(0), level0); // Header, Child data
        listDataChild.put(listDataHeader.get(1), level1);
        listDataChild.put(listDataHeader.get(2), level2);
        listDataChild.put(listDataHeader.get(3), level3);
        listDataChild.put(listDataHeader.get(4), level4);


    }
}
