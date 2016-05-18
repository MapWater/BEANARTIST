package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import fr.eseo.gpi.beanartist.controleur.outils.OutilChoisirCouleur;
import fr.eseo.gpi.beanartist.vue.ui.FenÍtreBeAnArtist;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class ActionChoisirCouleur extends AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String CHOISIR_COULEUR = "Choisir couleur";
	private PanneauDessin panneauDessin;

	public ActionChoisirCouleur (PanneauDessin pan){
		//LOLELOLELOLELOLEOLEOLEOLOL
	}
	
	public ActionChoisirCouleur (FenÍtreBeAnArtist fen){
		super(CHOISIR_COULEUR);
		this.panneauDessin = fen.getPanneauDessin();
	}
	
	public void actionPerformed(ActionEvent e) {
		OutilChoisirCouleur outilChoisirCouleur= new OutilChoisirCouleur(panneauDessin);
		outilChoisirCouleur.associer(panneauDessin);
		 }
}
