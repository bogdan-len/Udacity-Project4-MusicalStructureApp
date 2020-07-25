package com.example.musicalstructureapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ArtistsFragment extends Fragment {


    public ArtistsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.song_list, container, false);

        final ArrayList<Song> albums = new ArrayList<Song>();
        albums.add(new Song("Coldplay", R.drawable.coldplay_ghost_stories));
        albums.add(new Song("Eminem", R.drawable.eminem_kamikaze));
        albums.add(new Song("George Ezra", R.drawable.george_ezra_staying_at_tamara));
        albums.add(new Song("Rihanna", R.drawable.rihanna_a_girl_like_me));
        albums.add(new Song("Linkin Park", R.drawable.linkin_park_hybrid_theory));
        albums.add(new Song("U2", R.drawable.u2_the_saints_are_comming));


        SongAdapter adapter = new SongAdapter(getActivity(), albums);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(getContext(), NowPlayingActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
