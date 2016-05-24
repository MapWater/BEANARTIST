package fr.eseo.gpi.beanartist.modele.geom;



public class Cercle extends Ellipse{
	
	//-------------------     M�thodes    -----------------

	//					CONSTRUCTEURS
	
	public  Cercle(Point position, int diametre){
		super(position, diametre, diametre);
	}
	
	public Cercle (int x, int y, int diametre){
		this(new Point(x, y), diametre);
	}
	
	public Cercle (Point position){
		this(position, Forme.LARGEUR_PAR_DÉFAUT);
	}
	
	public Cercle (int diametre){
		this(Forme.POINT_PAR_DÉFAUT, diametre);
	}

	public Cercle(){
		// Constructeur  - Dimensions non renseignees
		this(Forme.POINT_PAR_DÉFAUT, Forme.LARGEUR_PAR_DÉFAUT);
	}

	//					ACCESSEURS
	
	public double getRayon(){
		return this.getLargeur()/2;
	}

	public void setRayon(int rayon){
		super.setLargeur(rayon*2);
		super.setHauteur(rayon*2);
	}

	public void setLargeur(int diametre){
		super.setLargeur(diametre);
		super.setHauteur(diametre);
	}

	public void setHauteur(int diametre){
		super.setLargeur(diametre);
		super.setHauteur(diametre);
	}
	
	//					AUTRES METHODES
	
	public double périmètre(){
		return Math.PI*this.getLargeur();
	}
	
	public double aire(){
		return Math.PI*this.getLargeur()/2d*this.getLargeur()/2d;
	}
	
}