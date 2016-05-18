package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import fr.eseo.gpi.beanartist.controleur.outils.OutilSélection;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;

public class ActionSélectionner extends AbstractAction{

	private static final long serialVersionUID = 1L;
	public static final String NOM_ACTION_SÉLECTIONNER = "OutilSélection";
	private FenêtreBeAnArtist fenêtre;
	
	public ActionSélectionner(FenêtreBeAnArtist f){
		super(NOM_ACTION_SÉLECTIONNER);
		this.fenêtre = f;
	}
	
	public void actionPerformed(ActionEvent event) {
		OutilSélection outilSélection= new OutilSélection(fenêtre.getPanneauDessin());
		outilSélection.associer(fenêtre.getPanneauDessin());
		
	}
	
}
