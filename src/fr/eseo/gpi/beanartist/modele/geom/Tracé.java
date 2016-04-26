package fr.eseo.gpi.beanartist.modele.geom;

import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class Tracé extends Forme{
	public static final double EPSILON = 0.001;

	private List<Ligne> lignes;
	
	// ----------   CONSTRUCTEURS   ----------
			
	public Tracé(Point pos1, Point pos2){
		this.lignes = new ArrayList<Ligne>();
		Ligne ligne  = new Ligne(pos1, pos2);
		this.lignes.add(ligne);
		this.setLargeur(ligne.getLargeur());
		this.setHauteur(ligne.getHauteur());
	}
	
	public Tracé(Ligne ligne){
		this.lignes = new ArrayList<Ligne>();
		this.lignes.add(ligne);
		this.setLargeur(ligne.getLargeur());
		this.setHauteur(ligne.getHauteur());
	}
	
	// --------   ACCESSEURS   ----------

	 public List<Ligne> getLignes(){
		 return this.lignes;
	 }
	// ----------   AUTRES METHODES   ----------
	public Ligne getLigne(int index){
		return this.getLignes().get(index);
	}
	
	public Point getP1(int index){
		return this.getLignes().get(index).getP1();
	}
	
	public Point getP2(int index){
		return this.getLignes().get(index).getP2();
	}
	
	public int getLargeur(int index){
		return this.getLignes().get(index).getLargeur();
	}
	
	public int getHauteur(int index){
		return this.getLignes().get(index).getHauteur();
	}
	
	public Ligne getDernLigne(int index){
		return this.getLigne(lignes.size()-1-index);
	}
	
	public Point getDernP1(int index){
		return this.getLigne(lignes.size()-1-index).getP1();
	}
	
	public Point getDernP2(int index){
		return this.getLigne(lignes.size()-1-index).getP2();
	}
	
	public double getDernLargeur(int index){
		return this.getLigne(lignes.size()-1-index).getLargeur();
	}
	
	public double getDernHauteur(int index){
		return this.getLigne(lignes.size()-1-index).getHauteur();
	}
	
	public double getXMin(){
		double xMin = this.getP1(0).getX();
		for(Ligne l:this.getLignes()){
			if (l.getP2().getX() < xMin){xMin = l.getP2().getX();}
		}
		return xMin;
	}
	
	public double getXMax(){
		double xMax = this.getP1(0).getX();
		for(Ligne l:this.getLignes()){
			if (l.getP2().getX() > xMax){xMax = l.getP2().getX();}
		}
		return xMax;
	}
	
	public double getYMin(){
		double yMin = this.getP1(0).getY();
		for(Ligne l:this.getLignes()){
			if (l.getP2().getY() < yMin){yMin = l.getP2().getY();}
		}
		return yMin;
	}
	
	public double getYMax(){
		double yMax = this.getP1(0).getY();
		for(Ligne l:this.getLignes()){
			if (l.getP2().getY() > yMax){yMax = l.getP2().getY();}
		}
		return yMax;
	}
	
	public void add(Ligne l){
		this.getLignes().add(l);
	}
	
	public int size(){
		return this.getLignes().size();
	}
	
	public void ajouterLigneVers(Point pos){
		Point dernPoint = this.getDernP2(0);
		Ligne nouvLigne = new Ligne(dernPoint, pos);
		this.add(nouvLigne);
		this.calculCadre();
		
	}
	
	public void calculCadre(){
		int largeur;
		int hauteur;
		int xMin = this.getLignes().get(0).getX(); int xMax = xMin;
		int yMin = this.getLignes().get(0).getY(); int yMax = yMin;
		for(Ligne l:this.getLignes()){
			if (l.getX() < xMin){xMin = l.getX();}
			if (l.getY() < yMin){yMin = l.getY();}
			if (l.getX() > xMax){xMax = l.getX();}
			if (l.getY() > yMax){yMax = l.getY();}
		}
		largeur = xMax - xMin;
		hauteur = yMax - yMin;
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.setPosition(new Point(xMin, yMin));
	}
	
	public void déplacerDe(int deltaX, int deltaY){
		int nouveauX = this.getPosition().getX()+deltaX;
		int nouveauY = this.getPosition().getY()+deltaY;
		Point nouveauPoint = new Point(nouveauX, nouveauY);
		//System.out.println(nouveauPoint.toString());
		this.setPosition(nouveauPoint);
	}
	
	public void déplacerVers(int newX, int newY){
		Point nouveauPoint = new Point(newX, newY);
		this.setPosition(nouveauPoint);
	}
	
	public void setHauteur(int nouvLargeur){
		double coef = nouvLargeur/this.getLargeur();
		//	CAS i=0 : PREMIERE LIGNE
		Ligne l = new Ligne(this.getP1(0), (int)(this.getLargeur(0)*coef), (int)(this.getHauteur(0)*coef));
		Tracé nouvTrace = new Tracé(l);
		
		//	AUTRES CAS
		for(int i=1; i<this.size(); i++){
			l = this.getLigne(i);
			Point auxPoint = nouvTrace.getP2(i);
			nouvTrace.add(new Ligne(auxPoint, (int)(this.getLargeur(i)*coef), (int)(this.getHauteur(i)*coef)));
		}
		this.calculCadre();
	}
	
	public void setLargeur(int nouvLargeur){
		double coef = nouvLargeur/this.getLargeur();
		//	CAS i=0 : PREMIERE LIGNE
		Ligne l = new Ligne(this.getP1(0), (int)(this.getLargeur(0)*coef), (int)(this.getHauteur(0)*coef));
		Tracé nouvTrace = new Tracé(l);
		
		//	AUTRES CAS
		for(int i=1; i<this.size(); i++){
			l = this.getLigne(i);
			Point auxPoint = nouvTrace.getP2(i);
			nouvTrace.add(new Ligne(auxPoint, (int)(this.getLargeur(i)*coef), (int)(this.getHauteur(i)*coef)));
		}
		this.calculCadre();
	}
	
	public void setX(int newX){
		
	}
	
	public void setY(int newY){
		
	}
	
	public void setPosition(Point nouvPosition){
		
	}
	
	public double périmètre(){
		double perimetre = 0;
		for(Ligne ligne : lignes){
			perimetre += ligne.périmètre();
		}
		return perimetre;
	}
	
	public double aire(){
		return 0;
	}
	
	public boolean contient(int x, int y){
		return this.contient(new Point(x,y));
	}
	
	public boolean contient(Point p){
		boolean contient = false;
		for(Ligne ligne:this.getLignes()){
			if(ligne.contient(p.getX(), p.getY())) {
				contient = true;
				break;
			}
		}
		return contient;
	}
	
	public String toString(){
		//String s = "[Ligne] p1 : ("+this.getP1().getX()+","+this.getP1().getY()+"),  p2 : ("+this.getP2().getX()+","+this.getP2().getY()+") ";
		//s+= "longueur : "+this.perimetre();	
		//return s;
		return "";
	}
}