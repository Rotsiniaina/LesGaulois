package personnages;

import objets.Equipement;

public class Gaulois {
    private String nom;
    private int force;
    private int effetPotion = 1;
    private Village village;

    public Gaulois(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    public Village getVillage() {
        return village;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println("Le gaulois " + nom + " : « " + texte + " »");
    }

    public void frapper(Romain romain) {
        int forceCoup = (force * effetPotion) / 3;
        System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
        romain.recevoirCoup(forceCoup);
        if (effetPotion > 1)
            effetPotion--;
    }

    public void boirePotion(int forcePotion) {
        effetPotion = forcePotion;
    }

    public void sePresenter() {
        System.out.print("Le Gaulois " + nom + " : ");
        if (village != null) {
            System.out.println("\"Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".\"");
        } else {
            System.out.println("\"Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.\"");
        }
    }

    @Override
    public String toString() {
        return nom;
    }
}
