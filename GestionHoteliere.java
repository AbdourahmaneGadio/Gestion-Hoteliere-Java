import java.util.LinkedList;

public class GestionHoteliere {

    LinkedList<Chambre> listeChambre = new LinkedList<Chambre>();

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

    public void detailsChambres() {
        int indiceChambre = 1;
        for (Chambre chambre : listeChambre) {
            System.out.println("Chambre n°" + indiceChambre + " : " + chambre);
            indiceChambre++;
        }
    }

    public void EnregistrerFacture() {

    } // EnregistrerFacture()

} // GestionHoteliere
