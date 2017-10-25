package com.yaashvisoftware.materialdesignexamples.activities.animations;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;

import com.yaashvisoftware.materialdesignexamples.R;

public class TransitionClassSecondActivity extends AppCompatActivity {

    private String transitionType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_class_second);

        setUpEnterTransition();
    }
    //End of onCreate()

    private void setUpEnterTransition(){
        transitionType = getIntent().getStringExtra("transition_type");
        if(transitionType.equals(AnimationsActivity.TRANSITIONEXPLODE)){
            setUpExplodeTransition();
        } else if(transitionType.equals(AnimationsActivity.TRANSITIONFADE)){
            setUpFadeTransition();
        } else if(transitionType.equals(AnimationsActivity.TRANSITIONSLIDE)){
            setUpSlideTransition();
        } else if(transitionType.equals(AnimationsActivity.TRANSITIONENTERRETURN)){
            setUpEnterReturnAnimation();
        }
    }
    //End of setUpEnterTransition()

    private void setUpExplodeTransition(){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition explodeTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_explode);
            getWindow().setEnterTransition(explodeTransition);
        }
    }
    //End of setUpExplodeTransition()

    private void setUpSlideTransition(){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition slideTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
            getWindow().setEnterTransition(slideTransition);
        }
    }
    //End of setUpSlideTransition()

    private void setUpFadeTransition(){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Set Up Programmatically
            Fade fadeTransition = new Fade();
            fadeTransition.setDuration(getResources().getInteger(R.integer.activity_trasition_duration));
            getWindow().setEnterTransition(fadeTransition);
        }
    }
    //End of setUpFadeTransition()

    private void setUpEnterReturnAnimation(){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition explodeTransition = TransitionInflater.from(this).inflateTransition(R.transition.activity_explode);
            getWindow().setEnterTransition(explodeTransition);

            Slide slide = new Slide();
            slide.setDuration(getResources().getInteger(R.integer.activity_trasition_duration));
            getWindow().setReturnTransition(slide);
        }
    }
    //End of setUpEnterReturnAnimation()
}
