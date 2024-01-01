public enum TypeLit {

    SIMPLE("simple", 5), DOUBLE("double", 10);

    private String typeLit;
    private int prixLit;

    private TypeLit(String typeLit, int prixLit) {
        this.typeLit = typeLit;
        this.prixLit = prixLit;
    }

    public String getTypeLit() {
        return typeLit;
    }

    public int getPrixLit(){
        return prixLit;
    }

}
