package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.*;
import fr.eseo.gpi.beanartist.controleur.outils.Outil;
import fr.eseo.gpi.beanartist.controleur.actions.*;



public class PanneauBarreOutil extends JPanel {
	
	// Constantes
	public static final int LARGEUR_PAR_D�FAUT = 170;
	public static final int HAUTEUR_PAR_D�FAUT = 600;
	public static final Color COULEUR_FOND_PAR_D�FAUT = Color.gray;
	public static final String NOM_ACTION_EFFACER = "EFFACER TOUT";
	public static final String NOM_ACTION_RECTANGLE = "RECTANGLE";
	public static final String NOM_ACTION_CARR� = "CARR�";
	public static final String NOM_ACTION_ELLIPSE = "ELLIPSE";
	public static final String NOM_ACTION_CERCLE = "CERCLE";
	public static final String NOM_ACTION_LIGNE = "LIGNE";
	public static final String NOM_ACTION_TRAC� = "TRAC�";
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
		this.setLayout(new GridLayout(12, 1));
		ajoutBoutonEffacer();
		ajoutBoutonRectangle();
		ajoutBoutonCarr�();
		ajoutBoutonEllipse();
		ajoutBoutonCercle();
		ajoutBoutonLigne();
		ajoutBoutonTrac�();
		ajoutBoutonRadio();
		ajoutBoutonCouleurFond();
		ajoutBoutonCouleurForme();
		ajoutBoutonSelection();
		fen�tre.pack();
	}
	
	private void ajoutBoutonEffacer(){
		JButton button = new JButton(NOM_ACTION_EFFACER);
		button.addActionListener(new ActionEffacer(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonRectangle(){
		JButton button = new JButton(NOM_ACTION_RECTANGLE);
		button.addActionListener(new ActionRectangle(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonCarr�(){
		JButton button = new JButton(NOM_ACTION_CARR�);
		button.addActionListener(new ActionCarr�(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonEllipse(){
		JButton button = new JButton(NOM_ACTION_ELLIPSE);
		button.addActionListener(new ActionEllipse(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonCercle(){
		JButton button = new JButton(NOM_ACTION_CERCLE);
		button.addActionListener(new ActionCercle(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonLigne(){
		JButton button = new JButton(NOM_ACTION_LIGNE);
		button.addActionListener(new ActionLigne(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonTrac�(){
		JButton button = new JButton(NOM_ACTION_TRAC�);
		button.addActionListener(new ActionTrac�(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonCouleurFond(){
		JButton button = new JButton("COULEUR FOND");
		button.addActionListener(new ActionChoisirFond(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonCouleurForme(){
		JButton button = new JButton("COULEUR FORME");
		button.addActionListener(new ActionChoisirCouleur(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonSelection(){
		JButton button = new JButton("SELECTIONNER");
		button.addActionListener(new ActionS�lectionner(this.getFen�tre()));
		button.setPreferredSize(new Dimension(160,30));
		this.add(button);
	}
	
	private void ajoutBoutonRadio(){
//		JRadioButton plein = new JRadioButton(NOM_ACTION_PLEIN, fen�tre.getPanneauDessin().estModeRemplissage());
//		JRadioButton vide = new JRadioButton(NOM_ACTION_VIDE, !fen�tre.getPanneauDessin().estModeRemplissage());
//		this.add(plein);
//		this.add(vide);
		ButtonGroup boutonRemplissage =  new ButtonGroup();
		ActionModeRemplissage actionModeRemplissage = new ActionModeRemplissage(getFen�tre().getPanneauDessin());
		
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
