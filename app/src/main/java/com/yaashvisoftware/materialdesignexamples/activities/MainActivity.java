package com.yaashvisoftware.materialdesignexamples.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yaashvisoftware.materialdesignexamples.R;
import com.yaashvisoftware.materialdesignexamples.activities.animations.AnimationsActivity;

public class MainActivity extends AppCompatActivity {

    private Button recyclerViewBtn, cardViewBtn, snackBarBtn, shadowsClippingBtn, animateVectorDrawablesBtn,
        alternateLayoutBtn, palleteBtn, floatingActionBtn, navigationDrawerBtn, animationsBtn;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewIds();

        setClickListeners();

    }
    //End of onCreate()

    private void findViewIds(){
        recyclerViewBtn = (Button) findViewById(R.id.recyclerViewBtn);
        cardViewBtn = (Button) findViewById(R.id.cardViewBtn);
        shadowsClippingBtn = (Button) findViewById(R.id.shadowsClippingBtn);
        snackBarBtn = (Button) findViewById(R.id.snackBarBtn);
        animateVectorDrawablesBtn = (Button) findViewById(R.id.animateVectorDrawablesBtn);
        alternateLayoutBtn = (Button) findViewById(R.id.alternateLayoutBtn);
        palleteBtn = (Button) findViewById(R.id.palleteBtn);
        floatingActionBtn = (Button) findViewById(R.id.floatingActionBtn);
        navigationDrawerBtn = (Button) findViewById(R.id.navigationDrawerBtn);
        animationsBtn = (Button) findViewById(R.id.animationsBtn);
    }
    //End of findViewIds();

    private void setClickListeners(){
        recyclerViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RecyclerViewActivity.class));
            }
        });

        cardViewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardViewActivity.class));
            }
        });

        snackBarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SnackBarActivity.class));
            }
        });

        shadowsClippingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ShadowClippingActivity.class));
            }
        });

        animateVectorDrawablesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnimateVectorDrawablesActivity.class));
            }
        });

        alternateLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AlternateLayoutActivity.class));
            }
        });

        palleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PalleteActivity.class));
            }
        });

        floatingActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FloatingActionButtonActivity.class));
            }
        });

        navigationDrawerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, NavigationDrawerActivity.class));
            }
        });

        animationsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnimationsActivity.class));
            }
        });
    }
    //End of setClickListeners()
}
