package com.yaashvisoftware.materialdesignexamples.activities;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.yaashvisoftware.materialdesignexamples.R;

public class AnimateVectorDrawablesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animate_vector_drawables);
        final ImageView imageView1 = (ImageView)findViewById(R.id.ivRotable);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Drawable drawable = ((ImageView) v).getDrawable();
                    ((Animatable) drawable).start();
                } else {
                    imageView1.startAnimation(AnimationUtils.loadAnimation(AnimateVectorDrawablesActivity.this,
                            R.anim.rotation));
                }
            }
        });
    }
}
