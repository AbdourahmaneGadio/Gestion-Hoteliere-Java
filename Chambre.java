public class Chambre {

   private TypeChambre typeChambre;
  private TypeLit typeLit;

   public Chambre(TypeChambre typeChambre, TypeLit typeLit){
    this.typeChambre = typeChambre;
    this.typeLit = typeLit;
   } // Chambre()

    public String getTypeChambre(){
        return typeChambre.toString();
    } // getTypeChambre()

    public String getTypeLit(){
        return typeLit.toString();
    } // getTypeLit()

    public String toString(){
        return "Chambre " + getTypeChambre() + " avec un lit " + getTypeLit();
    }
    
} // Chambre
