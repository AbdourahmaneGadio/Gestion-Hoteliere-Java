public enum Repas {

    PETIT_DEJ("Petit déjeuner", 5), DEJ("Déjeuner", 15), DINER("Dîner", 20);

    private String repas;
    private int prixRepas;

    private Repas(String repas, int prixRepas) {
        this.repas = repas;
        this.prixRepas = prixRepas;
    }

    public String toString() {
        return repas + ": " + prixRepas + "€";
    }

    public int getPrixRepas(){
        return prixRepas;
    }

}
