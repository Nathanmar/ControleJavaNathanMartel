import java.util.List;
import java.util.ArrayList;

public class GestionEmployes {
    private List<Employe> employes = new ArrayList<>();
    
    public GestionEmployes() {
        employes.add(new Employe("MA0001", "ALBERT", "NIELSON", "Directeur", 2000, 120000));
        employes.add(new Employe("MA0002", "MALIK", "YOAN", "Chef de service", 2001, 55000));
        employes.add(new Employe("MA0003", "VINCENT", "GOGH", "Informaticien", 2002, 40000));
        employes.add(new Employe("MA0004", "YOURI", "DODO", "Chef de service", 2003, 45000));
        employes.add(new Employe("MA0005", "NAEL", "MILES", "Informaticien", 2004, 45000));
        employes.add(new Employe("MA0006", "BOLAN", "KIKI", "Comptable", 2005, 45000));
        employes.add(new Employe("MA0007", "DOVER", "LOUIK", "Chef de service", 2006, 45000));
        employes.add(new Employe("MA0008", "KLIENS", "LYBE", "Informaticien", 2007, 35000));
        employes.add(new Employe("MA0009", "SIKA", "NIYLE", "Informaticien", 2008, 35000));
        employes.add(new Employe("MA0010", "JEAN", "DE DIEU", "Manager", 2009, 60000));
        employes.add(new Employe("MA0011", "DIANE", "SHUR", "CTO", 2010, 70000));
    }

    public void afficherEmployes() {
        employes.forEach(System.out::println);
    }

    public Employe rechercherParMatricule(String matricule) {
        return employes.stream().filter(e -> e.matricule.equals(matricule)).findFirst().orElse(null);
    }

    public void afficherParAnnee(int annee) {
        employes.stream().filter(e -> e.anneeDebut == annee).forEach(System.out::println);
    }

    public double calculerMasseSalariale() {
        return employes.stream().mapToDouble(e -> e.salaire).sum();
    }

    public void afficherAncienEmploye() {
        Employe ancien = employes.stream().min((e1, e2) -> Integer.compare(e1.anneeDebut, e2.anneeDebut)).orElse(null);
        System.out.println(ancien);
    }

    public void afficherSalaireMinMax() {
        Employe minSalaire = employes.stream().min((e1, e2) -> Double.compare(e1.salaire, e2.salaire)).orElse(null);
        Employe maxSalaire = employes.stream().max((e1, e2) -> Double.compare(e1.salaire, e2.salaire)).orElse(null);
        System.out.println("Plus petit salaire: " + minSalaire);
        System.out.println("Plus grand salaire: " + maxSalaire);
    }

    public void ajouterPrime(double montant) {
        employes.stream().max((e1, e2) -> Double.compare(e1.salaire, e2.salaire)).ifPresent(e -> e.salaire += montant);
    }

    public void afficherChefsService() {
        employes.stream().filter(e -> e.poste.equals("Chef de service")).forEach(System.out::println);
    }

    public void afficherEmployesAvant(int annee) {
        employes.stream().filter(e -> (2020 - e.anneeDebut) > 5 && e.salaire >= 60000 && e.salaire <= 150000).forEach(System.out::println);
    }

    public static void main(String[] args) {
        GestionEmployes gestion = new GestionEmployes();
        gestion.afficherEmployes();
        System.out.println("--- Recherche Employé par Matricule (MA0007) ---");
        System.out.println(gestion.rechercherParMatricule("MA0007"));
        System.out.println("--- Affichage des employés ayant commencé en 2008 ---");
        gestion.afficherParAnnee(2008);
        System.out.println("--- Masse salariale totale ---");
        System.out.println(gestion.calculerMasseSalariale());
        System.out.println("--- Employé le plus ancien ---");
        gestion.afficherAncienEmploye();
        System.out.println("--- Salaire min et max ---");
        gestion.afficherSalaireMinMax();
        System.out.println("--- Ajout de prime de 550 au plus haut salaire ---");
        gestion.ajouterPrime(550);
        gestion.afficherEmployes();
        System.out.println("--- Liste des chefs de service ---");
        gestion.afficherChefsService();
        System.out.println("--- Employés avec plus de 5 ans d'ancienneté et salaire entre 60k et 150k ---");
        gestion.afficherEmployesAvant(2020);
    }
}
