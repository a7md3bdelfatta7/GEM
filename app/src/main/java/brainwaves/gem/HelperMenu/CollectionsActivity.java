package brainwaves.gem.HelperMenu;

import android.content.Intent;
import android.os.Debug;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import brainwaves.gem.MainActivity;
import brainwaves.gem.R;

public class CollectionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_collections);
        LinearLayout collectionResultLayout = (LinearLayout) findViewById(R.id.collection_SearchResultLV);
        collectionResultLayout.setVisibility(View.GONE);
        LinearLayout collectionFirstLayout = (LinearLayout) findViewById(R.id.collection_FirstLayout);
        collectionFirstLayout.setVisibility(View.VISIBLE);
        LinearLayout collectionSecondLayout = (LinearLayout) findViewById(R.id.collection_FirstLayout);
        collectionSecondLayout.setVisibility(View.VISIBLE);


    }
    public void searchOnClick(View v) {
        TextView searchTxtView = (TextView) findViewById(R.id.collection_SearchTextView);
        String searchData = searchTxtView.getText().toString();
        LinearLayout collectionFirstLayout = (LinearLayout) findViewById(R.id.collection_FirstLayout);
        LinearLayout collectionSecondLayout = (LinearLayout) findViewById(R.id.collection_SecondLayout);
        LinearLayout collectionResultLayout = (LinearLayout) findViewById(R.id.collection_SearchResultLV);
        if(collectionResultLayout.getChildAt(0).getId() == R.id.artifact_1){
            ImageButton searchResultImgBtnasdas = (ImageButton) findViewById(collectionResultLayout.getChildAt(0).getId());
        }
        ImageButton searchResultImgBtn = (ImageButton) findViewById(collectionResultLayout.getChildAt(0).getId());

        ArrayList<String> artifacts = new ArrayList<String>();
        artifacts.add("tutAnkAmum");
        artifacts.add("ramsis");
        artifacts.add("shit");
        artifacts.add("fuck");
        artifacts.add("Lol");



        int artifactsIndex = 0;
        for(int i=0;i<artifacts.size();i++){
            if (artifacts.get(i).contains(searchData)) {
                artifactsIndex = i+1;
                break;
            }
        }
        collectionFirstLayout.setVisibility(View.GONE);
        collectionSecondLayout.setVisibility(View.GONE);
        collectionResultLayout.setVisibility(View.VISIBLE);

        switch (artifactsIndex){
            case 1:

                //searchResultImgBtn.setImageDrawable(getResources().getDrawable(R.drawable.highlight_i));
                searchResultImgBtn.setImageResource(R.drawable.highlight_i);
                searchResultImgBtn.setId(R.id.artifact_1);
                break;
            case 2:
                searchResultImgBtn.setImageResource(R.drawable.highlight_ii);
                searchResultImgBtn.setId(R.id.artifact_2);
                break;
            case 3:
                searchResultImgBtn.setImageResource(R.drawable.highlight_iii);
                searchResultImgBtn.setId(R.id.artifact_3);
                break;
            case 4:
                searchResultImgBtn.setImageResource(R.drawable.highlight_iv);
                searchResultImgBtn.setId(R.id.artifact_4);
                break;
            case 5:
                searchResultImgBtn.setImageResource(R.drawable.highlight_v);
                searchResultImgBtn.setId(R.id.artifact_5);
                break;
            case 6:
                searchResultImgBtn.setImageResource(R.drawable.highlight_xv);
                searchResultImgBtn.setId(R.id.artifact_6);
                break;
            case 7:
                searchResultImgBtn.setImageResource(R.drawable.highlight__i);
                searchResultImgBtn.setId(R.id.artifact_7);
                break;
            case 8:
                searchResultImgBtn.setImageResource(R.drawable.highlight__ii);
                searchResultImgBtn.setId(R.id.artifact_8);
                break;
            case 9:
                searchResultImgBtn.setImageResource(R.drawable.highlight__iii);
                searchResultImgBtn.setId(R.id.artifact_9);
                break;
            case 10:
                searchResultImgBtn.setImageResource(R.drawable.highlight__iv);
                searchResultImgBtn.setId(R.id.artifact_10);
                break;
            case 11:
                searchResultImgBtn.setImageResource(R.drawable.highlight__v);
                searchResultImgBtn.setId(R.id.artifact_11);
                break;
            case 12:
                searchResultImgBtn.setImageResource(R.drawable.highlight__xv);
                searchResultImgBtn.setId(R.id.artifact_12);
                break;
        }

    }
    public void artifactsDetailsonClick(View v) {
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
