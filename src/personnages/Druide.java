package personnages;

public class Druide {
	private String nom;
	private int force;
	private Chaudron chaudron;
	private int quantitePotion;

	public Druide(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.chaudron = new Chaudron();
	}  

	public String getNom() {
		return nom;
	}

	private String prendreParole() {
		return "Le Druide " + nom + " : ";
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");
	}

	public void fabriquerPotion(int quantite, int forcePotion) {
		chaudron.remplirChaudron(quantite, forcePotion);
		quantitePotion = quantite;
		parler("J'ai concoté " + quantite + " doses de potion magique.Elle a une force de " + forcePotion + ".");
	}

	public void booster(Gaulois gaulois) {
		if (chaudron.resterPotion()) {
			if (gaulois.getNom().equals("Obélix"))
				parler("Non, " + gaulois.getNom() + " Non!...Et tu le sais très bien!");
			else {
				int forcePotion = chaudron.prendreLouche();
				gaulois.boirePotion(forcePotion);
				parler("Tiens " + gaulois.getNom() + " un peu de potion magique.");
			}
		} else
			parler("Désolé " + gaulois.getNom() + " il n'y a plus de une seule goutte de potion");
	}

}
