package fr.eseo.gpi.beanartist.vue.ui;

import javax.swing.JFrame;

public class Fen�treBeAnArtist {
	// Constantes
	public static final int LARGEUR_PAR_D�FAUT = 800;
	public static final int HAUTEUR_PAR_D�FAUT = 600;
	public static final String TITRE_PAR_D�FAUT = "BeAnArtist";
	// Attributs
	private PanneauDessin panneauDessin;
	
	// Constructeurs
	public Fen�treBeAnArtist(){
		this(TITRE_PAR_D�FAUT, LARGEUR_PAR_D�FAUT, HAUTEUR_PAR_D�FAUT);
	}

	public Fen�treBeAnArtist(String titre){
		this("titre", LARGEUR_PAR_D�FAUT, HAUTEUR_PAR_D�FAUT);
	}

	public Fen�treBeAnArtist(int largeur, int hauteur){
		this(TITRE_PAR_D�FAUT, largeur, hauteur);
	}

	public Fen�treBeAnArtist(String titre, int largeur, int hauteur){
		this.panneauDessin = new PanneauDessin();
	}
	
	// Accesseurs
	public void setPanneauDessin(PanneauDessin panneau){
		this.panneauDessin = panneau;
	}
	
	public PanneauDessin getPanneauDessin(){
		return this.panneauDessin;
	}
	
	// Autres M�thodes
	private void associerPanneauDessin(int largeur, int hauteur){
		
	}
	
}
