package com.example.friendsr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {

    // instantiate variables
    private ArrayList<Friend> friends;

    // a constructor
    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
        super(context, resource, objects);

        // save the gotten Friend ArrayList in this FriendsAdapter class
        this.friends = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // convertView will be made when grid is shown for the first time
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

        // otherwise, recycle convertView
        ImageView image = convertView.findViewById(R.id.gridImage);
        TextView text = convertView.findViewById(R.id.gridName);

        // accessing the information we want to display
        Friend friend = friends.get(position);

        // assigning the new data to the Views
        image.setImageResource(friend.getDrawableId());
        text.setText(friend.getName());

        return convertView;
    }


}
