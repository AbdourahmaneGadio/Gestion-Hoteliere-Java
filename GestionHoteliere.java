import java.util.LinkedList;
import java.util.Scanner;

public class GestionHoteliere {

    private LinkedList<Chambre> listeChambre = new LinkedList<Chambre>();
    private int facture = 0;

    public GestionHoteliere(int nombreChambres) {

        // On ajoute x nombre de chambres de chaque type
        for (int indiceChambre = 0; indiceChambre < nombreChambres; indiceChambre++) {

            // Pour chaque type de chambre
            for (TypeChambre typeChambre : TypeChambre.values()) {

                // Pour chaque type de lit
                for (TypeLit typeLit : TypeLit.values()) {
                    Chambre nouvelleChambre = new Chambre(typeLit, typeChambre);
                    listeChambre.add(nouvelleChambre);
                } // for TypeLit

            } // for TypeChambre
        }

    } // GestionHoteliere()

    public void detailsChambres() throws NoRoomAvailableException {
        int indiceChambre = 1;

        if (listeChambre.isEmpty()) {
            throw new NoRoomAvailableException("Aucune chambre n'est disponible");
        } else {
            for (Chambre chambre : listeChambre) {
                System.out.println("Chambre n°" + indiceChambre + " : " + chambre);
                indiceChambre++;
            }
        }

    }

    public void gestionReserv(Scanner scan) throws NoRoomAvailableException {

        System.out.println("RESERVATION DE CHAMBRE");

        System.out.println("\nChoisissez parmi ces 4 options :");
        System.out.println("\n1: Réserver une chambre");
        System.out.println("2: Modifier une réservation de chambre");
        System.out.println("3: Supprimer une réservation de chambre");
        System.out.println("4: Annuler une réservation");

        String choixReserv = scan.next();

        switch (choixReserv) {
            case "1":

                System.out.println("\nVoici les détails des chambres disponibles: \n");

                detailsChambres();

                System.out.println("\nQuelle chambre voulez-vous réserver ?");

                System.out.println("\nTapez le numéro de la chambre.");

                choixReserv = scan.next();

                // On réserve la chambre
                System.out.println("\nRéservation de la chambre " + choixReserv + " en cours...");

                int choixReservToInt = Integer.parseInt(choixReserv) - 1;

                Chambre chambreChoisie = removeChambreFromList(choixReservToInt);

                facture += chambreChoisie.getPrixChambre();

                break;
            case "2":
                System.out.println("\nQuelle réservation voulez-vous modifier ?");

                System.out.println("\nTapez le numéro de la réservation.");

                choixReserv = scan.next();

                // On modifie la réservation
                System.out.println("\nModification de la réservation " + choixReserv + " en cours...");

                break;
            case "3":

                System.out.println("\nQuelle réservation voulez-vous supprimer ?");

                System.out.println("\nTapez le numéro de la réservation.");

                choixReserv = scan.next();

                // On supprime la réservation
                System.out.println("\nSuppression de la réservation " + choixReserv + " en cours...");
                break;
            case "4":
                System.out.println("\nQuelle réservation voulez-vous annuler ?");

                System.out.println("\nTapez le numéro de la réservation.");

                choixReserv = scan.next();

                // On annule la réservation
                System.out.println("\nAnnulation de la réservation " + choixReserv + " en cours...");
                break;

            default:
                System.out.println("\nCommande incorrecte.");

                break;
        }

        System.out.println("\nVotre facture actuelle : " + facture);

    }

    public Chambre removeChambreFromList(int indiceChambre) {

        LinkedList<Chambre> listeChambreTmp = new LinkedList<Chambre>();

        int indice = 0;

        Chambre chambreChoisie = new Chambre(null, null);

        for (Chambre chambre : listeChambre) {
            if (indice == indiceChambre) {
                chambreChoisie = chambre;
            } else {
                listeChambreTmp.add(chambre);
            }

            indice++;
        }

        listeChambre = listeChambreTmp;

        return chambreChoisie;
    }

    public void gestionRepas(Scanner scan) {

        System.out.println("COMMANDE DE REPAS\n");

        System.out.println("Les types de repas disponibles sont les suivants :\n");

        int indice = 1;

        for (Repas repas : Repas.values()) {
            System.out.println("Choix " + indice + " - " + repas);
            indice++;
        }

        System.out.println("\nQuel type de repas voulez-vous commander ?");

        String choixRepas = scan.next();

        // -1, car le choix imposé commence à 1
        Repas repasChoisi = Repas.values()[Integer.parseInt(choixRepas) - 1];

        System.out.println("Vous avez choisi de prendre: '" + repasChoisi + "'");

        facture += repasChoisi.getPrixRepas();

        System.out.println("\nVotre facture actuelle : " + facture);

    } // gestionRepas()

} // GestionHoteliere
