package brainwaves.gem;

import android.app.ActivityManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import brainwaves.gem.HelperMenu.ArtifactsActivity;
import brainwaves.gem.HelperMenu.CollectionsActivity;
import brainwaves.gem.HelperMenu.Favourites;
import brainwaves.gem.HelperMenu.MembershipActivity;
import brainwaves.gem.HelperMenu.QuizActivity;
import brainwaves.gem.HelperMenu.ShoppingCheckoutActivity;
import brainwaves.gem.HelperMenu.Tour;
import brainwaves.gem.ShoppingSystem.ShoppingActivity;
import brainwaves.gem.data.ArtifactsContract;
import brainwaves.gem.data.UserContract;
import brainwaves.gem.fragments.FeaturedEventsFragment;
import brainwaves.gem.HelperMenu.VisitDetailsActivity;import brainwaves.gem.fragments.ForMembersFragment;
import brainwaves.gem.fragments.StaffPicksFragment;
import brainwaves.gem.fragments.VisitFragment;
import brainwaves.gem.fragments.HighlightsFragment;
import brainwaves.gem.fragments.TodayEventFragment;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String LOG_TAG = MainActivity.class.getSimpleName();
    //ImageView advertismentImage;
    Animation hyperspaceJumpAnimation;
    ImageView imageView;
    int tabAddImgID = R.drawable.coca;

    // Titles of the individual pages (displayed in tabs)
    private final String[] PAGE_TITLES = new String[] {
            "VISIT",
            "HIGHLIGHTS",
            "TODAY'S EVENT",
            "FOR MEMBERS",
            "STAFF PICKS",
            "FEATURED EVENTS",
    };

    // The fragments that are used as the individual pages
    private final Fragment[] PAGES = new Fragment[] {
            new VisitFragment(),
            new HighlightsFragment(),
            new TodayEventFragment(),
            new ForMembersFragment(),
            new StaffPicksFragment(),
            new FeaturedEventsFragment()
    };

    // The ViewPager is responsible for sliding pages (fragments) in and out upon user input
    private ViewPager mViewPager;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyPagerAdapter(getFragmentManager()));

        final View navHeaderView=navigationView.getHeaderView(0);

        ////////////////actionbar///////////
        //advertismentImage = (ImageView) findViewById(R.id.advertisement);
        hyperspaceJumpAnimation = AnimationUtils.loadAnimation(this, R.anim.animation);
        imageView=(ImageView)findViewById(R.id.mapIcon);
        //advertismentImage.startAnimation(hyperspaceJumpAnimation);

        new CountDownTimer(900000, 4000) {

            public void onTick(long millisUntilFinished) {
                advertismentfn();
            }

            public void onFinish() {
                //Restart timer if you want.
            }
        }.start();

        // Connect the tabs with the ViewPager (the setupWithViewPager method does this for us in
        // both directions, i.e. when a new tab is selected, the ViewPager switches to this page,
        // and when the ViewPager switches to a new page, the corresponding tab is selected)
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(mViewPager);

        final AppBarLayout appBarLayout=(AppBarLayout)findViewById(R.id.appbar);

        final Window window = MainActivity.this.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // clear FLAG_TRANSLUCENT_STATUS flag:
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor("#FF1E1E"));
        }


        tabLayout.setOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(mViewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        int tabIndex = tab.getPosition();
                        int color = Color.parseColor(getResources().getString(0 + R.color.visiColor));
                        //advertismentImage.setImageResource(R.drawable.coca);
                        switch (tabIndex) {
                            case 0:
                                color = Color.parseColor(getResources().getString(0 + R.color.visiColor));
                                //advertismentImage.setImageResource(R.drawable.coca);
                                tabAddImgID = R.drawable.coca;
                                break;
                            case 1:
                                color = Color.parseColor(getResources().getString(0 + R.color.highlightColor));
                                //advertismentImage.setImageResource(R.drawable.vodafone);
                                tabAddImgID = R.drawable.vodafone;
                                break;
                            case 2:
                                color = Color.parseColor(getResources().getString(0 + R.color.todayEventColor));
                                //advertismentImage.setImageResource(R.drawable.cadbury);
                                tabAddImgID = R.drawable.cadbury;
                                break;
                            case 3:
                                color = Color.parseColor(getResources().getString(0 + R.color.forMemberColor));
                                //advertismentImage.setImageResource(R.drawable.we);
                                tabAddImgID = R.drawable.we;
                                break;
                            case 4:
                                color = Color.parseColor(getResources().getString(0 + R.color.staffPicksColor));
                                //advertismentImage.setImageResource(R.drawable.pepsi);
                                tabAddImgID = R.drawable.pepsi;
                                break;
                            case 5:
                                color = Color.parseColor(getResources().getString(0 + R.color.featuredEventsColor));
                                //advertismentImage.setImageResource(R.drawable.etisalat);
                                tabAddImgID = R.drawable.etisalat;
                                break;

                        }

                        appBarLayout.setBackgroundColor(color);
                        navHeaderView.setBackgroundColor(color);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            window.setStatusBarColor(color);
                        }
                    }
                }
        );


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Map.class);
                startActivity(intent);
            }
        });

        TextView fullName=(TextView)navHeaderView.findViewById(R.id.full_name);
        TextView userDetails=(TextView)navHeaderView.findViewById(R.id.user_details);
        fullName.setText(UserContract.fullName);
        userDetails.setText(UserContract.nationality+"-"+UserContract.birthDate);

    }
    public void VisitDetailsonClick(View v) {
        Intent intent = new Intent(MainActivity.this,
                VisitDetailsActivity.class);
        intent.putExtra("id",""+v.getId());
        startActivity(intent);
    }

    public void addArtifactToTour(View v) {
        Intent intent = new Intent(MainActivity.this,
                ArtifactsActivity.class);
        intent.putExtra("id",""+v.getId());
        startActivity(intent);
    }

    public void HighlightsAddToTouronClick(View v) {
        ImageButton flashButtonOn = (ImageButton) findViewById(v.getId());
        flashButtonOn.setImageResource(R.drawable.add_button_ii);

        ArtifactsContract artifact=new ArtifactsContract(getApplicationContext());
        String artifactId=String.valueOf(v.getTag());
        if(artifact.artifactExist(artifactId)){
            artifact.deleteArtifact(Integer.parseInt(artifactId));
            flashButtonOn.setImageResource(R.drawable.add_button_i);
            //Toast.makeText(this,"Already Added", Toast.LENGTH_SHORT).show();
        }else {
            long result= artifact.addNewArtifact(artifactId);
            if (result == -1) {
                Toast.makeText(this, "Failed to add! try again.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.collections_menu) {

            Intent itent = new Intent(MainActivity.this,
                    CollectionsActivity.class);
            startActivity(itent);
            // Handle the camera action

        } else if (id == R.id.shop_menu) {
            Intent itent = new Intent(MainActivity.this,
                    ShoppingActivity.class);
            startActivity(itent);


        } else if (id == R.id.quiz_menu) {
            Intent visit = new Intent(MainActivity.this,
                    QuizActivity.class);
            startActivity(visit);

        } else if (id == R.id.membership_menu) {
            Intent visit = new Intent(MainActivity.this,
                    MembershipActivity.class);
            startActivity(visit);

        } else if (id == R.id.tour_menu) {
            Intent tour = new Intent(MainActivity.this,
                    Tour.class);
            startActivity(tour);
        } else if (id == R.id.ticket_menu) {
            Intent intent = new Intent(MainActivity.this, ShoppingCheckoutActivity.class);
            intent.putExtra("purpose","ticket");
            startActivity(intent);

        }
        else if (id == R.id.Favourite_menu) {
            Intent Favourites = new Intent(MainActivity.this,
                    Favourites.class);
            startActivity(Favourites);
        } else if (id == R.id.AR_menu) {



/////////////////////////////////////////////
            List<ApplicationInfo> packages;
            PackageManager pm;
            pm = this.getPackageManager();
            //get a list of installed apps.
            packages = pm.getInstalledApplications(0);
            Context context = getApplicationContext();
            ActivityManager mActivityManager = (ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE);
            String myPackage = getApplicationContext().getPackageName();
            for (ApplicationInfo packageInfo : packages) {
                if((packageInfo.flags & ApplicationInfo.FLAG_SYSTEM)==1)continue;
                if(packageInfo.packageName.equals(myPackage)) continue;
                mActivityManager.killBackgroundProcesses(packageInfo.packageName);
            }


//////////////////////////////////////



//            PackageManager pm = this.getPackageManager();

            try
            {
                Intent it = pm.getLaunchIntentForPackage("com.BrainWaves.GEM");

                if (null != it)
                    this.startActivity(it);
            }

            catch (ActivityNotFoundException e)
            {
            }

        }else if (id == R.id.logout_menu) {
            UserContract user=new UserContract(getApplicationContext());
            user.deleteSharedPreference();
            Intent intent=new Intent(MainActivity.this,ChooseLangActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            ActivityCompat.finishAffinity(MainActivity.this);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /* PagerAdapter for supplying the ViewPager with the pages (fragments) to display. */
    public class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }
        @Override
        public Fragment getItem(int position) {
            return PAGES[position];
        }

        @Override
        public int getCount() {
            return PAGES.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return PAGE_TITLES[position];
        }

    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }

    public void eventOnClick(View v) {

        int eventId=v.getId();
        Intent intent = new Intent(getApplicationContext(),EventDetailsActivity.class);
        intent.putExtra("EVENT_ID",""+eventId);
        startActivity(intent);
    }


    public void nextPage(View v){

        mViewPager.setCurrentItem(mViewPager.getCurrentItem()+1);

    }



    public void advertismentfn(){
        if(imageView.getTag() == "Map"){
            imageView.setImageResource(tabAddImgID);
            imageView.setTag("Add");
            imageView.startAnimation(hyperspaceJumpAnimation);
        }
        else {
            imageView.setTag("Map");
            imageView.setImageResource(R.drawable.map_icon);
        }
    }





}
