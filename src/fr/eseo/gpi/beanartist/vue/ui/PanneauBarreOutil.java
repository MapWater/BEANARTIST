package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.*;
import fr.eseo.gpi.beanartist.controleur.outils.Outil;
import fr.eseo.gpi.beanartist.controleur.actions.*;



public class PanneauBarreOutil extends JPanel {
	
	// Constantes
	public static final int LARGEUR_PAR_DÉFAUT = 170;
	public static final int HAUTEUR_PAR_DÉFAUT = 600;
	public static final Color COULEUR_FOND_PAR_DÉFAUT = Color.gray;
	public static final String NOM_ACTION_EFFACER = "EFFACER TOUT";
	public static final String NOM_ACTION_RECTANGLE = "RECTANGLE";
	public static final String NOM_ACTION_CARRÉ = "CARRÉ";
	public static final String NOM_ACTION_ELLIPSE = "ELLIPSE";
	public static final String NOM_ACTION_CERCLE = "CERCLE";
	public static final String NOM_ACTION_LIGNE = "LIGNE";
	public static final String NOM_ACTION_TRACÉ = "TRACÉ";
	public static final String NOM_ACTION_PLEIN = "PLEIN";
	public static final String NOM_ACTION_VIDE = "VIDE";
	
	private FenêtreBeAnArtist fenêtre;
	private Outil outilCourant;
	private Color couleurForme;
	
	// Constructeurs
	
	public PanneauBarreOutil(){
		this(new FenêtreBeAnArtist());
	}
	
	public PanneauBarreOutil(FenêtreBeAnArtist fen){
		this.fenêtre = fen;
		this.setOpaque(true);
		this.setBackground(COULEUR_FOND_PAR_DÉFAUT);
		this.setMinimumSize(new Dimension(LARGEUR_PAR_DÉFAUT, HAUTEUR_PAR_DÉFAUT));
		this.setPreferredSize(new Dimension(LARGEUR_PAR_DÉFAUT, HAUTEUR_PAR_DÉFAUT));
		this.initComponents();
	}

	// Autres Méthodes
	
	private void initComponents(){
		this.setLayout(new GridLayout(12, 1));
		ajoutBoutonEffacer();
		ajoutBoutonRectangle();
		ajoutBoutonCarré();
		ajoutBoutonEllipse();
		ajoutBoutonCercle();
		ajoutBoutonLigne();
		ajoutBoutonTracé();
		ajoutBoutonRadio();
		ajoutBoutonCouleurFond();
		ajoutBoutonCouleurForme();
		ajoutBoutonSelection();
		fenêtre.pack();
	}
	
	private void ajoutBoutonEffacer(){
		JButton button = new JButton(NOM_ACTION_EFFACER);
		button.addActionListener(new ActionEffacer(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonRectangle(){
		JButton button = new JButton(NOM_ACTION_RECTANGLE);
		button.addActionListener(new ActionRectangle(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonCarré(){
		JButton button = new JButton(NOM_ACTION_CARRÉ);
		button.addActionListener(new ActionCarré(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonEllipse(){
		JButton button = new JButton(NOM_ACTION_ELLIPSE);
		button.addActionListener(new ActionEllipse(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonCercle(){
		JButton button = new JButton(NOM_ACTION_CERCLE);
		button.addActionListener(new ActionCercle(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonLigne(){
		JButton button = new JButton(NOM_ACTION_LIGNE);
		button.addActionListener(new ActionLigne(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonTracé(){
		JButton button = new JButton(NOM_ACTION_TRACÉ);
		button.addActionListener(new ActionTracé(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonCouleurFond(){
		JButton button = new JButton("COULEUR FOND");
		button.addActionListener(new ActionChoisirFond(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonCouleurForme(){
		JButton button = new JButton("COULEUR FORME");
		button.addActionListener(new ActionChoisirCouleur(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonSelection(){
		JButton button = new JButton("SELECTIONNER");
		button.addActionListener(new ActionSélectionner(this.getFenêtre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonRadio(){
//		JRadioButton plein = new JRadioButton(NOM_ACTION_PLEIN, fenêtre.getPanneauDessin().estModeRemplissage());
//		JRadioButton vide = new JRadioButton(NOM_ACTION_VIDE, !fenêtre.getPanneauDessin().estModeRemplissage());
//		this.add(plein);
//		this.add(vide);
		ButtonGroup boutonRemplissage =  new ButtonGroup();
		ActionModeRemplissage actionModeRemplissage = new ActionModeRemplissage(getFenêtre().getPanneauDessin());
		
		JRadioButton boutonRempli = new JRadioButton(actionModeRemplissage);
		boutonRempli.setActionCommand("rempli");
		JRadioButton boutonContour = new JRadioButton(actionModeRemplissage);
		boutonContour.setActionCommand("contour");
		
		boutonRemplissage.add(boutonRempli);
		boutonRempli.setText("Rempli");
		boutonRemplissage.add(boutonContour);
		boutonContour.setText("Contour");
		this.add(boutonRempli);
		this.add(boutonContour);
	}
	
	// ACCESSEURS
	
	public FenêtreBeAnArtist getFenêtre(){
		return this.fenêtre;
	}
	
	public void setFenêtre(FenêtreBeAnArtist fen){
		this.fenêtre = fen;
	}
	
	public void setCouleurForme(Color couleurForme){
		this.couleurForme = couleurForme;
	}
	
	public Color getCouleurForme(){
		return this.couleurForme;
	}
	
	public void setOutilCourant(Outil outil){
		this.outilCourant = outil;		
	}
	
	public Outil getOutilCourant(){
		return this.outilCourant;
	}
	
}
