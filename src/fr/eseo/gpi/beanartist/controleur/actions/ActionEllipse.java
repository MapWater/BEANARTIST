/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.controleur.outils.OutilEllipse;
import fr.eseo.gpi.beanartist.vue.ui.FenętreBeAnArtist;

/**
 * @author Clément
 *
 */
public class ActionEllipse extends javax.swing.AbstractAction{
	// CONSTANTES
	public static final String NOM_ACTION = "Ellipse";
	
	// ATTRIBUTS
	FenętreBeAnArtist fenetre;
	
	
	// CONSTRUCTEURS
	public ActionEllipse(FenętreBeAnArtist fen){
		this.fenetre = fen;
//		System.out.println(fen);
	}
	
	// AUTRES METHODES
	public void actionPerformed(ActionEvent e) {
//		System.out.println("ET C'EST LE GG!");
//		System.out.println(this.getFenetre());
//		System.out.println("Tentative de changement d'outil vers Ellipse");
		OutilEllipse outil = new OutilEllipse(this.fenetre.getPanneauDessin());
	}
	
	// ACCESSEURS
	public void setFenetre(FenętreBeAnArtist fen){
		this.fenetre = fen;
	}
	
	public FenętreBeAnArtist getFenetre(){
		return this.fenetre;
	}

}
