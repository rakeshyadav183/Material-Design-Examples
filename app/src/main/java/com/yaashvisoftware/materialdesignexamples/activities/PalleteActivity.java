package com.yaashvisoftware.materialdesignexamples.activities;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yaashvisoftware.materialdesignexamples.R;

public class PalleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallete);

        final ImageView buttonGreen = (ImageView) findViewById(R.id.btnGreen);
        final ImageView buttonRed = (ImageView) findViewById(R.id.btnRed);
        final ImageView buttonBlue = (ImageView) findViewById(R.id.btnBlue);

        final LinearLayout llGreen = (LinearLayout) findViewById(R.id.llGreen);
        final LinearLayout llRed = (LinearLayout) findViewById(R.id.llRed);
        final LinearLayout llBlue = (LinearLayout) findViewById(R.id.llBlue);

        /*Drawable drawable = buttonGreen.getBackground();
        Log.d("Palette", "Drawable: " + drawable);
        BitmapDrawable bmDrawable = (BitmapDrawable) drawable;
        Log.d("Palette", "BitmapDrawable: " + bmDrawable);
        Bitmap bitmap = bmDrawable.getBitmap();
        Log.d("Palette", "Bitmap: " + bitmap);*/

        Bitmap bitmapGreen = ((BitmapDrawable) buttonGreen.getBackground()).getBitmap();
        Palette paletteGreen = Palette.from(bitmapGreen).generate();
        llGreen.setBackgroundColor(paletteGreen.getDominantColor(0));

        Bitmap bitmapRed = ((BitmapDrawable) buttonRed.getBackground()).getBitmap();
        Palette paletteRed = Palette.from(bitmapRed).generate();
        llRed.setBackgroundColor(paletteRed.getLightVibrantColor(0));

        Bitmap bitmapBlue = ((BitmapDrawable) buttonBlue.getBackground()).getBitmap();
        Palette paletteBlue = Palette.from(bitmapBlue).generate();
        llBlue.setBackgroundColor(paletteBlue.getLightVibrantColor(0));

    }
    //End of onCreate()
}
