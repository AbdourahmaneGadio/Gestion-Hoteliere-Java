import java.util.Scanner;

public class GestionHoteliereConsole {

    public GestionHoteliereConsole() {

        System.out.println("\nBienvenue dans nôtre hôtel !");

        GestionHoteliere gestionHoteliere = new GestionHoteliere(1);

        System.out.println("\nQue souhaitez-vous faire ? Tapez une des commandes ci-dessous.\n");

        // Liste des options disponibles
        String optionsDisponibles = "c: Permet d'effectuer des opérations sur les réservations de chambre\n";
        optionsDisponibles += "h: Affiche ce terminal d'aide\n";
        optionsDisponibles += "q: Quitte le programme\n";
        optionsDisponibles += "r: Permet de commander un repas";

        System.out.println(optionsDisponibles);

        Scanner scan = new Scanner(System.in);
        String choix = scan.next();

        while (true) {

            switch (choix) {

                // Réservation de chambre
                case "c":

                    // On effectue des opérations sur les réservations
                    try {
                        gestionHoteliere.gestionReserv(scan);
                    } catch (NoRoomAvailableException e) {
                        System.out.println(e.getMessage());
                    }

                    break;

                // Terminal d'aide
                case "h":
                    System.out.println("-------------------------------------");
                    System.out.println(optionsDisponibles);
                    System.out.println("-------------------------------------");

                    break;

                // On quitte le programme
                case "q":
                    System.out.println("\nAu revoir !\n");

                    // On enregistre dans un fichier texte l'ensemble des détails du client
                    // Données : prix chambre, nombre de repas consommé
                    gestionHoteliere.enregistrerFacture();

                    scan.close();

                    // On quitte le programme
                    System.exit(0);
                    break;

                // Terminal d'aide
                case "r":

                    // On effectue des opérations sur les repas
                    gestionHoteliere.gestionRepas(scan);

                    break;

                // Commande incorrecte
                default:
                    System.out.println("\nCommande incorrecte. Tapez h pour voir l'aide.\n");

                    break;

            } // switch

            System.out.println("\nQue souhaitez-vous faire ?");
            choix = scan.next();

        } // while

    } // GestionHoteliereConsole()

    public static void main(String[] args) {
        new GestionHoteliereConsole();
    } // main()

} // GestionHoteliereConsole
