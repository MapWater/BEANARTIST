package fr.eseo.gpi.beanartist.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import fr.eseo.gpi.beanartist.controleur.outils.OutilChoisirFond;
import fr.eseo.gpi.beanartist.vue.ui.*;

public class ActionChoisirFond extends AbstractAction {

	private static final long serialVersionUID = 1L;
	public static final String CHOISIR_FOND = " Choisir couleur fond";
	private PanneauDessin panneauDessin;

	public ActionChoisirFond(FenêtreBeAnArtist fen){
		super(CHOISIR_FOND);
		this.panneauDessin = fen.getPanneauDessin();
	}
	
	public void actionPerformed(ActionEvent e) {
		OutilChoisirFond outilChoisirFond= new OutilChoisirFond(panneauDessin);
		outilChoisirFond.associer(panneauDessin);
	}
	
}
