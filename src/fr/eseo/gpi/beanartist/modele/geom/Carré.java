package fr.eseo.gpi.beanartist.modele.geom;

public class Carré extends Rectangle{
	
	//-------------------     Méthodes    -----------------

	//					CONSTRUCTEURS
	
	public Carré (Point position, int cote){
		super(position, cote, cote);
	}
	
	public Carré (int x, int y, int cote){
		this(new Point(x, y), cote);
	}
	
	public Carré (Point position){
		this(position, Rectangle.LARGEUR_PAR_DÉFAUT);
	}
	
	public Carré (int cote){
		this(Rectangle.POINT_PAR_DÉFAUT, cote );
	}

	public Carré(){
		this(POINT_PAR_DÉFAUT, Rectangle.LARGEUR_PAR_DÉFAUT);
	}

	//					ACCESSEURS
	
	public double getCote(){
		return this.getLargeur();
	}

	public void setCote(int cote){
		super.setLargeur(cote);
		super.setHauteur(cote);
	}

	public void setLargeur(int largeur){
		super.setLargeur(largeur);
		super.setHauteur(largeur);
	}

	public void setHauteur(int hauteur){
		super.setLargeur(hauteur);
		super.setHauteur(hauteur);
	}

	//					AUTRES METHODES
	
}