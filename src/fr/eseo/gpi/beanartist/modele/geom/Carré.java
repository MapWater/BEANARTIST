package fr.eseo.gpi.beanartist.modele.geom;

public class Carr� extends Rectangle{
	
	//-------------------     M�thodes    -----------------

	//					CONSTRUCTEURS
	
	public Carr� (Point position, int cote){
		super(position, cote, cote);
	}
	
	public Carr� (int x, int y, int cote){
		this(new Point(x, y), cote);
	}
	
	public Carr� (Point position){
		this(position, Rectangle.LARGEUR_PAR_D�FAUT);
	}
	
	public Carr� (int cote){
		this(Rectangle.POINT_PAR_D�FAUT, cote );
	}

	public Carr�(){
		this(POINT_PAR_D�FAUT, Rectangle.LARGEUR_PAR_D�FAUT);
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