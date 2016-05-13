/**
 * 
 */
package fr.eseo.gpi.beanartist.controleur.outils;

import fr.eseo.gpi.beanartist.vue.ui.PanneauDessin;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import java.awt.event.MouseEvent;

/**
 * @author Cl�ment
 *
 */
public abstract class Outil
	implements java.awt.event.MouseListener, java.awt.event.MouseMotionListener{
	// CONSTANTES DE CLASSE
	
	// ATTRIBUTS
	private PanneauDessin panneauDessin;
	private Point d�but;
	private Point fin;
	
	// CONSTRUCTEURS
	public Outil(){
	}
	
	public Outil(PanneauDessin panneauDessin){
		this.setPanneauDessin(panneauDessin);
		System.out.println(this.getPanneauDessin());
		this.associer(panneauDessin);
	}
	
	// AUTRES METHODES
	public void associer(PanneauDessin panneauDessin){
		System.out.println(this.getPanneauDessin().getOutilCourant());
		if (this.getPanneauDessin().getOutilCourant() != null){
			this.lib�rer();
		}
		this.getPanneauDessin().setOutilCourant(this);
		this.getPanneauDessin().addMouseListener(this);
		this.getPanneauDessin().addMouseMotionListener(this);
		System.out.println("Associ�:!");
		System.out.println(this.getPanneauDessin().getOutilCourant());
	}
	
	private void lib�rer(){
		System.out.println("lib�rer");
		this.getPanneauDessin().removeMouseListener(getPanneauDessin().getOutilCourant());
		this.getPanneauDessin().removeMouseMotionListener(getPanneauDessin().getOutilCourant());
		this.getPanneauDessin().setOutilCourant(null);
	}
	
	public void setD�but(Point point){
		this.d�but = point;
	}
	
	public void setFin(Point point){
		this.fin = point;
	}
	
	public Point getD�but(){
		return this.d�but;
	}
	
	public Point getFin(){
		return this.fin;
	}
	
	public void mousePressed(MouseEvent event){
		this.setD�but(new Point(event.getX(), event.getY()));
	}
	
	public void mouseClicked(MouseEvent event){
		
	}
	
	public void mouseReleased(MouseEvent event){
		this.setFin(new Point(event.getX(), event.getY()));
		//this.getPanneauDessin().ajouterVueForme();
	}
	
	public void mouseEntered(MouseEvent event){
		
	}
	
	public void mouseExited(MouseEvent event){
		
	}
	
	public void mouseDragged(MouseEvent event){
		
	}
	
	public void mouseMoved(MouseEvent event){
		
	}
	// ACCESSEURS
	
	public PanneauDessin getPanneauDessin(){
		return this.panneauDessin;
	}
	
	public void setPanneauDessin(PanneauDessin panneauDessin){
		this.panneauDessin = panneauDessin;
	}
	
}
