import java.util.Scanner;

public class GestionHoteliere {

    public static void main(String[] args) {
        System.out.println("Bienvenue à notre hôtel !");

        System.out.println("Que souhaitez-vous faire aujourd'hui ?");

        Chambre[] chambreList = Chambre.values();

        Scanner scan = new Scanner(System.in);
		String choice = scan.next();

        while (true){
			// Condition multiple
			switch(choice) { // Valide depuis Java 1.7
			
				// Message d'aide
				case "h" :
					System.out.println("h: Affiche les instructions disponibles");
                    System.out.println("r: Permet de voir les réservations de chambre");
					System.out.println("q: Quitte le programme");
                    System.out.println("\nQue souhaitez-vous faire aujourd'hui ?");
					choice = scan.next();
					break;
					
				// Réservation de chambre
				case "r" :
					System.out.println("Quelle type de chambre voulez-vous réserver ?");
					System.out.println("Tapez le nombre indiqué pour faire votre choix\n");

                    int indiceChambre = 0;
for(Chambre chambre : chambreList){
    					System.out.println(indiceChambre  + " : Chambre " + chambre.getTypeChambre() + " avec un lit " + chambre.getTypeLit());
indiceChambre++;
}

					choice = scan.next();

                    switch (choice) {
                        case "0":
                             System.out.println("Vous avez choisi une chambre normal avec un lit simple");
                            break;                        
                        case "1":
                             System.out.println("Vous avez choisi une chambre normal avec un lit double");
                            break;                        case "2":
                             System.out.println("Vous avez choisi une chambre de luxe avec un lit simple");
                            break;                        case "3":
                             System.out.println("Vous avez choisi une chambre de luxe avec un lit double");
                            break;
                    
                        default:
                            System.out.println("Le choix n'est pas correct. Aucune réservation n'a été faite.");
                            break;
                    }

                    System.out.println("\nQue souhaitez-vous faire aujourd'hui ?");
					choice = scan.next();

					break;

				// On quitte
				case "q" : // Ici on utilise "q" avec des guillemets en tant que String.
				System.out.println("\nMerci d'avoir fait confiance à nos services !");
                    scan.close();
				System.exit(0);
					break;
					
				// Autre
				default:
					System.out.println("\nCommande inconnue, tapez h pour afficher l'aide");
					choice = scan.next();
					break;
			} // switch
				
		} // while


    } // main
    
} // GestionHoteliere
