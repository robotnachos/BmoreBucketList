package com.example.android.bmorebucketlist;

import android.app.Activity;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sal on 2/21/17.
 */

public class LocationAdapter extends ArrayAdapter<Location>{

    private int mColorResourceID;


    public LocationAdapter(Activity context, ArrayList<Location> words, int colorResourceID) {

        super(context, 0, words);

        mColorResourceID = colorResourceID;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {

            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.title_text_view);

        titleTextView.setText(currentLocation.getTitleDescription());

        TextView addressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);

        addressTextView.setText(currentLocation.getAddressLocation());

        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);

        descriptionTextView.setText(currentLocation.getDescription());

        // Find the ImageView in the list_item.xml layout with the ID list_item_icon
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Get the image resource ID from the current AndroidFlavor object and
        // set the image to iconView

        if (currentLocation.hasImage()) {

            imageView.setImageResource(currentLocation.getImageResourceID());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceID);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        return listItemView;
    }

}
