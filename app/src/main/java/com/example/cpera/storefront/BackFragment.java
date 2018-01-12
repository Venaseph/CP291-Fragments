package com.example.cpera.storefront;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class BackFragment extends Fragment {

    private Intent intent;
    private Button back;
    private View backLayout;

    public BackFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        backLayout = inflater.inflate(R.layout.fragment_back, container, false);
        back = backLayout.findViewById(R.id.back);

        /*Attempted to use the imgClick functionality on the interface, but you wind up having to
        write the method you intend to use for the onClick on each activity that uses the frag. Not
        only that, but then you have to set the method to public and expose it as well, so said
        screw it  */
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //also acts as bundleSet() for rating bar state return via bundles
                startActivity(intent = new Intent(getContext(), MainActivity.class));
            }
        });

        return backLayout;
    }

}
