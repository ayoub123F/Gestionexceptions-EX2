public class CompteEpargne extends CompteBancaire {
    private double tauxInteret;

    public CompteEpargne(String numeroCompte, double solde, String nomTitulaire, double tauxInteret) {
        super(numeroCompte, solde, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    // Méthode pour calculer les intérêts
    public void calculerInterets() {
        double interets = getSolde() * tauxInteret / 100;
        deposerArgent(interets);
    }
}
