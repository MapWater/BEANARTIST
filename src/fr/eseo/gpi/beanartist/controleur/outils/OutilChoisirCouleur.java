package fr.eseo.gpi.beanartist.controleur.outils;

import javax.swing.JColorChooser;
import javax.swing.event.ChangeEvent;

import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

public class OutilChoisirCouleur extends Outil implements javax.swing.event.ChangeListener{

	protected JColorChooser tcc;
	protected PanneauDessin panneauDessin;

	public OutilChoisirCouleur(PanneauDessin p) {
		super(p);
		this.panneauDessin = p;
		tcc = new JColorChooser();
		tcc.getSelectionModel().addChangeListener(this);
	    panneauDessin.add(tcc);
	    this.panneauDessin.setVisible(false);
	    this.panneauDessin.setVisible(true);
	}
	
	public void stateChanged(ChangeEvent e) {
		panneauDessin.setCouleurForme(tcc.getColor());
	    panneauDessin.remove(tcc);
	    this.panneauDessin.setVisible(false);
	    this.panneauDessin.setVisible(true);
	}
}
