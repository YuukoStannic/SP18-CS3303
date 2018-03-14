package com.example.jecsan.cscourses;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * This does nothing if the UI is in dual pane mode;
 * otherwise it will create a new DetailsFragment instance 
 * and display the new fragment
 */

public class CourseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            finish();
            return;
        }
        if(savedInstanceState == null){
            DetailsFragment detailsFragment = new DetailsFragment();
            detailsFragment.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, detailsFragment).commit();
        }
    }
}
