package brainwaves.gem.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import brainwaves.gem.R;

/* Fragment used as page 2 */
public class HighlightsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.highlights_page, container, false);

        ImageButton img=(ImageButton) rootView.findViewWithTag("1");
        img.setImageResource(R.drawable.);
        return rootView;
    }

}
