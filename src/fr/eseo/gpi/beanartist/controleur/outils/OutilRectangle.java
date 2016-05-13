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
 * @author Clément
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
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#créerVueForme()
	 */
	@Override
	protected VueForme créerVueForme() {
		Rectangle forme = new Rectangle(this.getDébut(), this.getFin().getX()-this.getDébut().getX(), this.getFin().getY()-this.getDébut().getY());
		VueRectangle vue = new VueRectangle(forme, this.getPanneauDessin().getCouleurForme(), true);
		return vue;
	}

}
