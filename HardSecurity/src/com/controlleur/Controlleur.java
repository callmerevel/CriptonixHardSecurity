/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlleur;

import com.developpez.adiguba.shell.Shell;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yuri
 */
public class Controlleur {
    
    public Controlleur() {}
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void empecherRedirectionManuelleDossiersProfilsON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v DisablePersonalDirChange /t REG_DWORD /d 00000001 /f");
    }
    public void empecherRedirectionManuelleDossiersProfilsOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v DisablePersonalDirChange /f");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void arreterExplorerON() {
        this.configurerExploreur(0);
    }
    public void arreterExplorerOFF() {
        this.configurerExploreur(1);
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void masquerEtDesactiverElementsBureauON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoDesktop /t REG_DWORD /d 00000001 /f");
        //this.relancerExploreur();
    }
    public void masquerEtDesactiverElementsBureauOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoDesktop /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cacherPanneauConfigurationON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoControlPanel /t REG_DWORD /d 00000001 /f");
        //this.relancerExploreur();
    }
    public void cacherPanneauConfigurationOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoControlPanel /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cacherMenuExecuterON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoRun /t REG_DWORD /d 00000001 /f");
        //this.relancerExploreur();
    }
    public void cacherMenuExecuterOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoRun /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cacherMenuFermerSessionMenuDemarrerON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v StartMenuLogOff /t REG_DWORD /d 00000001 /f");
        //this.relancerExploreur();
    }
    public void cacherMenuFermerSessionMenuDemarrerOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v StartMenuLogOff /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cacherBoutton_Arreter_Redemarrer_MiseEnVeilleON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoClose /t REG_DWORD /d 00000001 /f");
        //this.relancerExploreur();
    }
    public void cacherBoutton_Arreter_Redemarrer_MiseEnVeilleOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoClose /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void empecherModificationBarreDeTacheON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoSetTaskbar /t REG_DWORD /d 00000001 /f");
        //this.relancerExploreur();
    }
    public void empecherModificationBarreDeTacheOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoSetTaskbar /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void empecherChangementArrierePlanON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\ActiveDesktop /v NoChangingWallPaper /t REG_DWORD /d 00000001 /f");
        //this.relancerExploreur();
    }
    public void empecherChangementArrierePlanOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\ActiveDesktop /v NoChangingWallPaper /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cacherLecteursON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoViewOnDrive /t REG_DWORD /d 0x3ffffff /f");
        //this.relancerExploreur();
    }
    public void cacherLecteursOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoViewOnDrive /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cacherGestionnaireTacheON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v DisableTaskMgr /t REG_DWORD /d 00000001 /f");
        //this.relancerExploreur();
    }
    public void cacherGestionnaireTacheOFF() {
        this.executerCommande("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v DisableTaskMgr /f");
        //this.relancerExploreur();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cacherInviteDeCommandeON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Policies\\Microsoft\\Windows\\System /v DisableCMD /t REG_DWORD /d 00000001 /f");
    }
    public void cacherInviteDeCommandeOFF() {
        try {
            Runtime.getRuntime().exec("REG DELETE HKCU\\Software\\Policies\\Microsoft\\Windows\\System /v DisableCMD /f"); 
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cacherRegistreON() {
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v DisableRegistryTools /t REG_DWORD /d 00000002 /f");
        //this.relancerExploreur();
    }
    public void cacherRegistreOFF() {
        try {
            Runtime.getRuntime().exec("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\System /v DisableRegistryTools /f"); 
            //this.relancerExploreur();
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void lancerProgrammeAutoriseeON(String programme) {  //TRES BON à completer
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v RestrictRun /t REG_DWORD /d 00000002 /f");
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\RestrictRun /v "+programme+" /t REG_SZ /d "+programme+" /f");
//        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\RestrictRun /v vlc.exe /t REG_SZ /d vlc.exe /f");
//        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\RestrictRun /v explorer.exe /t REG_SZ /d explorer.exe /f");
//        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\RestrictRun /v netbeans.exe /t REG_SZ /d netbeans.exe /f");
        //this.relancerExploreur();
    }
    public void lancerProgrammeAutoriseeOFF() {
        try {
            Runtime.getRuntime().exec("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v RestrictRun /f");
            Runtime.getRuntime().exec("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\RestrictRun /f"); 
            //this.relancerExploreur();
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void nePaslancerProgrammePreciserON(String programme) {  //ICI les applictions precisees ne seront pas executees TRES BON à completer
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v DisallowRun /t REG_DWORD /d 00000002 /f");
        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\DisallowRun /v "+programme+" /t REG_SZ /d "+programme+" /f");
//        this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\DisallowRun /v vlc.exe /t REG_SZ /d vlc.exe /f");
        //this.relancerExploreur();
    }
    public void nePaslancerProgrammePreciserOFF() {
        try {
            Runtime.getRuntime().exec("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v DisallowRun /f");
            Runtime.getRuntime().exec("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer\\DisallowRun /f"); 
            //this.relancerExploreur();
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void desactiverFichierAutorunON(int valeur) {  
        if(valeur == 0) {
            this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoDriveTypeAutoRun /t REG_DWORD /d 00000001 /f"); //1 desactive pour les peripherique inconnu
            //this.relancerExploreur();
        }
        if(valeur == 1){
            this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoDriveTypeAutoRun /t REG_DWORD /d 00000004 /f"); //2 desactive pour les peripherique amovible
            //this.relancerExploreur();
        }
        if(valeur == 2){
            this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoDriveTypeAutoRun /t REG_DWORD /d 00000008 /f"); //3 desactive pour les peripherique disques fixes
            //this.relancerExploreur();
        }
        if(valeur == 3){
            this.executerCommande("REG ADD HKEY_CURRENT_USER\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoDriveTypeAutoRun /t REG_DWORD /d 0xb5 /f"); //4 desactive sur les CDROM ET peripherique amovibles
            //this.relancerExploreur();
        }
    }
    
    public void desactiverFichierAutorunOFF() {
        try {
            Runtime.getRuntime().exec("REG DELETE HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Policies\\Explorer /v NoDriveTypeAutoRun /f"); 
            //this.relancerExploreur();
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void elevationDroitON(String valeur) {   //PB
            this.executerCommande("REG ADD \"HKEY_CURRENT_USER\\Software\\Microsoft\\Windows NT\\CurrentVersion\\AppCompatFlags\\Compatibility Assistant\\Persisted\" /v \""+valeur+"\" /t REG_DWORD /d 00000001 /f"); 
            //this.relancerExploreur();        
    }   //PAS ENCORE SURE!!
    
    public void elevationDroitOFF(String valeur) {
        try {
            Runtime.getRuntime().exec("REG DELETE \"HKCU\\Software\\Microsoft\\Windows NT\\CurrentVersion\\AppCompatFlags\\Compatibility Assistant\\Persisted\" /v \""+valeur+"\" /f"); 
            //this.relancerExploreur();
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public  void relancerExploreur() {        
        //System.out.println(this.executerCommande("tasklist").trim().replace(' ', '|'));        
        BufferedReader entree = null;
        BufferedWriter ecriture = null;
        boolean bool = false;
        try {
            ecriture = new BufferedWriter(new FileWriter("data.txt"));
            ecriture.write(this.executerCommande("tasklist").trim().replace(' ', ';'));
            ecriture.close();
            /**************** LECTURE  ******************/
            entree = new BufferedReader (new FileReader ("data.txt"));
            String ligne;
            do{                 
                ligne = entree.readLine() ;                
                if( ligne != null) {
                    if( ligne.split(";")[0].trim().equalsIgnoreCase("explorer.exe") ) {
                        bool = true;
                        String[] bonneLigne;
                        String PID ="";
                        System.out.println(ligne.split(";")[0].trim());
                        bonneLigne = ligne.split(";");
                        for(int i = 1;i <= bonneLigne.length;i++) {
                            if(bonneLigne[i].length() != 0) {
                                PID = bonneLigne[i];
                                break;
                            }
                        }
                        System.out.println(PID);
                        this.executerCommande("taskkill /f /im "+PID);
                        this.executerCommande("explorer"); 
                    }                  
                }
            }while(ligne != null);
            
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ecriture.close();
                entree.close();
            } catch (IOException ex) {
                Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if(bool == false) {
            this.executerCommande("explorer");
        }else{
            bool = false;
        }
        File file = new File("data.txt");
        file.delete();
    }
    public void configurerExploreur(int val) { 
        if(val == 0) {
        BufferedReader entree = null;
        BufferedWriter ecriture = null;
        try {
            ecriture = new BufferedWriter(new FileWriter("data.txt"));
            ecriture.write(this.executerCommande("tasklist").trim().replace(' ', ';'));
            ecriture.close();
            /**************** LECTURE  ******************/
            entree = new BufferedReader (new FileReader ("data.txt"));
            String ligne;
            do{                 
                ligne = entree.readLine() ;                
                if( ligne != null) {
                    if( ligne.split(";")[0].trim().equalsIgnoreCase("explorer.exe") ) {
                        String[] bonneLigne;
                        String PID ="";
                        System.out.println(ligne.split(";")[0].trim());
                        bonneLigne = ligne.split(";");
                        for(int i = 1;i <= bonneLigne.length;i++) {
                            if(bonneLigne[i].length() != 0) {
                                PID = bonneLigne[i];
                                break;
                            }
                        }
                        System.out.println(PID);
                        this.executerCommande("taskkill /f /im "+PID);
                        //this.executerCommande("explorer"); 
                    }                  
                }
            }while(ligne != null);
            
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ecriture.close();
                entree.close();
            } catch (IOException ex) {
                Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }else{            
            this.executerCommande("explorer");
        }
        File file = new File("data.txt");
        file.delete();
    }
    private String executerCommande(String commande) {
        String result = "";
        try {
            Shell sh = new Shell();
            result = sh.command(commande).consumeAsString();            
        } catch (IOException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalStateException ex) {
            Logger.getLogger(Controlleur.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}
