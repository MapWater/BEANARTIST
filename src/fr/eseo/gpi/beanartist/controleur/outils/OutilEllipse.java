/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueEllipse;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;


import java.awt.Color;



/**
 * @author Cl�ment
 *
 */
public class OutilEllipse extends OutilForme {

	public OutilEllipse() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	/**
	 * @param panneauDessin
	 */
	public OutilEllipse(PanneauDessin panneauDessin) {
		super(panneauDessin);
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#cr�erVueForme()
	 */
	@Override
	protected VueForme cr�erVueForme() {
		Ellipse forme = new Ellipse(this.getD�but(), this.getFin().getX()-this.getD�but().getX(), this.getFin().getY()-this.getD�but().getY());
		VueEllipse vue = new VueEllipse(forme, this.getPanneauDessin().getCouleurForme(), true);
		return vue;
	}

}
