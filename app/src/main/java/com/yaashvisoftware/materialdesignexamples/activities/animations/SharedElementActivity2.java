package com.yaashvisoftware.materialdesignexamples.activities.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yaashvisoftware.materialdesignexamples.R;

public class SharedElementActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_element2);

        View smallImageView = findViewById(R.id.smallerImageView);
        View editText = findViewById(R.id.editText);

        //Transition Set Using Java Code
        smallImageView.setTransitionName(getString(R.string.activity_text_trans));
        editText.setTransitionName(getString(R.string.activity_mixed_trans));
    }
}
