//package fr.eseo.gpi.beanartist.modele.geom;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.lang.Math;
//import java.text.DecimalFormat;
//
//public class TracéCopy extends Forme{
//	public static final double EPSILON = 1;
//
//	private List<Ligne> lignes;
//	
//	// ----------   CONSTRUCTEURS   ----------
//	
//	public TracéCopy(Point pos1, Point pos2){
//		lignes = new ArrayList<Ligne>();
//		Ligne ligne  = new Ligne(pos1, pos2);
//		this.lignes.add(ligne);
//		super.setLargeur(ligne.getLargeur());
//		super.setHauteur(ligne.getHauteur());
//		super.setPosition(new Point(ligne.getMinX(), ligne.getMinY()));
//	}
//	
//	public TracéCopy(Ligne ligne){
//		this(ligne.getP1(), ligne.getP2());
//	}
//	
//	// --------   ACCESSEURS   ----------
//	public int getLargeur(){
//		return super.getLargeur();
//	}
//	
//	public int getHauteur(){
//		return super.getHauteur();
//	}
//		
//	public List<Ligne> getLignes(){
//		 return this.lignes;
//	}
//	
//	public void setLignes(ArrayList<Ligne> lignes){
//		this.lignes = lignes;
//	}
//	// ----------   AUTRES METHODES   ----------
//	public Ligne getLigne(int index){
//		return this.getLignes().get(index);
//	}
//	
//	public Point getP1(int index){
//		return this.getLignes().get(index).getP1();
//	}
//	
//	public Point getP2(int index){
//		return this.getLignes().get(index).getP2();
//	}
//	
//	public int getLargeur(int index){
//		return this.getLignes().get(index).getLargeur();
//	}
//	
//	public int getHauteur(int index){
//		return this.getLignes().get(index).getHauteur();
//	}
//	
//	public Ligne getDernLigne(int index){
//		return this.getLigne(lignes.size()-1-index);
//	}
//	
//	public Point getDernP1(int index){
//		return this.getLigne(lignes.size()-1-index).getP1();
//	}
//	
//	public Point getDernP2(int index){
//		return this.getLigne(lignes.size()-1-index).getP2();
//	}
//	
//	public double getDernLargeur(int index){
//		return this.getLigne(lignes.size()-1-index).getLargeur();
//	}
//	
//	public double getDernHauteur(int index){
//		return this.getLigne(lignes.size()-1-index).getHauteur();
//	}
//	
//	public double getXMin(){
//		double xMin = this.getP1(0).getX();
//		for(Ligne l:this.getLignes()){
//			if (l.getP2().getX() < xMin){xMin = l.getP2().getX();}
//		}
//		return xMin;
//	}
//	
//	public double getXMax(){
//		double xMax = this.getP1(0).getX();
//		for(Ligne l:this.getLignes()){
//			if (l.getP2().getX() > xMax){xMax = l.getP2().getX();}
//		}
//		return xMax;
//	}
//	
//	public double getYMin(){
//		double yMin = this.getP1(0).getY();
//		for(Ligne l:this.getLignes()){
//			if (l.getP2().getY() < yMin){yMin = l.getP2().getY();}
//		}
//		return yMin;
//	}
//	
//	public double getYMax(){
//		double yMax = this.getP1(0).getY();
//		for(Ligne l:this.getLignes()){
//			if (l.getP2().getY() > yMax){yMax = l.getP2().getY();}
//		}
//		return yMax;
//	}
//	
//	public void add(Ligne l){
//		this.getLignes().add(l);
//	}
//	
//	public int size(){
//		return this.getLignes().size();
//	}
//	
//	public void ajouterLigneVers(Point pos){
//		Point dernPoint = this.getDernP2(0);
//		dernPoint.toString();
//		Ligne nouvLigne = new Ligne(dernPoint, pos);
//		this.add(nouvLigne);
//		this.calculCadre2();		
//	}
//	
//	public void calculCadre1(){
//		int largeur;
//		int hauteur;
//		int xMin = this.getLigne(0).getX(); int xMax = xMin;
//		int yMin = this.getLigne(0).getY(); int yMax = yMin;
//		//Tous les points sauf le dernier
//		for(Ligne l:this.getLignes()){
//			if (l.getP1X() < xMin){xMin = l.getP1X();}
//			if (l.getP1Y() < yMin){yMin = l.getP1Y();}
//			if (l.getP1X() > xMax){xMax = l.getP1X();}
//			if (l.getP1Y() > yMax){yMax = l.getP1Y();}
//		}
//		//Dernier point
//		if (this.getDernLigne(0).getP2X() < xMin){xMin = this.getDernLigne(0).getP2X();}
//		if (this.getDernLigne(0).getP2Y() < yMin){yMin = this.getDernLigne(0).getP2Y();}
//		if (this.getDernLigne(0).getP2X() > xMax){xMax = this.getDernLigne(0).getP2X();}
//		if (this.getDernLigne(0).getP2Y() > yMax){yMax = this.getDernLigne(0).getP2Y();}
//		largeur = xMax - xMin;
//		hauteur = yMax - yMin;
//		super.setLargeur(largeur);
//		super.setHauteur(hauteur);
//		super.setPosition(new Point(xMin, yMin));
//	}
//	
//	public void calculCadre2(){
//		int largeur;
//		int hauteur;
//		int xMin = this.getLigne(0).getX(); int xMax = xMin;
//		int yMin = this.getLigne(0).getY(); int yMax = yMin;
//		for(Ligne l:this.getLignes()){
//			if (l.getMinX() < xMin){xMin = l.getMinX();}
//			if (l.getMinY() < yMin){yMin = l.getMinY();}
//			if (l.getMaxX() > xMax){xMax = l.getMaxX();}
//			if (l.getMaxY() > yMax){yMax = l.getMaxY();}
//		}
//		largeur = xMax - xMin;
//		hauteur = yMax - yMin;
//		super.setLargeur(largeur);
//		super.setHauteur(hauteur);
//		super.setPosition(new Point(xMin, yMin));
//	}
//	
//	public void déplacerDe(int deltaX, int deltaY){
//		for(Ligne ligne : this.getLignes()){
//			ligne.déplacerDe(deltaX, deltaY);
//		}
//		this.getPosition().déplacerDe(deltaX, deltaY);
//	}
//	
//	public void déplacerVers(int newX, int newY){
//		int deltaX = newX - this.getPosition().getX();
//		int deltaY = newY - this.getPosition().getY();
//		this.déplacerDe(deltaX, deltaY);
//	}
//	
//	public void déplacerVers(Point newP){
//		this.déplacerDe(newP.getX(), newP.getY());
//	}
//	
//	public void setHauteur(int nouvHauteur){
//		if (this.getHauteur()!=0){
//			double coef = (double)nouvHauteur/(double)this.getHauteur();
//			this.getLigne(0).homothétieY(coef);
//			for(int i = 1; i < this.size(); i++){
//				this.getLigne(i).homothétieY(coef);
//				this.getLigne(i).déplacerVers(this.getP2(i-1));
//			}
//		}
//		//this.calculCadre2();
//	}
//	
//	public void setLargeur(int nouvLargeur){
//		double coef = 0;
//		if (this.getLargeur()!=0){
//			coef = (double)nouvLargeur/(double)this.getLargeur();
//		}
//		
//		this.getLignes();
//		this.getLignes().get(0);
//		
////		if (this.size() == 1) this.getLigne(0).homothétieX(coef);
////		if (this.size() > 1){
////			for(int i = 1; (i < this.size()); i++){
////				this.getLigne(i).homothétieX(coef);
////				this.getLigne(i).déplacerVers(this.getP2(i-1));
////			}
////		}
//		//--------------------------------
////		if (this.getLargeur()!=0){
////			double coef = (double)nouvLargeur/(double)this.getLargeur();
////			this.getLigne(0).homothétieX(coef);
////			for(int i = 1; i < this.size(); i++){
////				this.getLigne(i).homothétieX(coef);
////				this.getLigne(i).déplacerVers(this.getP2(i-1));
////			}
////		}
////		this.calculCadre2();
//	}
//	
//	public void setX(int newX){
//		this.setPosition(newX, this.getPosition().getY());
//	}
//	
//	public void setY(int newY){
//		this.setPosition(newY, this.getPosition().getY());
//	}
//	
//	public void setPosition(int x, int y){
//		this.setPosition(new Point(x,y));		
//	}
//	
//	public void setPosition(Point nouvPosition){
//		super.setPosition(nouvPosition);
//	}
//	
//	public double périmètre(){
//		double perimetre = 0;
//		for(Ligne ligne : lignes){
//			perimetre += ligne.périmètre();
//		}
//		return perimetre;
//	}
//	
//	public double aire(){
//		return 0;
//	}
//	
//	public boolean contient(int x, int y){
//		return this.contient(new Point(x,y));
//	}
//	
//	public boolean contient(Point p){
//		boolean contient = false;
//		for(Ligne ligne:lignes){
//			if(ligne.contient(p)) {
//				contient = true;
//				break;
//			}
//		}
//		return contient;
//	}
//	
//	public String toString(){
//		DecimalFormat entier = new DecimalFormat("#####");
//		DecimalFormat decimal = new DecimalFormat("####.##");
//		String s = "["+this.getClass().getSimpleName()+"] ";
//		s+= "pos : ("+this.getPosition().getX()+","+this.getPosition().getY()+") ";
//		s+= "dim : "+Math.abs(this.getLargeur())+" x "+Math.abs(this.getHauteur())+" ";
//		s+= "longueur : "+decimal.format(this.périmètre())+ " nbLignes : "+decimal.format(this.size());
//		return s;
//	}
//}