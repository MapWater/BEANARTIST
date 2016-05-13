/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;

import java.awt.Color;



/**
 * @author Cl�ment
 *
 */
public class OutilLigne extends OutilForme {

	public OutilLigne() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	/**
	 * @param panneauDessin
	 */
	public OutilLigne(PanneauDessin panneauDessin) {
		super(panneauDessin);
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#cr�erVueForme()
	 */
	@Override
	protected VueForme cr�erVueForme() {
		Ligne ligne = new Ligne(this.getD�but(), this.getFin());
//		VueLigne vueLigne = new VueLigne(ligne, couleurLigne);
		VueLigne vueLigne = new VueLigne(ligne, this.getPanneauDessin().getCouleurForme());
		return vueLigne;
	}

}
