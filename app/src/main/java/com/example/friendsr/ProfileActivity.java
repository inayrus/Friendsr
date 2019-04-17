package com.example.friendsr;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // get the data (Friend object) send by MainActivity
        Intent intent = getIntent();
        Friend sendFriend = (Friend) intent.getSerializableExtra("clicked_friend");

        // get the fields from ProfileActivity
        TextView name = findViewById(R.id.profileName);
        ImageView image = findViewById(R.id.profileImage);
        TextView bio = findViewById(R.id.profileBio);

        // set the Friend data in the fields
        String stringName = sendFriend.getName();
        name.setText(stringName);
        image.setImageResource(sendFriend.getDrawableId());
        bio.setText(sendFriend.getBio());

        // set the ratings listener
        RatingBar ratingView = findViewById(R.id.ratingBar);
        ratingView.setOnRatingBarChangeListener(new ratingsChange());

        // get the stored ratings data
        SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);
        Float rating = prefs.getFloat(stringName, 0);

        // if something stored under the key, set the rating
        if (rating != 0) {
            ratingView.setRating(rating);
        }
    }

    // a listener class for the rating changes
    private class ratingsChange implements RatingBar.OnRatingBarChangeListener {

        Intent intent = getIntent();
        Friend sendFriend = (Friend) intent.getSerializableExtra("clicked_friend");
        String name = sendFriend.getName();

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
            // get the dict with sharedPreferences
            SharedPreferences prefs = getSharedPreferences("settings", MODE_PRIVATE);

            // set an editor for the sharedPreferences file
            SharedPreferences.Editor editor = prefs.edit();

            // change the rating and store it under the key
            editor.putFloat(name, rating);

            // save the change
            editor.apply();
        }
    }
}
