package com.example.cpera.storefront;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RatingBar;

public class amethActivity extends AppCompatActivity {

    private SharedPreferences sharedPref;
    private SharedPreferences.Editor edit;
    private RatingBar amethStar;
    private Intent intent;
    private float stars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ameth);

        amethStar = findViewById(R.id.amethBar);
        //set up Sharedprefs
        sharedPref = this.getSharedPreferences("com.example.cpera.storefront", Context.MODE_PRIVATE);
        edit = sharedPref.edit();
        //grab/set current value on load
        amethStar.setRating(sharedPref.getFloat("amethStar", 0));
        //Listener for state change on stars
        amethStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {

            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                stars = amethStar.getRating();
                sharedPref.edit().putFloat("amethStar", stars).apply();
            }
        });

    }

}