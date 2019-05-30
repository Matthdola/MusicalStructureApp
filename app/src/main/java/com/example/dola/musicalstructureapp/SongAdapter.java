package com.example.dola.musicalstructureapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;


import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    int screenNumber = 0;

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    public SongAdapter(Context context, ArrayList<Song> songs, int screenNumber) {
        super(context, 0, songs);
        this.screenNumber = screenNumber;
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        // Get the Word object located at this position in the list
        final Song currentSong = getItem(position);

        // Find the the ImageView in the list_item layout with the ID song_cover_img
        ImageView coverImage = listItemView.findViewById(R.id.song_cover_img);
        coverImage.setImageResource(currentSong.getsImageResourceId());
        coverImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), NowPlayingActivity.class);

                intent.putExtra("song_name", currentSong.getSongName());
                intent.putExtra("artist_name", currentSong.getArtistName());
                intent.putExtra("download_price", currentSong.getPrice());
                intent.putExtra("cover_image_id", currentSong.getsImageResourceId());

                getContext().startActivity(intent);
            }
        });

        // Find the the textView in the list_item layout with the ID title_text_view
        // Get the SongName value from the current song object
        // Set the value to the textView
        TextView titleTextView = listItemView.findViewById(R.id.title_text_view);
        titleTextView.setText(currentSong.getSongName());

        // Find the the textView in the list_item layout with the ID artist_text_view
        // Get the Artist name value from the current song object
        // Set the value to the textView
        TextView artistTextView = listItemView.findViewById(R.id.artist_text_view);
        artistTextView.setText(currentSong.getArtistName());

        // Find the the textView in the list_item layout with the ID price_text_view
        // Get the Song price  value from the current song object
        // Set the value to the textView
        TextView priceTextView = listItemView.findViewById(R.id.price_text_view);
        priceTextView.setText(String.format("$ %s",currentSong.getPrice()));


        final CheckBox checkBox = listItemView.findViewById(R.id.select_song);
        ImageButton imageButton = listItemView.findViewById(R.id.item_menu_btn);

        if (screenNumber == StoreActivity.SCREEN_NUMBER){
            checkBox.setVisibility(View.VISIBLE);
            imageButton.setVisibility(View.GONE);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (checkBox.isChecked()){
                        currentSong.setSelected(true);

                    } else {
                        currentSong.setSelected(false);
                    }
                }
            });
        } else {
            checkBox.setVisibility(View.GONE);
            imageButton.setVisibility(View.VISIBLE);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popup = new PopupMenu(getContext(), v);
                    MenuInflater inflater = popup.getMenuInflater();
                    inflater.inflate(R.menu.list_actions, popup.getMenu());
                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            Intent intent;
                            switch (item.getItemId()){
                                case R.id.action_play_song:
                                    intent = new Intent(getContext(), NowPlayingActivity.class);

                                    intent.putExtra("song_name", currentSong.getSongName());
                                    intent.putExtra("artist_name", currentSong.getArtistName());
                                    intent.putExtra("download_price", currentSong.getPrice());
                                    intent.putExtra("cover_image_id", currentSong.getsImageResourceId());

                                    getContext().startActivity(intent);
                                    return true;

                                case R.id.action_show_detail:
                                    intent = new Intent(getContext(), SongDetailActivity.class);

                                    intent.putExtra("song_name", currentSong.getSongName());
                                    intent.putExtra("artist_name", currentSong.getArtistName());
                                    intent.putExtra("download_price", currentSong.getPrice());
                                    intent.putExtra("cover_image_id", currentSong.getsImageResourceId());

                                    getContext().startActivity(intent);
                                    return true;

                                default:
                                    return false;
                            }
                        }
                    });
                    popup.show();
                }
            });
        }



        return listItemView;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

}
