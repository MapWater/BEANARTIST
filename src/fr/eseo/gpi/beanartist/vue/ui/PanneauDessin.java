package fr.eseo.gpi.beanartist.vue.ui;

import java.awt.Color;
import javax.swing.JPanel;


public class PanneauDessin {
	
	// Constantes
	public static final int LARGEUR_PAR_D�FAUT = 800;
	public static final int HAUTEUR_PAR_D�FAUT = 600;
	public static final Color COULEUR_FOND_PAR_D�FAUT = Color.white;
	public static final Color COULEUR_LIGNE_PAR_D�FAUT = Color.black;
	// Attributs
	private Fen�treBeAnArtist fen�tre;
	
	// Constructeurs
	
	public PanneauDessin(){
		
	}
	
	public PanneauDessin(int largeur, int hauteur){
		
	}

	public PanneauDessin(int largeur, int hauteur, Color couleurFond){
		
	}
	
	// Accesseurs
	
	public Fen�treBeAnArtist getFen�tre(){
		return this.fen�tre;
	}
	
	public void setFen�tre(Fen�treBeAnArtist fen){
		this.fen�tre = fen;
	}
	
	// Autres M�thodes
	
	
}
