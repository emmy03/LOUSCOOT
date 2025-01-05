package model;

public class Location {

    public String dateDeb;
    public int duree;
    public Scooter scooter;
    public Magasin magasin;
    public Client client;

    public Location(String d, int du, Magasin ms, Scooter s, Client c) {
        dateDeb = d;
        duree = du;
        magasin = ms;
        scooter = s;
        client = c;
    }

    public Scooter getScooter() {
        return scooter;
    }

}