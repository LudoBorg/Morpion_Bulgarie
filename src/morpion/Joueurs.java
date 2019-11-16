/**
 * Constructeur de joueur, permet la génération de joueurs dans Plateau.java
 * 
 * @author LudovicB
 * @version 1.1
 */

package morpion;

public class Joueurs {
	public String nom; //Public car doit être accessible dans une autre class
	public char signe;
	
//Pour générer méthode : Sélectionne la class Joueur puis Source puis Generate getters and setters
/**
 * Méthode getNom()
 * 
 * @return nom : Retourne le nom du joueur 
 */
	public String getNom() { 
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

/**
 * Méthode getSigne()
 *  
 * @return signe : Retourne le signe du joueur (X ou O)
 */
	public char getSigne() {
		return signe;
	}

	public void setSigne(char signe) {
		this.signe = signe;
	}

/**
 * Constructeur Joueurs
 * 
 * @param nom_j : Nom du joueur
 * @param signe_j : Signe du joueur (X ou O)
 */
	public Joueurs (String nom_j, char signe_j) {
		nom = nom_j;
		signe = signe_j;
	}
}
