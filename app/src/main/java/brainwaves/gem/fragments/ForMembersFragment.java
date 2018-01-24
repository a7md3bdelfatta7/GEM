package brainwaves.gem.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import brainwaves.gem.HelperMenu.MembershipActivity;
import brainwaves.gem.MainActivity;
import brainwaves.gem.R;

public class ForMembersFragment extends Fragment {

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.for_member_fragment, container, false);

        Button becomMember=(Button)rootView.findViewById(R.id.becomMember);

        becomMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),MembershipActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }



}
