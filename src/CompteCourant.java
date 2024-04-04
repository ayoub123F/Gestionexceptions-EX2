public class CompteCourant extends CompteBancaire {
    private double decouvertAutorise;

    public CompteCourant(String numeroCompte, double solde, String nomTitulaire, double decouvertAutorise) {
        super(numeroCompte, solde, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    // Méthode spécifique pour autoriser un découvert
    public void autoriserDecouvert(double montant) {
        decouvertAutorise += montant;
    }

    // Méthode pour effectuer un découvert
    public void faireDecouvert(double montant) throws FondsInsuffisantsException {
        if (montant > getSolde() + decouvertAutorise) {
            throw new FondsInsuffisantsException("Opération non autorisée : fonds insuffisants et découvert non autorisé");
        }
        retirerArgent(montant);
    }
}
