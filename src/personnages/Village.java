package personnages;

public class Village {
    private String nom;
    private Gaulois chef;
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

    public void ajouterVillageois(Gaulois gaulois) {
        if (nbVillageois < villageois.length) {
            villageois[nbVillageois] = gaulois;
            gaulois.setVillage(this);
            nbVillageois++;
        }
    }

    public Gaulois trouverVillageois(int num) {
        if (num > 0 && num <= nbVillageois) {
            return villageois[num - 1];
        } else {
            System.out.println("Il n'y a pas autant d'habitants dans notre village !");
            return null;
        }
    }

    public void afficherVillageois() {
        System.out.println("Dans le village \"" + nom + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois :");
        for (int i = 0; i < nbVillageois; i++) {
            System.out.println("- " + villageois[i].getNom());
        }
    }

    public static void main(String[] args) {
        Gaulois abraracourcix = new Gaulois("Abraracourcix", 6);
        Village village = new Village("Village des Irréductibles", 30, abraracourcix);
        Gaulois gauloisTest = village.trouverVillageois(30);
        System.out.println(gauloisTest);
    
        Gaulois asterix = new Gaulois("Astérix", 8);
        village.ajouterVillageois(asterix);
    
        Gaulois gaulois1 = village.trouverVillageois(1);
        System.out.println(gaulois1);
        Gaulois gaulois2 = village.trouverVillageois(2);
        System.out.println(gaulois2);
    
        village.afficherVillageois();
    
        Gaulois obelix = new Gaulois("Obélix", 25);
        village.ajouterVillageois(obelix);
    
        Gaulois doublePolemix = new Gaulois("DoublePolémix", 4);
    
        abraracourcix.sePresenter();
        asterix.sePresenter();
        doublePolemix.sePresenter();
    }

}
