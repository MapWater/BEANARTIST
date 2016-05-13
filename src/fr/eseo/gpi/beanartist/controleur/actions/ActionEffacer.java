/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import fr.eseo.gpi.beanartist.vue.ui.Fen�treBeAnArtist;
//import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

/**
 * @author Cl�ment
 *
 */
public class ActionEffacer extends javax.swing.AbstractAction{
	// CONSTANTES
	public static final String NOM_ACTION = "Effacer";
	
	// ATTRIBUTS
	Fen�treBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionEffacer(Fen�treBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ET C'EST LE GG!");
//		System.out.println(this.getFenetre());
		this.fenetre.getPanneauDessin().getVueFormes().clear();
		this.fenetre.getPanneauDessin().removeAll();
	}
	
	// ACCESSEURS
	public void setFenetre(Fen�treBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public Fen�treBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
