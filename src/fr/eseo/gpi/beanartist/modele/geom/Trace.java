//package fr.eseo.gpi.beanartist.modele.geom;
//
//import java.util.ArrayList;
//
//public class Trace extends Forme{
//
//	ArrayList<Ligne> lstLignes;
//	
//	// ----------   CONSTRUCTEURS   ----------
//			
//	public Trace(Point pos1, Point pos2){
//		this.lstLignes = new ArrayList<Ligne>();
//		Ligne ligne  = new Ligne(pos1, pos2);
//		this.lstLignes.add(ligne);
//		this.setLargeur(ligne.getLargeur());
//		this.setHauteur(ligne.getHauteur());
//	}
//	
//	public Trace(Ligne ligne){
//		this.lstLignes = new ArrayList<Ligne>();
//		this.lstLignes.add(ligne);
//		this.setLargeur(ligne.getLargeur());
//		this.setHauteur(ligne.getHauteur());
//	}
//	
//	// --------   ACCESSEURS   ----------
//
//	 public ArrayList<Ligne> getLstLignes(){
//		 return this.lstLignes;
//	 }
//	// ----------   AUTRES METHODES   ----------
//	public Ligne getLigne(int index){
//		return this.getLstLignes().get(index);
//	}
//	
//	public Point getP1(int index){
//		return this.getLstLignes().get(index).getP1();
//	}
//	
//	public Point getP2(int index){
//		return this.getLstLignes().get(index).getP2();
//	}
//	
//	public double getLargeur(int index){
//		return this.getLstLignes().get(index).getLargeur();
//	}
//	
//	public double getHauteur(int index){
//		return this.getLstLignes().get(index).getHauteur();
//	}
//	
//	public Ligne getDernLigne(int index){
//		return this.getLigne(lstLignes.size()-1-index);
//	}
//	
//	public Point getDernP1(int index){
//		return this.getLigne(lstLignes.size()-1-index).getP1();
//	}
//	
//	public Point getDernP2(int index){
//		return this.getLigne(lstLignes.size()-1-index).getP2();
//	}
//	
//	public double getDernLargeur(int index){
//		return this.getLigne(lstLignes.size()-1-index).getLargeur();
//	}
//	
//	public double getDernHauteur(int index){
//		return this.getLigne(lstLignes.size()-1-index).getHauteur();
//	}
//	
//	public double getXMin(){
//		double xMin = this.getP1(0).getX();
//		for(Ligne l:this.getLstLignes()){
//			if (l.getP2().getX() < xMin){xMin = l.getP2().getX();}
//		}
//		return xMin;
//	}
//	
//	public double getXMax(){
//		double xMax = this.getP1(0).getX();
//		for(Ligne l:this.getLstLignes()){
//			if (l.getP2().getX() > xMax){xMax = l.getP2().getX();}
//		}
//		return xMax;
//	}
//	
//	public double getYMin(){
//		double yMin = this.getP1(0).getY();
//		for(Ligne l:this.getLstLignes()){
//			if (l.getP2().getY() < yMin){yMin = l.getP2().getY();}
//		}
//		return yMin;
//	}
//	
//	public double getYMax(){
//		double yMax = this.getP1(0).getY();
//		for(Ligne l:this.getLstLignes()){
//			if (l.getP2().getY() > yMax){yMax = l.getP2().getY();}
//		}
//		return yMax;
//	}
//	
//	public void add(Ligne l){
//		this.getLstLignes().add(l);
//	}
//	
//	public int size(){
//		return this.getLstLignes().size();
//	}
//	
//	public void ajouterLigneVers(Point pos){
//		Point dernPoint = this.getDernP2(0);
//		Ligne nouvLigne = new Ligne(dernPoint, pos);
//		this.add(nouvLigne);
//		this.calculCadre();
//		
//	}
//	
//	public void calculCadre(){
//		double largeur;
//		double hauteur;
//		double xMin = this.getLstLignes().get(0).getX(); double xMax = xMin;
//		double yMin = this.getLstLignes().get(0).getY(); double yMax = yMin;
//		for(Ligne l:this.getLstLignes()){
//			if (l.getX() < xMin){xMin = l.getX();}
//			if (l.getY() < yMin){yMin = l.getY();}
//			if (l.getX() > xMax){xMax = l.getX();}
//			if (l.getY() > yMax){yMax = l.getY();}
//		}
//		largeur = xMax - xMin;
//		hauteur = yMax - yMin;
//		this.setLargeur(largeur);
//		this.setHauteur(hauteur);
//		this.setPosition(new Point(xMin, yMin));
//	}
//	
//	public void deplacerDe(int deltaX, int deltaY){
//		double nouveauX = this.getPosition().getX()+deltaX;
//		double nouveauY = this.getPosition().getY()+deltaY;
//		Point nouveauPoint = new Point(nouveauX, nouveauY);
//		//System.out.println(nouveauPoint.toString());
//		this.setPosition(nouveauPoint);
//	}
//	
//	public void deplacerVers(int newX, int newY){
//		Point nouveauPoint = new Point(newX, newY);
//		this.setPosition(nouveauPoint);
//	}
//	
//	public void etirerLargeur(int nouvLargeur){
//		double coef = nouvLargeur/this.getLargeur();
//		//	CAS i=0 : PREMIERE LIGNE
//		Ligne l = new Ligne(this.getP1(0), this.getLargeur(0)*coef, this.getHauteur(0)*coef);
//		Trace nouvTrace = new Trace(l);
//		
//		//	AUTRES CAS
//		for(int i=1; i<this.size(); i++){
//			l = this.getLigne(i);
//			Point auxPoint = nouvTrace.getP2(i);
//			nouvTrace.add(new Ligne(auxPoint, this.getLargeur(i)*coef, this.getHauteur(i)*coef));
//		}
//		this.calculCadre();
//	}
//	public double perimetre(){
//		double perimetre = 0;
//		for(Ligne ligne : lstLignes){
//			perimetre += ligne.perimetre();
//		}
//		return perimetre;
//	}
//	
//	public double aire(){
//		return 0;
//	}
//	
//	/*public String toString(){
//		String s = "[Ligne] p1 : ("+this.getP1().getX()+","+this.getP1().getY()+"),  p2 : ("+this.getP2().getX()+","+this.getP2().getY()+") ";
//		s+= "longueur : "+this.perimetre();	
//		return s;
//	}*/
//}