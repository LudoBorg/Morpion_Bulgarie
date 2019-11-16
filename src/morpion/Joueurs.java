/**
 * Constructeur de joueur, permet la g�n�ration de joueurs dans Plateau.java
 * 
 * @author LudovicB
 * @version 1.1
 */

package morpion;

public class Joueurs {
	public String nom; //Public car doit �tre accessible dans une autre class
	public char signe;
	
//Pour g�n�rer m�thode : S�lectionne la class Joueur puis Source puis Generate getters and setters
/**
 * M�thode getNom()
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
 * M�thode getSigne()
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
