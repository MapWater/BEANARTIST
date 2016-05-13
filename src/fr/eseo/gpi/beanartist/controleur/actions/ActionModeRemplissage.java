/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.controleur.outils.OutilRectangle;
import fr.eseo.gpi.beanartist.vue.ui.FenętreBeAnArtist;
//import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

/**
 * @author Clément
 *
 */
public class ActionModeRemplissage extends javax.swing.AbstractAction{
	// CONSTANTES
	public static final String NOM_ACTION = "Rectangle";
	
	// ATTRIBUTS
	FenętreBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionModeRemplissage(FenętreBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
		this.fenetre.getPanneauDessin().setModeRemplissage(true);;
	}
	
	// ACCESSEURS
	public void setFenetre(FenętreBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public FenętreBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
