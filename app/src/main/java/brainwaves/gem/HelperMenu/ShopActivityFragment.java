package brainwaves.gem.HelperMenu;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import brainwaves.gem.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class ShopActivityFragment extends Fragment {

    public ShopActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_shop, container, false);
    }
}
