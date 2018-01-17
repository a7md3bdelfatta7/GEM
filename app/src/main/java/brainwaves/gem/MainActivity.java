package brainwaves.gem;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

import brainwaves.gem.HelperMenu.ArtefactsActivity;
import brainwaves.gem.HelperMenu.CollectionsActivity;
import brainwaves.gem.HelperMenu.MembershipActivity;
import brainwaves.gem.HelperMenu.QuizActivity;
import brainwaves.gem.HelperMenu.VisitDetailsActivity;
import brainwaves.gem.fragments.ForMembersFragment;
import brainwaves.gem.fragments.StaffPicksFragment;
import brainwaves.gem.fragments.VisitFragment;
import brainwaves.gem.fragments.HighlightsFragment;
import brainwaves.gem.fragments.TodayEventFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    // Titles of the individual pages (displayed in tabs)
    private final String[] PAGE_TITLES = new String[] {
            "Visit",
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
            new TodayEventFragment()
    };

    // The ViewPager is responsible for sliding pages (fragments) in and out upon user input
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
                        switch (tabIndex) {
                            case 0:
                                color = Color.parseColor(getResources().getString(0 + R.color.visiColor));
                                break;
                            case 1:
                                color = Color.parseColor(getResources().getString(0 + R.color.highlightColor));
                                break;
                            case 2:
                                color = Color.parseColor(getResources().getString(0 + R.color.todayEventColor));
                                break;
                            case 3:
                                color = Color.parseColor(getResources().getString(0 + R.color.forMemberColor));
                                break;
                            case 4:
                                color = Color.parseColor(getResources().getString(0 + R.color.staffPicksColor));
                                break;
                            case 5:
                                color = Color.parseColor(getResources().getString(0 + R.color.featuredEventsColor));
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
    }
    public void VisitDetailsonClick(View v) {
        Intent visit = new Intent(MainActivity.this,
                VisitDetailsActivity.class);
        visit.putExtra("id",1);
        startActivity(visit);
    }
    public void HighlightsDetailsonClick(View v) {
        Intent visit = new Intent(MainActivity.this,
                ArtefactsActivity.class);
        visit.putExtra("id",1);
        startActivity(visit);
    }
    public void HighlightsAddToTouronClick(View v) {
        ImageButton flashButtonOn = (ImageButton) findViewById(v.getId());
        flashButtonOn.setImageResource(R.drawable.add_button_ii);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.collections_menu) {

            Intent visit = new Intent(MainActivity.this,
                    CollectionsActivity.class);
            startActivity(visit);
            // Handle the camera action

        } else if (id == R.id.shop_menu) {
            Uri uri = Uri.parse("http://www.statue.com/Products/Egyptian-Decor/");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);


        } else if (id == R.id.quiz_menu) {
            Intent visit = new Intent(MainActivity.this,
                    QuizActivity.class);
            startActivity(visit);

        } else if (id == R.id.membership_menu) {
            Intent visit = new Intent(MainActivity.this,
                    MembershipActivity.class);
            startActivity(visit);

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

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
}
