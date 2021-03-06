package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.os.Debug;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import brainwaves.gem.MainActivity;
import brainwaves.gem.R;

public class CollectionsActivity extends AppCompatActivity {

    LinearLayout collectionFirstLayout;
    LinearLayout collectionSecondLayout;
    LinearLayout collectionResultLayout;
    LinearLayout collectionFilterLayout;
    static boolean filteredchecked = false;

    Button filterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_collections);
        getSupportActionBar().setTitle(getResources().getString(R.string.title_activity_collections));

        //result for research
        collectionResultLayout = (LinearLayout) findViewById(R.id.collection_SearchResultLV);
        collectionResultLayout.setVisibility(View.GONE);
        //Kings section
        collectionFirstLayout = (LinearLayout) findViewById(R.id.collection_FirstLayout);
        collectionFirstLayout.setVisibility(View.VISIBLE);
        //status section
        collectionSecondLayout = (LinearLayout) findViewById(R.id.collection_SecondLayout);
        collectionSecondLayout.setVisibility(View.VISIBLE);
        //filter section
        collectionFilterLayout = (LinearLayout) findViewById(R.id.collection_FilterLayout);
        collectionFilterLayout.setVisibility(View.GONE);


        //when filter was clicked
        filterButton = (Button) findViewById(R.id.collection_filterButton);
        filterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(!filteredchecked) {
                    collectionFilterLayout.setVisibility(View.VISIBLE);
                    filteredchecked = true;
                }else{
                    collectionFilterLayout.setVisibility(View.GONE);
                    collectionResultLayout.setVisibility(View.GONE);
                    collectionFirstLayout.setVisibility(View.VISIBLE);
                    collectionSecondLayout.setVisibility(View.VISIBLE);
                    filteredchecked = false;
                }
                    // Code here executes on main thread after user presses button
            }
        });

    }
    public void addArtifactDetails(View v) {
        Intent intent = new Intent(CollectionsActivity.this,
                ArtifactsActivity.class);

        intent.putExtra("id",""+v.getTag());
        startActivity(intent);
    }
    public void searchOnClick(View v) {
        TextView searchTxtView = (TextView) findViewById(R.id.collection_SearchTextView);
        String searchData = searchTxtView.getText().toString();

        if(collectionResultLayout.getChildAt(0).getId() == R.id.artifact_1){
            ImageButton searchResultImgBtnasdas = (ImageButton) findViewById(collectionResultLayout.getChildAt(0).getId());
        }
        ImageButton searchResultImgBtn = (ImageButton) findViewById(collectionResultLayout.getChildAt(0).getId());

        ArrayList<String> artifacts = new ArrayList<String>();
        artifacts.add(getString(R.string.artifact_title_1).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_2).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_3).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_4).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_5).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_6).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_7).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_8).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_9).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_10).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_11).toLowerCase().trim());
        artifacts.add(getString(R.string.artifact_title_12).toLowerCase().trim());


        searchData = searchData.toLowerCase();
        int artifactsIndex = 0;
        if(searchData.trim().isEmpty()){
            collectionFilterLayout.setVisibility(View.GONE);
            collectionResultLayout.setVisibility(View.GONE);
            collectionFirstLayout.setVisibility(View.VISIBLE);
            collectionSecondLayout.setVisibility(View.VISIBLE);
        }else {
            for (int i = 0; i < artifacts.size(); i++) {
                if (artifacts.get(i).contains(searchData.trim())) {
                    artifactsIndex = i + 1;
                    break;
                }
            }
            collectionFirstLayout.setVisibility(View.GONE);
            collectionSecondLayout.setVisibility(View.GONE);
            collectionResultLayout.setVisibility(View.VISIBLE);

            switch (artifactsIndex) {
                case 1:
                    searchResultImgBtn.setImageResource(R.drawable.highlight_i);
                    searchResultImgBtn.setTag(R.id.artifact_1);
                    break;
                case 2:
                    searchResultImgBtn.setImageResource(R.drawable.highlight_ii);
                    searchResultImgBtn.setTag(R.id.artifact_2);
                    break;
                case 3:
                    searchResultImgBtn.setImageResource(R.drawable.highlight_iii);
                    searchResultImgBtn.setTag(R.id.artifact_3);
                    break;
                case 4:
                    searchResultImgBtn.setImageResource(R.drawable.highlight_iv);
                    searchResultImgBtn.setTag(R.id.artifact_4);
                    break;
                case 5:
                    searchResultImgBtn.setImageResource(R.drawable.highlight_v);
                    searchResultImgBtn.setTag(R.id.artifact_5);
                    break;
                case 6:
                    searchResultImgBtn.setImageResource(R.drawable.highlight_xv);
                    searchResultImgBtn.setTag(R.id.artifact_6);
                    break;
                case 7:
                    searchResultImgBtn.setImageResource(R.drawable.highlight__i);
                    searchResultImgBtn.setTag(R.id.artifact_7);
                    break;
                case 8:
                    searchResultImgBtn.setImageResource(R.drawable.highlight__ii);
                    searchResultImgBtn.setTag(R.id.artifact_8);
                    break;
                case 9:
                    searchResultImgBtn.setImageResource(R.drawable.highlight__iii);
                    searchResultImgBtn.setTag(R.id.artifact_9);
                    break;
                case 10:
                    searchResultImgBtn.setImageResource(R.drawable.highlight__iv);
                    searchResultImgBtn.setTag(R.id.artifact_10);
                    break;
                case 11:
                    searchResultImgBtn.setImageResource(R.drawable.highlight__v);
                    searchResultImgBtn.setTag(R.id.artifact_11);
                    break;
                case 12:
                    searchResultImgBtn.setImageResource(R.drawable.highlight__xv);
                    searchResultImgBtn.setTag(R.id.artifact_12);
                    break;
            }
        }
    }
    public void onFilterRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        collectionResultLayout.setVisibility(View.GONE);
        collectionFirstLayout.setVisibility(View.VISIBLE);
        collectionSecondLayout.setVisibility(View.VISIBLE);
        collectionFilterLayout.setVisibility(View.VISIBLE);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.collections_filter_kings:
                if (checked)
                    collectionSecondLayout.setVisibility(View.GONE);
                break;
            case R.id.collections_filter_status:
                if (checked)
                    collectionFirstLayout.setVisibility(View.GONE);
                break;
        }
    }
    public void addArtifactToTour(View v) {
        Intent intent = new Intent(CollectionsActivity.this,
                ArtifactsActivity.class);
        intent.putExtra("id",""+v.getId());
        startActivity(intent);
    }
    @Override
    protected  void onDestroy() {
        super.onDestroy();
        Runtime.getRuntime().gc();
        System.gc();
    }
}
