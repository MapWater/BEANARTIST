package fr.eseo.gpi.beanartist.vue.ui;

import javax.swing.JFrame;

public class FenêtreBeAnArtist {
	// Constantes
	public static final int LARGEUR_PAR_DÉFAUT = 800;
	public static final int HAUTEUR_PAR_DÉFAUT = 600;
	public static final String TITRE_PAR_DÉFAUT = "BeAnArtist";
	// Attributs
	private PanneauDessin panneauDessin;
	
	// Constructeurs
	public FenêtreBeAnArtist(){
		this(TITRE_PAR_DÉFAUT, LARGEUR_PAR_DÉFAUT, HAUTEUR_PAR_DÉFAUT);
	}

	public FenêtreBeAnArtist(String titre){
		this("titre", LARGEUR_PAR_DÉFAUT, HAUTEUR_PAR_DÉFAUT);
	}

	public FenêtreBeAnArtist(int largeur, int hauteur){
		this(TITRE_PAR_DÉFAUT, largeur, hauteur);
	}

	public FenêtreBeAnArtist(String titre, int largeur, int hauteur){
		this.panneauDessin = new PanneauDessin();
	}
	
	// Accesseurs
	public void setPanneauDessin(PanneauDessin panneau){
		this.panneauDessin = panneau;
	}
	
	public PanneauDessin getPanneauDessin(){
		return this.panneauDessin;
	}
	
	// Autres Méthodes
	private void associerPanneauDessin(int largeur, int hauteur){
		
	}
	
}
