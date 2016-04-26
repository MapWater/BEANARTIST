package fr.eseo.gpi.beanartist.modele.geom;

import java.text.DecimalFormat;

public class Ellipse extends Forme{
	public static final double EPSILON = 0.1;
	static int nbEllipses;
	
	//-------------------     Méthodes    -----------------

	//					CONSTRUCTEURS

	public Ellipse(Point position, int largeur, int hauteur){
		// Constructeur Complet
		this.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		Ellipse.incNbEllipses();
	}

	public Ellipse(int x, int y, int largeur, int hauteur){
		this(new Point(x,y), largeur, hauteur);
	}
	
	public Ellipse(int largeur, int hauteur){
		// Constructeur  - Coordonnes non renseignees
		this(Forme.POINT_PAR_DÉFAUT, largeur, hauteur);
	}
	
	public Ellipse(Point position){
		// Constructeur  - Dimensions non renseignees
		this(position, Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
	}
	
	public Ellipse(){
		// Constructeur  - Dimensions non renseignees
		this(Forme.POINT_PAR_DÉFAUT, Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
	}

	//					AUTRES METHODES

	private static void incNbEllipses(){
		Ellipse.nbEllipses++;
	}
	
	public String toString(){
		DecimalFormat formatter = new DecimalFormat("#####.##");     
		String s = "["+this.getClass().getSimpleName()+"] ";
		s+= "pos : ("+this.getPosition().getX()+","+this.getPosition().getY()+") ";
		s+= "dim : "+this.getLargeur()+" x "+this.getHauteur()+" ";
		s+= "périmètre : "+ formatter.format(this.périmètre())+" aire : "+ formatter.format(this.aire());
		return s;
	}
	
	public double périmètre(){
		double a = this.getHauteur()/2d;
		double b = this.getLargeur()/2d;
		double h = Math.pow((a-b)/(a+b),2);
		return Math.PI*(a+b)*(1+3*h/(10+Math.sqrt(4-3*h)));
	}
	
	public double aire(){
		return Math.PI*this.getLargeur()/2d*this.getHauteur()/2d;
	}
	
	public boolean contient(int x, int y){
		boolean contient = false;
		Point centre = new Point(this.getX()+this.getLargeur()/2, this.getY()+this.getHauteur()/2);
		double xCentre = centre.getX();
		double yCentre = centre.getY();
		double a = this.getLargeur()/2;
		double b = this.getHauteur()/2;	
		double r = (x-xCentre)*(x-xCentre)/(a*a)+(y-yCentre)*(y-yCentre)/(b*b);
		if((r-1)<Ellipse.EPSILON){
			contient = true;
		}
		return contient;
	}
	
	public boolean contient(Point p){
		return this.contient(p.getX(), p.getY());
	}
}
