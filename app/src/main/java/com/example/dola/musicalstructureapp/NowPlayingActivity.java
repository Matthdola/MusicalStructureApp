package com.example.dola.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        String songName = getIntent().getStringExtra("song_name");
        String artistName = getIntent().getStringExtra("artist_name");
        double downloadPrice = getIntent().getDoubleExtra("download_price", 0);
        int coverImageResourceId = getIntent().getIntExtra("cover_image_id", 0);

        ImageView coverImageView = findViewById(R.id.playing_cover_img);
        coverImageView.setImageResource(coverImageResourceId);

        TextView playingSongName = findViewById(R.id.playing_song_name);
        playingSongName.setText(songName);


        TextView playingArtistName = findViewById(R.id.playing_artist_name);
        playingArtistName.setText(artistName);


        //TextView playingSongPrice = findViewById(R.id.playing_song_price);
        //playingSongPrice.setText(downloadPrice);
    }
}
