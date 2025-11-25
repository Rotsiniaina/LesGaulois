package personnages;

import objets.Equipement;

public class Romain {

    private String nom;
    private int force;
    private Equipement[] equipements = new Equipement[2];
    private int nbEquipement = 0;

    public Romain(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public String getNom() {
        return nom;
    }

    public void parler(String texte) {
        System.out.println("Le romain " + nom + " : « " + texte + " »");
    }

    private boolean isInvariantVerified() {
        return force >= 0;
    }

    public void recevoirCoup(int forceCoup) {
        assert forceCoup > 0 : "Erreur : la force du coup doit être positive !";
        int ancienneForce = force;
        force -= forceCoup;
        if (force < 1) {
            force = 0;
            parler("J'abandonne !");
        } else {
            parler("Aïe");
        }
        assert force <= ancienneForce : "Erreur : la force du Romain n’a pas diminué après le coup !";
        assert isInvariantVerified() : "Erreur : invariant violé, la force est négative !";
    }

    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + nom + " est déjà bien protégé !");
                break;
            case 1:
                if (equipements[0] == equipement) {
                    System.out.println("Le soldat " + nom + " possède déjà un " + equipement + " !");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            case 0:
                ajouterEquipement(equipement);
                break;
            default:
                System.out.println("Erreur inattendue dans le nombre d’équipements !");
        }
    }

    private void ajouterEquipement(Equipement equipement) {
        equipements[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
    }

    @Override
    public String toString() {
        return nom;
    }

    public static void main(String[] args) {
        System.out.println(Equipement.CASQUE);
        System.out.println(Equipement.BOUCLIER);
        System.out.println();
    
        Romain minus = new Romain("Minus", 6);
    
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
    
        minus.recevoirCoup(3);
        minus.recevoirCoup(5);
    }

}
