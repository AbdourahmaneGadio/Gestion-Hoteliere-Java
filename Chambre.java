import java.io.Serializable;

public class Chambre implements Serializable{

    private TypeLit typeLit;
    private TypeChambre typeChambre;

    public Chambre(TypeLit typeLit, TypeChambre typeChambre){
        this.typeLit = typeLit;
        this.typeChambre = typeChambre;
    };

    public String toString(){
        return typeChambre + " avec Lit " + typeLit + " - Prix : " + getPrixChambre();
    }

    public int getPrixChambre(){
        return typeChambre.getPrixChambre() + typeLit.getPrixLit();
    }
    
}
