package fr.eseo.gpi.beanartist.controleur.outils;

import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;

import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilChoisirFond extends Outil implements javax.swing.event.ChangeListener {

	protected JColorChooser tcc;
	protected PanneauDessin panneau;

	public OutilChoisirFond(PanneauDessin p) {
		super(p);
		this.panneau = p;
		tcc = new JColorChooser();
		tcc.getSelectionModel().addChangeListener(this);
	    panneau.add(tcc);
	    this.panneau.setVisible(false);
	    this.panneau.setVisible(true);
	}
	
	public void stateChanged(ChangeEvent e) {
		panneau.setCouleurFond(tcc.getColor());
	    panneau.remove(tcc);
	    this.panneau.setVisible(false);
	    this.panneau.setVisible(true);
	}
}
