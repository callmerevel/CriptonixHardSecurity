/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.etat;

import java.io.Serializable;

/**
 *
 * @author yuri
 */
public class Etat implements Serializable {
    
    private int empecherRedirectionmanuelleDossiersProfils = 1;
    private int masquerElementsBureau = 1;
    private int cacherpanneauDeConfiguration = 1;
    private int cacherMenuExecuter = 1;
    private int cacherMenuFermerSession = 1;
    private int cacherBouttonsArreterRedemarrerMiseEnVeille = 1;
    private int empecherModificationBarreDeTache = 1;
    private int empecherModificationArrierPlan = 1;
    private int cacherLecteurs = 1;
    private int cachergestionnaireDeTache = 1;
    private int cacherInviteDeCommande = 1;
    private int cacherRegistre = 1;
    private int desactiverExecutionFichierAutun = 4;
    private String applicationsAutorisees [];
    private String applicationNonAutorisee [];
    
    public Etat(){}

    public int getEmpecherRedirectionmanuelleDossiersProfils() {
        return empecherRedirectionmanuelleDossiersProfils;
    }

    public void setEmpecherRedirectionmanuelleDossiersProfils(int empecherRedirectionmanuelleDossiersProfils) {
        this.empecherRedirectionmanuelleDossiersProfils = empecherRedirectionmanuelleDossiersProfils;
    }

    public int getMasquerElementsBureau() {
        return masquerElementsBureau;
    }

    public void setMasquerElementsBureau(int masquerElementsBureau) {
        this.masquerElementsBureau = masquerElementsBureau;
    }

    public int getCacherpanneauDeConfiguration() {
        return cacherpanneauDeConfiguration;
    }

    public void setCacherpanneauDeConfiguration(int cacherpanneauDeConfiguration) {
        this.cacherpanneauDeConfiguration = cacherpanneauDeConfiguration;
    }

    public int getCacherMenuExecuter() {
        return cacherMenuExecuter;
    }

    public void setCacherMenuExecuter(int cacherMenuExecuter) {
        this.cacherMenuExecuter = cacherMenuExecuter;
    }

    public int getCacherMenuFermerSession() {
        return cacherMenuFermerSession;
    }

    public void setCacherMenuFermerSession(int cacherMenuFermerSession) {
        this.cacherMenuFermerSession = cacherMenuFermerSession;
    }

    public int getCacherBouttonsArreterRedemarrerMiseEnVeille() {
        return cacherBouttonsArreterRedemarrerMiseEnVeille;
    }

    public void setCacherBouttonsArreterRedemarrerMiseEnVeille(int cacherBouttonsArreterRedemarrerMiseEnVeille) {
        this.cacherBouttonsArreterRedemarrerMiseEnVeille = cacherBouttonsArreterRedemarrerMiseEnVeille;
    }

    public int getEmpecherModificationBarreDeTache() {
        return empecherModificationBarreDeTache;
    }

    public void setEmpecherModificationBarreDeTache(int empecherModificationBarreDeTache) {
        this.empecherModificationBarreDeTache = empecherModificationBarreDeTache;
    }

    public int getEmpecherModificationArrierPlan() {
        return empecherModificationArrierPlan;
    }

    public void setEmpecherModificationArrierPlan(int empecherModificationArrierPlan) {
        this.empecherModificationArrierPlan = empecherModificationArrierPlan;
    }

    public int getCacherLecteurs() {
        return cacherLecteurs;
    }

    public void setCacherLecteurs(int cacherLecteurs) {
        this.cacherLecteurs = cacherLecteurs;
    }

    public int getCachergestionnaireDeTache() {
        return cachergestionnaireDeTache;
    }

    public void setCachergestionnaireDeTache(int cachergestionnaireDeTache) {
        this.cachergestionnaireDeTache = cachergestionnaireDeTache;
    }

    public int getCacherInviteDeCommande() {
        return cacherInviteDeCommande;
    }

    public void setCacherInviteDeCommande(int cacherInviteDeCommande) {
        this.cacherInviteDeCommande = cacherInviteDeCommande;
    }

    public int getCacherRegistre() {
        return cacherRegistre;
    }

    public void setCacherRegistre(int cacherRegistre) {
        this.cacherRegistre = cacherRegistre;
    }

    public int getDesactiverExecutionFichierAutun() {
        return desactiverExecutionFichierAutun;
    }

    public void setDesactiverExecutionFichierAutun(int desactiverExecutionFichierAutun) {
        this.desactiverExecutionFichierAutun = desactiverExecutionFichierAutun;
    }

    public String[] getApplicationsAutorisees() {
        return applicationsAutorisees;
    }

    public void setApplicationsAutorisees(String[] applicationsAutorisees) {
        this.applicationsAutorisees = applicationsAutorisees;
    }

    public String[] getApplicationNonAutorisee() {
        return applicationNonAutorisee;
    }

    public void setApplicationNonAutorisee(String[] applicationNonAutorisee) {
        this.applicationNonAutorisee = applicationNonAutorisee;
    }
    
}
