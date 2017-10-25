package com.yaashvisoftware.materialdesignexamples.activities.animations;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.View;
import android.widget.Button;

import com.yaashvisoftware.materialdesignexamples.R;
import com.yaashvisoftware.materialdesignexamples.activities.CustomTouchFeedbackThroughRippleActivity;
import com.yaashvisoftware.materialdesignexamples.activities.RevealEffectActivity;

public class AnimationsActivity extends AppCompatActivity {

    // Animations include
    /*Touch feedback - Ripple
    Circular Reveal
    Activity transitions
    //Curved motion
    //View state changes*/

    private Button btnCustomFeedback, btnRevealEffect, btnActivityTransitionsExplode,
            btnActivityTransitionsSlide, btnActivityTransitionsFade,
            btnActivityTransitionsEnterReturn, btnActivityTransitionsTheme,
            btnTransitionSharedElementActivities, btnTransitionSharedElementFragments;

    public static final String TRANSITIONEXPLODE = "explode";
    public static final String TRANSITIONSLIDE = "slide";
    public static final String TRANSITIONFADE = "fade";
    public static final String TRANSITIONENTERRETURN = "enter_return";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);

        findViewIds();

        setClickListeners();

        setData();

    }
    //End of onCreate()

    private void findViewIds() {

        btnCustomFeedback = (Button) findViewById(R.id.btnCustomFeedback);
        btnRevealEffect = (Button) findViewById(R.id.btnRevealEffect);
        btnActivityTransitionsExplode = (Button) findViewById(R.id.btnActivityTransitionsExplode);
        btnActivityTransitionsSlide = (Button) findViewById(R.id.btnActivityTransitionsSlide);
        btnActivityTransitionsFade = (Button) findViewById(R.id.btnActivityTransitionsFade);
        btnActivityTransitionsEnterReturn = (Button) findViewById(R.id.btnActivityTransitionsEnterReturn);
        btnActivityTransitionsTheme = (Button) findViewById(R.id.btnActivityTransitionsTheme);

        btnTransitionSharedElementActivities = (Button) findViewById(R.id.btnTransitionsSharedElementActivities);
        btnTransitionSharedElementFragments = (Button) findViewById(R.id.btnTransitionsSharedElementFragment);

    }
    //End of findViewIds()

    private void setClickListeners(){
        btnCustomFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimationsActivity.this, CustomTouchFeedbackThroughRippleActivity.class));
            }
        });

        btnRevealEffect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimationsActivity.this, RevealEffectActivity.class));
            }
        });

        btnActivityTransitionsExplode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpExplodeTransition();
                Intent intent = new Intent(AnimationsActivity.this, TransitionClassSecondActivity.class);
                intent.putExtra("transition_type", TRANSITIONEXPLODE);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                        AnimationsActivity.this).toBundle());
            }
        });

        btnActivityTransitionsSlide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpSlideTransition();
                Intent intent = new Intent(AnimationsActivity.this, TransitionClassSecondActivity.class);
                intent.putExtra("transition_type", TRANSITIONSLIDE);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                        AnimationsActivity.this).toBundle());
            }
        });

        btnActivityTransitionsFade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpFadeTransition();
                Intent intent = new Intent(AnimationsActivity.this, TransitionClassSecondActivity.class);
                intent.putExtra("transition_type", TRANSITIONFADE);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                        AnimationsActivity.this).toBundle());
            }
        });

        btnActivityTransitionsEnterReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setUpSlideTransition();
                Intent intent = new Intent(AnimationsActivity.this, TransitionClassSecondActivity.class);
                intent.putExtra("transition_type", TRANSITIONENTERRETURN);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                        AnimationsActivity.this).toBundle());
            }
        });

        btnActivityTransitionsTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setUpSlideTransition();
                Intent intent = new Intent(AnimationsActivity.this, TransitionUsingThemeActivity.class);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(
                        AnimationsActivity.this).toBundle());
            }
        });

        btnTransitionSharedElementActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimationsActivity.this, SharedElementActivity1.class));
            }
        });

        btnTransitionSharedElementFragments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AnimationsActivity.this, SharedElementFragmentsActivity.class));
            }
        });
    }
    //End of setClickListeners()

    private void setData(){
        /*// Re-enter transition is executed when returning to this activity
        Slide slideTransition = new Slide();
        slideTransition.setSlideEdge(Gravity.LEFT);
        slideTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
        getWindow().setReenterTransition(slideTransition);
        getWindow().setExitTransition(slideTransition);*/
    }
    //End of setData()

    private void setUpExplodeTransition(){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Transition explodeTransition = TransitionInflater.from(this).
                    inflateTransition(R.transition.activity_explode);
            getWindow().setExitTransition(explodeTransition);
            //getWindow().setReturnTransition(explodeTransition);
        }
    }
    //End of setUpExplodeTransition()

    private void setUpSlideTransition(){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide slideTransition = (Slide) TransitionInflater.from(this).inflateTransition(R.transition.activity_slide);
            getWindow().setExitTransition(slideTransition);
        }
    }
    //End of setUpSlideTransition()

    private void setUpFadeTransition(){
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            //Set Up Programmatically
            Fade fadeTransition = new Fade();
            fadeTransition.setDuration(getResources().getInteger(R.integer.activity_trasition_duration));
            getWindow().setExitTransition(fadeTransition);
        }
    }
    //End of setUpFadeTransition()
}
