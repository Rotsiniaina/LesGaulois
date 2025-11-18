package personnages;

public class Chef extends Gaulois {
	public Chef(String nom, int force) {
        super(nom, force);
	}

	@Override
    public void sePresenter() {
        System.out.print("Le chef " + getNom() + " : ");
        if (getVillage() != null) {
            System.out.println("\"Bonjour, je m'appelle " + getNom() + ". Je suis le chef du village "
                    + getVillage().getNom() + ".\"");
        } else {
            System.out.println("\"Bonjour, je m'appelle " + getNom() + ". Je voyage de villages en villages.\"");
        }
    }
}