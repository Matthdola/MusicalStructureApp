package com.example.dola.musicalstructureapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }


    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }


        // Get the Word object located at this position in the list
        Song currentSong = getItem(position);

        // Find the the ImageView in the list_item layout with the ID song_cover_img
        ImageView coverImage = listItemView.findViewById(R.id.song_cover_img);
        coverImage.setImageResource(currentSong.getsImageResourceId());

        // Find the the textView in the list_item layout with the ID title_text_view
        TextView titleTextView = listItemView.findViewById(R.id.title_text_view);

        // Get the SongName value from the current song object
        // Set the value to the textView
        titleTextView.setText(currentSong.getSongName());

        // Find the the textView in the list_item layout with the ID artist_text_view
        TextView artistTextView = listItemView.findViewById(R.id.artist_text_view);

        // Get the Artist name value from the current song object
        // Set the value to the textView
        artistTextView.setText(currentSong.getArtistName());

        return listItemView;
    }
}
