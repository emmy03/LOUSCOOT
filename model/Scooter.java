package model;

import java.util.*;

public class Scooter {

	// nouvel attribut pour l'état de disponibilité du scooter
	private boolean disponible;

	public String modele;
	public int numId;
	public int kilometrage;
	public int prix;
	public Magasin magasin;
	public Location location;
	public Vector<Location> listLocation = new Vector<Location>();

	public Scooter(String m, int n, int k, int i, Magasin ms, Location l) {
		modele = m;
		numId = n;
		kilometrage = k;
		prix = i;
		magasin = ms;
		location = l;
		disponible = true; // on initialise le scooter comme disponible par défaut
	}

	// retourne une représentation textuelle de l'objet Scooter
	public String toString() {
		return "Scooter [marque=" + modele + ", id=" + numId + ", prix(euros/jour)=" + prix + ", disponibilite="
				+ disponible + ", kilométrage=" + kilometrage + "]";
	}

	// méthode pour marquer le scooter comme loué et non disponible
	public void louer() {
		disponible = false;
	}

	// méthode pour marquer le scooter comme disponible après une location
	public void rendre() {
		disponible = true;
	}

	// méthode pour vérifier l'état de disponibilité du scooter
	public boolean estDispo() {
		return disponible;
	}

	// méthode pour mettre à jour son kilométrage
	public void majKm(int k) {
		kilometrage += k;
	}

	// méthode getNumId()
	public int getNumId() {
		return numId;
	}

}