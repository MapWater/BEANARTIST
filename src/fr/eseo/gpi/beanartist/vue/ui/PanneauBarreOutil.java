package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.plaf.basic.BasicButtonListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.controleur.outils.Outil;
import fr.eseo.gpi.beanartist.controleur.actions.*;



public class PanneauBarreOutil extends JPanel {
	
	// Constantes
	public static final int LARGEUR_PAR_DÉFAUT = 200;
	public static final int HAUTEUR_PAR_DÉFAUT = 600;
	public static final Color COULEUR_FOND_PAR_DÉFAUT = Color.gray;
	public static final String NOM_ACTION_EFFACER = "EFFACER TOUT";
	public static final String NOM_ACTION_RECTANGLE = "RECTANGLE";
	public static final String NOM_ACTION_ELLIPSE = "ELLIPSE";
	public static final String NOM_ACTION_LIGNE = "LIGNE";
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
		ajoutBoutonEffacer();
		ajoutBoutonRectangle();
		ajoutBoutonEllipse();
		ajoutBoutonLigne();
		ajoutBoutonRadio();
	}
	
	private void ajoutBoutonEffacer(){
		JButton button = new JButton(NOM_ACTION_EFFACER);
		button.addActionListener(new ActionEffacer(this.getFenêtre()));
		this.add(button, BorderLayout.NORTH);
	}
	
	private void ajoutBoutonRectangle(){
		JButton button = new JButton(NOM_ACTION_RECTANGLE);
		button.addActionListener(new ActionRectangle(this.getFenêtre()));
		this.add(button, BorderLayout.NORTH);
	}
	
	private void ajoutBoutonEllipse(){
		JButton button = new JButton(NOM_ACTION_ELLIPSE);
		button.addActionListener(new ActionEllipse(this.getFenêtre()));
		this.add(button, BorderLayout.NORTH);
	}
	
	private void ajoutBoutonLigne(){
		JButton button = new JButton(NOM_ACTION_LIGNE);
		button.addActionListener(new ActionLigne(this.getFenêtre()));
		this.add(button, BorderLayout.NORTH);
	}
	
	private void ajoutBoutonRadio(){
		JRadioButton plein = new JRadioButton(NOM_ACTION_PLEIN, fenêtre.getPanneauDessin().estModeRemplissage());
		JRadioButton vide = new JRadioButton(NOM_ACTION_VIDE, !fenêtre.getPanneauDessin().estModeRemplissage());
		this.add(plein, BorderLayout.NORTH);
		this.add(vide, BorderLayout.NORTH);
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
