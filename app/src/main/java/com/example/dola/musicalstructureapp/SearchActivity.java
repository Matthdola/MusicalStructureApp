package com.example.dola.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    public void searchSong(View view){

        // Search song
        EditText searchZoneEditText = findViewById(R.id.search_zone_edit);
        final String value = searchZoneEditText.getText().toString();
        if (value.isEmpty()){
            Toast.makeText(this, "No text is given to search", Toast.LENGTH_SHORT).show();
            return;
        }

        ProgressBar progressBar = findViewById(R.id.search_progress);
        progressBar.setVisibility(View.VISIBLE);

        final ArrayList<Song> findSong = new ArrayList<>();

        findSong.add(new Song("Shallow", "Badley Cooper", R.drawable.shallowbradleycooper2018));
        findSong.add(new Song("2002", "Anne-Marie", R.drawable._2002annemarie2018));
        findSong.add( new Song("Havana", "Camila Cabello", R.drawable.havanacamilacabello2018));
        findSong.add(new Song("Fake Love", "BTS", R.drawable.fakeloverockingbts2018));
        findSong.add(new Song("When I'm with Him", "Empresso Of", R.drawable.whenimwithhimempressof2018));
        findSong.add(new Song("Nice For What", "Drake", R.drawable.niceforwhatdrake2018));
        findSong.add(new Song("Mariners Apartment", "Lana Del Rey", R.drawable.marinersapartementlanadelrey2018));
        findSong.add(new Song("Drip Too Hard", "Gunna", R.drawable.driptoohardgunna2018));
        findSong.add(new Song("Boo'd Up", "Ella Mai", R.drawable.boodupellamai2018));
        findSong.add(new Song("Venice Bitch", "Lana Del Rey", R.drawable.venicebitchlanadelrey2018));
        findSong.add(new Song("Self Care", "Mac Miller", R.drawable.selfcaremacmiller2018));

        ArrayList<Song> result = new ArrayList<>();
        ListView listView = findViewById(R.id.list_found_song);
        SongAdapter itemsAdapter = new SongAdapter(this, findSong);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(SearchActivity.this, SongDetailActivity.class);
                Song song = findSong.get(position);
                intent.putExtra("song_name", song.getSongName());
                intent.putExtra("artist_name", song.getArtistName());
                intent.putExtra("download_price", song.getPrice());
                intent.putExtra("cover_image_id", song.getsImageResourceId());
                startActivity(intent);
            }
        });
        progressBar.setVisibility(View.GONE);
    }
}
