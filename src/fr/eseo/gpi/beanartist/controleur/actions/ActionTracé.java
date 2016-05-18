/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.controleur.outils.OutilTrac�;
import fr.eseo.gpi.beanartist.controleur.outils.OutilLigne;
import fr.eseo.gpi.beanartist.vue.ui.Fen�treBeAnArtist;


/**
 * @author Cl�ment
 *
 */
public class ActionTrac� extends javax.swing.AbstractAction{

	
	// ATTRIBUTS
	Fen�treBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionTrac�(Fen�treBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ET C'EST LE GG!");
//		System.out.println(this.getFenetre());
		OutilTrac� outil = new OutilTrac�(this.fenetre.getPanneauDessin());
	}
	
	// ACCESSEURS
	public void setFenetre(Fen�treBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public Fen�treBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
