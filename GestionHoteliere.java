public class GestionHoteliere {

   private ListeChambre listeChambre;

    public GestionHoteliere() {
        this.listeChambre = new ListeChambre(2);
    }

    public Chambre getChambreDispo(Chambre chambre) throws NoRoomAvailableException {
        return listeChambre.chambreAvailable(chambre);
    }

    public void chambreDispoDetails(){
       System.out.println(listeChambre.getNombreChambreDispo()) ;
    }

}
