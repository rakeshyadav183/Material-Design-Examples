package com.yaashvisoftware.materialdesignexamples.activities.animations;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.yaashvisoftware.materialdesignexamples.R;
import com.yaashvisoftware.materialdesignexamples.fragments.SharedElementTransitionFragment1;

public class SharedElementFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element_fragments);

        SharedElementTransitionFragment1 startFragment = new SharedElementTransitionFragment1();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, startFragment)
                .commit();
    }
}
