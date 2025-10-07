package personnages;

public class Druide {
	private String nom;
	private int force;
	
	public String getNom() {
		return nom;
	}

	private String prendreParole() {
		return "Le Druide" + nom + " : ";
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "\"" + texte + "\"");	
	}

	public void fabriquerPotion(int quantite,int forcePotion) {
		remplirChaudron(quantite,forcePotion);
		parler("J'ai concoté" + quantite + "doses de potion magique.Elle a une force de" + forcePotion + ".");
	}
	
	public void booster(Gaulois gaulois) {
		if (resterPotion){
			if (gaulois.getNom() == "Obelix")
				parler("Non," + gaulois.getNom() + "Non!...Et tu le sais très bien!");
			else
				prendreLouche();
				boirePotion(forcePotion);
				parler("Tiens" + gaulois.getNom() + "un peu de potion magique.");
		} else
			parler("Désolé" + gaulois.getNom() + "il n'y a plus de une seule goutte de potion");
	}
	
	
	
}
