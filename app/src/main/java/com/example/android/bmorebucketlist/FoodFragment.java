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
public class FoodFragment extends Fragment {


    public FoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Location> location = new ArrayList<Location>();
        location.add(new Location(getString(R.string.chaps_title), getString(R.string.chaps_address), getString(R.string.chaps_description), R.drawable.chaps));
        location.add(new Location(getString(R.string.faidleys_title), getString(R.string.faidleys_address), getString(R.string.faidleys_description), R.drawable.crab));
        location.add(new Location(getString(R.string.woodberry_title), getString(R.string.woodberry_address), getString(R.string.woodberry_description), R.drawable.woodberry));
        location.add(new Location(getString(R.string.parts_title), getString(R.string.parts_address), getString(R.string.parts_description), R.drawable.parts));

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
