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
	public static final int LARGEUR_PAR_D�FAUT = 200;
	public static final int HAUTEUR_PAR_D�FAUT = 600;
	public static final Color COULEUR_FOND_PAR_D�FAUT = Color.gray;
	public static final String NOM_ACTION_EFFACER = "EFFACER TOUT";
	public static final String NOM_ACTION_RECTANGLE = "RECTANGLE";
	public static final String NOM_ACTION_ELLIPSE = "ELLIPSE";
	public static final String NOM_ACTION_LIGNE = "LIGNE";
	public static final String NOM_ACTION_PLEIN = "PLEIN";
	public static final String NOM_ACTION_VIDE = "VIDE";
	
	private Fen�treBeAnArtist fen�tre;
	private Outil outilCourant;
	private Color couleurForme;
	
	// Constructeurs
	
	public PanneauBarreOutil(){
		this(new Fen�treBeAnArtist());
	}
	
	public PanneauBarreOutil(Fen�treBeAnArtist fen){
		this.fen�tre = fen;
		this.setOpaque(true);
		this.setBackground(COULEUR_FOND_PAR_D�FAUT);
		this.setMinimumSize(new Dimension(LARGEUR_PAR_D�FAUT, HAUTEUR_PAR_D�FAUT));
		this.setPreferredSize(new Dimension(LARGEUR_PAR_D�FAUT, HAUTEUR_PAR_D�FAUT));
		this.initComponents();
	}

	// Autres M�thodes
	
	private void initComponents(){
		ajoutBoutonEffacer();
		ajoutBoutonRectangle();
		ajoutBoutonEllipse();
		ajoutBoutonLigne();
		ajoutBoutonRadio();
	}
	
	private void ajoutBoutonEffacer(){
		JButton button = new JButton(NOM_ACTION_EFFACER);
		button.addActionListener(new ActionEffacer(this.getFen�tre()));
		this.add(button, BorderLayout.NORTH);
	}
	
	private void ajoutBoutonRectangle(){
		JButton button = new JButton(NOM_ACTION_RECTANGLE);
		button.addActionListener(new ActionRectangle(this.getFen�tre()));
		this.add(button, BorderLayout.NORTH);
	}
	
	private void ajoutBoutonEllipse(){
		JButton button = new JButton(NOM_ACTION_ELLIPSE);
		button.addActionListener(new ActionEllipse(this.getFen�tre()));
		this.add(button, BorderLayout.NORTH);
	}
	
	private void ajoutBoutonLigne(){
		JButton button = new JButton(NOM_ACTION_LIGNE);
		button.addActionListener(new ActionLigne(this.getFen�tre()));
		this.add(button, BorderLayout.NORTH);
	}
	
	private void ajoutBoutonRadio(){
		JRadioButton plein = new JRadioButton(NOM_ACTION_PLEIN, fen�tre.getPanneauDessin().estModeRemplissage());
		JRadioButton vide = new JRadioButton(NOM_ACTION_VIDE, !fen�tre.getPanneauDessin().estModeRemplissage());
		this.add(plein, BorderLayout.NORTH);
		this.add(vide, BorderLayout.NORTH);
	}
	
	// ACCESSEURS
	
	public Fen�treBeAnArtist getFen�tre(){
		return this.fen�tre;
	}
	
	public void setFen�tre(Fen�treBeAnArtist fen){
		this.fen�tre = fen;
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
