package com.example.dola.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST = 1;
    // Create an array of words
    public ArrayList<Song> songs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songs.add(new Song("Shallow", "Badley Cooper", R.drawable.shallowbradleycooper2018, 5.0));
        songs.add(new Song("2002", "Anne-Marie", R.drawable._2002annemarie2018, 8.0));
        songs.add( new Song("Havana", "Camila Cabello", R.drawable.havanacamilacabello2018, 3.0));
        songs.add(new Song("Fake Love", "BTS", R.drawable.fakeloverockingbts2018, 2.0));
        songs.add(new Song("When I'm with Him", "Empresso Of", R.drawable.whenimwithhimempressof2018, 9.0));
        songs.add(new Song("Nice For What", "Drake", R.drawable.niceforwhatdrake2018, 2.0));
        songs.add(new Song("Mariners Apartment", "Lana Del Rey", R.drawable.marinersapartementlanadelrey2018, 1.0));
        songs.add(new Song("Drip Too Hard", "Gunna", R.drawable.driptoohardgunna2018, 3.0));
        songs.add(new Song("Boo'd Up", "Ella Mai", R.drawable.boodupellamai2018, 10.0));
        songs.add(new Song("Venice Bitch", "Lana Del Rey", R.drawable.venicebitchlanadelrey2018, 10.0));
        songs.add(new Song("Self Care", "Mac Miller", R.drawable.selfcaremacmiller2018, 1.0));

        ListView listView = findViewById(R.id.list);
        SongAdapter itemsAdapter = new SongAdapter(this, songs);

        listView.setAdapter(itemsAdapter);

        Button btnQuitApp = findViewById(R.id.quit_activity_btn);
        btnQuitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.search_song:
                Intent intent = new Intent(this, SearchActivity.class);
                startActivity(intent);
                return  true;

            case R.id.action_buy_song:
                Intent i = new Intent(this, StoreActivity.class);
                startActivity(i);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


}
