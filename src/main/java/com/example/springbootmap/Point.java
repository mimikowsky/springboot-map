package com.example.springbootmap;

public class Point {
   
    private double lon;
    private double lat;
    private String text;

    public Point(double lon, double lat, String text) {
        this.lon = lon;
        this.lat = lat;
        this.text = text;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public String gettext() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
