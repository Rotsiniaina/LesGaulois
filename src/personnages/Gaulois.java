package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int effetPotion = 1;

	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	private String prendreParole() {
		return "Le gaulois" + nom + " : ";
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		System.out.println(asterix.getNom());
	}

	@Override
	public String toString() {
		return nom;
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
		if (this instanceof Chef) {
			System.out.println("\"Bonjour, je m'appelle " + nom + ". Je suis le chef du village "
					+ ((Chef) this).getVillage().getNom() + ".\"");
		} else if (village != null) {
			System.out.println("\"Bonjour, je m'appelle " + nom + ". J'habite le village " + village.getNom() + ".\"");
		} else {
			System.out.println("\"Bonjour, je m'appelle " + nom + ". Je voyage de villages en villages.\"");
		}
	}

}
