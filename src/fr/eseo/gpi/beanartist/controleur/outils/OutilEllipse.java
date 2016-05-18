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
 * @author Clément
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
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#créerVueForme()
	 */
	@Override
	protected VueForme créerVueForme() {
		Ellipse forme = new Ellipse(this.getDébutDessin(), this.getFinDessin().getX()-this.getDébutDessin().getX(), this.getFinDessin().getY()-this.getDébutDessin().getY());
		VueEllipse vue = new VueEllipse(forme, this.getPanneauDessin().getCouleurForme(), this.getPanneauDessin().estModeRemplissage());
		return vue;
	}

}
