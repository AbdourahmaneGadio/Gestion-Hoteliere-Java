public enum TypeLit {

    SIMPLE("simple"), 
    DOUBLE("double");

    private String typeLit;

    private TypeLit(String typeLit){
        this.typeLit = typeLit;
    }

    public String getTypeLit(){
        return typeLit;
    }

}
