public enum Chambre {

    NORMAL_SIMPLE("normal", "simple"), 
    NORMAL_DOUBLE("normal", "double"),
    LUXE_SIMPLE("luxe", "simple"),
    LUXE_DOUBLE("luxe", "double");

   private String typeChambre;
    private String typeLit;

   private Chambre(String typeChambre, String typeLit){
    this.typeChambre = typeChambre;
        this.typeLit = typeLit;
   } // Chambre()

public String getTypeChambre(){
    return typeChambre;
} // getTypeChambre()

   public String getTypeLit(){
    return typeLit;
   } // getTypeLit()
    
} // Chambre
