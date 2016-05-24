/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueRectangle;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;


import java.awt.Color;



/**
 * @author Cl�ment
 *
 */
public class OutilRectangle extends OutilForme {

	public OutilRectangle() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	/**
	 * @param panneauDessin
	 */
	public OutilRectangle(PanneauDessin panneauDessin) {
		super(panneauDessin);
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#cr�erVueForme()
	 */
	@Override
	protected VueForme créerVueForme() {
		Rectangle forme = new Rectangle(this.getDébutDessin(), this.getFinDessin().getX()-this.getDébutDessin().getX(), this.getFinDessin().getY()-this.getDébutDessin().getY());
		VueRectangle vue = new VueRectangle(forme, this.getPanneauDessin().getCouleurForme(), this.getPanneauDessin().estModeRemplissage());
		return vue;
	}

}
