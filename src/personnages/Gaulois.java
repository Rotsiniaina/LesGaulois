package personnages;

public class Gaulois {
    private String nom;
    private int force;
    private Village village; // peut être null si pas encore dans un village

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public void parler(String texte) {
        System.out.println(prendreParole() + "« " + texte + " »");
    }

    private String prendreParole() {
        return "Le gaulois " + nom + " : ";
    }

    public void frapper(Romain romain) {
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        romain.recevoirCoup(force / 3);
    }

    public void sePresenter() {
        System.out.print("Le Gaulois " + nom + " : ");

        if (village != null) {
            System.out.println("\"Bonjour, je m'appelle " + nom +
                               ". J'habite le village " + village.getNom() + ".\"");
        } else {
            System.out.println("\"Bonjour, je m'appelle " + nom +
                               ". Je voyage de villages en villages.\"");
        }
    }
}
