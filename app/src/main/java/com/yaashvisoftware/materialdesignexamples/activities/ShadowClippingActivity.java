package com.yaashvisoftware.materialdesignexamples.activities;

import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;

import com.yaashvisoftware.materialdesignexamples.R;

public class ShadowClippingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shadow_clipping);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setClipping();
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void setClipping() {
        final ImageView cubsButton = (ImageView) findViewById(R.id.ivClip);
        final int paddingSize = 15;//getResources().getDimensionPixelSize(R.dimen.fab_inner_padding);
        final int imageSize = cubsButton.getDrawable().getIntrinsicWidth();
        ViewOutlineProvider provider = new ViewOutlineProvider() {
            @Override
            public void getOutline(View view, Outline outline) {
                //outline.setOval(paddingSize, paddingSize, imageSize - paddingSize, imageSize - paddingSize);
                outline.setRoundRect(paddingSize, paddingSize, imageSize - paddingSize,
                        imageSize - paddingSize, 5);
            }
        };
        cubsButton.setOutlineProvider(provider);
        cubsButton.setClipToOutline(true);
    }
}
