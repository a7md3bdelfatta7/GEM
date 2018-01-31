package brainwaves.gem.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import java.util.ArrayList;

import brainwaves.gem.R;
import brainwaves.gem.data.ArtifactsContract;

/* Fragment used as page 2 */
public class HighlightsFragment extends Fragment {

    View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         rootView = inflater.inflate(R.layout.highlights_page, container, false);


        ArtifactsContract artifact=new ArtifactsContract(getActivity());
        ArrayList<String> selectedArtifacts=artifact.getSelectedArtifacts();

        for(String artifactId:selectedArtifacts){
            ImageButton img=(ImageButton) rootView.findViewWithTag(artifactId);
            img.setImageResource(R.drawable.add_button_ii);
        }

        return rootView;
    }

    @Override
    public void onResume() {


        ArtifactsContract artifact=new ArtifactsContract(getActivity());
        ArrayList<String> selectedArtifacts=artifact.getSelectedArtifacts();

        for(int i=1;i<=12;i++){
            ImageButton img=(ImageButton) rootView.findViewWithTag(String.valueOf(i));
            img.setImageResource(R.drawable.add_button_i);
        }

        for(String artifactId:selectedArtifacts){
            ImageButton img=(ImageButton) rootView.findViewWithTag(artifactId);
            img.setImageResource(R.drawable.add_button_ii);
        }

        super.onResume();
    }
}
