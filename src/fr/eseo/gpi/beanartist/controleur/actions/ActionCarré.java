/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.controleur.outils.OutilCarré;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;
//import fr.eseo.gpi.beanartist.vue.ui.FenetreBeAnArtist;

/**
 * @author Cl�ment
 *
 */
public class ActionCarré extends javax.swing.AbstractAction{
	// CONSTANTES
	
	// ATTRIBUTS
	FenêtreBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionCarré(FenêtreBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ET C'EST LE GG!");
//		System.out.println(this.getFenetre());
//		this.getFenetre().getPanneauDessin().getOutilCourant().lib�rer();
		OutilCarré outil = new OutilCarré(this.fenetre.getPanneauDessin());
	}
	
	// ACCESSEURS
	public void setFenetre(FenêtreBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public FenêtreBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
