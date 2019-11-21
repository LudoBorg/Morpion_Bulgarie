/**
 * @author LudovicB
 * @version 1.1
 * 
 * 2) Génération des cases grace à un constructeur et initialisation de la grille
 * 3) Début du jeu 
 */

package morpion;

import java.util.*;

public class Plateau {

	private static Case[][] l_tabCases = new Case[3][3];
	
	public static void main (String [] args) throws VerifEntreeUtilisateur {
	DemandeCaseUtilisateur();

	}
	
/**
 * Méthode qui constuit un tableau de 3X3
 * 	  
 */	
	public static void ConstructionGrille() {
		//Parcourt par ligne et initialisation de toutes les cases vides
		for(int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				l_tabCases[i][j] = new Case(i,j,' ');		
				//System.out.println("Case "+(i*3+j)+": x="+j+" y="+i);
			}
		}
	}
	
/**
 * Méthode afficheGrille() dans la console
 * 
 * Affiche la grille du jeu 
 */
	private static void afficheGrille() {
		//Affichage de la grille 3X3	
		int i;		// Nombre de lignes
		int j;		// Nombre d'éléments par ligne
		int col; 	// Axe des abscisses
		
		System.out.println(""); //Sauter une ligne			
		System.out.printf("      ");
		//Affichage du numéro de colonne :
		for (col=0; col<3; col++) {
			System.out.print("  "+(col+1)+" ");
		}
		System.out.println("");
		System.out.println("	_   _   _");
		
		//Initialisation du compteur:
		i=0;
		
		//Affichage du tableau à 2 dimensions :
		while (i < 3) {
		  j = 0;	  
		  //Affichage du nombre de lignes :
		  System.out.print("   "+(i+1)+"  | ");
		  while(j < 3) {
		    System.out.print(l_tabCases[i][j].getEtat());
		    System.out.print(" | ");
		    j++;
		  }
		  //Retour à la ligne pour chaque ligne du tableau :
		  System.out.println("");
		  i++;
		}
		System.out.println("	_   _   _");
		System.out.println("");
	}
	
/**
 * Méthode DemandeCaseUtilisateur() dans la console
 * 
 * 
 */
	public static void DemandeCaseUtilisateur() {
		afficheGrille();
		
			int tour = 0;
			while (tour < 10) {
				Scanner case_choisie_j1 = new Scanner(System.in);
				System.out.println(Joueurs.Joueur1.getNom() + " commence, choisissez une case en donnant ses coordonnées (numéro de la colonne puis numero de la ligne) :");
				String case_j1 = case_choisie_j1.nextLine();
				

				String cases_j1[] = case_j1.split(","); // Sépare les membres du string en plusieurs string (entre chaque virgule)
				int coordonnee_x_j1 = Integer.parseInt(cases_j1[0])-1; // Transformation de string en int de la coordonnée x (-1 car tableau)
				int coordonnee_y_j1 = Integer.parseInt(cases_j1[1])-1;
				
//				if (coordonnee_x_j1>3 || coordonnee_x_j1<0) {
//					throw new VerifEntreeUtilisateur();
//				}
				
				l_tabCases[coordonnee_y_j1][coordonnee_x_j1].setEtat(Joueurs.Joueur1.getSigne());
				
				tour++;
				afficheGrille();
				
				Scanner case_choisie_j2 = new Scanner(System.in);
				System.out.println(Joueurs.Joueur2.getNom() + ", choisissez une case en donnant ses coordonnées (numéro de la colonne puis numero de la ligne) :");
				String case_j2 = case_choisie_j2.nextLine();
				

				String cases_j2[] = case_j2.split(","); // Sépare les membres du string en plusieurs string (entre chaque virgule)
				int coordonnee_x_j2 = Integer.parseInt(cases_j2[0])-1; // Transformation de string en int de la coordonnée x (-1 car tableau)
				int coordonnee_y_j2 = Integer.parseInt(cases_j2[1])-1;
				l_tabCases[coordonnee_y_j2][coordonnee_x_j2].setEtat(Joueurs.Joueur2.getSigne());


				tour++;
				afficheGrille();
			}
			 

			

			
//			sc_nom_j1.close();
//			sc_signe_j1.close();
//			sc_nom_j2.close();
//			case_choisie_j1.close();
//			case_choisie_j2.close();			
			
		}	
	
	class VerifEntreeUtilisateur extends Exception{ 
		  public VerifEntreeUtilisateur(){
		    System.out.println("Veuillez séléctionne une case valide !");
		  }  
		}
	

	

		
	}

