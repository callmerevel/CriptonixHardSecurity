/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trhread;

import com.etat.Authentification;
import com.controlleur.Controlleur;
import com.etat.Etat;
import com.ui.CriptonixAuthentification;
import com.ui.MasterSecurity;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yuri
 */
public class ThreadPresentation extends Thread {
    private int val;
    private Etat etat;
    private Authentification connexion;
    
    public ThreadPresentation(int val, Etat etat) {
        this.val = val;
        this.etat = etat;
    }
    public ThreadPresentation(int val, Etat etat, Authentification connexion) {
        this.val = val;
        this.etat = etat;
        this.connexion = connexion;
    }
    @Override
    public void run() {
        if(this.val == 1) {
            MasterSecurity master = new MasterSecurity(this.etat,connexion);
            master.setVisible(true);
            master.setLocationRelativeTo(master.getParent());
        }else if(this.val == 2){
            CriptonixAuthentification authentification = new CriptonixAuthentification(this.etat);
            authentification.setVisible(true);
            authentification.setLocationRelativeTo(authentification.getParent());
        }else if(this.val == 3) {
            Controlleur controlleur = new Controlleur();
            controlleur.relancerExploreur();
        }else if(this.val == 4) {
            Controlleur controlleur = new Controlleur();
            controlleur.arreterExplorerON();
        }else if(this.val == 5) {
            this.sauvegarderDonnees();
        }
    }
    private void sauvegarderDonnees() {
        ObjectOutputStream oos;          
            try {
                oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("restrictions.txt"))));
                oos.writeObject(this.etat);
                oos.close();
            } catch (IOException ex) {
                Logger.getLogger(MasterSecurity.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
