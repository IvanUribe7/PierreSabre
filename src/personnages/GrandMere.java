package personnages;
import java.util.Random;


public class GrandMere extends Humain {

	public GrandMere(String nom, int sous) {
		super(nom, "tisane" , sous);
	}
	
	public enum TypeHumain {
		COMMERCANT("commercant"),HUMAIN("habitant"),RONIN("ronin"),SAMOURAI("samourai"),TRAITRE("traitre");
		private String nom;
		
		private TypeHumain(String nom) {
			this.nom = nom;
		}
		public String toString() {
			return this.nom;
		}

		public static String randomTypeHumain() {
			Random rand = new Random();
			TypeHumain[] types = TypeHumain.values();
			return types[rand.nextInt(3)].toString();
		}
	}
	
	
	
	private String humainHasard(){
		return TypeHumain.randomTypeHumain();
	}
	
	@Override
	protected void memoriser(Humain humain) {
		if (nbConnaissance < 5) {
				memoire[nbConnaissance] = humain;
				nbConnaissance+=1;
		} 
		else {
			parler("Oh ma tête ! Je ne peux plus retenir le nom d'une personne supplémentaire !");
		}
	}
	
	public void ragoter() {
		String type;
		for (int n = 0 ; n < nbConnaissance ; n++) {
			if (memoire[n] instanceof Traitre) {
				parler("Je sais que " + memoire[n].getNom() + " est un traître. Petit chenapan !");
			}
			else {
				type = humainHasard();
				parler("Je crois que " + memoire[n].getNom() + " est un " + type);
			}
		}
	}
	
}