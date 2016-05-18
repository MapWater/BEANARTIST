/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueCarré;
import fr.eseo.gpi.beanartist.vue.geom.VueCarré;
import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;


import java.awt.Color;
import java.awt.event.MouseEvent;



/**
 * @author Clément
 *
 */
public class OutilCarré extends OutilForme {

	public OutilCarré() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	
	/**
	 * @param panneauDessin
	 */
	public OutilCarré(PanneauDessin panneauDessin) {
		super(panneauDessin);
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see fr.eseo.gpi.beanartist.controleur.outils.OutilForme#créerVueForme()
	 */
	@Override
	protected VueForme créerVueForme() {
		int x1 = super.getDébut().getX();
		int x2 = super.getFin().getX();
		int y1 = super.getDébut().getY();
		int y2 = super.getFin().getY();
		
		int largeur = Math.max(Math.abs(x2-x1),Math.abs(y2-y1));

		VueCarré retour;
		
		if(x1 < x2 && y1 < y2){
			return new VueCarré(new Carré(x1,y1,largeur),this.getPanneauDessin().getCouleurForme(),this.getPanneauDessin().estModeRemplissage());
		}
		else if(x1 < x2 && y1 > y2){
			return new VueCarré(new Carré(x1,y1-largeur,largeur),this.getPanneauDessin().getCouleurForme(),this.getPanneauDessin().estModeRemplissage());
		}
		else if(x1 > x2 && y1 < y2){
			return new VueCarré(new Carré(x1-largeur,y1,largeur),this.getPanneauDessin().getCouleurForme(),this.getPanneauDessin().estModeRemplissage());
		}
		else if(x1 > x2 && y1 > y2){
			return new VueCarré(new Carré(x1-largeur,y1-largeur,largeur),this.getPanneauDessin().getCouleurForme(),this.getPanneauDessin().estModeRemplissage());
		}else{
			retour = new VueCarré(new Carré(0,0,0),false);
		}
		return retour;
	
	}
	
	public void mouseReleased(MouseEvent event){
		PanneauDessin pan = this.getPanneauDessin();
		this.setFin(new Point(event.getX(),event.getY()));
		pan.ajouterVueForme(this.créerVueForme());

		this.getPanneauDessin().setVueTemp(PanneauDessin.VUE_TEMP);
		this.getPanneauDessin().repaint();
	}
	
	public void mouseDragged(MouseEvent event){
		this.setFin(new Point(event.getX(),event.getY()));
		PanneauDessin pan = this.getPanneauDessin();				
		pan.setVueTemp(this.créerVueForme());
		this.getPanneauDessin().repaint();
	}

}
