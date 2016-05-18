package fr.eseo.gpi.beanartist.xml;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.SwingUtilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import fr.eseo.gpi.beanartist.modele.geom.Carré;
import fr.eseo.gpi.beanartist.modele.geom.Cercle;
import fr.eseo.gpi.beanartist.modele.geom.Ellipse;
import fr.eseo.gpi.beanartist.modele.geom.Ligne;
import fr.eseo.gpi.beanartist.modele.geom.Point;
import fr.eseo.gpi.beanartist.modele.geom.Rectangle;
import fr.eseo.gpi.beanartist.modele.geom.Tracé;
import fr.eseo.gpi.beanartist.vue.geom.VueCarré;
import fr.eseo.gpi.beanartist.vue.geom.VueCercle;
import fr.eseo.gpi.beanartist.vue.geom.VueEllipse;
import fr.eseo.gpi.beanartist.vue.geom.VueForme;
import fr.eseo.gpi.beanartist.vue.geom.VueLigne;
import fr.eseo.gpi.beanartist.vue.geom.VueRectangle;
import fr.eseo.gpi.beanartist.vue.geom.VueTracé;
import fr.eseo.gpi.beanartist.vue.ui.FenêtreBeAnArtist;

/**
 * Un lecteur XML est un processeur DOM responsable du chargement d'un dessin au
 * format XML défini par l'application.
 * 
 * Il utilise les méthodes héritées de la classe ProcesseurDOM pour charger le
 * fichier XML dans un document DOM, ainsi que les méthodes de lecture des
 * entiers.
 * 
 * Les méthodes lisDessin et créeXxxx devront être complétées. Des méthodes
 * utilitaires pourront venir compléter celles définies par la classe
 * ProcesseurDOM ; elles devront dans ce cas être OBLIGATOIREMENT définies en
 * "private" à la fin de la classe LecteurXML.
 * 
 */
public class LecteurXML extends ProcesseurDOM {

	/**
	 * Lance le test de chargement (méthode teste) avec le fichier XML nommé
	 * "S30-Dessin-in.xml".
	 * 
	 * Vous aurez pris soin de le copier prélablablement dans le ficher
	 * "S30-Dessin-in.xml".
	 * 
	 * Ce test MANUEL doit OBLIGATOIREMENT passer avant de commencer la gestion
	 * de l'enregistrement en XML (classe EnregistreurXML).
	 */
	public static void main(String[] args) throws FileNotFoundException {
		teste("S30-Dessin-in.xml");
	}

	/**
	 * Teste le chargement du fichier XML. Le contenu du fichier est ensuite
	 * affiché dans la fenêtre de l'application (classe FenêtreBeAnArtist).
	 * @param nomFichier le fichier d'entrée à lire
	 * @throws FileNotFoundException si le fichier n'existe pas
	 */
	public static void teste(String nomFichier) throws FileNotFoundException {
		LecteurXML lecteur = new LecteurXML();
		final List<VueForme> dessin = lecteur.lisDessin(nomFichier);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				FenêtreBeAnArtist fenêtre = new FenêtreBeAnArtist();
				for (VueForme vueForme : dessin) {
					fenêtre.getPanneauDessin().ajouterVueForme(vueForme);
				}
			}
		});
	}

	/**
	 * Charge le fichier XML donné dans un document DOM puis renvoie
	 * l'intégralité du dessin sous la forme d'une liste de vues représentant
	 * les formes stockées dans le fichier.
	 * 
	 * @param nomFichier le nom du fichier XML
	 * @return l'intégralité du dessin sous la forme d'une liste de vues
	 * @throws FileNotFoundException si le fichier n'est pas trouvé ou
	 *             accessible
	 */
	public List<VueForme> lisDessin(String nomFichier) throws FileNotFoundException {
		List<VueForme> dessin = new ArrayList<>();
		chargeDocument(nomFichier);
		Element racine = getDocument().getDocumentElement();
		NodeList noeudsFils = racine.getChildNodes();
		for (int i = 0; i < noeudsFils.getLength(); i++){
			Node noeud = noeudsFils.item(i);
			System.out.println(racine.getChildNodes().item(i).getNodeName());
			if (noeud.getNodeType() == Node.ELEMENT_NODE){
				Element élémentFils = (Element) noeud;
				
			}
			else if (noeud.getNodeType() == Node.TEXT_NODE){
			}
		}
		// Pour chaque noeud fils de l'élément racine du document,
		// si le noeud est un élément DOM, convertir cet élément en une vue sur
		// la forme que l'élément représente en utilisant la méthode
		// créeVueForme, puis ajouter cette vue au dessin.
		return dessin;
	}

	/**
	 * Crée une forme et sa vue associée réprésentées par l'élément DOM donné,
	 * puis renvoie cette vue. Cette méthode invoque les méthodes crée<Forme>
	 * définies pour chacune des <Forme> considérée.
	 * @param element l'élément représentant la vue et sa forme
	 * @return la vue stockée dans l'élément considéré
	 */
	public VueForme créeVueForme(Element element) {
		VueForme vue = null;
		String nom = element.getNodeName();
		boolean rempli = false;
		
		Color couleur = Color.blue; //(""+element.getAttribute("couleurFond"));
		if (nom.equals("à modifier !")) {
			Rectangle forme = créeRectangle(element);
			vue = new VueRectangle(forme, couleur, rempli);
		}
		else if (nom.equals("à modifier !")) {
			Carré forme = créeCarré(element);
			vue = new VueCarré(forme, couleur, rempli);
		}
		else if (nom.equals("à modifier !")) {
			Ellipse forme = créeEllipse(element);
			vue = new VueEllipse(forme, couleur, rempli);
		}
		else if (nom.equals("à modifier !")) {
			Cercle forme = créeCercle(element);
			vue = new VueCercle(forme, couleur, rempli);
		}
		else if (nom.equals("à modifier !")) {
			Ligne forme = créeLigne(element);
			vue = new VueLigne(forme, couleur);
		}
		else if (nom.equals("à modifier !")) {
			Tracé forme = créeTracé(element);
			vue = new VueTracé(forme, couleur);
		}
		return vue;
	}

	/**
	 * Renvoie un nouveau rectangle représenté par l'élément DOM donné.
	 * @param element l'élément représentant le rectangle
	 * @return le rectangle stocké dans l'élément considéré
	 */
	public Rectangle créeRectangle(Element element) {
		int largeur = Integer.parseInt(element.getAttribute("largeur"));
		int hauteur = Integer.parseInt(element.getAttribute("hauteur"));
		int abscisse = Integer.parseInt(element.getAttribute("abscisse")); 
		int ordonnée = Integer.parseInt(element.getAttribute("ordonnée"));
		return new Rectangle(abscisse, ordonnée, largeur, hauteur);
	}

	/**
	 * Renvoie un nouveau carré représenté par l'élément DOM donné.
	 * @param element l'élément représentant le carré
	 * @return le carré stocké dans l'élément considéré
	 */
	public Carré créeCarré(Element element) {
		int largeur = Integer.parseInt(element.getAttribute("largeur"));
		int hauteur = Integer.parseInt(element.getAttribute("hauteur"));
		int cote = Integer.parseInt(element.getAttribute("cote"));
		return new Carré(cote, largeur, hauteur);
	}

	/**
	 * Renvoie une nouvelle ellipse représentée par l'élément DOM donné.
	 * @param element l'élément représentant l'ellipse
	 * @return l'ellipse stockée dans l'élément considéré
	 */
	public Ellipse créeEllipse(Element element) {
		int largeur = Integer.parseInt(element.getAttribute("largeur"));
		int hauteur = Integer.parseInt(element.getAttribute("hauteur"));
		int abscisse = Integer.parseInt(element.getAttribute("abscisse")); 
		int ordonnée = Integer.parseInt(element.getAttribute("ordonnee"));
		return new Ellipse(abscisse, ordonnée, largeur, hauteur);
	}

	/**
	 * Renvoie un nouveau cercle représenté par l'élément DOM donné.
	 * @param element l'élément représentant le cercle
	 * @return le cercle stocké dans l'élément considéré
	 */
	public Cercle créeCercle(Element element) {
		int largeur = Integer.parseInt(element.getAttribute("largeur"));
		int hauteur = Integer.parseInt(element.getAttribute("hauteur"));
		int diametre = Integer.parseInt(element.getAttribute("diametre")); 
		return new Cercle(diametre, largeur, hauteur);
	}

	/**
	 * Renvoie la nouvelle ligne représentée par l'élément DOM donné.
	 * @param element l'élément représentant la ligne
	 * @return la ligne stockée dans l'élément considéré
	 */
	public Ligne créeLigne(Element element) {
		int largeur = Integer.parseInt(element.getAttribute("largeur"));
		int hauteur = Integer.parseInt(element.getAttribute("hauteur"));
		int abscisse = Integer.parseInt(element.getAttribute("abscisse")); 
		int ordonnée = Integer.parseInt(element.getAttribute("ordonnee"));
		return new Ligne(abscisse, ordonnée, largeur, hauteur);
	}

	/**
	 * Renvoie un nouveau tracé représenté par l'élément DOM donné.
	 * @param element l'élément représentant le tracé
	 * @return le tracé stocké dans l'élément considéré
	 */
	public Tracé créeTracé(Element element) {
		// création de la liste des points du tracé
		List<Point> points = new ArrayList<>();
		// création des lignes formant le tracé
		return null;
	}

}
