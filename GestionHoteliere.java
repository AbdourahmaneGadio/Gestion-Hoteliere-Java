import java.util.Scanner;

public class GestionHoteliere {

    public static void main(String[] args) {
        System.out.println("Bienvenue à notre hôtel !");

        System.out.println("Que souhaitez-vous faire aujourd'hui ?");

        Scanner scan = new Scanner(System.in);
		String choice = scan.next();

        while (true){
			// Condition multiple
			switch(choice) { // Valide depuis Java 1.7
			
				// Message d'aide
				case "h" :
					System.out.println("h: Affiche les instructions disponibles");
					System.out.println("q: Quitte le programme");
                    System.out.println("Que souhaitez-vous faire aujourd'hui ?");
					choice = scan.next();
					break;
					
				
				// On quitte
				case "q" : // Ici on utilise "q" avec des guillemets en tant que String.
				System.out.println("Merci d'avoir fait confiance à nos services !");
                    scan.close();
				System.exit(0);
					break;
					
				// Autre
				default:
					System.out.println("Commande inconnue, tapez h pour afficher l'aide");
					choice = scan.next();
					break;
			} // switch
				
		} // while


    } // main
    
} // GestionHoteliere
