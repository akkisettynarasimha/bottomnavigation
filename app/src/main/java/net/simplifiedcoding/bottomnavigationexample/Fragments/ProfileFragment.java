package net.simplifiedcoding.bottomnavigationexample.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.simplifiedcoding.bottomnavigationexample.R;

/**
 * Created by Belal on 1/23/2018.
 */

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view= inflater.inflate(R.layout.fragment_profile, null);
       return view;

    }
}
