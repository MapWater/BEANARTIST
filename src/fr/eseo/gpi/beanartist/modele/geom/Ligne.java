package fr.eseo.gpi.beanartist.modele.geom;

public class Ligne extends Forme{
	
	public static final double EPSILON = 1;
	
			// ----------   CONSTRUCTEURS   ----------
			
	public Ligne(Point position, int largeur, int hauteur){
		super(position, largeur, hauteur);
	}
	
	public Ligne(int x, int y, int largeur, int hauteur){
		this(new Point(x, y), largeur, hauteur);
	}
	
	public Ligne(Point position){
		this(position, Forme.LARGEUR_PAR_DÉFAUT, Forme.HAUTEUR_PAR_DÉFAUT);
	}
	
	public Ligne(int largeur, int hauteur){
		this(Forme.POINT_PAR_DÉFAUT, largeur, hauteur);
	}
	
	public Ligne(Point pos1, Point pos2){
		this.setPosition(pos1);
		int largeur = pos2.getX()-pos1.getX();
		int hauteur = pos2.getY()-pos1.getY();
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
	}
	
	public Ligne(){
		this(Forme.POINT_PAR_DÉFAUT, Forme.LARGEUR_PAR_DÉFAUT, 
															Forme.HAUTEUR_PAR_DÉFAUT);
	}
	
			// --------   ACCESSEURS   ----------
	
	public Point getP1(){
		return this.getPosition();
	}
	
	public void setP1(Point autrePosition){
		Point p2 = this.getP2();
		this.setPosition(autrePosition);
		this.setP2(p2);
	}
	
	public Point getP2(){
		int p2X = this.getP1().getX()+this.getLargeur();
		int p2Y = this.getP1().getY()+this.getHauteur();
		return new Point(p2X, p2Y);
	}
	
	public void setP2(Point autrePosition){
		this.setLargeur(autrePosition.getX() - this.getP1().getX() );
		this.setHauteur(autrePosition.getY() - this.getP1().getY() );
	}
	
	// ----------   AUTRES METHODES   ----------
	
	public int getP1X(){
		return this.getP1().getX();
	}
	
	public int getP1Y(){
		return this.getP1().getY();
	}
	
	public int getP2X(){
		return this.getP1().getX();
	}
	
	public int getP2Y(){
		return this.getP2().getY();
	}
	
	public int getMinX(){
		int resultat;
		if (this.getP1X()<this.getP2X()){
			resultat = this.getP1X();
		} else {
			resultat = this.getP2X();
		}
		return resultat;
	}
	
	public int getMaxX(){
		int resultat;
		if (this.getP1X()>this.getP2X()){
			resultat = this.getP1X();
		} else {
			resultat = this.getP2X();
		}
		return resultat;
	}
	
	public int getMinY(){
		int resultat;
		if (this.getP1Y()<this.getP2Y()){
			resultat = this.getP1Y();
		} else {
			resultat = this.getP2Y();
		}
		return resultat;
	}
	
	public int getMaxY(){
		int resultat;
		if (this.getP1Y()>this.getP2Y()){
			resultat = this.getP1Y();
		} else {
			resultat = this.getP2Y();
		}
		return resultat;
	}
	
	public void deplacerP1Vers(Point position){
		this.setP1(position);
	}

	public void deplacerP2Vers(Point position){
		this.setP2(position);
	}
	
	public void deplacerP1De(int deltaX, int deltaY){
		int nouveauX = this.getPosition().getX()+deltaX;
		int nouveauY = this.getPosition().getY()+deltaY;
		Point nouveauPoint = new Point(nouveauX, nouveauY);
		//System.out.println(nouveauPoint.toString());
		this.setP1(nouveauPoint);
	}
	
	public void deplacerP2De(int deltaX, int deltaY){
		int nouveauX = this.getP2().getX()+deltaX;
		int nouveauY = this.getP2().getY()+deltaY;
		Point nouveauPoint = new Point(nouveauX, nouveauY);
		//System.out.println(nouveauPoint.toString());
		this.setP2(nouveauPoint);
	}
	
	public double périmètre(){
		return Math.sqrt(this.getLargeur()*this.getLargeur()+this.getHauteur()*this.getHauteur());
	}
	
	public double aire(){
		return 0;
	}
	
	public boolean contient(int x, int y ){
		return this.contient(new Point(x, y));
	}
	
	public boolean contient(Point p){
		double coef = (this.getP2Y()-this.getP1Y())/(this.getP2X()-this.getP1X());
		for(int i = ; i)
	}
	
	public String toString(){
		String s = "[Ligne] p1 : ("+this.getP1().getX()+","+this.getP1().getY()+"),  ";
		s+= "p2 : ("+this.getP2().getX()+","+this.getP2().getY()+") ";
		s+= "longueur : "+this.périmètre();	
		return s;
	}
}