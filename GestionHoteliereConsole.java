import java.util.Scanner;

public class GestionHoteliereConsole {

	public GestionHoteliereConsole() {

		GestionHoteliere gestionHoteliere = new GestionHoteliere();

		Scanner scan = new Scanner(System.in);

		System.out.println("Bienvenue à notre hôtel !");

		System.out.println("Quel est votre nom ?");

		String nomClient = scan.next();

		System.out.println("Que souhaitez-vous faire aujourd'hui ?");

		String choice = scan.next();

		while (true) {
			// Condition multiple
			switch (choice) { // Valide depuis Java 1.7

				// Message d'aide
				case "h":
					System.out.println("h: Affiche les instructions disponibles");
					System.out.println("p: Commander un repas");
					System.out.println("r: Réserver une chambre");
					System.out.println("q: Quitte le programme");
					System.out.println("\nQue souhaitez-vous faire aujourd'hui ?");
					choice = scan.next();
					break;

				// Réservation de chambre
				case "r":

					gestionHoteliere.chambreDispoDetails();

					// On choisit un type de chambre
					TypeChambre typeChambreChoisie = choixChambre(scan);
					// On choisit un type de lit
					TypeLit typeLitChoisi = choixLit(scan);

					// On regarde si une chambre est disponible
					Chambre chambreRecherche = new Chambre(typeChambreChoisie, typeLitChoisi);
					try {
						Chambre chambreDispo = gestionHoteliere.getChambreDispo(chambreRecherche);
						
						Reservation reservation = new Reservation();
						reservation.ajoutReserv(chambreDispo, nomClient);
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

	} // GestionHoteliereConsole()

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

		int indiceLit = 0;

		TypeLit[] typeLitList = TypeLit.values();

		// Pour chaque valeur possible
		for (TypeLit typeLit : typeLitList) {
			System.out.println(indiceLit + " : " + typeLit);
			indiceLit++;
		}

		String choice = scan.next();

		int choixToInt = Integer.parseInt(choice);
		return typeLitList[choixToInt];
	} // choixLit()

	public static void main(String[] args) {
		new GestionHoteliereConsole();
	} // main

} // GestionHoteliere
