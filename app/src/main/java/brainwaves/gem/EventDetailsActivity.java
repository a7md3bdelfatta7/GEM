package brainwaves.gem;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import brainwaves.gem.HelperMenu.MembershipActivity;

import static android.view.View.VISIBLE;

public class EventDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_event_details);

        ActionBar actionBar=getSupportActionBar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.event_title_layout);

        TextView actionBarTitle=(TextView)findViewById(R.id.action_bar_title);


        ImageView eventDetailsImage=(ImageView)findViewById(R.id.event_details_img);
        TextView eventTitle=(TextView)findViewById(R.id.event_title);
        TextView eventDetails=(TextView)findViewById(R.id.event_details);

        Intent intent=getIntent();
        String eventId=intent.getStringExtra("EVENT_ID");

        LinearLayout memberContainer=(LinearLayout)findViewById(R.id.member_container);
        LinearLayout subscribeContainer=(LinearLayout)findViewById(R.id.subscribe_container);
        Button becomeMember=(Button)findViewById(R.id.becomMember);

        switch (Integer.parseInt(eventId)) {

            case R.id.for_member_event1:
            case R.id.for_member_event2:
            case R.id.for_member_event3:
                memberContainer.setVisibility(VISIBLE);
                subscribeContainer.setVisibility(View.GONE);
                becomeMember.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent=new Intent(EventDetailsActivity.this,MembershipActivity.class);
                        startActivity(intent);
                    }
                });

        }

        switch (Integer.parseInt(eventId)){

            case R.id.for_member_event1:
                eventDetailsImage.setImageResource(R.drawable.member_shape1);
                actionBarTitle.setText(R.string.member_event1_topic);
                eventTitle.setText(R.string.member_event1_topic);
                eventDetails.setText(R.string.temp_text);
                break;
            case R.id.for_member_event2:
                eventDetailsImage.setImageResource(R.drawable.member_shape2);
                actionBarTitle.setText(R.string.member_event2_topic);
                eventTitle.setText(R.string.member_event2_topic);
                eventDetails.setText(R.string.temp_text);
                break;
            case R.id.for_member_event3:
                eventDetailsImage.setImageResource(R.drawable.member_shape3);
                actionBarTitle.setText(R.string.member_event3_topic);
                eventTitle.setText(R.string.member_event3_topic);
                eventDetails.setText(R.string.temp_text);
                break;

            case R.id.featured_event1:
                eventDetailsImage.setImageResource(R.drawable.member_shape3);
                actionBarTitle.setText(R.string.featured_event1_topic);
                eventTitle.setText(R.string.featured_event1_topic);
                eventDetails.setText(R.string.temp_text);
                break;

            case R.id.featured_event2:
                eventDetailsImage.setImageResource(R.drawable.featured_shape2);
                actionBarTitle.setText(R.string.featured_event2_topic);
                eventTitle.setText(R.string.featured_event2_topic);
                eventDetails.setText(R.string.temp_text);
                break;

            case R.id.featured_event3:
                eventDetailsImage.setImageResource(R.drawable.featured_shape3);
                actionBarTitle.setText(R.string.featured_event3_topic);
                eventTitle.setText(R.string.featured_event3_topic);
                eventDetails.setText(R.string.temp_text);
                break;

            case R.id.featured_event4:
                eventDetailsImage.setImageResource(R.drawable.featured_shape4);
                actionBarTitle.setText(R.string.featured_event4_topic);
                eventTitle.setText(R.string.featured_event4_topic);
                eventDetails.setText(R.string.temp_text);
                break;

            case R.id.today_event1:
                eventDetailsImage.setImageResource(R.drawable.todaysevent_i);
                actionBarTitle.setText(R.string.event1_topic);
                eventTitle.setText(R.string.event1_topic);
                eventDetails.setText(R.string.temp_text);
                break;

            case R.id.today_event2:
                eventDetailsImage.setImageResource(R.drawable.todaysevent_ii);
                actionBarTitle.setText(R.string.event2_topic);
                eventTitle.setText(R.string.event2_topic);
                eventDetails.setText(R.string.temp_text);
                break;

            case R.id.today_event3:
                eventDetailsImage.setImageResource(R.drawable.todaysevent_iii);
                actionBarTitle.setText(R.string.event3_topic);
                eventTitle.setText(R.string.event3_topic);
                eventDetails.setText(R.string.temp_text);
                break;



        }

        Button subscribeButton=(Button)findViewById(R.id.subscribeButton);

        subscribeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView subscribeNum=(TextView)findViewById(R.id.subscribe_num);
                subscribeNum.setText("Going : 91");
                view.setVisibility(View.INVISIBLE);
            }
        });

    }
}
