/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui;

import com.etat.Authentification;
import com.controlleur.Controlleur;
import com.etat.Etat;
import com.trhread.ThreadPresentation;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author yuri
 */
public class MasterSecurity extends javax.swing.JFrame {

    /**
     * Creates new form MasterSecurity
     */
    private Controlleur controlleur;
    private Etat etat;
    private Authentification authentification;
    
    public MasterSecurity(Etat etat) {
        this.design();
        initComponents();
        this.controlleur = new Controlleur();
        this.etat = etat;
        this.initialiser();
    }
    public MasterSecurity(Etat etat, Authentification authentification) {
        this.design();
        initComponents();
        this.controlleur = new Controlleur();
        this.etat = etat;
        this.authentification = authentification;
        this.initialiser();
    }
    private void design() {        
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MasterSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(MasterSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(MasterSecurity.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(MasterSecurity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void initialiser() {
        
        this.cboxEmpecherRedirectionmanuelleDossiersProfils.setSelectedIndex(this.etat.getEmpecherRedirectionmanuelleDossiersProfils());        
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxMasquerElementsBureau.setSelectedIndex(this.etat.getMasquerElementsBureau());        
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxCacherpanneauDeConfiguration.setSelectedIndex(this.etat.getCacherpanneauDeConfiguration());        
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxCacherMenuExecuter.setSelectedIndex(this.etat.getCacherMenuExecuter());
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxCacherMenuFermerSession.setSelectedIndex(this.etat.getCacherMenuFermerSession());        
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxCacherBouttonsArreterRedemarrerMiseEnVeille.setSelectedIndex(this.etat.getCacherBouttonsArreterRedemarrerMiseEnVeille());
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxEmpecherModificationBarreDeTache.setSelectedIndex(this.etat.getEmpecherModificationBarreDeTache());
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxEmpecherModificationArrierPlan.setSelectedIndex(this.etat.getEmpecherModificationArrierPlan());
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxCacherLecteurs.setSelectedIndex(this.etat.getCacherLecteurs());
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxCachergestionnaireDeTache.setSelectedIndex(this.etat.getCachergestionnaireDeTache());
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxCacherInviteDeCommande.setSelectedIndex(this.etat.getCacherInviteDeCommande());
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxCacherRegistre.setSelectedIndex(this.etat.getCacherRegistre());
        /////////////////////////////////////////////////////////////////////////////////
        this.cboxDesactiverExecutionFichierAutun.setSelectedIndex(this.etat.getDesactiverExecutionFichierAutun());
        /////////////////////////////////////////////////////////////////////////////////
        String valeur = "";
        if(this.etat.getApplicationsAutorisees() != null) {
            for(int i=0;i<this.etat.getApplicationsAutorisees().length;i++) {
                valeur = valeur+this.etat.getApplicationsAutorisees()[i]+";";
            }
            //valeur = valeur+";";
            this.txtApplicationsAutorisees.setText(valeur);
        }else{
            this.txtApplicationsAutorisees.setText(valeur);
        }
        //////////////////////////////////////////////////////////////////////////////////
        String valeur1 = "";
        if(this.etat.getApplicationNonAutorisee() != null) {
            for(int i=0;i<this.etat.getApplicationNonAutorisee().length;i++) {
                valeur1 = valeur1+this.etat.getApplicationNonAutorisee()[i]+";";
            }
            //valeur1 = valeur1+";";
            this.txtApplicationNonAutorisee.setText(valeur1);
        }else{
            this.txtApplicationNonAutorisee.setText(valeur1);
        }
        /////////////////////////////////////////////////////////////////////////////////
    }
    private void appliquerChoixUtilisateur() {
        if(this.cboxEmpecherRedirectionmanuelleDossiersProfils.getSelectedIndex() == 0) {
            this.etat.setEmpecherRedirectionmanuelleDossiersProfils(0);
            this.controlleur.empecherRedirectionManuelleDossiersProfilsON();
        }
        if(this.cboxEmpecherRedirectionmanuelleDossiersProfils.getSelectedIndex() == 1) {
            this.etat.setEmpecherRedirectionmanuelleDossiersProfils(1);
            this.controlleur.empecherRedirectionManuelleDossiersProfilsOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxMasquerElementsBureau.getSelectedIndex() == 0) {
            this.etat.setMasquerElementsBureau(0);
            this.controlleur.masquerEtDesactiverElementsBureauON();
        }
        if(this.cboxMasquerElementsBureau.getSelectedIndex() == 1) {
            this.etat.setMasquerElementsBureau(1);
            this.controlleur.masquerEtDesactiverElementsBureauOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxCacherpanneauDeConfiguration.getSelectedIndex() == 0) {
            this.etat.setCacherpanneauDeConfiguration(0);
            this.controlleur.cacherPanneauConfigurationON();
        }
        if(this.cboxCacherpanneauDeConfiguration.getSelectedIndex() == 1) {
            this.etat.setCacherpanneauDeConfiguration(1);
            this.controlleur.cacherPanneauConfigurationOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxCacherMenuExecuter.getSelectedIndex() == 0) {
            this.etat.setCacherMenuExecuter(0);
            this.controlleur.cacherMenuExecuterON();
        }
        if(this.cboxCacherMenuExecuter.getSelectedIndex() == 1) {
            this.etat.setCacherMenuExecuter(1);
            this.controlleur.cacherMenuExecuterOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxCacherMenuFermerSession.getSelectedIndex() == 0) {
            this.etat.setCacherMenuFermerSession(0);
            this.controlleur.cacherMenuFermerSessionMenuDemarrerON();
        }
        if(this.cboxCacherMenuFermerSession.getSelectedIndex() == 1) {
            this.etat.setCacherMenuFermerSession(1);
            this.controlleur.cacherMenuFermerSessionMenuDemarrerOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxCacherBouttonsArreterRedemarrerMiseEnVeille.getSelectedIndex() == 0) {
            this.etat.setCacherBouttonsArreterRedemarrerMiseEnVeille(0);
            this.controlleur.cacherBoutton_Arreter_Redemarrer_MiseEnVeilleON();
        }
        if(this.cboxCacherBouttonsArreterRedemarrerMiseEnVeille.getSelectedIndex() == 1) {
            this.etat.setCacherBouttonsArreterRedemarrerMiseEnVeille(1);
            this.controlleur.cacherBoutton_Arreter_Redemarrer_MiseEnVeilleOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxEmpecherModificationBarreDeTache.getSelectedIndex() == 0) {
            this.etat.setEmpecherModificationBarreDeTache(0);
            this.controlleur.empecherModificationBarreDeTacheON();
        }
        if(this.cboxEmpecherModificationBarreDeTache.getSelectedIndex() == 1) {
            this.etat.setEmpecherModificationBarreDeTache(1);
            this.controlleur.empecherModificationBarreDeTacheOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxEmpecherModificationArrierPlan.getSelectedIndex() == 0) {
            this.etat.setEmpecherModificationArrierPlan(0);
            this.controlleur.empecherChangementArrierePlanON();
        }
        if(this.cboxEmpecherModificationArrierPlan.getSelectedIndex() == 1) {
            this.etat.setEmpecherModificationArrierPlan(1);
            this.controlleur.empecherChangementArrierePlanOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxCacherLecteurs.getSelectedIndex() == 0) {
            this.etat.setCacherLecteurs(0);
            this.controlleur.cacherLecteursON();
        }
        if(this.cboxCacherLecteurs.getSelectedIndex() == 1) {
            this.etat.setCacherLecteurs(1);
            this.controlleur.cacherLecteursOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxCachergestionnaireDeTache.getSelectedIndex() == 0) {
            this.etat.setCachergestionnaireDeTache(0);
            this.controlleur.cacherGestionnaireTacheON();
        }
        if(this.cboxCachergestionnaireDeTache.getSelectedIndex() == 1) {
            this.etat.setCachergestionnaireDeTache(1);
            this.controlleur.cacherGestionnaireTacheOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxCacherInviteDeCommande.getSelectedIndex() == 0) {
            this.etat.setCacherInviteDeCommande(0);
            this.controlleur.cacherInviteDeCommandeON();
        }
        if(this.cboxCacherInviteDeCommande.getSelectedIndex() == 1) {
            this.etat.setCacherInviteDeCommande(1);
            this.controlleur.cacherInviteDeCommandeOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxCacherRegistre.getSelectedIndex() == 0) {
            this.etat.setCacherRegistre(0);
            this.controlleur.cacherRegistreON();
        }
        if(this.cboxCacherRegistre.getSelectedIndex() == 1) {
            this.etat.setCacherRegistre(1);
            this.controlleur.cacherRegistreOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.cboxDesactiverExecutionFichierAutun.getSelectedIndex() == 0) {
            this.etat.setDesactiverExecutionFichierAutun(0);
            this.controlleur.desactiverFichierAutorunON(0);
        }
        if(this.cboxDesactiverExecutionFichierAutun.getSelectedIndex() == 1) {
            this.etat.setDesactiverExecutionFichierAutun(1);
            this.controlleur.desactiverFichierAutorunON(1);
        }
        if(this.cboxDesactiverExecutionFichierAutun.getSelectedIndex() == 2) {
            this.etat.setDesactiverExecutionFichierAutun(2);
            this.controlleur.desactiverFichierAutorunON(2);
        }
        if(this.cboxDesactiverExecutionFichierAutun.getSelectedIndex() == 3) {
            this.etat.setDesactiverExecutionFichierAutun(3);
            this.controlleur.desactiverFichierAutorunON(3);
        }
        if(this.cboxDesactiverExecutionFichierAutun.getSelectedIndex() == 4) {
            this.etat.setDesactiverExecutionFichierAutun(4);
            this.controlleur.desactiverFichierAutorunOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
        if(this.txtApplicationsAutorisees.getText().length() != 0) {
            this.controlleur.lancerProgrammeAutoriseeOFF();
            String[] valeur = this.txtApplicationsAutorisees.getText().split(";");
            this.etat.setApplicationsAutorisees(valeur);
            for(int i = 0; i<valeur.length;i++) {
                this.controlleur.lancerProgrammeAutoriseeON(valeur[i]);
            }
        }else{
            this.etat.setApplicationsAutorisees(null);
            this.controlleur.lancerProgrammeAutoriseeOFF();
        }        
        if(this.txtApplicationNonAutorisee.getText().length() != 0) {
            this.controlleur.nePaslancerProgrammePreciserOFF();
            String[] valeur = this.txtApplicationNonAutorisee.getText().split(";");
            this.etat.setApplicationNonAutorisee(valeur);
            for(int i = 0; i<valeur.length;i++) {
                this.controlleur.nePaslancerProgrammePreciserON(valeur[i]);
            }
        }else{
            this.etat.setApplicationNonAutorisee(null);
            this.controlleur.nePaslancerProgrammePreciserOFF();
        }
        /////////////////////////////////////////////////////////////////////////////////
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboxEmpecherRedirectionmanuelleDossiersProfils = new javax.swing.JComboBox();
        cboxCacherMenuExecuter = new javax.swing.JComboBox();
        cboxMasquerElementsBureau = new javax.swing.JComboBox();
        cboxCacherpanneauDeConfiguration = new javax.swing.JComboBox();
        cboxCacherMenuFermerSession = new javax.swing.JComboBox();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtApplicationsAutorisees = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtApplicationNonAutorisee = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        cboxCacherBouttonsArreterRedemarrerMiseEnVeille = new javax.swing.JComboBox();
        jLabel22 = new javax.swing.JLabel();
        cboxEmpecherModificationBarreDeTache = new javax.swing.JComboBox();
        jLabel21 = new javax.swing.JLabel();
        cboxEmpecherModificationArrierPlan = new javax.swing.JComboBox();
        jLabel26 = new javax.swing.JLabel();
        cboxCacherLecteurs = new javax.swing.JComboBox();
        jLabel25 = new javax.swing.JLabel();
        cboxCachergestionnaireDeTache = new javax.swing.JComboBox();
        jLabel24 = new javax.swing.JLabel();
        cboxCacherInviteDeCommande = new javax.swing.JComboBox();
        jLabel28 = new javax.swing.JLabel();
        cboxCacherRegistre = new javax.swing.JComboBox();
        jLabel29 = new javax.swing.JLabel();
        cboxDesactiverExecutionFichierAutun = new javax.swing.JComboBox();
        btnAppliquer = new javax.swing.JButton();
        btnAppliquerEtVerouiller = new javax.swing.JButton();
        btnAppliquerEtVerouiller1 = new javax.swing.JButton();
        btnAppliquer1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("PC MAX  SECURITY");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(213, 217, 226));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel1.setBackground(new java.awt.Color(76, 89, 149));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PC MAX  SECURITY");
        jLabel1.setOpaque(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(152, 152, 158));
        jLabel2.setText("EMPECHER REDIRECTION MANUELLE DOSSIERS PROFILS");

        cboxEmpecherRedirectionmanuelleDossiersProfils.setBackground(new java.awt.Color(195, 222, 198));
        cboxEmpecherRedirectionmanuelleDossiersProfils.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxEmpecherRedirectionmanuelleDossiersProfils.setSelectedIndex(1);

        cboxCacherMenuExecuter.setBackground(new java.awt.Color(195, 222, 198));
        cboxCacherMenuExecuter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxCacherMenuExecuter.setSelectedIndex(1);

        cboxMasquerElementsBureau.setBackground(new java.awt.Color(195, 222, 198));
        cboxMasquerElementsBureau.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxMasquerElementsBureau.setSelectedIndex(1);

        cboxCacherpanneauDeConfiguration.setBackground(new java.awt.Color(195, 222, 198));
        cboxCacherpanneauDeConfiguration.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxCacherpanneauDeConfiguration.setSelectedIndex(1);

        cboxCacherMenuFermerSession.setBackground(new java.awt.Color(195, 222, 198));
        cboxCacherMenuFermerSession.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxCacherMenuFermerSession.setSelectedIndex(1);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(152, 152, 158));
        jLabel15.setText("MASQUER LES ELEMENTS DU BUREAU");

        jLabel16.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(152, 152, 158));
        jLabel16.setText("CACHER LE PANNEAU DE CONFIGURATION");

        jLabel19.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(152, 152, 158));
        jLabel19.setText("CACHER MENU EXECUTER");

        jLabel20.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(152, 152, 158));
        jLabel20.setText("CACHER MENU FEMER SESSION DU MENU DEMARRER");

        jLabel30.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(152, 152, 158));
        jLabel30.setText("APPLICATIONS AUTORISEES");

        jLabel31.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(152, 152, 158));
        jLabel31.setText("APPLICATIONS NON AUTORISEES");

        txtApplicationsAutorisees.setColumns(20);
        txtApplicationsAutorisees.setRows(5);
        jScrollPane1.setViewportView(txtApplicationsAutorisees);

        txtApplicationNonAutorisee.setColumns(20);
        txtApplicationNonAutorisee.setRows(5);
        jScrollPane2.setViewportView(txtApplicationNonAutorisee);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboxEmpecherRedirectionmanuelleDossiersProfils, 0, 134, Short.MAX_VALUE)
                            .addComponent(cboxMasquerElementsBureau, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxCacherpanneauDeConfiguration, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxCacherMenuExecuter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboxCacherMenuFermerSession, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboxEmpecherRedirectionmanuelleDossiersProfils, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cboxMasquerElementsBureau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cboxCacherpanneauDeConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cboxCacherMenuExecuter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cboxCacherMenuFermerSession, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel30)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(152, 152, 158));
        jLabel23.setText("CACHER BOUTTONS ARRETER_REDEMARRER_VEILLE");

        cboxCacherBouttonsArreterRedemarrerMiseEnVeille.setBackground(new java.awt.Color(195, 222, 198));
        cboxCacherBouttonsArreterRedemarrerMiseEnVeille.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxCacherBouttonsArreterRedemarrerMiseEnVeille.setSelectedIndex(1);

        jLabel22.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(152, 152, 158));
        jLabel22.setText("EMPECHER MODIFICATION BARRE DE TACHE");

        cboxEmpecherModificationBarreDeTache.setBackground(new java.awt.Color(195, 222, 198));
        cboxEmpecherModificationBarreDeTache.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxEmpecherModificationBarreDeTache.setSelectedIndex(1);

        jLabel21.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(152, 152, 158));
        jLabel21.setText("EMPECHER MODIFICATION ARRIERE PLAN");

        cboxEmpecherModificationArrierPlan.setBackground(new java.awt.Color(195, 222, 198));
        cboxEmpecherModificationArrierPlan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxEmpecherModificationArrierPlan.setSelectedIndex(1);

        jLabel26.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(152, 152, 158));
        jLabel26.setText("CACHER TOUS LECTEURS DE DISQUE");

        cboxCacherLecteurs.setBackground(new java.awt.Color(195, 222, 198));
        cboxCacherLecteurs.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxCacherLecteurs.setSelectedIndex(1);

        jLabel25.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(152, 152, 158));
        jLabel25.setText("CACHER GESTIONNAIRE DE TACHE");

        cboxCachergestionnaireDeTache.setBackground(new java.awt.Color(195, 222, 198));
        cboxCachergestionnaireDeTache.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxCachergestionnaireDeTache.setSelectedIndex(1);

        jLabel24.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(152, 152, 158));
        jLabel24.setText("EMPECHER ACCES  INVITE DE COMMANDE");

        cboxCacherInviteDeCommande.setBackground(new java.awt.Color(195, 222, 198));
        cboxCacherInviteDeCommande.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxCacherInviteDeCommande.setSelectedIndex(1);

        jLabel28.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(152, 152, 158));
        jLabel28.setText("EMPECHER ACCES AU  REGISTRE");

        cboxCacherRegistre.setBackground(new java.awt.Color(195, 222, 198));
        cboxCacherRegistre.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ACTIVER", "DESACTIVER" }));
        cboxCacherRegistre.setSelectedIndex(1);

        jLabel29.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(152, 152, 158));
        jLabel29.setText("DESACTIVER EXECUTION  FICHIER AUTORUN");

        cboxDesactiverExecutionFichierAutun.setBackground(new java.awt.Color(195, 222, 198));
        cboxDesactiverExecutionFichierAutun.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CHOIX 1", "CHOIX 2", "CHOIX 3", "CHOIX 4", "DESACTIVER" }));
        cboxDesactiverExecutionFichierAutun.setSelectedIndex(4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxDesactiverExecutionFichierAutun, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addComponent(cboxCacherRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxCacherInviteDeCommande, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxCachergestionnaireDeTache, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxCacherLecteurs, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxEmpecherModificationArrierPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxEmpecherModificationBarreDeTache, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboxCacherBouttonsArreterRedemarrerMiseEnVeille, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(cboxCacherBouttonsArreterRedemarrerMiseEnVeille, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(cboxEmpecherModificationBarreDeTache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cboxEmpecherModificationArrierPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(cboxCacherLecteurs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(cboxCachergestionnaireDeTache, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(cboxCacherInviteDeCommande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(cboxCacherRegistre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cboxDesactiverExecutionFichierAutun, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnAppliquer.setText("APPLIQUER");
        btnAppliquer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppliquerActionPerformed(evt);
            }
        });

        btnAppliquerEtVerouiller.setBackground(new java.awt.Color(255, 255, 255));
        btnAppliquerEtVerouiller.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAppliquerEtVerouiller.setText("VERROUILLER");
        btnAppliquerEtVerouiller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppliquerEtVerouillerActionPerformed(evt);
            }
        });

        btnAppliquerEtVerouiller1.setBackground(new java.awt.Color(255, 255, 255));
        btnAppliquerEtVerouiller1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnAppliquerEtVerouiller1.setText("VERROUILLER & EXPLORER");
        btnAppliquerEtVerouiller1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppliquerEtVerouiller1ActionPerformed(evt);
            }
        });

        btnAppliquer1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnAppliquer1.setText("MODIFIER DONNEES AUTHENTIFICATION");
        btnAppliquer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAppliquer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAppliquer1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAppliquer, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnAppliquerEtVerouiller1, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAppliquerEtVerouiller, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(371, 371, 371))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAppliquer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAppliquer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnAppliquerEtVerouiller1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAppliquerEtVerouiller, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAppliquerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppliquerActionPerformed
        this.appliquerChoixUtilisateur();
        ThreadPresentation configuration = new ThreadPresentation(3,this.etat);
        configuration.start();
        //this.controlleur.relancerExploreur();
    }//GEN-LAST:event_btnAppliquerActionPerformed

    private void btnAppliquerEtVerouillerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppliquerEtVerouillerActionPerformed
        ThreadPresentation configuration = new ThreadPresentation(2,this.etat);
        configuration.start();
        this.dispose();
    }//GEN-LAST:event_btnAppliquerEtVerouillerActionPerformed

    private void btnAppliquerEtVerouiller1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppliquerEtVerouiller1ActionPerformed
        ThreadPresentation configuration = new ThreadPresentation(4,this.etat);
        configuration.start();
        ThreadPresentation configuration1 = new ThreadPresentation(2,this.etat);
        configuration1.start();
        this.dispose();
    }//GEN-LAST:event_btnAppliquerEtVerouiller1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.etat.setApplicationsAutorisees(null);
        this.etat.setApplicationNonAutorisee(null);
        this.controlleur.lancerProgrammeAutoriseeOFF();
        this.controlleur.nePaslancerProgrammePreciserOFF();
        ThreadPresentation sauveagrde = new ThreadPresentation(5,this.etat);
        sauveagrde.start();
    }//GEN-LAST:event_formWindowClosing

    private void btnAppliquer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAppliquer1ActionPerformed
        UpdateInfoAuthentification parametre = new UpdateInfoAuthentification(this,true,this.authentification);
        parametre.setLocationRelativeTo(this);
        parametre.setVisible(true);
        
    }//GEN-LAST:event_btnAppliquer1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAppliquer;
    private javax.swing.JButton btnAppliquer1;
    private javax.swing.JButton btnAppliquerEtVerouiller;
    private javax.swing.JButton btnAppliquerEtVerouiller1;
    private javax.swing.JComboBox cboxCacherBouttonsArreterRedemarrerMiseEnVeille;
    private javax.swing.JComboBox cboxCacherInviteDeCommande;
    private javax.swing.JComboBox cboxCacherLecteurs;
    private javax.swing.JComboBox cboxCacherMenuExecuter;
    private javax.swing.JComboBox cboxCacherMenuFermerSession;
    private javax.swing.JComboBox cboxCacherRegistre;
    private javax.swing.JComboBox cboxCachergestionnaireDeTache;
    private javax.swing.JComboBox cboxCacherpanneauDeConfiguration;
    private javax.swing.JComboBox cboxDesactiverExecutionFichierAutun;
    private javax.swing.JComboBox cboxEmpecherModificationArrierPlan;
    private javax.swing.JComboBox cboxEmpecherModificationBarreDeTache;
    private javax.swing.JComboBox cboxEmpecherRedirectionmanuelleDossiersProfils;
    private javax.swing.JComboBox cboxMasquerElementsBureau;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea txtApplicationNonAutorisee;
    private javax.swing.JTextArea txtApplicationsAutorisees;
    // End of variables declaration//GEN-END:variables
}
