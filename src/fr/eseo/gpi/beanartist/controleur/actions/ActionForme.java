package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import fr.eseo.gpi.beanartist.vue.ui.Fen�treBeAnArtist;

public abstract class ActionForme extends javax.swing.AbstractAction{
	// CONSTANTES
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_RECTANGLE = "Rectangle";
	public static final String NOM_ACTION_CARR� = "Carr�";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	public static final String NOM_ACTION_TRAC� = "Trac�";
	
	// ATTRIBUTS
	private Fen�treBeAnArtist fen�tre;
	
	public ActionForme(Fen�treBeAnArtist fen){
		this.fen�tre = fen;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0){
		
	}

}
