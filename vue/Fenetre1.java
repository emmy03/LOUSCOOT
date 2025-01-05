package vue;

import java.awt.*;
import javax.swing.*;
import controller.*;

public class Fenetre1 extends JFrame {
    model.Magasin magasin;
    JLabel t1 = new JLabel("Entrer l'identifiant du scooter");
    JLabel t2 = new JLabel("Entrez votre identifiant");
    JLabel t3 = new JLabel("Entrez la date de location (JJ-MM-AAAA)");
    JLabel t4 = new JLabel("Entrez la durée de location en jours");

    JTextField p1 = new JTextField("");
    JTextField p2 = new JTextField("");
    JTextField p3 = new JTextField("");
    JTextField p4 = new JTextField("");

    JButton val = new JButton("Valider");

    public Fenetre1(model.Magasin m) {
        magasin = m;
        this.setTitle("Louer un scooter");
        GridLayout sp1 = new GridLayout(5, 1);
        FlowLayout sp2 = new FlowLayout();
        JPanel bouttons = new JPanel();
        bouttons.setLayout(sp1);
        t1.setLayout(sp1);

        getContentPane().setLayout(sp1);
        getContentPane().add(t1);
        getContentPane().add(p1);
        getContentPane().add(t2);
        getContentPane().add(p2);
        getContentPane().add(t3);
        getContentPane().add(p3);
        getContentPane().add(t4);
        getContentPane().add(p4);
        getContentPane().add(val);

        val.setLayout(sp2);

        LouerScoot a = new LouerScoot(magasin, p1, p2, p3, p4);
        val.addActionListener(a);

        this.pack();
        this.show();
        this.setResizable(false);
    }
}