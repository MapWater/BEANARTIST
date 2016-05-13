/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.controleur.outils.OutilRectangle;
import fr.eseo.gpi.beanartist.vue.ui.Fen�treBeAnArtist;
//import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

/**
 * @author Cl�ment
 *
 */
public class ActionModeRemplissage extends javax.swing.AbstractAction{
	// CONSTANTES
	public static final String NOM_ACTION = "Rectangle";
	
	// ATTRIBUTS
	Fen�treBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionModeRemplissage(Fen�treBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
		this.fenetre.getPanneauDessin().setModeRemplissage(true);;
	}
	
	// ACCESSEURS
	public void setFenetre(Fen�treBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public Fen�treBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
