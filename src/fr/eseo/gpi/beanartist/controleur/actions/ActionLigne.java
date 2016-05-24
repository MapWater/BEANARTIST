/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;


/**
 * @author Cl�ment
 *
 */
public class ActionLigne extends javax.swing.AbstractAction{

	
	// ATTRIBUTS
	FenêtreBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionLigne(FenêtreBeAnArtist fen){
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
	public void setFenetre(FenêtreBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public FenêtreBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
