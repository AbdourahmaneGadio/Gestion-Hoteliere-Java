import java.util.LinkedList;

public class ListeChambre {

    private LinkedList<Chambre> listeChambreDispoNormalSimple = new LinkedList<Chambre>();
    private LinkedList<Chambre> listeChambreDispoNormalDouble = new LinkedList<Chambre>();
    private LinkedList<Chambre> listeChambreDispoLuxeSimple = new LinkedList<Chambre>();
    private LinkedList<Chambre> listeChambreDispoLuxeDouble = new LinkedList<Chambre>();

    public ListeChambre(int nombreChambre) {

        // Pour le nombre de chambre disponible
        for (int indice = 0; indice < nombreChambre; indice++) {

            // Pour chaque type de chambre
            for (TypeChambre typeChambre : TypeChambre.values()) {

                // Pour chaque type de lit
                for (TypeLit typeLit : TypeLit.values()) {

                    Chambre chambre = new Chambre(typeChambre, typeLit);

                    if (typeChambre == TypeChambre.NORMAL) {
                        if (typeLit == TypeLit.SIMPLE) {
                            listeChambreDispoNormalSimple.add(chambre);
                        }
                        if (typeLit == TypeLit.DOUBLE) {
                            listeChambreDispoNormalDouble.add(chambre);

                        }
                    }

                    else {
                        if (typeChambre == TypeChambre.LUXE) {
                            if (typeLit == TypeLit.SIMPLE) {
                                listeChambreDispoLuxeSimple.add(chambre);
                            }
                            if (typeLit == TypeLit.DOUBLE) {
                                listeChambreDispoLuxeDouble.add(chambre);

                            }
                        }
                    }

                }

            }

        }

    } // ListeChambre()

    public String getNombreChambreDispo() {
        String phrase = "Voici le nombre de chambres disponibles.\n";

        for (TypeChambre typeChambre : TypeChambre.values()) {
            phrase += "\nChambre " + typeChambre + "\n";

            for (TypeLit typeLit : TypeLit.values()) {
                            phrase += "Nombre de lits " + typeLit + " : ";

                           if (typeChambre == TypeChambre.NORMAL) {
                        if (typeLit == TypeLit.SIMPLE) {
                          phrase+=  listeChambreDispoNormalSimple.size() + "\n";
                        }
                        if (typeLit == TypeLit.DOUBLE) {
                           phrase+=    listeChambreDispoNormalDouble.size() + "\n";

                        }
                    }

                    else {
                        if (typeChambre == TypeChambre.LUXE) {
                            if (typeLit == TypeLit.SIMPLE) {
                              phrase+=     listeChambreDispoLuxeSimple.size() + "\n";
                            }
                            if (typeLit == TypeLit.DOUBLE) {
                                 phrase+=  listeChambreDispoLuxeDouble.size() + "\n";

                            }
                        }
                    }

            }
        }

        return phrase;
    }

    public Chambre chambreAvailable(Chambre chambreRecherche) throws NoRoomAvailableException {

        Chambre chambreTrouve = new Chambre(null, null);

        if (chambreRecherche.getTypeChambre() == TypeChambre.NORMAL.toString()) {
            if (chambreRecherche.getTypeLit() == TypeLit.SIMPLE.toString()) {
                if (!listeChambreDispoNormalSimple.isEmpty()) {
                    chambreTrouve = listeChambreDispoNormalSimple.pollFirst();
                }
                else{
                    throw new NoRoomAvailableException("Ce type de chambre n'est plus dispo");
                }
                ;
            }
            if (chambreRecherche.getTypeLit() == TypeLit.DOUBLE.toString()) {
                if (!listeChambreDispoNormalDouble.isEmpty()) {
                    chambreTrouve = listeChambreDispoNormalDouble.pollFirst();
                }
                ;
            }
        } else if (chambreRecherche.getTypeChambre() == TypeChambre.LUXE.toString()) {
            if (chambreRecherche.getTypeLit() == TypeLit.SIMPLE.toString()) {
                if (!listeChambreDispoLuxeSimple.isEmpty()) {
                    chambreTrouve = listeChambreDispoLuxeSimple.pollFirst();
                }
                ;
            }
            if (chambreRecherche.getTypeLit() == TypeLit.DOUBLE.toString()) {
                if (!listeChambreDispoLuxeSimple.isEmpty()) {
                    chambreTrouve = listeChambreDispoLuxeDouble.pollFirst();
                }
                ;
            }
        }

        return chambreTrouve;

    } // ChambreAvailable()

} // ListeChambre
