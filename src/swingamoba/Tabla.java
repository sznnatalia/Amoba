/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingamoba;

import java.awt.Button;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

/**
 *
 * @author Nati
 */
public class Tabla {

    Button tabla[][];
    Jatekos j1;
    Jatekos j2;
    Jatekos aktualis;
    JPanel pn;
    JLabel lbAktualisJatekos;
    JRootPane root;

    public Tabla() {
    }

    public Tabla(Button[][] tabla, Jatekos j1, Jatekos j2, JPanel pn, JLabel lbAktualisJatekos, JRootPane root) {
        this.tabla = tabla;
        this.j1 = j1;
        this.j2 = j2;
        this.pn = pn;
        this.lbAktualisJatekos = lbAktualisJatekos;
        this.root = root;
        
        aktualis = j1;
        
        lbAktualisJatekos.setText(aktualis.getNev()+" ("+aktualis.getJel()+")");

        

    }

    public void feltolt() {
        for (Button[] tabla1 : tabla) {
            for (int j = 0; j < tabla1.length; j++) {
               
                Button bt = new Button("");
                bt.setFont(new Font("Tahoma", 0, 18));
                
                tabla1[j] = bt;
                
                tabla1[j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Button nyomott = (Button) e.getSource();
                        nyomott.setLabel(aktualis.getJel());
                      
                        nyomott.setEnabled(false);
                        
                        
                        if (nyeres()){
                            befejez();
                            
                        } else {
                        
                        aktualisJatekos();

                    }
                }
                });
                pn.add(tabla1[j]);
            }
        }
    }

    public boolean nyeres() {
        
        for (int i = 0; i < tabla.length; i++) {
            for (int k = 0; k < (tabla.length - 3); k++) {

                if (tabla[i][k].getLabel().equals(aktualis.getJel()) && tabla[i][k + 1].getLabel().equals(aktualis.getJel()) && tabla[i][k + 2].getLabel().equals(aktualis.getJel()) && tabla[i][k + 3].getLabel().equals(aktualis.getJel())) {
                    JOptionPane.showMessageDialog(root, (aktualis.getNev()+" nyert"), "Játék vége", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                } else if (tabla[k][i].getLabel().equals(aktualis.getJel()) && tabla[k + 1][i].getLabel().equals(aktualis.getJel()) && tabla[k + 2][i].getLabel().equals(aktualis.getJel()) && tabla[k + 3][i].getLabel().equals(aktualis.getJel())) {
                    JOptionPane.showMessageDialog(root, (aktualis.getNev()+" nyert"), "Játék vége", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }

            }
        }

        for (int i = 0; i < tabla.length - 4; i++) {
            for (int k = 0; k < tabla.length - 4; k++) {
                if (tabla[i][k].getLabel().equals(aktualis.getJel()) && tabla[i + 1][k + 1].getLabel().equals(aktualis.getJel()) && tabla[i + 2][k + 2].getLabel().equals(aktualis.getJel()) && tabla[i + 3][k + 3].getLabel().equals(aktualis.getJel())) {
                    JOptionPane.showMessageDialog(root, (aktualis.getNev()+" nyert"), "Játék vége", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
        }

        for (int i = 0; i < tabla.length - 4; i++) {
            for (int k = 3; k < tabla.length; k++) {
                if (tabla[i][k].getLabel().equals(aktualis.getJel()) && tabla[i + 1][k - 1].getLabel().equals(aktualis.getJel()) && tabla[i + 2][k - 2].getLabel().equals(aktualis.getJel()) && tabla[i + 3][k - 3].getLabel().equals(aktualis.getJel())) {
                    JOptionPane.showMessageDialog(root, (aktualis.getNev()+" nyert"), "Játék vége", JOptionPane.INFORMATION_MESSAGE);
                    return true;
                }
            }
        }

        return false;

    }

    public boolean betelt() {
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                if (tabla[i][j].getLabel().equals(" ")) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public void aktualisJatekos(){
        if (aktualis==j1){
            aktualis=j2;
        } else{
            aktualis=j1;
        }
        
        lbAktualisJatekos.setText(aktualis.getNev()+" ("+aktualis.getJel()+")");
        
        
    }
    
    public void befejez(){
        for (int  i = 0;  i < tabla.length;  i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                tabla[i][j].setEnabled(false);
                
            }
        }
        
        lbAktualisJatekos.setText("Vége a játéknak");
    }
    
    public void tablaTorol(){
        for (Button[] tabla1 : tabla) {
            for (int j = 0; j < tabla1.length; j++) {
                if (tabla1[j]!=null){
                    tabla1[j].setEnabled(true);
                    tabla1[j].setLabel("");
                }}
    }
    aktualis = j1;
    lbAktualisJatekos.setText(aktualis.getNev()+" ("+aktualis.getJel()+")");
    }

}
