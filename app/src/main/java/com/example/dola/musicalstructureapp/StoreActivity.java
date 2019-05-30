package com.example.dola.musicalstructureapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class StoreActivity extends AppCompatActivity {

    public static int SCREEN_NUMBER = 5;
    private double totalAmount = 0.0;
    private int seletedNumberOfSong = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Create an array of words
        final ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("Shallow", "Badley Cooper", R.drawable.shallowbradleycooper2018));
        songs.add(new Song("2002", "Anne-Marie", R.drawable._2002annemarie2018));
        songs.add( new Song("Havana", "Camila Cabello", R.drawable.havanacamilacabello2018));
        songs.add(new Song("Fake Love", "BTS", R.drawable.fakeloverockingbts2018));
        songs.add(new Song("When I'm with Him", "Empresso Of", R.drawable.whenimwithhimempressof2018));
        songs.add(new Song("Nice For What", "Drake", R.drawable.niceforwhatdrake2018));
        songs.add(new Song("Mariners Apartment", "Lana Del Rey", R.drawable.marinersapartementlanadelrey2018));
        songs.add(new Song("Drip Too Hard", "Gunna", R.drawable.driptoohardgunna2018));
        songs.add(new Song("Boo'd Up", "Ella Mai", R.drawable.boodupellamai2018));
        songs.add(new Song("Venice Bitch", "Lana Del Rey", R.drawable.venicebitchlanadelrey2018));
        songs.add(new Song("Self Care", "Mac Miller", R.drawable.selfcaremacmiller2018));

        ListView listView = findViewById(R.id.list);
        SongAdapter itemsAdapter = new SongAdapter(this, songs, SCREEN_NUMBER);

        listView.setAdapter(itemsAdapter);
        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
                Song song = songs.get(position);
                intent.putExtra("song_name", song.getSongName());
                intent.putExtra("artist_name", song.getArtistName());
                intent.putExtra("download_price", song.getPrice());
                intent.putExtra("cover_image_id", song.getsImageResourceId());
                startActivity(intent);
            }
        });
        */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.list_action_shop, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_buy_selected_song:

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Musical App: Song Bill")
                .setMessage(String.format("The total amount to paid is $%s ", totalAmount))
                        .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //Toast.makeText(this, "You paid, the download started", Toast.LENGTH_SHORT).show();
                            }
                        })

                .create()
                .show();
                return  true;
        }
        return super.onOptionsItemSelected(item);
    }

}
