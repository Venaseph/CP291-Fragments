package com.example.cpera.storefront;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

public class cubeActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor edit;
    private RatingBar cubeStar;
    private Intent intent;
    private float stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        cubeStar = findViewById(R.id.cubeBar);
        //set up Sharedprefs
        sharedPref = this.getSharedPreferences("com.example.cpera.storefront", Context.MODE_PRIVATE);
        edit = sharedPref.edit();
        //grab/set current value on load
        cubeStar.setRating(sharedPref.getFloat("cubeStar", 0));
        //Listener for state change on stars
        cubeStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                stars = cubeStar.getRating();
                sharedPref.edit().putFloat("cubeStar", stars).apply();
            }
        });

    }

}

