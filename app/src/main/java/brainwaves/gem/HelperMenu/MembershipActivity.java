package brainwaves.gem.HelperMenu;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import brainwaves.gem.HelperClasses.ExpandableListAdapter;
import brainwaves.gem.MainActivity;
import brainwaves.gem.R;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MembershipActivity extends AppCompatActivity {
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    ExpandableListView expListView1;
    ExpandableListView expListView2;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    boolean is_checked=false;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_membership);
        Button submitButton = (Button) findViewById(R.id.membership_submit);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_membership));


        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);

        expListView.expandGroup(0);
        //expListView.expandGroup(2);

        // get the listview
        expListView1 = (ExpandableListView) findViewById(R.id.lvExp2);
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView1.setAdapter(listAdapter);

        expListView1.expandGroup(0);

        // get the listview
        expListView2 = (ExpandableListView) findViewById(R.id.lvExp3);
        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView2.setAdapter(listAdapter);

        expListView2.expandGroup(0);

        expListView1.setVisibility(View.GONE);
        expListView2.setVisibility(View.GONE);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                if(is_checked) {
                    Intent intent = new Intent(MembershipActivity.this,
                            ShoppingCheckoutActivity.class);
                    intent.putExtra("id", "" + v.getId());
                    startActivity(intent);
                    // Code here executes on main thread after user presses button
                }else{
                    Toast.makeText(MembershipActivity.this, "Please Select Duration.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        is_checked=true;
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.membership_three_months:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Thanks for submitting 3 Months",Toast.LENGTH_LONG).show();
                    break;
            case R.id.membership_six_months:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Thanks for submitting 6 Months",Toast.LENGTH_LONG).show();
                    break;
            case R.id.membership_one_year:
                if (checked)
                    Toast.makeText(getApplicationContext(),"Thanks for submitting 1 Year",Toast.LENGTH_LONG).show();
                    break;

        }
    }
    public void childrenDetailsonClick(View v) {
        expListView.setVisibility(View.VISIBLE);
        expListView1.setVisibility(View.GONE);
        expListView2.setVisibility(View.GONE);
    }
    public void egyptainDetailsonClick(View v) {
        expListView.setVisibility(View.GONE);
        expListView1.setVisibility(View.VISIBLE);
        expListView2.setVisibility(View.GONE);
    }
    public void foreignDetailsonClick(View v) {
        expListView.setVisibility(View.GONE);
        expListView1.setVisibility(View.GONE);
        expListView2.setVisibility(View.VISIBLE);
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
        listDataHeader.add(getResources().getString(R.string.membership_silver));
        listDataHeader.add(getResources().getString(R.string.membership_golden));
        listDataHeader.add(getResources().getString(R.string.membership_platinum));

        // Adding child data
        List<String> level0 = new ArrayList<String>();
        level0.add(getResources().getString(R.string.membership_benefits_items_i));
        level0.add(getResources().getString(R.string.membership_benefits_items_ii));


        List<String> level1 = new ArrayList<String>();
        level1.add("Silver membership plus.");
        level1.add(getResources().getString(R.string.membership_benefits_items_iii));
        level1.add(getResources().getString(R.string.membership_benefits_items_iiii));


        List<String> level2 = new ArrayList<String>();
        level2.add("Golden membership plus.");
        level2.add(getResources().getString(R.string.membership_benefits_items_iiiii));
        level2.add(getResources().getString(R.string.membership_benefits_items_iiiiii));



        listDataChild.put(listDataHeader.get(0), level0); // Header, Child data
        listDataChild.put(listDataHeader.get(1), level1);
        listDataChild.put(listDataHeader.get(2), level2);



    }
}
