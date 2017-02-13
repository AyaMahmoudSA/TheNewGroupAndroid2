package com.av.thegroup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Lobna on 2/1/2017.
 */
public class PerferredFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.activity_perferred,container,false);
        Toast.makeText(PerferredFragment.this.getActivity(),"",Toast.LENGTH_LONG).show();
        return rootView;

    }
}
