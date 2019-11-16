/**
 * @author LudovicB
 * @version 1.1
 * 
 * 1) G�n�ration des joueurs grace � un constructeur
 * 2) G�n�ration des cases grace � un constructeur et initialisation de la grille
 * 3) D�but du jeu 
 */

package morpion;

import java.util.*;

public class Plateau {
	public static Joueurs Joueur1; //Utilisation du constructeur joueurs
	public static Joueurs Joueur2;

	private static Case[][] l_tabCases = new Case[3][3];
	
	public static void main (String [] args) {
		//1)
		Scanner sc_nom_j1 = new Scanner(System.in); //Pour r�cup�rer le nom du joueur1 tap� au clavier
		System.out.println("Entrez le nom du joueur 1 : ");
		String nom_j1 = sc_nom_j1.nextLine();
		//System.out.println("Vous avez saisi : " + nom_j1);
		
		//V�rification du caract�re du signe du joueur 1
		char signe_j1 = ' ';
		Scanner sc_signe_j1;
		do {
			sc_signe_j1 = new Scanner(System.in);
			System.out.println("Choisissez le signe du joueur 1 : (O ou X)");
			signe_j1 = sc_signe_j1.nextLine().charAt(0);
			//System.out.println("Vous avez saisi : " + signe_j1);
		} while ( !(signe_j1 == 'O' || signe_j1 == 'X')); //Tant qu'il est diff�rent de O ou X on refait le do

		Joueur1 = new Joueurs(nom_j1, signe_j1); //Construction du joueur 1
		System.out.println("Joueur 1 : " + Joueur1.getNom() + ", Signe : " + Joueur1.getSigne()); //Utilisation de m�thodes pour afficher le nom et le signe du joueur 1
		
		Scanner sc_nom_j2 = new Scanner(System.in);
		System.out.println("Entrez le nom du joueur 2 : ");
		String nom_j2 = sc_nom_j2.nextLine();
		//System.out.println("Vous avez saisi : " + nom_j2);

		char signe_j2 = ' ';
		
		switch(signe_j1) { //Attribue le signe non s�lectionn� au joueur 2
			case 'X':
				signe_j2 = 'O';
				//System.out.println(signe_j2);
				break;
			case 'O':
				signe_j2 = 'X';
				//System.out.println(signe_j2);
				break;
		}
		
		Joueur2 = new Joueurs(nom_j2, signe_j2); //Construction du joueur 2
		System.out.println("Joueur 2 : " + Joueur2.getNom() + ", Signe : " + Joueur2.getSigne()); //Utilisation de m�thodes pour afficher le nom et le signe du joueur 2
	

		
		//2)
		
		//Parcourt par ligne et initialisation de toutes les cases vides
		for(int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				l_tabCases[i][j] = new Case(i,j,' ');		
				//System.out.println("Case "+(i*3+j)+": x="+j+" y="+i);
			}
		}
		
		afficheGrille();
		
			int tour = 0;
			while (tour < 10) {
				Scanner case_choisie_j1 = new Scanner(System.in);
				System.out.println(Joueur1.getNom() + " commence, choisissez une case en donnant ses coordonn�es X,Y :");
				String case_j1 = case_choisie_j1.nextLine();
				

				String cases_j1[] = case_j1.split(","); // S�pare les membres du string en plusieurs string (entre chaque virgule)
				int coordonnee_x_j1 = Integer.parseInt(cases_j1[0])-1; // Transformation de string en int de la coordonn�e x (-1 car tableau)
				int coordonnee_y_j1 = Integer.parseInt(cases_j1[1])-1;
				l_tabCases[coordonnee_y_j1][coordonnee_x_j1].setEtat(Joueur1.getSigne());
				
				tour++;
				afficheGrille();
				
				Scanner case_choisie_j2 = new Scanner(System.in);
				System.out.println(Joueur2.getNom() + " commence, choisissez une case en donnant ses coordonn�es X,Y :");
				String case_j2 = case_choisie_j2.nextLine();
				

				String cases_j2[] = case_j2.split(","); // S�pare les membres du string en plusieurs string (entre chaque virgule)
				int coordonnee_x_j2 = Integer.parseInt(cases_j2[0])-1; // Transformation de string en int de la coordonn�e x (-1 car tableau)
				int coordonnee_y_j2 = Integer.parseInt(cases_j2[1])-1;
				l_tabCases[coordonnee_y_j2][coordonnee_x_j2].setEtat(Joueur2.getSigne());


				tour++;
				
				afficheGrille();
				
			}
			 

			

			
//			sc_nom_j1.close();
//			sc_signe_j1.close();
//			sc_nom_j2.close();
//			case_choisie_j1.close();
//			case_choisie_j2.close();			
			
		}	
	
/**
 * M�thode afficheGrille()
 * 
 * Affiche la grille du jeu 
 */
	private static void afficheGrille() {
		//Affichage de la grille 3X3	
		int i;		// Nombre de lignes
		int j;		// Nombre d'�l�ments par ligne
		int col; 	// Axe des abscisses
		
		System.out.println(""); //Sauter une ligne			
		System.out.printf("      ");
		//Affichage du num�ro de colonne :
		for (col=0; col<3; col++) {
			System.out.print("  "+(col+1)+" ");
		}
		System.out.println("");
		System.out.println("	_   _   _");
		
		//Initialisation du compteur:
		i=0;
		
		//Affichage du tableau � 2 dimensions :
		while (i < 3) {
		  j = 0;	  
		  //Affichage du nombre de lignes :
		  System.out.print("   "+(i+1)+"  | ");
		  while(j < 3) {
		    System.out.print(l_tabCases[i][j].getEtat());
		    System.out.print(" | ");
		    j++;
		  }
		  //Retour � la ligne pour chaque ligne du tableau :
		  System.out.println("");
		  i++;
		}
		System.out.println("	_   _   _");
		System.out.println("");
		
	}
		
	}

