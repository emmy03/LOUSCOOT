package controller;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LouerScoot implements ActionListener {
    model.Magasin magasin;
    JTextField p1, p2, p3, p4;

    public LouerScoot(model.Magasin m, JTextField sId, JTextField cId, JTextField d, JTextField du) {
        magasin = m;
        p1 = sId;
        p2 = cId;
        p3 = d;
        p4 = du;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int id = Integer.parseInt(p1.getText());
        String idC = p2.getText();
        String deb = p3.getText();
        int duree = Integer.parseInt(p4.getText());
        magasin.louerScooter(id, idC, deb, duree);
    }
}
