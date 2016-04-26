package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Carré;

public class CarréTest{
	public static void main(String args[]){
		Point p1 = new Point(1,1);
		
		Carré c1 = new Carré(p1, 10);
		Carré c2 = new Carré(200);
		Carré c3 = new Carré(new Point(141,62));
		Carré c4 = new Carré(1,2,3);
		Carré c5 = new Carré();
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c3.getX());
		System.out.println(c3.getY());
		System.out.println(c4);
		System.out.println(c5);

	}
}
