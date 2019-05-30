package com.example.dola.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongDetailActivity extends AppCompatActivity {
    @BindView(R.id.detail_song_name)
    TextView detailSongName ;

    @BindView(R.id.detail_artist_name)
    TextView detailArtistName ;

    @BindView(R.id.detail_song_price)
    TextView detailSongPrice ;

    @BindView(R.id.detail_cover_img)
    ImageView coverImageView;

    @BindView(R.id.buy_button)
    Button buyButton;


    @BindView(R.id.quit_detail_screen)
    Button quitDetailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);
        ButterKnife.bind(this);

        String songName = getIntent().getStringExtra("song_name");
        String artistName = getIntent().getStringExtra("artist_name");
        double downloadPrice = getIntent().getDoubleExtra("download_price", 0);
        int coverImageResourceId = getIntent().getIntExtra("cover_image_id", 0);

        coverImageView.setImageResource(coverImageResourceId);
        detailSongName.setText(songName);
        detailArtistName.setText(artistName);
        detailSongPrice.setText(String.format("Price: $ %s", downloadPrice));

        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SongDetailActivity.this, StoreActivity.class);
                startActivity(intent);
            }
        });

        quitDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
