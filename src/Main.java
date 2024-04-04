import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<CompteBancaire> comptes = new ArrayList<>();

        // Ajouter des comptes
        CompteBancaire compte1 = new CompteBancaire("123456", 1000.0, "Alice");
        CompteBancaire compte2 = new CompteBancaire("789012", 2000.0, "Bob");
        comptes.add(compte1);
        comptes.add(compte2);

        // Effectuer des opérations sur les comptes
        try {
            compte1.deposerArgent(500.0);
            compte2.retirerArgent(300.0);
            compte1.transfertArgent(compte2, 200.0);
        } catch (FondsInsuffisantsException e) {
            System.out.println("Erreur: " + e.getMessage());
        } catch (CompteInexistantException e) {
            System.out.println("Erreur: " + e.getMessage());
        }

        // Affichage des soldes des comptes
        for (CompteBancaire compte : comptes) {
            // Utilisez getSolde() à la place de getNumeroCompte()
            System.out.println("Solde du compte : " + compte.getSolde());
        }
    }
}
