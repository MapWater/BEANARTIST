package fr.eseo.gpi.beanartist.modele.geom;
public class Point{
		
	static int nbPoints;
	
	int x;
	int y;
	
	
	//-------------------     Méthodes    -----------------
	
	//					CONSTRUCTEURS
	
	public Point(int x2, int y2){
		// Constructeur Complet
		this.setX(x2);
		this.setY(y2);
		Point.incNbPoints();
	}
	
	public Point(){
		// Constructeur par defaut
		this(0,0);
	}
	
	//					ACCESSEURS
	
	public int getX(){
		return this.x;
	}
	
	public void setX(int a){
		this.x = a;
	}
	
	public int getY(){
		return this.y;
	}
	
	public void setY(int b){
		this.y = b;
	}
	
	private static void incNbPoints(){
		Point.nbPoints++;
	}
	
	public void déplacerVers(int nX, int nY){
		this.setX(nX);
		this.setY(nY);
	}
	
	public void déplacerDe(int dX, int dY){
		this.setX(this.getX()+dX);
		this.setY(this.getY()+dY);
	}
	
	public String toString(){
		String s = "("+this.getX()+","+this.getY()+")";
		return s;
	}
}