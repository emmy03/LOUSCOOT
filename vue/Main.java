package vue;

import model.*;
import java.util.*;

public class Main {

    static Magasin magasin = new Magasin("LOUSCOOT", "123 rue de la Paix, 91000 Evry", null, null, null);

    public static void main(String[] args) {
        FenetreMenu f0 = new FenetreMenu(magasin);

        Scooter scooter1 = new Scooter("Piaggio", 12345, 1500, 35, magasin, null);
        Scooter scooter2 = new Scooter("Yamaha", 23456, 2200, 45, magasin, null);
        Scooter scooter3 = new Scooter("Honda", 34567, 5000, 25, magasin, null);
        Scooter scooter4 = new Scooter("Kymco", 45678, 3000, 20, magasin, null);
        Scooter scooter5 = new Scooter("Aprilia", 56789, 1800, 30, magasin, null);

        Client client1 = new Client("Jean Dupont", "10 rue de la Liberté, 91000 Evry", "123456", magasin, null);
        Client client2 = new Client("Marie Martin", "5 avenue des Roses, 91086 Bondoufle", "789012", magasin, null);

        magasin.ajoutScooter(scooter1);
        magasin.ajoutScooter(scooter2);
        magasin.ajoutScooter(scooter3);
        magasin.ajoutScooter(scooter4);
        magasin.ajoutScooter(scooter5);

        client1.ajoutClient(client1);
        client2.ajoutClient(client2);

        Scanner scanner = new Scanner(System.in);
        int choix = 0;
        do {
            System.out.println("Menu :");
            System.out.println("1. Louer un scooter");
            System.out.println("2. Retour d'un scooter");
            System.out.println("3. État d'un scooter");
            System.out.println("4. Affichage de l'état du parc de scooters");
            System.out.println("5. Saisie du parc des scooters");
            System.out.println("6. Quitter le programme");
            System.out.print("Choix : ");
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    System.out.print("Entrez l'identifiant du scooter : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez votre identifiant : ");
                    String num = scanner.nextLine();
                    System.out.print("Entrez la date de location (JJ-MM-AAAA) : ");
                    String str = scanner.nextLine();
                    System.out.print("Entrez la durée de location en jours : ");
                    int duree = scanner.nextInt();
                    magasin.louerScooter(id, num, str, duree);
                    break;
                case 2:
                    System.out.print("Entrez l'identifiant du scooter : ");
                    int n = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Entrez le kilométrage total : ");
                    int km = scanner.nextInt();
                    magasin.returnScooter(n, km);
                    break;
                case 3:
                    System.out.print("Entrez l'identifiant du scooter : ");
                    int i = scanner.nextInt();
                    Scooter scooter = magasin.getScooterByNum(i);
                    System.out.println(scooter);
                    break;
                case 4:
                    afficherEtatParcScooters();
                    break;
                case 5:
                    magasin.saisirParcScooters();
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
            System.out.println();
        } while (choix != 6);

    }

    // CHOIX N°4
    private static void afficherEtatParcScooters() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Afficher tous les scooters");
        System.out.println("2. Rechercher un scooter par modèle");
        System.out.println("3. Rechercher un scooter par disponibilité");
        System.out.println("4. Rechercher un scooter par prix de location");
        System.out.println("5. Retour");
        System.out.print("Choix : ");
        if (sc.hasNextInt()) {
            int choix = sc.nextInt();
            sc.nextLine();

            switch (choix) {
                case 1:
                    magasin.consulterScooters();
                    break;
                case 2:
                    System.out.print("Modèle : ");
                    String modele = sc.nextLine();
                    List<Scooter> scootsByMarque = magasin.getScootByMarque(modele);
                    if (scootsByMarque.isEmpty()) {
                        System.out.println("Aucun scooter trouvé pour ce modèle !");
                    } else {
                        System.out.println("Voici les scooters pour le modèle " + modele + " : ");
                        for (Scooter s : scootsByMarque) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 3:
                    List<Scooter> scootsDispo = magasin.getDispoScooters();
                    if (scootsDispo.isEmpty()) {
                        System.out.println("Aucun scooter n'est actuellement disponible !");
                    } else {
                        System.out.println("Voici les scooters disponibles : ");
                        for (Scooter s : scootsDispo) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 4:
                    System.out.println("Prix de location minimum : ");
                    double prixMin = sc.nextDouble();
                    System.out.print("Prix de location maximum : ");
                    double prixMax = sc.nextDouble();
                    List<Scooter> scootsByPrix = magasin.getScootsByPrix(prixMin, prixMax);
                    if (scootsByPrix.isEmpty()) {
                        System.out.println("Aucun scooter trouvé pour ce prix !");
                    } else {
                        System.out.println("Voici les scooters entre " + prixMin + " et " + prixMax + " euros : ");
                        for (Scooter s : scootsByPrix) {
                            System.out.println(s);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Retour au menu principal !");
                    return;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
            System.out.println();
        } else {
            System.out.println("Entrée invalide !");
        }
    }
}