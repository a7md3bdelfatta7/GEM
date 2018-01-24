package brainwaves.gem.HelperMenu;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
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
        final Button childrenButton = (Button) findViewById(R.id.Children_btn);
        Button egyptainButton = (Button) findViewById(R.id.Egyptain_btn);
        Button foreignButton = (Button) findViewById(R.id.Foreign_btn);


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
                Intent intent = new Intent(MembershipActivity.this,
                        ShippingCheckoutActivity.class);
                intent.putExtra("id",""+v.getId());
                startActivity(intent);
                // Code here executes on main thread after user presses button
            }
        });
        childrenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                expListView.setVisibility(View.VISIBLE);
                expListView1.setVisibility(View.GONE);
                expListView2.setVisibility(View.GONE);

                // Code here executes on main thread after user presses button
            }
        });
        egyptainButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                expListView.setVisibility(View.GONE);
                expListView1.setVisibility(View.VISIBLE);
                expListView2.setVisibility(View.GONE);

                // Code here executes on main thread after user presses button
            }
        });
        foreignButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                expListView.setVisibility(View.GONE);
                expListView1.setVisibility(View.GONE);
                expListView2.setVisibility(View.VISIBLE);

                // Code here executes on main thread after user presses button
            }
        });

    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

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
        listDataHeader.add("Silver membership");
        listDataHeader.add("Golden membership");
        listDataHeader.add("Platinum membership");

        // Adding child data
        List<String> level0 = new ArrayList<String>();
        level0.add("Free express admission for you and children under 18.");
        level0.add("Free admission for your guest(s) on every visit.");


        List<String> level1 = new ArrayList<String>();
        level1.add("Silver membership plus.");
        level1.add("Early access to exhibitions and special viewing hours.");
        level1.add("Invitation to buy ticket to members only events and parties.");


        List<String> level2 = new ArrayList<String>();
        level2.add("Golden membership plus.");
        level2.add("10% off at the Dining room at GEM.");
        level2.add("10% off at GEM store.");





        listDataChild.put(listDataHeader.get(0), level0); // Header, Child data
        listDataChild.put(listDataHeader.get(1), level1);
        listDataChild.put(listDataHeader.get(2), level2);



    }
}
