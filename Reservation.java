import java.io.File; // Permet de créer un fichier
import java.io.FileWriter; // Permet de lire/écrire dans un fichier
import java.io.IOException; // Exception si le fichier n'existe pas

public class Reservation {

    

    public Reservation() {
    }

    public void ajoutReserv(Chambre chambre, String nomClient) throws NoRoomAvailableException {
            try {

                // On crée le fichier dans lequel on sauvegarde toutes les données
                File myObj = new File("donneesClient.txt");
                myObj.createNewFile();

                // On ouvre le fichier en écriture
                FileWriter myWriter = new FileWriter("donneesClient.txt", true); // True pour garder les informations
                                                                            // précédentes
                myWriter.write(nomClient + " : " + chambre + "\n");
                myWriter.close();

                System.out.println("\nRéservation effectuée avec succès !\n");
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        

    } // ajoutReserv()

    public void modifReserv() {

    } // modifReserv()

    public void supprimerReserv() {

    } // supprimerReserv()

    public void annulationReserv() {

    } // annulationReserv()

}
