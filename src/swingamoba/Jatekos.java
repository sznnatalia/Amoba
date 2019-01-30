package swingamoba;


import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nati
 */
public class Jatekos {
    private String nev;
    private String jel;
    

    public Jatekos() {
    }

    public Jatekos(String nev, String jel) {
        this.nev = nev;
        this.jel = jel;
    }

    
    
    public String lepesKer(){
        Scanner sc = new Scanner(System.in);
        System.out.println(nev+" következik, írja be a lépést:");
        String lepes = sc.nextLine();
        return lepes;
        
    }

    public String getJel() {
        return jel;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setJel(String jel) {
        this.jel = jel;
    }

    
    
    

}
