package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import javax.swing.JPanel;


public class PanneauDessin {
	
	// Constantes
	public static final int LARGEUR_PAR_DÉFAUT = 800;
	public static final int HAUTEUR_PAR_DÉFAUT = 600;
	public static final Color COULEUR_FOND_PAR_DÉFAUT = Color.white;
	public static final Color COULEUR_LIGNE_PAR_DÉFAUT = Color.black;
	// Attributs
	private FenêtreBeAnArtist fenêtre;
	
	// Constructeurs
	
	public PanneauDessin(){
		
	}
	
	public PanneauDessin(int largeur, int hauteur){
		
	}

	public PanneauDessin(int largeur, int hauteur, Color couleurFond){
		
	}
	
	// Accesseurs
	
	public FenêtreBeAnArtist getFenêtre(){
		return this.fenêtre;
	}
	
	public void setFenêtre(FenêtreBeAnArtist fen){
		this.fenêtre = fen;
	}
	
	// Autres Méthodes
	
	
}
