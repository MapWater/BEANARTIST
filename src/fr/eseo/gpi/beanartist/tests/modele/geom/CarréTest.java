package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Carr�;

public class Carr�Test{
	public static void main(String args[]){
		Point p1 = new Point(1,1);
		
		Carr� c1 = new Carr�(p1, 10);
		Carr� c2 = new Carr�(200);
		Carr� c3 = new Carr�(new Point(141,62));
		Carr� c4 = new Carr�(1,2,3);
		Carr� c5 = new Carr�();
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c3.getX());
		System.out.println(c3.getY());
		System.out.println(c4);
		System.out.println(c5);

	}
}
