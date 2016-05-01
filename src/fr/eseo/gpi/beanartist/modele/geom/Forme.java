package fr.eseo.gpi.beanartist.modele.geom;

import java.text.DecimalFormat;

public abstract class Forme {
	
	static final Point POINT_PAR_DÉFAUT = new Point(0,0);
	public static final int LARGEUR_PAR_DÉFAUT = 100;
	public static final int HAUTEUR_PAR_DÉFAUT = 150;

	private int largeur ;
	private int hauteur ;
	private Point position ;

	public Forme (){
		this ( new Point (), HAUTEUR_PAR_DÉFAUT ,
		LARGEUR_PAR_DÉFAUT );
	}

	public Forme (int x, int y, int largeur2 , int hauteur2 ){
		this ( new Point (x,y), largeur2 , hauteur2 );
	}

	public Forme ( Point position2 , int largeur2 , int hauteur2 ){
		this.position = position2;
		this.largeur = largeur2;
		this.hauteur = hauteur2;
	}
	
	public Forme (int largeur , int hauteur ){
		this ( new Point (), largeur , hauteur );
	}
	
	public Forme ( Point position ){
		this ( position , HAUTEUR_PAR_DÉFAUT , LARGEUR_PAR_DÉFAUT );
	}
	
	public Point getPosition (){
		return this.position ;
	}
	
	public void setPosition ( Point position2 ){
		this.position = position2;
	}
	
	public int getLargeur(){
		return this.largeur;
	}
	
	public void setLargeur(int largeur2){
		this.largeur = largeur2;
	}
	
	public int getHauteur(){
		return this.hauteur;
	}
	
	public void setHauteur(int hauteur2){
		this.hauteur = hauteur2;
	}
	
	public int getX(){
		return this.getPosition().getX();
	}
	
	public void setX(int x){
		this.getPosition().setX(x);
	}
	
	public int getY(){
		return this.getPosition().getY();
	}
	
	public void setY(int y){
		this.getPosition().setY(y);
	}
	
	public int getMinX(){
		return this.getPosition().getX();
	}
	
	public int getMinY(){
		return this.getPosition().getY();
	}
	public int getMaxX(){
		return this.getPosition().getX()+this.getLargeur();
	}
	
	public int getMaxY(){
		return this.getPosition().getY()+this.getHauteur();
	}
	
	public void déplacerVers(int x, int y){
		this.getPosition().setX(x);
		this.getPosition().setY(y);
	}
	
	public void déplacerDe(int deltaX, int deltaY){
		int x2 = this.getPosition().getX() + deltaX;
		int y2 = this.getPosition().getY() + deltaY;
		this.getPosition().setX(x2);
		this.getPosition().setY(y2);
	}
	
	public String toString(){
		DecimalFormat formatter = new DecimalFormat("#####");
		String s = "["+this.getClass().getSimpleName()+"] ";
		s+= "pos : ("+this.getPosition().getX()+","+this.getPosition().getY()+") ";
		s+= "dim : "+this.getLargeur()+" x "+this.getHauteur()+" ";
		s+= "périmètre : "+ formatter.format(this.périmètre())+" aire : "+ formatter.format(this.aire());
		return s;
	}
	
	public abstract double aire();
	
	public abstract double périmètre();
	
	public abstract boolean contient(int x, int y);
	
	public abstract boolean contient(Point position2);
}