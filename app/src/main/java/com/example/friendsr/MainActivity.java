package com.example.friendsr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create an ArrayList to contains Friend objects
        ArrayList<Friend> friends = new ArrayList<>();

        // initialize the Friends to add
        String[] names = {"dustin","eleven","jonathan","joyce","lucas","max","mike","nancy","steve","will"};
        String[] bios = {"im a joker and the comic relief :)", "superpowers are real", "photography is my passion",
                         "WHERE IS MY BOI", "the person you need in a crisis", "im badass", "friend shaped, big nerd",
                         "SO BADASS", "get your redemption, be the dad friend", "im lost"};

        for(int i = 0; i < names.length; i++){
            int drawableId = getResources().getIdentifier(names[i], "drawable", getPackageName());
            friends.add(new Friend(names[i], bios[i], drawableId));
        }

        // connecting the adapter to the grid view
        // instantiate adapter
        FriendsAdapter adapter = new FriendsAdapter(this, R.layout.grid_item, friends);

        // attach the adapter to GridView (for both portrait and landscape)
        GridView mainView = findViewById(R.id.GridView);
        mainView.setAdapter(adapter);

        // connect the GridItemListener class to the GridView
        mainView.setOnItemClickListener(new GridItemListener());
    }

    // listener class for when an item (child) is clicked in the view produced by adapter (parent)
    private class GridItemListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            // get the Friend object that was clicked on. possible by indexing parent
            // (parent contains all shown Friend objects from the adapter list)
            Friend clickedFriend = (Friend) parent.getItemAtPosition(position);

            // pass the Friend object over to ProfileActivity (putExtra works bc of Serializable)
            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}
