package com.draz.amjad.amjadapp.myFragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.draz.amjad.amjadapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondMeal extends Fragment {


    public SecondMeal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_meal, container, false);
    }

}
