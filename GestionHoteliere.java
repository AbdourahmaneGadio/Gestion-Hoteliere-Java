import java.util.Scanner;

public class GestionHoteliere {

	private static TypeChambre choixChambre(Scanner scan) {

		System.out.println("Quelle type de chambre voulez-vous réserver ?");
		System.out.println("Tapez le nombre indiqué pour faire votre choix\n");

		int indiceChambre = 0;

		TypeChambre[] typeChambreList = TypeChambre.values();

		// Pour chaque valeur possible
		for (TypeChambre typeChambre : typeChambreList) {
			System.out.println(indiceChambre + " : " + typeChambre);
			indiceChambre++;
		}

		String choice = scan.next();

		int choixToInt = Integer.parseInt(choice);
		return typeChambreList[choixToInt];
	}

		private static TypeLit choixLit(Scanner scan) {

		System.out.println("Quelle type de lit voulez-vous pour cette chambre ?");
		System.out.println("Tapez le nombre indiqué pour faire votre choix\n");

		int indiceLit= 0;

		TypeLit[] typeLitList = TypeLit.values();

		// Pour chaque valeur possible
		for (TypeLit typeLit: typeLitList) {
			System.out.println(indiceLit+ " : " + typeLit);
			indiceLit++;
		}

		String choice = scan.next();

		int choixToInt = Integer.parseInt(choice);
		return typeLitList[choixToInt];
	}

	public static void main(String[] args) {
		System.out.println("Bienvenue à notre hôtel !");

		System.out.println("Que souhaitez-vous faire aujourd'hui ?");

		Scanner scan = new Scanner(System.in);
		String choice = scan.next();

		while (true) {
			// Condition multiple
			switch (choice) { // Valide depuis Java 1.7

				// Message d'aide
				case "h":
					System.out.println("h: Affiche les instructions disponibles");
					System.out.println("r: Permet de voir les réservations de chambre");
					System.out.println("q: Quitte le programme");
					System.out.println("\nQue souhaitez-vous faire aujourd'hui ?");
					choice = scan.next();
					break;

				// Réservation de chambre
				case "r":
					// On choisit un type de chambre
					TypeChambre typeChambreChoisie = choixChambre(scan);
					// On choisit un type de lit
					TypeLit typeLitChoisi = choixLit(scan);

					// La nouvelle chambre
					Chambre chambreChoisie = new Chambre(typeChambreChoisie, typeLitChoisi);
					
					// La réservation de cette même chambre
					Reservation reservation = new Reservation();

					try {
						reservation.ajoutReserv(chambreChoisie);
					} catch (NoRoomAvailableException e) {
						e.getMessage();
					}
					System.out.println("\nQue souhaitez-vous faire aujourd'hui ?");
					choice = scan.next();

					break;

				// On quitte
				case "q": // Ici on utilise "q" avec des guillemets en tant que String.
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
