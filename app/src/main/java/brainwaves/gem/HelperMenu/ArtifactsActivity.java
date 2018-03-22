package brainwaves.gem.HelperMenu;

import android.Manifest;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import brainwaves.gem.MainActivity;
import brainwaves.gem.R;
import brainwaves.gem.artifact_video;
import brainwaves.gem.data.ArtifactsContract;
import brainwaves.gem.data.ArtifactsFavourite;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ArtifactsActivity extends AppCompatActivity {

    int artifact_num;
    CallbackManager callbackManager; // for using fb
    ImageButton artifactAddedToTourImgButton;
    public static final int MY_PERMISSIONS_REQUEST_EXTERNAL_STORAGE=1;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_artifacts_details);

        if (Build.VERSION.SDK_INT == 23) {
            checkPermissions();
        }

        artifactAddedToTourImgButton = (ImageButton) findViewById(R.id.add_tourBtn);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.artifacts_actionbar);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        ImageView img = (ImageView) findViewById(R.id.artifact_details);
        TextView artifactActionBar = (TextView) findViewById(R.id.artifactNameActionBar);
        TextView aritfactDetailsText = (TextView) findViewById(R.id.artifact_details_text);
        TextView aritfactDetailsTitle = (TextView) findViewById(R.id.artifact_details_title);
        artifact_num = 0;
        switch (Integer.parseInt(id)) {
            case R.id.artifact_1:
                artifact_num = 1;
                img.setImageResource(R.drawable.highlight_i);
                aritfactDetailsTitle.setText(R.string.artifact_title_1);
                artifactActionBar.setText(R.string.artifact_title_1);
                aritfactDetailsText.setText(R.string.artifact_info_1);
                break;
            case R.id.artifact_2:
                artifact_num = 2;
                img.setImageResource(R.drawable.highlight_ii);
                aritfactDetailsTitle.setText(R.string.artifact_title_2);
                artifactActionBar.setText(R.string.artifact_title_2);
                aritfactDetailsText.setText(R.string.artifact_info_2);
                break;
            case R.id.artifact_3:
                artifact_num = 3;
                img.setImageResource(R.drawable.highlight_iii);
                aritfactDetailsTitle.setText(R.string.artifact_title_3);
                artifactActionBar.setText(R.string.artifact_title_3);
                aritfactDetailsText.setText(R.string.artifact_info_3);
                break;
            case R.id.artifact_4:
                artifact_num = 4;
                img.setImageResource(R.drawable.highlight_iv);
                aritfactDetailsTitle.setText(R.string.artifact_title_4);
                artifactActionBar.setText(R.string.artifact_title_4);
                aritfactDetailsText.setText(R.string.artifact_info_4);
                break;
            case R.id.artifact_5:
                artifact_num = 5;
                img.setImageResource(R.drawable.highlight_v);
                aritfactDetailsTitle.setText(R.string.artifact_title_5);
                artifactActionBar.setText(R.string.artifact_title_5);
                aritfactDetailsText.setText(R.string.artifact_info_5);
                break;
            case R.id.artifact_6:
                artifact_num = 6;
                img.setImageResource(R.drawable.highlight_xv);
                aritfactDetailsTitle.setText(R.string.artifact_title_6);
                artifactActionBar.setText(R.string.artifact_title_6);
                aritfactDetailsText.setText(R.string.artifact_info_6);
                break;
            case R.id.artifact_7:
                artifact_num = 7;
                img.setImageResource(R.drawable.highlight__i);
                aritfactDetailsTitle.setText(R.string.artifact_title_7);
                artifactActionBar.setText(R.string.artifact_title_7);
                aritfactDetailsText.setText(R.string.artifact_info_7);
                break;
            case R.id.artifact_8:
                artifact_num = 8;
                img.setImageResource(R.drawable.highlight__ii);
                aritfactDetailsTitle.setText(R.string.artifact_title_8);
                artifactActionBar.setText(R.string.artifact_title_8);
                aritfactDetailsText.setText(R.string.artifact_info_8);
                break;
            case R.id.artifact_9:
                artifact_num = 9;
                img.setImageResource(R.drawable.highlight__iii);
                aritfactDetailsTitle.setText(R.string.artifact_title_9);
                artifactActionBar.setText(R.string.artifact_title_9);
                aritfactDetailsText.setText(R.string.artifact_info_9);
                break;
            case R.id.artifact_10:
                artifact_num = 10;
                img.setImageResource(R.drawable.highlight__iv);
                aritfactDetailsTitle.setText(R.string.artifact_title_10);
                artifactActionBar.setText(R.string.artifact_title_10);
                aritfactDetailsText.setText(R.string.artifact_info_10);
                break;
            case R.id.artifact_11:
                artifact_num = 11;
                img.setImageResource(R.drawable.highlight__v);
                aritfactDetailsTitle.setText(R.string.artifact_title_11);
                artifactActionBar.setText(R.string.artifact_title_11);
                aritfactDetailsText.setText(R.string.artifact_info_11);
                break;
            case R.id.artifact_12:
                artifact_num = 12;
                img.setImageResource(R.drawable.highlight__xv);
                aritfactDetailsTitle.setText(R.string.artifact_title_12);
                artifactActionBar.setText(R.string.artifact_title_12);
                aritfactDetailsText.setText(R.string.artifact_info_12);
                break;
            case R.id.artifact_13:
                artifact_num = 13;
                img.setImageResource(R.drawable.staff_i);
                aritfactDetailsTitle.setText(R.string.artifact_title_13);
                artifactActionBar.setText(R.string.artifact_title_13);
                aritfactDetailsText.setText(R.string.artifact_info_13);
                break;
            case R.id.artifact_14:
                artifact_num = 14;
                img.setImageResource(R.drawable.staff_ii);
                aritfactDetailsTitle.setText(R.string.artifact_title_14);
                artifactActionBar.setText(R.string.artifact_title_14);
                aritfactDetailsText.setText(R.string.artifact_info_14);
                break;
            case R.id.artifact_15:
                artifact_num = 15;
                img.setImageResource(R.drawable.staff_iii);
                aritfactDetailsTitle.setText(R.string.artifact_title_15);
                artifactActionBar.setText(R.string.artifact_title_15);
                aritfactDetailsText.setText(R.string.artifact_info_15);
                break;
            case R.id.artifact_16:
                artifact_num = 16;
                img.setImageResource(R.drawable.staff_iv);
                aritfactDetailsTitle.setText(R.string.artifact_title_16);
                artifactActionBar.setText(R.string.artifact_title_16);
                aritfactDetailsText.setText(R.string.artifact_info_16);
                break;
            case R.id.artifact_17:
                artifact_num = 17;
                img.setImageResource(R.drawable.staff_v);
                aritfactDetailsTitle.setText(R.string.artifact_title_17);
                artifactActionBar.setText(R.string.artifact_title_17);
                aritfactDetailsText.setText(R.string.artifact_info_17);
                break;
            case R.id.artifact_18:
                artifact_num = 18;
                img.setImageResource(R.drawable.staff_xv);
                aritfactDetailsTitle.setText(R.string.artifact_title_18);
                artifactActionBar.setText(R.string.artifact_title_18);
                aritfactDetailsText.setText(R.string.artifact_info_18);
                break;
            case R.id.artifact_19:
                artifact_num = 19;
                img.setImageResource(R.drawable.staff__i);
                aritfactDetailsTitle.setText(R.string.artifact_title_19);
                artifactActionBar.setText(R.string.artifact_title_19);
                aritfactDetailsText.setText(R.string.artifact_info_19);
                break;
            case R.id.artifact_20:
                artifact_num = 20;
                img.setImageResource(R.drawable.staff__ii);
                aritfactDetailsTitle.setText(R.string.artifact_title_20);
                artifactActionBar.setText(R.string.artifact_title_20);
                aritfactDetailsText.setText(R.string.artifact_info_20);
                break;
            case R.id.artifact_21:
                artifact_num = 21;
                img.setImageResource(R.drawable.staff__iii);
                aritfactDetailsTitle.setText(R.string.artifact_title_21);
                artifactActionBar.setText(R.string.artifact_title_21);
                aritfactDetailsText.setText(R.string.artifact_info_21);
                break;
            case R.id.artifact_22:
                artifact_num = 22;
                img.setImageResource(R.drawable.staff__iv);
                aritfactDetailsTitle.setText(R.string.artifact_title_22);
                artifactActionBar.setText(R.string.artifact_title_22);
                aritfactDetailsText.setText(R.string.artifact_info_22);
                break;
            case R.id.artifact_23:
                artifact_num = 23;
                img.setImageResource(R.drawable.staff__v);
                aritfactDetailsTitle.setText(R.string.artifact_title_23);
                artifactActionBar.setText(R.string.artifact_title_23);
                aritfactDetailsText.setText(R.string.artifact_info_23);
                break;
            case R.id.artifact_24:
                artifact_num = 24;
                img.setImageResource(R.drawable.staff__xv);
                aritfactDetailsTitle.setText(R.string.artifact_title_24);
                artifactActionBar.setText(R.string.artifact_title_24);
                aritfactDetailsText.setText(R.string.artifact_info_24);
                break;
        }
        if (artifact_num > 12)
            artifactAddedToTourImgButton.setVisibility(View.GONE);
        highlightToFavourites();
        highlightTotour();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void shareonClick(View v) {
        Toast.makeText(this, "Done.", Toast.LENGTH_SHORT).show();
    }

    public void onButtonShowPopupWindowClick(View view) {


        callbackManager = CallbackManager.Factory.create();
        //Bitmap image = BitmapFactory.decodeResource(getResources(), R.drawable.fbpost);
        ShareDialog shareDialog;
        shareDialog = new ShareDialog(this);
        ShareLinkContent linkContent = new ShareLinkContent.Builder()
                .setContentUrl(Uri.parse("http://www.e-c-h-o.org/images/SchematicGEM.jpg")).setContentTitle("Greatest egyptian museum")
                .setQuote("Connect on a global scale.").setShareHashtag(new ShareHashtag.Builder()
                        .setHashtag("#GEM")
                        .build()).setRef("GEM APP")
                .build();
        shareDialog.show(linkContent);


    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void onButtonMapPopupWindowClick(View view) {

        // get a reference to the already created main layout
        ScrollView mainLayout = (ScrollView)
                findViewById(R.id.colltections_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_map, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void onButtonVRPopupWindowClick(View view) {

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            if (Build.VERSION.SDK_INT >= 23) {
                int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
                if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_EXTERNAL_STORAGE);
                }
            }
        } else {
            fun();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    fun();
                }
                return;
            }
        }
    }

    public void fun() {

        // get a reference to the already created main layout
        ScrollView mainLayout = (ScrollView)
                findViewById(R.id.colltections_main_layout);

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_vrunlock, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        popupWindow.showAtLocation(mainLayout, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });


    }

    public void unlockVR(View v) {

        /////////////////////////////////////////////
        List<ApplicationInfo> packages;
        PackageManager pm;
        pm = this.getPackageManager();
        //get a list of installed apps.
        packages = pm.getInstalledApplications(0);
        Context context = getApplicationContext();
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        String myPackage = getApplicationContext().getPackageName();
        for (ApplicationInfo packageInfo : packages) {
            if ((packageInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 1) continue;
            if (packageInfo.packageName.equals(myPackage)) continue;
            mActivityManager.killBackgroundProcesses(packageInfo.packageName);
        }

//////////////////////////////////////


        String path = "/storage/emulated/0/";
        File file = new File(path, "VR.txt");
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            stream.write("1".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
                //\PackageManager pm = this.getPackageManager();

                try {
                    Intent it = pm.getLaunchIntentForPackage("com.BrainWaves.GEM");

                    if (null != it)
                        this.startActivity(it);
                } catch (ActivityNotFoundException e) {
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void videoOnClick(View v) {

        if (!isNetworkAvailable()) {
            Intent intent = new Intent(ArtifactsActivity.this, artifact_video.class);
            intent.putExtra("artifact_num", artifact_num);
            startActivity(intent);
        } else {
            String[] artifactsVideoUrl = {"https://www.youtube.com/watch?v=FXk-NbSWDs8",
                    "https://www.youtube.com/watch?v=yKGe3FcmLLg",
                    "https://www.youtube.com/watch?v=lGq0dOH9qEA",
                    "https://www.youtube.com/watch?v=KTrEAvqYSKQ",
                    "https://www.youtube.com/watch?v=lzdTBKHjxQ4",
                    "https://www.youtube.com/watch?v=lGq0dOH9qEA",
                    "https://www.youtube.com/watch?v=X4gr4_aKgyI",
                    "https://www.youtube.com/watch?v=wgNYtrfD1U8",
                    "https://www.youtube.com/watch?v=DKO-rUJkA4M",
                    "https://www.youtube.com/watch?v=DKO-rUJkA4M",
                    "https://www.youtube.com/watch?v=yKGe3FcmLLg",
                    "https://www.youtube.com/watch?v=BRgWQNOu6v4",
                    "https://www.youtube.com/watch?v=ddazR1n7pA4",
                    "https://www.youtube.com/watch?v=K6YlJwPurVg",
                    "https://www.youtube.com/watch?v=6bv-XeM2l4U",
                    "https://www.youtube.com/watch?v=9n62e1HXjIg",
                    "https://www.youtube.com/watch?v=4j5yJRwMu0w",
                    "https://www.youtube.com/watch?v=L8XcVxUeSyc",
                    "https://www.youtube.com/watch?v=EnZKeNim8T8",
                    "https://www.youtube.com/watch?v=kIVbqlS05BQ",
                    "https://www.youtube.com/watch?v=lGq0dOH9qEA",
                    "https://www.youtube.com/watch?v=lGq0dOH9qEA",
                    "https://www.youtube.com/watch?v=LXrdxoWNA7M",
                    "https://www.youtube.com/watch?v=5OBXPmnkNoQ"};

            String[] artifactsVideoIds = {"FXk-NbSWDs8",
                    "yKGe3FcmLLg",
                    "lGq0dOH9qEA",
                    "KTrEAvqYSKQ",
                    "lzdTBKHjxQ4",
                    "lGq0dOH9qEA",
                    "X4gr4_aKgyI",
                    "wgNYtrfD1U8",
                    "DKO-rUJkA4M",
                    "DKO-rUJkA4M",
                    "yKGe3FcmLLg",
                    "BRgWQNOu6v4",
                    "ddazR1n7pA4",
                    "K6YlJwPurVg",
                    "6bv-XeM2l4U",
                    "9n62e1HXjIg",
                    "4j5yJRwMu0w",
                    "L8XcVxUeSyc",
                    "EnZKeNim8T8",
                    "kIVbqlS05BQ",
                    "lGq0dOH9qEA",
                    "lGq0dOH9qEA",
                    "LXrdxoWNA7M",
                    "5OBXPmnkNoQ"};
//        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(artifactsVideoUrl[artifact_num-1]));
//        startActivity(browserIntent);
            Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + artifactsVideoIds[artifact_num - 1]));
            Intent webIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.youtube.com/watch?v=" + artifactsVideoIds[artifact_num - 1]));
            try {
                this.startActivity(appIntent);
            } catch (ActivityNotFoundException ex) {
                this.startActivity(webIntent);
            }
        }

    }

    public void connectionOnClick(View v) {
        String[] artifactsConnectionsUrl = {"https://www.vanityfair.com/culture/2013/04/king-tut-exhibit-new-york",
                "https://www.britannica.com/biography/Amenhotep-II",
                "http://www.ancientegyptonline.co.uk/anubis.html",
                "http://www.touregypt.net/featurestories/ushabti.htm",
                "http://www.landofpyramids.org/sobek.htm",
                "https://isiopolis.com/2013/01/26/milk-the-magic-of-isis/",
                "https://www.flickr.com/photos/24729615@N00/33528187152/in/photostream/",
                "http://egypttoursinformation.blogspot.com.eg/2015/05/ing-amenemhat-iii-in-priestly-costume.html",
                "https://www.thecultureconcept.com/the-silver-pharaoh-psusennes-i-facing-the-afterlife-in-style",
                "http://ib205.tripod.com/psusennes-mummy.html",
                "http://www.egyptianmyths.net/mythhatshep.htm",
                "https://www.sav.sk/journals/uploads/05141128Magdolen.pdf",
                "http://www.globalegyptianmuseum.org/detail.aspx?id=4934",
                "http://www.touregypt.net/featurestories/coffins.htm",
                "https://www.pbslearningmedia.org/resource/xir68322/queen-kawit-at-her-toilet-from-the-sarc-xir68322-egyptian/#.WnLrZa6WYps",
                "https://www.thecultureconcept.com/the-silver-pharaoh-psusennes-i-facing-the-afterlife-in-style",
                "https://www.ancient.eu/image/3411/",
                "https://www.google.com/culturalinstitute/beta/asset/sandstone-ba-statue-of-a-woman/9wEPlxMrXHSn1A?hl=en",
                "https://www.egypttoursplus.com/tomb-of-king-tut/",
                "http://www.gizapyramids.org/pdf_library/hawass_fs_mokhtar.pdf",
                "http://www.ancientegyptonline.co.uk/anubis.html",
                "https://ancientart.as.ua.edu/head-of-a-cow-goddess-hathor/",
                "http://www.landofpyramids.org/uraeus.htm",
                "http://www.oneonta.edu/faculty/farberas/arth/arth200/Body/egypt_body.htm"};


        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(artifactsConnectionsUrl[artifact_num - 1]));
        startActivity(browserIntent);


    }

    public void HighlightsAddTofavouriteonClick(View v) {
        ImageButton flashButtonOn = (ImageButton) findViewById(R.id.favouritesActionBar);
        ArtifactsFavourite artifactFavourite = new ArtifactsFavourite(getApplicationContext());

        if (artifactFavourite.artifactExist(artifact_num + "")) {
            artifactFavourite.deleteArtifact(artifact_num);
            flashButtonOn.setImageResource(R.drawable.favourite_blank);
        } else {
            flashButtonOn.setImageResource(R.drawable.favourite_red);
            long result = artifactFavourite.addNewArtifact(artifact_num + "");
            if (result == -1) {
                Toast.makeText(this, "Failed to add! try again.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void HighlightsAddToTouronClick(View v) {
        ImageButton flashButtonOn = (ImageButton) findViewById(R.id.add_tourBtn);
        ArtifactsContract artifact = new ArtifactsContract(getApplicationContext());

        if (artifact.artifactExist(artifact_num + "")) {
            artifact.deleteArtifact(artifact_num);
            flashButtonOn.setImageResource(R.drawable.add_button_i);
        } else {
            flashButtonOn.setImageResource(R.drawable.add_button_ii);
            long result = artifact.addNewArtifact(artifact_num + "");
            if (result == -1) {
                Toast.makeText(this, "Failed to add! try again.", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Added Successfully", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public void highlightToFavourites() {
        ImageButton flashButtonOn = (ImageButton) findViewById(R.id.favouritesActionBar);
        ArtifactsFavourite artifactFavourite = new ArtifactsFavourite(getApplicationContext());
        if (artifactFavourite.artifactExist(artifact_num + "")) {
            flashButtonOn.setImageResource(R.drawable.favourite_red);
        }
    }

    public void highlightTotour() {
        ImageButton flashButtonOn = (ImageButton) findViewById(R.id.add_tourBtn);
        ArtifactsContract artifact = new ArtifactsContract(getApplicationContext());
        if (artifact.artifactExist(artifact_num + "")) {
            flashButtonOn.setImageResource(R.drawable.add_button_ii);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }


    String[] permissions = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,

    };

    private boolean checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String p : permissions) {
            result = ContextCompat.checkSelfPermission(this, p);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(p);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), 100);
            return false;
        }
        return true;
    }



    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Artifacts Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
