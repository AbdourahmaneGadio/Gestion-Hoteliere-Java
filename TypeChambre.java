public enum TypeChambre {

    NORMAL("normal"), 
    LUXE("luxe");

    private String typeChambre;

    private TypeChambre(String typeChambre){
        this.typeChambre = typeChambre;
    }

    public String getTypeChambre(){
        return typeChambre;
    }

}
