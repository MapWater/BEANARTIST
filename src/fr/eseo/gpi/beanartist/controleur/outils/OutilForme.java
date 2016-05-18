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
		// D�tection cas Abscisse/Ordonn�e n�gative :
		Point d�butAux = new Point(this.getD�but());
		Point finAux = new Point(event.getX(), event.getY());
		int aux;
		// Cas Largeur < 0 :
		if (finAux.getX() - d�butAux.getX() < 0){
			aux = d�butAux.getX();
			d�butAux.setX(finAux.getX());
			finAux.setX(aux);
		}
		// Cas Hauteur < 0 :
		if (finAux.getY() - d�butAux.getY() < 0){
			aux = d�butAux.getY();
			d�butAux.setY(finAux.getY());
			finAux.setY(aux);
		}
		
		this.setD�butDessin(d�butAux);
		this.setFinDessin(finAux);
		pan.ajouterVueForme(this.cr�erVueForme());
//		System.out.println("Relach�!");
//		System.out.println(pan.getVueFormes().get(0).toString());
		this.getPanneauDessin().setVueTemp(PanneauDessin.VUE_TEMP);
		this.getPanneauDessin().repaint();
	}
	
	public void mouseDragged(MouseEvent event){
//		System.out.println("Dragged");
		PanneauDessin pan = this.getPanneauDessin();
		// D�tection cas Abscisse/Ordonn�e n�gative :
		Point d�butAux = new Point(this.getD�but());
		Point finAux = new Point(event.getX(), event.getY());
		int aux;
		// Cas Largeur < 0 :
		if (finAux.getX() - d�butAux.getX() < 0){
			aux = d�butAux.getX();
			d�butAux.setX(finAux.getX());
			finAux.setX(aux);
		}
		// Cas Hauteur < 0 :
		if (finAux.getY() - d�butAux.getY() < 0){
			aux = d�butAux.getY();
			d�butAux.setY(finAux.getY());
			finAux.setY(aux);
		}
		this.setD�butDessin(d�butAux);
		this.setFinDessin(finAux);
		pan.setVueTemp(this.cr�erVueForme());
		this.getPanneauDessin().repaint();
	}
	
	protected abstract VueForme cr�erVueForme();
}
