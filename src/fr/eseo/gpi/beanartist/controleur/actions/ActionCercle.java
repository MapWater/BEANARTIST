/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.controleur.outils.OutilCercle;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;

/**
 * @author Clément
 *
 */
public class ActionCercle extends javax.swing.AbstractAction{
	
	// ATTRIBUTS
	FenêtreBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionCercle(FenêtreBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ET C'EST LE GG!");
//		System.out.println(this.getFenetre());
//		System.out.println("Tentative de changement d'outil vers Ellipse");
		OutilCercle outil = new OutilCercle(this.fenetre.getPanneauDessin());
	}
	
	// ACCESSEURS
	public void setFenetre(FenêtreBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public FenêtreBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
