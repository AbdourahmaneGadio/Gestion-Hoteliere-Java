public class Chambre {

    private TypeLit typeLit;
    private TypeChambre typeChambre;

    public Chambre(TypeLit typeLit, TypeChambre typeChambre){
        this.typeLit = typeLit;
        this.typeChambre = typeChambre;
    };

    public String toString(){
        return typeChambre + " avec Lit " + typeLit;
    }
    
}
