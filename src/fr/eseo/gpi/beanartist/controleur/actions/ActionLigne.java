/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.vue.ui.FenętreBeAnArtist;


/**
 * @author Clément
 *
 */
public class ActionLigne extends javax.swing.AbstractAction{

	
	// ATTRIBUTS
	FenętreBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionLigne(FenętreBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ET C'EST LE GG!");
//		System.out.println(this.getFenetre());
		OutilLigne outil = new OutilLigne(this.fenetre.getPanneauDessin());
	}
	
	// ACCESSEURS
	public void setFenetre(FenętreBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public FenętreBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
