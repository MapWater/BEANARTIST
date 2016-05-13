package fr.eseo.gpi.beanartist.vue.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

public class FenêtreBeAnArtist extends JFrame{
	// Constantes
	public static final int LARGEUR_PAR_DÉFAUT = 800;
	public static final int HAUTEUR_PAR_DÉFAUT = 600;
	public static final String TITRE_PAR_DÉFAUT = "BeAnArtist";
	public static final Color COULEUR_FOND_PAR_DÉFAUT = Color.white;
	// Attributs
	private PanneauDessin panneauDessin;
	private PanneauBarreOutil panneauBarreOutil;
	private JSplitPane splitPane;
	private JPanel windowPan;
	
	// Constructeurs
	public FenêtreBeAnArtist(){
		this(TITRE_PAR_DÉFAUT, LARGEUR_PAR_DÉFAUT, HAUTEUR_PAR_DÉFAUT, COULEUR_FOND_PAR_DÉFAUT);
	}

	public FenêtreBeAnArtist(String titre){
		this("titre", LARGEUR_PAR_DÉFAUT, HAUTEUR_PAR_DÉFAUT, COULEUR_FOND_PAR_DÉFAUT);
	}

	public FenêtreBeAnArtist(int largeur, int hauteur){
		this(TITRE_PAR_DÉFAUT, largeur, hauteur, COULEUR_FOND_PAR_DÉFAUT);
	}

	public FenêtreBeAnArtist(String titre, int largeur, int hauteur){
		this(titre, largeur, hauteur, COULEUR_FOND_PAR_DÉFAUT);
	}
	
	public FenêtreBeAnArtist(String titre, int largeur, int hauteur, Color couleurFond){
		// Infos Basiques
		this.setTitle(titre);
		this.setSize(largeur, hauteur);
		this.setBackground(couleurFond);
		this.setMinimumSize(new Dimension(largeur, hauteur));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setResizable (false);
		
	    // Layout
	    this.windowPan = new JPanel();
	    this.windowPan.setLayout(new BorderLayout());
	    this.getContentPane().add(windowPan);
	    
	    this.splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT); 
	    this.windowPan.add(splitPane, BorderLayout.CENTER);
	    
		this.associerPanneauDessin(couleurFond);
		this.associerBarreOutil();
		splitPane.setLeftComponent( this.getPanneauDessin());
		splitPane.setRightComponent( this.getPanneauBarreOutil() );
		
		this.pack();
		this.setVisible(true);
	}
	

	// Autres Méthodes
	
//	private void associerPanneauDessin(){
//		this.associerPanneauDessin(this.getLargeur(), hauteur, Color.white);
//	}
	
	private void associerPanneauDessin(Color couleurFond){
		this.panneauDessin = new PanneauDessin(couleurFond, PanneauDessin.COULEUR_LIGNE_PAR_DÉFAUT, this);
		this.panneauDessin.setLayout( new BorderLayout() );
	}
	
	private void associerPanneauDessin(int largeur, int hauteur){
		this.associerPanneauDessin(largeur, hauteur, Color.white);
	}
	
	private void associerPanneauDessin(int largeur, int hauteur, Color couleurFond){
		this.panneauDessin = new PanneauDessin(largeur, hauteur, couleurFond, PanneauDessin.COULEUR_LIGNE_PAR_DÉFAUT, this);
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
