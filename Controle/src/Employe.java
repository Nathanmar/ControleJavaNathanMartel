

public class Employe {
    String matricule;
    String nom;
    String prenom;
    String poste;
    int anneeDebut;
    double salaire;

    public Employe(String matricule, String nom, String prenom, String poste, int anneeDebut, double salaire) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.anneeDebut = anneeDebut;
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return matricule + " - " + nom + " " + prenom + " - " + poste + " - " + anneeDebut + " - " + salaire;
    }
}