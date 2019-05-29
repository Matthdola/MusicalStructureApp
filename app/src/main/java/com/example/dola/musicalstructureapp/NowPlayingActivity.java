package com.example.dola.musicalstructureapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NowPlayingActivity extends AppCompatActivity {

    private boolean isPlaying = false;
    private double currentTime=0;
    private double totalTime = 4;

    @BindView(R.id.playing_song_name)
    TextView playingSongName ;

    @BindView(R.id.playing_artist_name)
    TextView playingArtistName ;

    @BindView(R.id.playing_cover_img)
    ImageView coverImageView ;

    @BindView(R.id.play_current_button)
    ImageView playImageBtn;

    @BindView(R.id.play_next_button)
    ImageView nextImageBtn;

    @BindView(R.id.play_previous_button)
    ImageView previousImageBtn;

    @BindView(R.id.play_repeat_button)
    ImageView repeatImageBtn;

    @BindView(R.id.play_cancel_button)
    ImageView cancelImageBtn;

    @BindView(R.id.play_show_others_button)
    ImageView moreImageBtn;

    @BindView(R.id.more_song_list)
    LinearLayout moreSongList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        ButterKnife.bind(this);

        String songName = getIntent().getStringExtra("song_name");
        String artistName = getIntent().getStringExtra("artist_name");
        double downloadPrice = getIntent().getDoubleExtra("download_price", 0);
        int coverImageResourceId = getIntent().getIntExtra("cover_image_id", 0);

        coverImageView = findViewById(R.id.playing_cover_img);
        coverImageView.setImageResource(coverImageResourceId);

        playingSongName = findViewById(R.id.playing_song_name);
        playingSongName.setText(songName);


        playingArtistName = findViewById(R.id.playing_artist_name);
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


        repeatImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(NowPlayingActivity.this, "You set playing to repeat mode", Toast.LENGTH_SHORT).show();

            }
        });

        cancelImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this, "You clicked on the shuffle button", Toast.LENGTH_SHORT).show();
            }
        });

        moreImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(NowPlayingActivity.this, "Show more songs on the same screen", Toast.LENGTH_SHORT).show();
                moreSongList.setVisibility(View.VISIBLE);
            }
        });


    }
}
