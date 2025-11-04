package personnages;

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

	@Override
	public String toString() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	private boolean isInvariantVerified() {
		return force >= 0;
	}

	public void recevoirCoup(int forceCoup) {
		assert forceCoup > 0 : "Erreur : la force du coup doit être positive !";
		int ancienneForce = force; // pour la postcondition

		force -= forceCoup;
		if (force < 1) {
			force = 0;
			parler("J'abandonne !");
		} else {
			parler("Aïe");
		}

		// 🔹 Postcondition : la force du Romain a diminué (sauf si elle était déjà à 0)
		assert force <= ancienneForce : "Erreur : la force du Romain n’a pas diminué après le coup !";

		// 🔹 Vérification de l’invariant à la fin de la méthode
		assert isInvariantVerified() : "Erreur : invariant violé, la force est négative !";
	}

	// Méthode sEquiper
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
			break;
		}
	}

	// Méthode privée pour éviter le code dupliqué
	private void ajouterEquipement(Equipement equipement) {
		equipements[nbEquipement] = equipement;
		nbEquipement++;
		System.out.println("Le soldat " + nom + " s'équipe avec un " + equipement + ".");
	}

	// MAIN pour tester
	public static void main(String[] args) {
		// Test affichage des énumérés
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		System.out.println();

		// Création d'un Romain
		Romain minus = new Romain("Minus", 6);

		// Tests de sEquiper
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
