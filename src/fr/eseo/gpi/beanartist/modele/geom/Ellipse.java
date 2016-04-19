package fr.eseo.gpi.beanartist.modele.geom;

import java.text.DecimalFormat;

public class Ellipse extends Forme{
	
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
		Point position = new Point(x, y);
		return this.contient(position);
	}
	
	public boolean contient(Point position){
		boolean b = true;
		Point centre = new Point(this.getX()+this.getLargeur()/2, this.getY()+this.getHauteur()/2);
		Point calcul = new Point(this.getX()-centre.getX(), this.getY()-centre.getY());
		calcul.setX(calcul.getX()/this.getLargeur());
		calcul.setY(calcul.getY()/this.getHauteur());
		double r = calcul.getX()*calcul.getX()+calcul.getY()*calcul.getY();
		if(r>1){
			b = false;
		}
		return b;
	}
}
