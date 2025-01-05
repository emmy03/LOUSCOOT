package vue;

import java.awt.*;
import javax.swing.*;

import controller.*;

public class FenetreMenu extends JFrame {

    model.Magasin magasin;
    JButton choix_1 = new JButton("1. Louer un scooter");
    JButton choix_2 = new JButton("2. Retour d'un scooter");
    JButton choix_3 = new JButton("3. État d'un scooter");
    JButton choix_4 = new JButton("4. Affichage de l'état du parc de scooters");
    JButton choix_5 = new JButton("5. Saisie du parc des scooters");
    JButton choix_6 = new JButton("6. Quitter le programme");

    public FenetreMenu(model.Magasin m) {
        magasin = m;
        this.setTitle("Menu du magasin");
        GridLayout sp1 = new GridLayout(6, 1);
        FlowLayout sp2 = new FlowLayout();
        JPanel bouttons = new JPanel();
        bouttons.setLayout(sp1);
        getContentPane().setLayout(sp1);
        getContentPane().add(bouttons);

        bouttons.add(choix_1);
        bouttons.add(choix_2);
        bouttons.add(choix_3);
        bouttons.add(choix_4);
        bouttons.add(choix_5);
        bouttons.add(choix_6);

        Choix1 c1 = new Choix1();
        choix_1.addActionListener(c1);

        this.pack();
        this.show();
        this.setResizable(false);
    }
}
