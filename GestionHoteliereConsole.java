import java.util.Scanner;

public class GestionHoteliereConsole {

    public GestionHoteliereConsole() {

        System.out.println("\nBienvenue dans nôtre hôtel !");

        GestionHoteliere gestionHoteliere = new GestionHoteliere(1);

        System.out.println("\nQue souhaitez-vous faire ? Tapez une des commandes ci-dessous.\n");

        // Liste des options disponibles
        String optionsDisponibles = "c: Permet de réserver une chambre\n";
        optionsDisponibles+= "h: Affiche ce terminal d'aide\n";
        optionsDisponibles+="q: Quitte le programme\n";
        optionsDisponibles+= "r: Permet de commander un repas";

        System.out.println(optionsDisponibles);

        Scanner scan = new Scanner(System.in);
        String choix = scan.next();

        while (true) {

            switch (choix) {

                // Réservation de chambre
                case "c":
                    System.out.println("RESERVATION DE CHAMBRE");
                    System.out.println("\nVoici les détails des chambres disponibles: \n");
                    gestionHoteliere.detailsChambres();

                    System.out.println("\nQuelle chambre voulez-vous réserver ?");
                    System.out.println("\nTapez le numéro de la chambre.");

                    choix = scan.next();

                    // On réserve la chambre
                    System.out.println("\nRéservation de la chambre " + choix + " en cours...");

                    // ...
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
                    scan.close();

                    // On enregistre dans un fichier texte l'ensemble des détails du client
                    // Données : prix chambre, nombre de repas consommé

                    System.exit(0);
                    break;

                         // Terminal d'aide
                case "r":
                    System.out.println("COMMANDE DE REPAS");
             
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
    }

} // GestionHoteliereConsole
