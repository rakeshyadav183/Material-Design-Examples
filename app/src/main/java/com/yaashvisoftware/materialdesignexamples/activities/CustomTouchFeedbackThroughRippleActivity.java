package com.yaashvisoftware.materialdesignexamples.activities;

import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.yaashvisoftware.materialdesignexamples.R;

public class CustomTouchFeedbackThroughRippleActivity extends AppCompatActivity {

    private Button btnRippleThroughCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_touch_feedback_through_ripple);

        findViewIds();

        setClickListeners();

        setData();

    }
    //End of onCreate()

    private void findViewIds(){
        btnRippleThroughCode = (Button) findViewById(R.id.btnRippleThroughCode);
    }
    //End of findViewIds()

    private void setClickListeners(){
        btnRippleThroughCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    RippleDrawable rippleDrawable = (RippleDrawable) getDrawable(R.drawable.ripple_via_mask);
                    int height = btnRippleThroughCode.getHeight();
                    int width = btnRippleThroughCode.getWidth();
                    //Set Ripple in Center
                    if (rippleDrawable != null) {
                        rippleDrawable.setHotspot(width / 2, height / 2);
                    }
                    btnRippleThroughCode.setBackground(rippleDrawable);
                }
            }
        });
    }
    //End of setClickListeners()

    private void setData(){

    }
    //End of setData()
}
