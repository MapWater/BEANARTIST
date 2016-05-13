/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;

/**
 * @author Cl�ment
 *
 */
public abstract class OutilForme extends Outil {

	
	public OutilForme() {
		super();
		// TODO Auto-generated constructor stub
	}	
	
	/**
	 * @param panneauDessin
	 */
	public OutilForme(PanneauDessin panneauDessin) {
		super(panneauDessin);
		// TODO Auto-generated constructor stub
	}
	
	public void mousePressed(MouseEvent event){
		this.setD�but(new Point(event.getX(), event.getY()));
//		System.out.println("Click�!");
	}
	
	public void mouseClicked(MouseEvent event){
		
	} 
	
	public void mouseReleased(MouseEvent event){
		PanneauDessin pan = this.getPanneauDessin(); 
		this.setFin(new Point(event.getX(), event.getY()));
		pan.ajouterVueForme(this.cr�erVueForme());
//		System.out.println("Relach�!");
//		System.out.println(pan.getVueFormes().get(0).toString());
		this.getPanneauDessin().setVueTemp(PanneauDessin.VUE_TEMP);
		this.getPanneauDessin().repaint();
	}
	
	public void mouseDragged(MouseEvent event){
//		System.out.println("Dragged");
		PanneauDessin pan = this.getPanneauDessin();
		this.setFin(new Point(event.getX(), event.getY()));
//		System.out.println(this.getFin());
		pan.setVueTemp(this.cr�erVueForme());
		this.getPanneauDessin().repaint();
	}
	
	protected abstract VueForme cr�erVueForme();
}
