package fr.eseo.gpi.beanartist.tests.modele.geom;

import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;

public class CercleTest {

	public static void main(String[] args) {
		//Création des instances avec les différents constructeurs
		Cercle cercle1 = new Cercle();
		Cercle cercle2 = new Cercle(new Point());
		Cercle cercle3 = new Cercle(5);
		Cercle cercle4 = new Cercle(2, 9, 10);
		Cercle cercle5 = new Cercle(new Point(7, 3), 9);
		
		//Test de la méthode d'affichage pour chaque instance créée
		//On teste ainsi également les méthodes d'instances aire et périmètre
		System.out.println(cercle1.toString());
		System.out.println(cercle2.toString());
		System.out.println(cercle3.toString());
		System.out.println(cercle4.toString());
		System.out.println(cercle5.toString());
		
		//Test des accesseurs en écriture
		cercle1.setHauteur(4);
		cercle2.setLargeur(3);
		cercle1.setX(2);
		cercle1.setY(8);
		System.out.println(cercle1.toString());
		System.out.println(cercle2.toString());
		
		//Test des accesseurs en lecture
		System.out.println(cercle3.getHauteur()); //5
		System.out.println(cercle3.getLargeur()); //5
		System.out.println(cercle5.getX()); //7
		System.out.println(cercle5.getY()); //3
		System.out.println(cercle5.getMinX()); //7
		System.out.println(cercle5.getMinY()); //3
		System.out.println(cercle5.getMaxX()); //16
		System.out.println(cercle5.getMaxY()); //12
		
		//Test des autres méthodes
		cercle4.déplacerVers(2, 5);
		System.out.println(cercle4.toString()); //(2, 5)
		cercle5.déplacerDe(4, 7);
		System.out.println(cercle5.toString()); //(11, 10)
		System.out.println(cercle1.contient(1, 9)); //false
		System.out.println(cercle1.contient(new Point (58, 18))); //false
	}

}
