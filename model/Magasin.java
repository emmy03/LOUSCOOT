package model;

import java.util.*;
import java.util.ArrayList;

public class Magasin {

	public Magasin(String n, String a, Scooter s, Location l, Client c) {
		nom = n;
		adresse = a;
		Scooter scooter = s;
		Location location = l;
		Client client = c;
	}

	public String nom;
	public String adresse;
	public Vector<Scooter> listScooter = new Vector<Scooter>();
	public Vector<Client> listClient = new Vector<Client>();
	public Vector<Location> listLocation = new Vector<Location>();

	// GESTION SCOOTER

	// ajout d'un scooter
	public void ajoutScooter(Scooter s) {
		listScooter.add(s);
	}

	// supprimer un scooter
	public void supprimerScoot(Scooter s) {
		listScooter.remove(s);
	}

	// consulter la liste de tous les scooters
	public Vector<Scooter> consulterScooters() {
		if (listScooter.isEmpty()) {
			System.out.println("Aucun scooter n'est actuellement disponible à la location chez LOUSCOOT.");
		} else {
			for (Scooter s : listScooter) {
				System.out.println("Modèle : " + s.modele + ", ID : " + s.numId + ", Kilométrage : " + s.kilometrage
						+ " km, Prix : " + s.prix + " euros par jour. Etat : " + s.location);
			}
		}
		return listScooter;
	}

	// rechercher un scooter par modele
	public List<Scooter> getScootByMarque(String modele) {
		List<Scooter> scootByMarque = new ArrayList<Scooter>();
		for (Scooter s : listScooter) {
			if (s.modele.equals(modele)) {
				scootByMarque.add(s);
			}
		}
		return scootByMarque;
	}

	// rechercher le scooter par son ID
	public Scooter getScooterByNum(int numId) {
		for (Scooter scooter : listScooter) {
			if (scooter.numId == numId) {
				return scooter;
			}
		}
		System.out.println("Le scooter n'existe pas dans le parc.");
		return null;
	}

	// recherche de scooter par prix
	public List<Scooter> getScootsByPrix(double prixMin, double prixMax) {
		List<Scooter> scootByPrix = new ArrayList<>();
		for (Scooter s : listScooter) {
			if (s.prix >= prixMin && s.prix <= prixMax) {
				scootByPrix.add(s);
			}
		}
		return scootByPrix;
	}

	// louer un scooter
	public void louerScooter(int numId, String clientId, String dateDeb, int duree) {
		// recherche du scooter parmi la liste des scooters
		Scooter scooter = null;
		for (Scooter s : listScooter) {
			if (s.getNumId() == numId) {
				scooter = s;
				break;
			}
		}

		// recherche du client correspondant à l'id
		Client client = getClientById(clientId);
		if (nom == null) {
			System.out.println("Le client avec l'identifiant " + clientId + " n'existe pas. ");
			return;
		}

		// Vérification de l'existence du scooter
		if (scooter == null) {
			System.out.println("Le scooter avec l'identifiant " + numId + " n'existe pas.");
			return;
		}

		// Vérification de la disponibilité du scooter
		if (!scooter.estDispo()) {
			System.out.println("Le scooter avec l'identifiant" + numId + " est déjà loué.");
			return;
		}

		// Création de la location et ajout à la liste des locations
		Location location = new Location(dateDeb, duree, this, scooter, client);
		listLocation.add(location);

		// Marquage du scooter comme étant en location
		scooter.louer();

		// Ajout de la location à la liste des locations du client
		client.ajoutLocation(location);

		System.out.println("Le scooter avec l'identifiant " + numId + " a été loué avec succès.");
		System.out.println("Le montant total à payer est de " + scooter.prix * duree + " euros.");
	}

	// retourner un scooter
	public void returnScooter(int scootId, int km) {
		boolean scooterFound = false;
		for (Scooter s : listScooter) {
			if (s.getNumId() == scootId) {
				scooterFound = true;
				if (s.estDispo()) {
					System.out.println("Le scooter n'était pas en location.");
				} else {
					s.majKm(km);
					s.rendre();
					System.out.println("Le scooter a été retourné avec succès.");
				}
				break;
			}
		}
		if (!scooterFound) {
			System.out.println("Le scooter n'existe pas dans le parc.");
		}
	}

	// liste des scooters actuellement loués
	public ArrayList<Scooter> getScootsLoues() {
		ArrayList<Scooter> scootsLoues = new ArrayList<Scooter>();
		for (Scooter s : listScooter) {
			if (!s.estDispo() == true) {
				scootsLoues.add(s);
			}
		}
		return scootsLoues;
	}

	// liste des scooter disponibles pour une location
	public ArrayList<Scooter> getDispoScooters() {
		ArrayList<Scooter> scootsDispo = new ArrayList<Scooter>();
		for (Scooter s : listScooter) {
			if (s.estDispo() == true) {
				scootsDispo.add(s);
			}
		}
		return scootsDispo;
	}

	// GESTION DU PARC
	public void saisirParcScooters() {
		// Afficher le nombre total de scooters
		System.out.println("Nombre total de scooters : " + listScooter.size());

		// Afficher le nombre de scooters en location et leur ID
		ArrayList<Scooter> scootsLoues = getScootsLoues();
		System.out.println("Nombre de scooters en location : " + scootsLoues.size());
		System.out.println("Liste des scooters en location :");
		for (Scooter s : scootsLoues) {
			System.out.println("Scooter " + s.getNumId() + " est en location.");
		}

		// Afficher le nombre de scooters disponibles et leur ID
		ArrayList<Scooter> scootsDispo = getDispoScooters();
		System.out.println("Nombre de scooters disponibles : " + scootsDispo.size());
		System.out.println("Liste des scooters en location :");
		for (Scooter s : scootsDispo) {
			System.out.println("Scooter " + s.getNumId() + " est disponible");
		}

		// Afficher le kilométrage moyen de l'ensemble des scooters
		int totalKm = 0;
		for (Scooter s : listScooter) {
			totalKm += s.kilometrage;
		}
		double kmMoyen = (double) totalKm / listScooter.size();
		System.out.println("Kilométrage moyen : " + kmMoyen);
	}

	// GESTION CLIENT
	// rechercher un client par son ID et avoir son nom
	public Client getClientById(String id) {
		for (Client c : listClient) {
			if (c.num.equals(id)) {
				return c;
			}
		}
		return null;
	}

	// GESTION LOCATION
	// créer une location
	public void ajoutLocation(String dateDeb, int duree, Magasin louscoot, Scooter scooter, Client c) {
		Location l = new Location(dateDeb, duree, louscoot, scooter, c);
		listLocation.add(l);
		scooter.louer(); // marquer le scooter comme non-disponible
	}

	// annuler une location
	public void annulerLocation(Location l) {
		listLocation.remove(l);
		Scooter scooter = l.getScooter();
		scooter.rendre(); // marquer le scooter comme disponible après la location annulée
	}

}
