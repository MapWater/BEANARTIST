package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;

public class EllipseTest {

	public static void main(String[] args) {
		// Création des instances aveec les différents constucteurs
		Ellipse ellipse1 = new Ellipse();
		Ellipse ellipse2 = new Ellipse(new Point(3, 6));
		Ellipse ellipse3 = new Ellipse(4, 7);
		Ellipse ellipse4 = new Ellipse(3, 9, 10, 5);
		Ellipse ellipse5 = new Ellipse(new Point(7, 9), 6, 3);
		
		//Test de la méthode d'affichage pour chaque instance créée
		//On teste ainsi également les méthodes d'instances aire et périmètre
		System.out.println(ellipse1.toString());
		System.out.println(ellipse2.toString());
		System.out.println(ellipse3.toString());
		System.out.println(ellipse4.toString());
		System.out.println(ellipse5.toString());
		
		//Test des accesseurs en écriture
		ellipse1.setHauteur(4);
		ellipse1.setLargeur(3);
		ellipse1.setX(2);
		ellipse1.setY(8);
		System.out.println(ellipse1.toString());
		
		//Test des accesseurs en lecture
		System.out.println(ellipse3.getHauteur()); //7
		System.out.println(ellipse3.getLargeur()); //4
		System.out.println(ellipse5.getX()); //7
		System.out.println(ellipse5.getY()); //9
		System.out.println(ellipse5.getMinX()); //7
		System.out.println(ellipse5.getMinY()); //9
		System.out.println(ellipse5.getMaxX()); //13
		System.out.println(ellipse5.getMaxY()); //12
		
		//Test des autres méthodes
		ellipse4.déplacerVers(2, 5);
		System.out.println(ellipse4.toString()); //(2, 5)
		ellipse5.déplacerDe(4, 7);
		System.out.println(ellipse5.toString()); //(11, 16)
		System.out.println(ellipse1.contient(4, 10)); //true
		System.out.println(ellipse1.contient(new Point(3, 10))); //true
	}

}
