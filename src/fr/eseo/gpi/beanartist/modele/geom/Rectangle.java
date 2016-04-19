package fr.eseo.gpi.beanartist.modele.geom;

public class Rectangle extends Forme{
	
	static int nbRectangles;
	
	//-------------------     Méthodes    -----------------
	
	//					CONSTRUCTEURS

	// Constructeur Complet
	public Rectangle(Point position, int largeur, int hauteur){
		super(position, largeur, hauteur);
		Rectangle.incNbRectangles();
	}
	
	// Constructeur  - Coordonnes renseignées
	public 	Rectangle(int x, int y, int largeur, int hauteur){	
		this(new Point(x, y), largeur, hauteur);
	}
	
	// Constructeur  - Coordonnes non renseignees
	public 	Rectangle(int largeur, int hauteur){
		this(new Point(), largeur, hauteur);
	}
	
	// Constructeur  - Dimensions non renseignees	
	public Rectangle(Point point){
		this(point, Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
	}
	
	// Constructeur  - Dimensions non renseignees
	public Rectangle(){
		this(Forme.POINT_PAR_DÉFAUT, Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
	}

	//					AUTRES METHODES

	private static void incNbRectangles(){
		Rectangle.nbRectangles++;
	}
	
	public double périmètre(){
		return 2*(this.getLargeur()+this.getHauteur());
	}
	
	public double aire(){
		return this.getLargeur()*this.getHauteur();
	}
	
	public boolean contient(int x, int y){
		Point position = new Point(x, y);
		return this.contient(position);
	}
	
	public boolean contient(Point position){
		boolean b = true; 
		if(position.getX()<this.getMinX() || position.getX()>this.getMaxX()){
			b = false;
		}
		if(position.getY()<this.getMinY() || position.getY()>this.getMaxY()){
			b = false;
		}
		return b;
	}
	
}
