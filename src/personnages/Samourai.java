package personnages;

public class Samourai extends Ronin{
	private String seigneur;
	
	public Samourai(String seigneur,String nom,String boissonPreferee,int sous) {
		super(nom,boissonPreferee,sous);
		this.seigneur = seigneur;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Je suis fier de servir le seigneur " + this.seigneur);
	}
	
	//@Override
	public void boire(String boisson) {
		parler("Qu'est-ce que je vais choisir comme boisson ? Tiens je vais prendre "+ "du " + boisson + ".");
	}
	
	
}
