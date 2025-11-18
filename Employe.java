import java.util.ArrayList;
import java.util.List;

public abstract class Employe {
    private String nom;
    private String prenom;
    private int age;
    private String adresse;

    public Employe(String nom, String prenom, int age, String adresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.adresse = adresse;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getAdresse() {
        return adresse;
    }
    
    public void afficherInfos() {
        System.out.println("Nom: " + nom);
        System.out.println("Prenom: " + prenom);
        System.out.println("Age: " + age);
        System.out.println("Adresse: " + adresse);
    }

    @Override
    public String toString() {
        return "Employe{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", adresse='" + adresse + '\'' +
                '}';
    }

    public abstract double calculerSalaire();
}

class EmployeSalarie extends Employe {
    private double salaireMensuel;

    public EmployeSalarie(String nom, String prenom, int age, String adresse, double salaireMensuel) {
        super(nom, prenom, age, adresse);
        this.salaireMensuel = salaireMensuel;
    }
    
    public double getSalaireMensuel() {
        return salaireMensuel;
    }

    @Override
    public double calculerSalaire() {
        return salaireMensuel;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", type=Salarié, salaireMensuel=" + salaireMensuel + "€";
    }
}

class EmployeHoraire extends Employe {
    private double tauxHoraire;
    private int heuresTravaillees;
    
    public EmployeHoraire(String nom, String prenom, int age, String adresse, double tauxHoraire, int heuresTravaillees) {
        super(nom, prenom, age, adresse);
        this.tauxHoraire = tauxHoraire;
        this.heuresTravaillees = heuresTravaillees;
    }
    
    public double getTauxHoraire() {
        return tauxHoraire;
    }
    
    public int getHeuresTravaillees() {
        return heuresTravaillees;
    }
    
    @Override
    public double calculerSalaire() {
        return heuresTravaillees * tauxHoraire;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", type=Horaire, tauxHoraire=" + tauxHoraire + 
               "€/h, heuresTravaillees=" + heuresTravaillees + "h";
    }
}

class EmployeFreelance extends Employe {
    private double montantParProjet;
    private int nombreProjets;
    
    public EmployeFreelance(String nom, String prenom, int age, String adresse, double montantParProjet, int nombreProjets) {
        super(nom, prenom, age, adresse);
        this.montantParProjet = montantParProjet;
        this.nombreProjets = nombreProjets;
    }
    
    public double getMontantParProjet() {
        return montantParProjet;
    }
    
    public int getNombreProjets() {
        return nombreProjets;
    }
    
    @Override
    public double calculerSalaire() {
        return montantParProjet * nombreProjets;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", type=Freelance, montantParProjet=" + montantParProjet + 
               "€, nombreProjets=" + nombreProjets;
    }
}

class Stagiaire extends Employe {
    private double gratificationMensuelle;
    private int dureeStage;
    
    public Stagiaire(String nom, String prenom, int age, String adresse, double gratificationMensuelle, int dureeStage) {
        super(nom, prenom, age, adresse);
        this.gratificationMensuelle = gratificationMensuelle;
        this.dureeStage = dureeStage;
    }
    
    public double getGratificationMensuelle() {
        return gratificationMensuelle;
    }
    
    public int getDureeStage() {
        return dureeStage;
    }
    
    @Override
    public double calculerSalaire() {
        return gratificationMensuelle * dureeStage;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", type=Stagiaire, gratificationMensuelle=" + gratificationMensuelle + 
               "€, dureeStage=" + dureeStage + " mois";
    }
}

class Main {
    public static void main(String[] args) {
        List<Employe> employes = new ArrayList<>();
        
        employes.add(new EmployeSalarie("Doe", "John", 35, "123 Rue de Paris", 3500.0));
        employes.add(new EmployeHoraire("Doe", "Jane", 42, "125 Rue de Paris", 25.0, 160));
        employes.add(new Stagiaire("Doe2", "John", 28, "124 Rue de Paris", 4200.0, 6));
        employes.add(new EmployeFreelance("Doe2", "Jane", 31, "126 Rue de Paris", 30.0, 3));
        
        for (Employe employe : employes) {
            employe.afficherInfos();
            
            System.out.println("Salaire: " + employe.calculerSalaire() + " euros");
            System.out.println("");
        }
    }
}
