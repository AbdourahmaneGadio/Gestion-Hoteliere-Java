public enum TypeChambre {

    NORMAL("NORMAL", 10),LUXE("LUXE", 25);

    private String typeChambre;
    private int prixChambre;

    private TypeChambre(String typeChambre, int prixChambre){
        this.typeChambre = typeChambre;
        this.prixChambre = prixChambre;
    } // TypeChambre()

    public String getTypeChambre(){
        return typeChambre;
    }  

        public int getPrixChambre(){
        return prixChambre;
    }  
    
} // TypeChambre
