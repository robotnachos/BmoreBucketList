package com.example.android.bmorebucketlist;


import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FestivalsFragment extends Fragment {


    public FestivalsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Location> location = new ArrayList<Location>();
        location.add(new Location(getString(R.string.bike_title), getString(R.string.bike_address), getString(R.string.bike_description), R.drawable.bike));
        location.add(new Location(getString(R.string.kinetic_title), getString(R.string.kinetic_address), getString(R.string.kinetic_description), R.drawable.kinetic));
        location.add(new Location(getString(R.string.folk_title), getString(R.string.folk_address), getString(R.string.folk_description), R.drawable.folk));
        location.add(new Location(getString(R.string.crab_beer_title), getString(R.string.crab_beer_address), getString(R.string.crab_beer_description), R.drawable.crabbeer));

        LocationAdapter adapter = new LocationAdapter(getActivity(), location, R.color.color_white);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location locAddress = location.get(position);
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH );
                intent.putExtra(SearchManager.QUERY, locAddress.getTitleDescription() + " " + locAddress.getAddressLocation());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
