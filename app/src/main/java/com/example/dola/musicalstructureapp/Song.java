package com.example.dola.musicalstructureapp;

public class Song {
    private String songName;
    private String artistName;
    private String albumName;
    private int sImageResourceId;
    private double price;
    private double size;
    private boolean selected = false;


    public Song(String songName, String artistName, String albumName){
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
    }

    public Song(String songName, String artistName, int sImageResourceId){
        this.songName = songName;
        this.artistName = artistName;
        this.sImageResourceId = sImageResourceId;
    }

    public Song(String songName, String artistName, int sImageResourceId, double price){
        this.songName = songName;
        this.artistName = artistName;
        this.sImageResourceId = sImageResourceId;
        this.price = price;
    }

    public Song(String songName, String artistName, String albumName, int sImageResourceId){
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.sImageResourceId = sImageResourceId;
    }


    public Song(String songName, String artistName, String albumName, int sImageResourceId, double price){
        this.songName = songName;
        this.artistName = artistName;
        this.albumName = albumName;
        this.sImageResourceId = sImageResourceId;
        this.price = price;
    }


    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getsImageResourceId() {
        return sImageResourceId;
    }

    public void setsImageResourceId(int sImageResourceId) {
        this.sImageResourceId = sImageResourceId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }


    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
