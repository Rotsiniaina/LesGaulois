package personnages;

public class Village {

	private String nom;
	private int nbVillageois = 0;
	private Chef chef;
	private Gaulois[] villageois;
	private final int NB_VILLAGEOIS_MAX;

	private Village(String nom, int nbVillageois, Chef chef, Gaulois[] villageois) {
		this.nom = nom;
		this.nbVillageois = nbVillageois;
		this.chef = chef;
		this.villageois = new Gaulois[nbVillageoisMax];
	}

	public String getNom() {
		return nom;
	}

	public Chef getChef() {
		return chef;
	}

	public void ajouterVillageois(Gaulois gaulois) {
		if (nbVillageois < NB_VILLAGEOIS_MAX) {
			villageois[nbVillageois] = gaulois;
			nbVillageois++;
			gaulois.setVillage(this); 
		} 
	}

	public Gaulois trouverVillageois(int numVillageois) {
		if (numVillageois <= nbVillageois && numVillageois > 0) {
			return villageois[numVillageois - 1];
		} else {
			System.out.println("Il n'y a pas autant d'habitants dans notre village !");
			return null;
		}
	}

	public void afficherVillageois() {
		System.out.println(
				"Dans le village \"" + nom + "\" du chef " + chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0; i < nbVillageois; i++) {
			System.out.println("- " + villageois[i].getNom());
		}
	}

	public static void main(String[] args) {
		Chef Abraracourcix = new Chef("Abraracourcix", 6, null);

		Village village = new Village("Village des Irréductibles", 30, Abraracourcix);

		Gaulois asterix = new Gaulois("Astérix", 8);
		village.ajouterVillageois(asterix);

		Gaulois gaulois = village.trouverVillageois(1);
		System.out.println(gaulois);

		gaulois = village.trouverVillageois(2);
		System.out.println(gaulois);

		village.afficherVillageois();
		
		Gaulois obelix = new Gaulois("Obélix", 25);

		Gaulois doublePolemix = new Gaulois("DoublePolémix", 4);

		System.out.println();
		abraracourcix.sePresenter();
		asterix.sePresenter();
		doublePolemix.sePresenter();
	}
}
