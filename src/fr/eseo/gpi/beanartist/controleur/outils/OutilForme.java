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
 * @author Clément
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
		this.setDébut(new Point(event.getX(), event.getY()));
//		System.out.println("Clické!");
	}
	
	public void mouseClicked(MouseEvent event){
		
	} 
	
	public void mouseReleased(MouseEvent event){
		PanneauDessin pan = this.getPanneauDessin();
		// Détection cas Abscisse/Ordonnée négative :
		Point débutAux = new Point(this.getDébut());
		Point finAux = new Point(event.getX(), event.getY());
		int aux;
		// Cas Largeur < 0 :
		if (finAux.getX() - débutAux.getX() < 0){
			aux = débutAux.getX();
			débutAux.setX(finAux.getX());
			finAux.setX(aux);
		}
		// Cas Hauteur < 0 :
		if (finAux.getY() - débutAux.getY() < 0){
			aux = débutAux.getY();
			débutAux.setY(finAux.getY());
			finAux.setY(aux);
		}
		
		this.setDébutDessin(débutAux);
		this.setFinDessin(finAux);
		pan.ajouterVueForme(this.créerVueForme());
//		System.out.println("Relaché!");
//		System.out.println(pan.getVueFormes().get(0).toString());
		this.getPanneauDessin().setVueTemp(PanneauDessin.VUE_TEMP);
		this.getPanneauDessin().repaint();
	}
	
	public void mouseDragged(MouseEvent event){
//		System.out.println("Dragged");
		PanneauDessin pan = this.getPanneauDessin();
		// Détection cas Abscisse/Ordonnée négative :
		Point débutAux = new Point(this.getDébut());
		Point finAux = new Point(event.getX(), event.getY());
		int aux;
		// Cas Largeur < 0 :
		if (finAux.getX() - débutAux.getX() < 0){
			aux = débutAux.getX();
			débutAux.setX(finAux.getX());
			finAux.setX(aux);
		}
		// Cas Hauteur < 0 :
		if (finAux.getY() - débutAux.getY() < 0){
			aux = débutAux.getY();
			débutAux.setY(finAux.getY());
			finAux.setY(aux);
		}
		this.setDébutDessin(débutAux);
		this.setFinDessin(finAux);
		pan.setVueTemp(this.créerVueForme());
		this.getPanneauDessin().repaint();
	}
	
	protected abstract VueForme créerVueForme();
}
