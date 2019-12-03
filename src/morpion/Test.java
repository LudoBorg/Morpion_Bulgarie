package morpion;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
	Scanner lit=new Scanner(System.in);
	boolean chiffre = false;
	String string1;
	 
	do {
	  string1 = lit.nextLine();
	  try {
	    int toto = Integer.parseInt(string1);
	    chiffre = true; // si ton exécution arrive jusque là, ça signifie qu'il n'y a aucune exception lancée et que ta saisie est donc bien un chiffre
	  } catch(NumberFormatException e) {
	    System.out.println("Cette valeur n'est pas un chiffre, essaie encore !");
	  }
	} while (chiffre != true);
	 
	System.out.println("Cette valeur est bien un chiffre : " + string1);
}
}

