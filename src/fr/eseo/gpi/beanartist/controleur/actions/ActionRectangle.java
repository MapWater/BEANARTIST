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
public class ActionRectangle extends javax.swing.AbstractAction{
	// CONSTANTES
	
	// ATTRIBUTS
	Fen�treBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionRectangle(Fen�treBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ET C'EST LE GG!");
//		System.out.println(this.getFenetre());
//		this.getFenetre().getPanneauDessin().getOutilCourant().lib�rer();
		OutilRectangle outil = new OutilRectangle(this.fenetre.getPanneauDessin());
	}
	
	// ACCESSEURS
	public void setFenetre(Fen�treBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public Fen�treBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
