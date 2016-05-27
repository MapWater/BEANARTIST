package fr.eseo.gpi.beanartist.xml;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.List;

import org.w3c.dom.Element;

import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;

/**
 * Un enregistreur SVG est un processeur DOM responsable de l'enregistrement
 * d'un dessin au format SVG standard.
 * 
 * Il suit exactement les mêmes principes que ceux de l'enregistreur XML (classe
 * EnregistreurXML). Les méthodes enregistreDessin et créeElémentXxxx devront
 * être complétées. Des méthodes utilitaires pourront venir compléter celles
 * définies par la classe ProcesseurDOM ; elles devront dans ce cas être
 * OBLIGATOIREMENT définies en "private" à la fin de la classe EnregistreurXML.
 *
 */
public class EnregistreurSVG extends ProcesseurDOM {

	/**
	 * Lance le test d'enristrement (méthode teste) avec le fichier XML d'entrée
	 * nommé "S30-Dessin-in.xml" et le fichier SVG de sortie nommé
	 * "S30-Dessin-out.svg".
	 * 
	 * Vérifier la conformité du fichier de sortie en l'affichant avec un
	 * navigateur Web et en comparant cet affichage avec celui fourni par la
	 * méthode LecteurXML.main.
	 * 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		teste("S30-Dessin-in.xml", "S30-Dessin-out.svg");
	}

	/**
	 * Teste l'enregistrement du dessin dans un fichier SVG. Le fichier XML
	 * d'entrée est préalablement lu, puis sauvagardé dans un fichier de sortie
	 * au format SVG.
	 * 
	 * @param nomFichierEntrée le nom du fichier XML d'entrée lu
	 * @param nomFichierSortie le nom du fichier SVG de sortie écrit
	 * @throws FileNotFoundException si l'un des noms des fichiers n'est pas
	 *             valide
	 */
	public static void teste(String nomFichierEntrée, String nomFichierSortie) throws FileNotFoundException {
		LecteurXML lecteur = new LecteurXML();
		final List<VueForme> dessin = lecteur.lisDessin(nomFichierEntrée);
		EnregistreurSVG enregistreur = new EnregistreurSVG();
		enregistreur.enregistreDessin(nomFichierSortie, dessin);
	}

	/**
	 * Enregistre le dessin donné dans un fichier SVG.
	 * @param nomFichier le nom du fichier SVG de sauvegarde
	 * @param dessin le dessin formé de la liste des vues des formes
	 * @throws FileNotFoundException si le nom du fichier n'est pas valide
	 */
	public void enregistreDessin(String nomFichier, List<VueForme> dessin) throws FileNotFoundException {
		créeDocumentSVG();
		Element racine = getDocument().getDocumentElement();
		// Pour chaque vue du dessin, créer un élément DOM associé et l'ajouter
		// dans l'élément racine du document.
		
		for (int i = 0 ; i < dessin.size() ; i++){
			Element élément = créeElémentVueForme(dessin.get(i));
			racine.appendChild(élément);
		}
		enregistreDocument(nomFichier);
	}

	/**
	 * Crée un élément DOM au format SVG représentant la vue donnée d'une forme
	 * et retourne cet élément. Cette méthode invoque les méthodes
	 * créeElément<Forme> en fonction du type de la vue.
	 * @param vueForme la vue d'une forme
	 * @return l'élément DOM représentant la vue d'une forme
	 */
	public Element créeElémentVueForme(VueForme vueForme) {
		Element élément;
		String nom = vueForme.getClass().getSimpleName();
		boolean estRempli = false;
		int red = vueForme.getCouleurLigne().getRed();
		int green = vueForme.getCouleurLigne().getGreen();
		int blue = vueForme.getCouleurLigne().getBlue();
		String couleur = "rgb("+red+","+green+","+blue+")";
		
		if (nom.equals("VueRectangle") || nom.equals("VueCarré")) {
			élément = créeElémentRectangle(vueForme);
			écrisAttributsCouleur(élément, couleur, vueForme.estRempli());
		}
		else if (nom.equals("VueCarré")) {
			élément = créeElémentCarré(vueForme);
			écrisAttributsCouleur(élément, couleur, vueForme.estRempli());
		}
		else if (nom.equals("VueEllipse")) {
			élément = créeElémentEllipse(vueForme);
			écrisAttributsCouleur(élément, couleur, vueForme.estRempli());
		}
		else if (nom.equals("VueCercle")) {
			élément = créeElémentCercle(vueForme);
			écrisAttributsCouleur(élément, couleur, vueForme.estRempli());
		}
		else if (nom.equals("VueLigne")) {
			élément = créeElémentLigne(vueForme);
			écrisAttributsCouleur(élément, couleur, estRempli);
		}
		else if (nom.equals("VueTracé")) {
			élément = créeElémentTracé(vueForme);
			écrisAttributsCouleur(élément, couleur, estRempli);
		}
		else {
			throw new Error("Vue non gérée");
		}
		getDocument().getDocumentElement().appendChild(élément);
		return élément;
	}

	/**
	 * Renvoie un nouvel élément DOM au format SVG représentant le rectangle
	 * donné.
	 * @param forme le rectangle
	 * @return élément DOM représentant le rectangle
	 */
	public Element créeElémentRectangle(VueForme vue) {
		Rectangle forme = (Rectangle)vue.getForme();
		Element élément = getDocument().createElement("rect");
		écrisAttribut(élément, "width", forme.getLargeur());
		écrisAttribut(élément, "height", forme.getHauteur());
		écrisAttribut(élément, "x", forme.getMinX());
		écrisAttribut(élément, "y", forme.getMinY());
		
		return élément;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le carré donné.
	 * @param forme le carré
	 * @return élément DOM représentant le carré
	 */
	public Element créeElémentCarré(VueForme vue) {
		Carré forme = (Carré)vue.getForme();
		Element élément = getDocument().createElement("rect");
		écrisAttribut(élément, "width", forme.getLargeur());
		écrisAttribut(élément, "height", forme.getHauteur());
		écrisAttribut(élément, "x", forme.getMinX());
		écrisAttribut(élément, "y", forme.getMinY());
		return élément;
	}
	

	/**
	 * Renvoie un nouvel élément DOM représentant l'ellipse donnée.
	 * @param forme l'ellipse
	 * @return élément DOM représentant l'ellipse
	 */
	public Element créeElémentEllipse(VueForme vue) {
		Ellipse forme = (Ellipse)vue.getForme();
		Element élément = getDocument().createElement("ellipse");
		écrisAttribut(élément, "rx", forme.getLargeur()/2);
		écrisAttribut(élément, "ry", forme.getHauteur()/2);
		écrisAttribut(élément, "cx", forme.getMinX()+forme.getLargeur()/2);
		écrisAttribut(élément, "cy", forme.getMinY()+forme.getHauteur()/2);
		return élément;
	}
	

	/**
	 * Renvoie un nouvel élément DOM représentant le cercle donné.
	 * @param forme le cercle
	 * @return élément DOM représentant le cercle
	 */
	public Element créeElémentCercle(VueForme vue) {
		Cercle forme = (Cercle)vue.getForme();
		Element élément = getDocument().createElement("circle");
		écrisAttribut(élément, "r", forme.getLargeur()/2);
		écrisAttribut(élément, "cx", forme.getMinX()+forme.getLargeur()/2);
		écrisAttribut(élément, "cy", forme.getMinY()+forme.getHauteur()/2);
		return élément;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant la ligne donnée.
	 * @param forme la ligne
	 * @return élément DOM représentant la ligne
	 */
	public Element créeElémentLigne(VueForme vue) {
		Ligne forme = (Ligne)vue.getForme();
		Element élément = getDocument().createElement("line");
		écrisAttribut(élément, "x2", forme.getP2X());
		écrisAttribut(élément, "y2", forme.getP2Y());
		écrisAttribut(élément, "x1", forme.getP1X());
		écrisAttribut(élément, "y1", forme.getP1Y());
		return élément;
	}

	/**
	 * Renvoie un nouvel élément DOM représentant le tracé donné.
	 * @param forme le tracé
	 * @return élément DOM représentant le tracé
	 */
	public Element créeElémentTracé(VueForme vue) {
		Element élément = getDocument().createElement("polyline");
		String lignes = "";
		// Premier point:
		Ligne l1 = ((Tracé)vue.getForme()).getLigne(0);
		lignes += l1.getP1X()+","+l1.getP1Y()+" ";	
		// Autres points
		for(Ligne l : ((Tracé)vue.getForme()).getLignes()){
			lignes+= l.getP2X()+","+l.getP2Y()+" ";			
		}
		écrisAttribut(élément, "points", lignes);
		return élément;
	}

}