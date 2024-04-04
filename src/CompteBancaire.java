public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String nomTitulaire;

    public CompteBancaire(String numeroCompte, double solde, String nomTitulaire) {
        this.numeroCompte = numeroCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    public void deposerArgent(double montant) {
        solde += montant;
    }

    public void retirerArgent(double montant) throws FondsInsuffisantsException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants sur le compte " + numeroCompte);
        }
        solde -= montant;
    }

    public double getSolde() {
        return solde;
    }

    public void transfertArgent(CompteBancaire autreCompte, double montant) throws FondsInsuffisantsException, CompteInexistantException {
        if (montant > solde) {
            throw new FondsInsuffisantsException("Fonds insuffisants sur le compte " + numeroCompte);
        }
        if (autreCompte == null) {
            throw new CompteInexistantException("Le compte destinataire n'existe pas");
        }
        solde -= montant;
        autreCompte.deposerArgent(montant);
    }

    // Autres méthodes et accesseurs éventuels...
}
