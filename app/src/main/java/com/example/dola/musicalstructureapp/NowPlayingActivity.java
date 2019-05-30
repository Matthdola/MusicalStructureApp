package com.example.dola.musicalstructureapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlayingActivity extends AppCompatActivity {

    private boolean isPlaying = false;
    private double currentTime=0;
    private double totalTime = 4;

    String songName,  artistName;
    double downloadPrice ;
    int coverImageResourceId ;

    @BindView(R.id.playing_song_name)
    TextView playingSongName ;

    @BindView(R.id.playing_artist_name)
    TextView playingArtistName ;

    @BindView(R.id.playing_cover_img)
    ImageView coverImageView ;

    @BindView(R.id.play_current_button)
    ImageButton playImageBtn;

    @BindView(R.id.play_next_button)
    ImageButton nextImageBtn;

    @BindView(R.id.play_previous_button)
    ImageButton previousImageBtn;

    @BindView(R.id.play_info_button)
    ImageButton infoImageBtn;

    @BindView(R.id.play_back_button)
    ImageButton backImageBtn;

    @BindView(R.id.play_show_others_button)
    ImageButton moreImageBtn;

    //@BindView(R.id.more_song_list)
    //LinearLayout moreSongList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        ButterKnife.bind(this);
        //getSupportActionBar().hide();

        songName = getIntent().getStringExtra("song_name");
        artistName = getIntent().getStringExtra("artist_name");
        downloadPrice = getIntent().getDoubleExtra("download_price", 0);
        coverImageResourceId = getIntent().getIntExtra("cover_image_id", 0);

        coverImageView.setImageResource(coverImageResourceId);
        playingSongName.setText(songName);
        playingArtistName.setText(artistName);

        playImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){
                    Toast.makeText(NowPlayingActivity.this, "You started playing", Toast.LENGTH_SHORT).show();
                    playImageBtn.setImageResource(R.drawable.baseline_pause_white_24);
                } else {
                    Toast.makeText(NowPlayingActivity.this, "You stopped playing", Toast.LENGTH_SHORT).show();
                    playImageBtn.setImageResource(R.drawable.baseline_play_arrow_white_24);
                }
                isPlaying = !isPlaying;
            }
        });


        nextImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(NowPlayingActivity.this, "You request the next song", Toast.LENGTH_SHORT).show();

            }
        });


        previousImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(NowPlayingActivity.this, "You request the previous song", Toast.LENGTH_SHORT).show();
            }
        });


        infoImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SongDetailActivity.class);
                i.putExtra("song_name", songName);
                i.putExtra("artist_name", artistName);
                i.putExtra("download_price", downloadPrice);
                i.putExtra("cover_image_id", coverImageResourceId);

                startActivity(i);
            }
        });

        backImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        moreImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(NowPlayingActivity.this, "Show more songs on the same screen", Toast.LENGTH_SHORT).show();
            //moreSongList.setVisibility(View.VISIBLE);
            }
        });

    }
}
