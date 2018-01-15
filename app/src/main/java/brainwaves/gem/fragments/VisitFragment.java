package brainwaves.gem.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import brainwaves.gem.R;

/* Fragment used as page 1 */
public class VisitFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.visit_page, container, false);
        return rootView;
    }
}
