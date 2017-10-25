package com.yaashvisoftware.materialdesignexamples.activities;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.ImageView;

import com.yaashvisoftware.materialdesignexamples.R;

public class RevealEffectActivity extends AppCompatActivity {

    private FloatingActionButton fabEmailAndInfo;
    private ImageView ivView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reveal_effect);

        findViewIds();

        setClickListeners();

        setData();

    }
    //End of onCreate()

    private void findViewIds(){
        ivView = (ImageView) findViewById(R.id.ivView);
        fabEmailAndInfo = (FloatingActionButton) findViewById(R.id.fabEmailAndInfo);
    }
    //End of findViewIds()

    private void setClickListeners(){
        fabEmailAndInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (ivView.getVisibility() == View.INVISIBLE)
                        doCircularReveal();
                    else
                        doExitReveal();
                }
            }
        });
    }
    //End of setClickListeners()

    private void setData(){

    }
    //End of setData()

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void doCircularReveal() {

        // get the center for the clipping circle
        int centerX = (ivView.getLeft() + ivView.getRight()) / 2;
        int centerY = (ivView.getTop() + ivView.getBottom()) / 2;

        int startRadius = 0;
        // get the final radius for the clipping circle
        int endRadius = Math.max(ivView.getWidth(), ivView.getHeight());

        // create the animator for this view (the start radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(ivView, centerX, centerY, startRadius, endRadius);
        anim.setDuration(1000);

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });

        //Make the view visible because this was set invisible by exit reveal
        ivView.setVisibility(View.VISIBLE);
        anim.start();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    void doExitReveal() {

        // get the center for the clipping circle
        int centerX = (ivView.getLeft() + ivView.getRight()) / 2;
        int centerY = (ivView.getTop() + ivView.getBottom()) / 2;

        // get the initial radius for the clipping circle
        int initialRadius = ivView.getWidth();

        // create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(ivView,
                        centerX, centerY, initialRadius, 0);
        anim.setDuration(1000);
        // make the view invisible when the animation is done
        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                ivView.setVisibility(View.INVISIBLE);
            }
        });

        // start the animation
        anim.start();
    }
    //End of doExitReveal()
}
