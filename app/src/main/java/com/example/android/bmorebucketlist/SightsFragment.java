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
public class SightsFragment extends Fragment {


    public SightsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        final ArrayList<Location> location = new ArrayList<Location>();
        location.add(new Location(getString(R.string.mchenry_title), getString(R.string.mchenry_address), getString(R.string.mchenry_description), R.drawable.fortmchenry));
        location.add(new Location(getString(R.string.aquarium_title), getString(R.string.aquarium_address), getString(R.string.aquarium_description), R.drawable.aquarium));
        location.add(new Location(getString(R.string.conservatory_title), getString(R.string.conservatory_address), getString(R.string.conservatory_description), R.drawable.conservatory));
        location.add(new Location(getString(R.string.industry_title), getString(R.string.industry_address), getString(R.string.industry_description), R.drawable.industry));


        LocationAdapter adapter = new LocationAdapter(getActivity(), location, R.color.color_white);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Location locAddress = location.get(position);
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, locAddress.getTitleDescription() + " " + locAddress.getAddressLocation());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
