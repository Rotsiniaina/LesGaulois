package personnages;

public class Chaudron {
	private int quantitePotion;
	private int forcePotion;

	public boolean resterPotion(int quantite) {
		if(quantite==0)
			return true;
		return false;
	}
	
	public void remplirChaudron(int quantite,int forcePotion) {
		quantitePotion = quantite;
		forcePotion = forcePotion;
	}
	
	public void prendreLouche() {
		if (quantite == 0)
			forcePotion=0;
		quantite-=1;
	}
	
}
