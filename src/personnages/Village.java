package personnages;

public class Village {
    private String nom;
    private Gaulois chef;               // plus de classe Chef
    private Gaulois[] villageois;
    private int nbVillageois = 0;

    public Village(String nom, int nbVillageoisMax, Gaulois chef) {
        this.nom = nom;
        this.chef = chef;
        villageois = new Gaulois[nbVillageoisMax];
        chef.setVillage(this);
    }

    public String getNom() {
        return nom;
    }

    public Gaulois getChef() {
        return chef;
    }

    public void ajouterHabitant(Gaulois gaulois) {
        villageois[nbVillageois] = gaulois;
        gaulois.setVillage(this);
        nbVillageois++;
    }

    public Gaulois trouverHabitant(int numero) {
        return villageois[numero];
    }

    public void afficherVillageois() {
        System.out.println("Dans le village du chef " + chef.getNom() +
                           " se trouvent :");
        for (int i = 0; i < nbVillageois; i++) {
            System.out.println("- " + villageois[i].getNom());
        }
    }
}
