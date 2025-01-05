package model;

import java.util.*;

public class Client {

    public String nom;
    public String adresse;
    public String num;
    public Magasin magasin;
    public Location location;
    public Vector<Magasin> listMagasin = new Vector<Magasin>();
    public Vector<Location> listLocation = new Vector<Location>();

    public Client(String n, String a, String no, Magasin ms, Location l) {
        nom = n;
        adresse = a;
        num = no;
        magasin = ms;
        location = l;
    }

    // ajout d'un client
    public void ajoutClient(Client c) {
        magasin.listClient.add(c);
    }

    public void ajoutLocation(Location location) {
        listLocation.add(location);
    }

}