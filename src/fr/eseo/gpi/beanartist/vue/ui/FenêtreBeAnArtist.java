package fr.eseo.gpi.beanartist.vue.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class Fen�treBeAnArtist extends JFrame{
	// Constantes
	public static final int LARGEUR_PAR_D�FAUT = 800;
	public static final int HAUTEUR_PAR_D�FAUT = 600;
	public static final String TITRE_PAR_D�FAUT = "BeAnArtist";
	public static final Color COULEUR_FOND_PAR_D�FAUT = Color.white;
	// Attributs
	private PanneauDessin panneauDessin;
	private PanneauBarreOutil panneauBarreOutil;
	private JSplitPane splitPane;
	private JPanel windowPan;
	
	// Constructeurs
	public Fen�treBeAnArtist(){
		this(TITRE_PAR_D�FAUT, LARGEUR_PAR_D�FAUT, HAUTEUR_PAR_D�FAUT, COULEUR_FOND_PAR_D�FAUT);
	}

	public Fen�treBeAnArtist(String titre){
		this("titre", LARGEUR_PAR_D�FAUT, HAUTEUR_PAR_D�FAUT, COULEUR_FOND_PAR_D�FAUT);
	}

	public Fen�treBeAnArtist(int largeur, int hauteur){
		this(TITRE_PAR_D�FAUT, largeur, hauteur, COULEUR_FOND_PAR_D�FAUT);
	}

	public Fen�treBeAnArtist(String titre, int largeur, int hauteur){
		this(titre, largeur, hauteur, COULEUR_FOND_PAR_D�FAUT);
	}
	
	public Fen�treBeAnArtist(String titre, int largeur, int hauteur, Color couleurFond){
		// Infos Basiques
		this.setTitle(titre);
		this.setSize(largeur, hauteur);
		//this.setBackground(couleurFond);
		this.setMinimumSize(new Dimension(largeur, hauteur));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable (false);
		
	    // Layout
//	    this.windowPan = new JPanel();
//	    this.windowPan.setLayout(new BorderLayout());
//	    this.getContentPane().add(windowPan);
//	    
//	    this.splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT); 
//	    this.windowPan.add(splitPane, BorderLayout.CENTER);
//	    
//		this.associerPanneauDessin(couleurFond);
//		this.associerBarreOutil();
//		splitPane.setLeftComponent( this.getPanneauDessin());
//		splitPane.setRightComponent( this.getPanneauBarreOutil() );
		this.associerPanneauDessin(couleurFond);
		this.associerBarreOutil();
		this.getContentPane().add(this.panneauDessin, BorderLayout.WEST);
		this.getContentPane().add(this.panneauBarreOutil, BorderLayout.EAST);
		
		this.pack();
		this.setVisible(true);
	}
	

	// Autres M�thodes
	
//	private void associerPanneauDessin(){
//		this.associerPanneauDessin(this.getLargeur(), hauteur, Color.white);
//	}
	
	private void associerPanneauDessin(Color couleurFond){
		this.panneauDessin = new PanneauDessin(couleurFond, PanneauDessin.COULEUR_LIGNE_PAR_D�FAUT, this);
		this.panneauDessin.setLayout( new BorderLayout() );
	}
	
	private void associerPanneauDessin(int largeur, int hauteur){
		this.associerPanneauDessin(largeur, hauteur, Color.white);
	}
	
	private void associerPanneauDessin(int largeur, int hauteur, Color couleurFond){
		this.panneauDessin = new PanneauDessin(largeur, hauteur, couleurFond, PanneauDessin.COULEUR_LIGNE_PAR_D�FAUT, this);
		this.panneauDessin.setLayout( new BorderLayout() );
	}
	
	private void associerBarreOutil(){
		this.panneauBarreOutil = new PanneauBarreOutil(this);
		this.panneauBarreOutil.setLayout( new FlowLayout() );
		//this.setContentPane(this.panneauDessin);
	}

	// Accesseurs
	public void setPanneauDessin(PanneauDessin panneau){
		this.panneauDessin = panneau;
	}
	
	public PanneauDessin getPanneauDessin(){
		return this.panneauDessin;
	}
	
	public PanneauBarreOutil getPanneauBarreOutil(){
		return this.panneauBarreOutil;
	}
	
	public void setPanneauBarreOutil(PanneauBarreOutil panneauBarreOutil) {
		this.panneauBarreOutil = panneauBarreOutil;
	}
	
	
	
}
