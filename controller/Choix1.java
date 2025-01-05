package controller;

import java.awt.event.*;

import vue.Fenetre1;

public class Choix1 implements ActionListener {

    model.Magasin magasin;

    @Override
    public void actionPerformed(ActionEvent e) {
        Fenetre1 f1 = new Fenetre1(magasin);
    }

}
