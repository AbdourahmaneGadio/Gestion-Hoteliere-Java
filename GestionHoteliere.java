import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class GestionHoteliere {

    private LinkedList<Chambre> listeChambre = new LinkedList<Chambre>();
    private LinkedList<Chambre> listeChambrePrises = new LinkedList<Chambre>();

    private int facture = 0;
    private String filenameFacture = "donneesClient.txt";
    private String filenameChambre = "donneesChambre.txt";

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

        // On récupère la facture enregistrée
        recupererFacture();

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

            // Réservation de chambre
            case "1":

                System.out.println("\nVoici les détails des chambres disponibles: \n");

                detailsChambres();

                System.out.println("\nQuelle chambre voulez-vous réserver ?");

                System.out.println("\nTapez le numéro de la chambre.");

                choixReserv = scan.next();
                int choixReservToInt = Integer.parseInt(choixReserv);

                while (choixReservToInt > listeChambre.size() || choixReservToInt <= 0) {
                    System.out.println("Choix incorrect. Veuillez saisir une bonne valeur.");

                    choixReserv = scan.next();
                    choixReservToInt = Integer.parseInt(choixReserv);
                }

                choixReservToInt -= 1; // On enlève 1, car le 1er indice du tableau commence à 0

                // On réserve la chambre
                System.out.println("\nRéservation de la chambre " + choixReserv + " en cours...");

                ajoutReservation(choixReservToInt);

                break;

            // Modification de réservation
            case "2":

                showReservation();

                System.out.println("\nQuelle réservation voulez-vous modifier ?");

                System.out.println("\nTapez le numéro de la réservation.");

                choixReserv = scan.next();
                choixReservToInt = Integer.parseInt(choixReserv);

                while (choixReservToInt > listeChambrePrises.size() || choixReservToInt <= 0) {
                    System.out.println("Choix incorrect. Veuillez saisir une bonne valeur.");

                    choixReserv = scan.next();
                    choixReservToInt = Integer.parseInt(choixReserv);
                }

                choixReservToInt -= 1; // On enlève 1, car le 1er indice du tableau commence à 0

                // Choix de la chambre à remplacer

                System.out.println("\nPar quelle chambre voulez-vous la remplacer ?");

                detailsChambres();

                String choixChambreRemplace = scan.next();
                int choixChambreRemplaceToInt = Integer.parseInt(choixChambreRemplace);

                while (choixChambreRemplaceToInt > listeChambre.size() || choixChambreRemplaceToInt <= 0) {
                    System.out.println("Choix incorrect. Veuillez saisir une bonne valeur.");

                    choixChambreRemplace = scan.next();
                    choixChambreRemplaceToInt = Integer.parseInt(choixChambreRemplace);
                }

                choixChambreRemplaceToInt -= 1; // On enlève 1, car le 1er indice du tableau commence à 0

                modifReservation(choixReservToInt,choixChambreRemplaceToInt);

                break;
            case "3":
                showReservation();

                System.out.println("\nQuelle réservation voulez-vous supprimer ?");

                System.out.println("\nTapez le numéro de la réservation.");

                choixReserv = scan.next();

                // On supprime la réservation
                System.out.println("\nSuppression de la réservation " + choixReserv + " en cours...");

                choixReservToInt = Integer.parseInt(choixReserv);

                while (choixReservToInt > listeChambrePrises.size() || choixReservToInt <= 0) {
                    System.out.println("Choix incorrect. Veuillez saisir une bonne valeur.");

                    choixReserv = scan.next();
                    choixReservToInt = Integer.parseInt(choixReserv);
                }

                choixReservToInt -= 1; // On enlève 1, car le 1er indice du tableau commence à 0
                break;

            case "4":
                showReservation();
                System.out.println("\nQuelle réservation voulez-vous annuler ?");

                System.out.println("\nTapez le numéro de la réservation.");

                choixReserv = scan.next();
                choixReservToInt = Integer.parseInt(choixReserv);

                while (choixReservToInt > listeChambrePrises.size() || choixReservToInt <= 0) {
                    System.out.println("Choix incorrect. Veuillez saisir une bonne valeur.");

                    choixReserv = scan.next();
                    choixReservToInt = Integer.parseInt(choixReserv);
                }

                choixReservToInt -= 1; // On enlève 1, car le 1er indice du tableau commence à 0

                // On annule la réservation
                System.out.println("\nAnnulation de la réservation " + choixReserv + " en cours...");

                // On réajoute la chambre réservée, dans la liste des chambres disponibles
                annulerReservation(choixReservToInt);

                break;

            default:
                System.out.println("\nCommande incorrecte.");

                break;
        }

        System.out.println("\nVotre facture actuelle : " + facture);

    }

    public void ajoutReservation(int indiceChambre) {

        LinkedList<Chambre> listeChambreTmp = new LinkedList<Chambre>();

        int indice = 0;

        Chambre chambreChoisie = new Chambre(null, null);

        for (Chambre chambre : listeChambre) {
            if (indice == indiceChambre) {
                chambreChoisie = chambre;
                listeChambrePrises.add(chambre);
            } else {
                listeChambreTmp.add(chambre);
            }

            indice++;
        }

        listeChambre = listeChambreTmp;

        facture += chambreChoisie.getPrixChambre();
    }

    public void showReservation() throws NoRoomAvailableException {
        if (listeChambrePrises.isEmpty()) {
            throw new NoRoomAvailableException("Aucune chambre n'a été réservée");
        } else {
            System.out.println("Voici les chambres que vous avez réservées:\n");
            int indiceChambre = 1;

            for (Chambre chambre : listeChambrePrises) {
                System.out.println(indiceChambre + " : " + chambre);
                indiceChambre++;
            }
        }
    } // showReservation()

    public void annulerReservation(int indiceChambre) {

        LinkedList<Chambre> listeChambreTmp = new LinkedList<Chambre>();

        Chambre chambreChoisie = new Chambre(null, null);
        int indice = 0;
        for (Chambre chambre : listeChambrePrises) {
            if (indice == indiceChambre) {
                chambreChoisie = chambre;

                // On retire de la facture la chambre annulée
                facture -= chambreChoisie.getPrixChambre();
            } else {
                listeChambreTmp.add(chambre);
            }

            indice++;
        }

        listeChambrePrises = listeChambreTmp;

        listeChambre.add(chambreChoisie);

    } // annulerReservation()

    public void modifReservation(int indiceReservation, int indiceChambre) {

        System.out.println("Indice réserv : " + indiceReservation);
        System.out.println("Indice chambre : " + indiceChambre);

        LinkedList<Chambre> listeChambreTmp = new LinkedList<Chambre>();
        LinkedList<Chambre> listeChambreReservTmp = new LinkedList<Chambre>();

        int indiceBoucleReserv = 0;
 int indiceBoucleDispo = 0;

        // La liste des réservations
        for (Chambre chambre : listeChambrePrises) {

            // Si on n'est pas sur la bonne réservation à changer
            if (indiceBoucleReserv != indiceReservation) {
                listeChambreReservTmp.add(chambre);
            }

            // On a trouvé la bonne réservation
            else{
                         // On retire de la facture l'ancienne chambre chosie
                facture -= chambre.getPrixChambre();
            }
            indiceBoucleReserv++;
        }

        listeChambrePrises = listeChambreReservTmp;

        // On remplace la chambre LUXE DOUBLE, par LUXE SIMPLE

        for (Chambre chambre2 : listeChambre) {

            // Si on n'est pas sur la chambre à remplacer
            if (indiceBoucleDispo == indiceChambre) {
                                listeChambreTmp.add(chambre2);

            
            } 
            
            // Si on a trouvé la chambre à remplacer
            else {
                    listeChambreReservTmp.add(chambre2);

                // On ajoute à la facture le prix de la nouvelle chambre
                facture+=chambre2.getPrixChambre();
            }
            indiceBoucleDispo++;
        }

        // Résultat attendu dans chambres dispo : 3 chambres

        listeChambrePrises = listeChambreReservTmp;
        listeChambre = listeChambreTmp;

    } // modifReservation()

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

        int choixRepasToInt = Integer.parseInt(choixRepas);

        while (choixRepasToInt < 0 || choixRepasToInt > 3) {
            System.out.println("\nChoix incorrect.");

            System.out.println("\nQuel type de repas voulez-vous commander ?");

            choixRepas = scan.next();

            choixRepasToInt = Integer.parseInt(choixRepas);
        }

        // -1, car le choix imposé commence à 1
        Repas repasChoisi = Repas.values()[choixRepasToInt - 1];

        System.out.println("Vous avez choisi de prendre: '" + repasChoisi + "'");

        facture += repasChoisi.getPrixRepas();

        System.out.println("\nVotre facture actuelle : " + facture);

    } // gestionRepas()

    public void recupererFacture() {
        // Deserialization
        try {
            // On lit les données du fichier
            FileInputStream file = new FileInputStream(filenameFacture);
            ObjectInputStream in = new ObjectInputStream(file);

            FileInputStream fileChambre = new FileInputStream(filenameChambre);
            ObjectInputStream inChambre = new ObjectInputStream(fileChambre);

            // On attribute la valeur de la facture
            try {
                facture = (int) in.readObject();

                // while (true) {
                // listeChambre.add((Chambre) inChambre.readObject());
                // }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // On ferme le fichier
            in.close();
            file.close();

            inChambre.close();
            fileChambre.close();

        }

        catch (IOException ex) {
            System.out.println("Problème lecture facture");
        }
    } // recupererFacture()

    public void enregistrerFacture() {
        // Serialization
        try {
            // On ouvre un fichier
            FileOutputStream file = new FileOutputStream(filenameFacture);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // On écrit dans le fichier
            out.writeObject(facture);

            out.close();
            file.close();

            FileOutputStream fileChambre = new FileOutputStream(filenameChambre);
            ObjectOutputStream outChambre = new ObjectOutputStream(fileChambre);

            // outChambre.writeObject(listeChambre);

            outChambre.close();
            fileChambre.close();

        }

        catch (IOException ex) {
            System.out.println("Problème enregistrement facture");
        }
    } // enregistrerFacture()

} // GestionHoteliere
