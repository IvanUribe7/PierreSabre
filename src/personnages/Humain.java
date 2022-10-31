package personnages;

public class Humain {
	private String nom;
	private String boissonPreferee;
	private int sous;
	
	public Humain(String nom, String boissonPreferee, int sous) {
		this.nom = nom;
		this.boissonPreferee = boissonPreferee;
		this.sous = sous;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "�" + texte + "�");
	}
	
	private String prendreParole() {
		return "(" + nom + ") - ";
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m�appelle " + this.nom + " et j�aime boire du " + this.boissonPreferee) ;
	}

	public void boire() {
		parler("Mmmm, un bon verre de " +  this.boissonPreferee + "! GLOUPS !");
	}
	
	public int gaganerArgent(int gain) {
		return this.sous+=gain;
	}
	
	public int perdreArgent(int perte) {
		return this.sous-=perte;
	}
	
	public void acheter(String bien, int prix) {
		if(this.sous<prix) {
			parler("Je n'ai plus que " + this.sous + " sous en poche. Je ne peux m�me pas m'offrir " + bien + " � " + prix + " sous.");
		}
		else{
			parler("J'ai " + this.sous + " sous en poche. Je vais pouvoir m'offrir " + bien + " � " + prix + " sous.");
			perdreArgent(prix);
		}
	}

	public class Commercant extends Humain{
		public Commercant(String nom, String boissonPreferee, int sous) {
			super(nom,boissonPreferee,sous);
			super.nom = nom;
			super.boissonPreferee = boissonPreferee;
			super.sous = sous;
		}
		
		//Si un field est marqu� d'un acc�s priv�, on ne peut y acc�der qu'� 
		//l'int�rieur de cette classe ou de ses instances.
		//Solution 1: Red�finir les m�thodes dans la classe fille Commer�ant
		//Solution 2: Faire appel au constructeur super()
		
		
			public void seFaireExtorquer() {
				super.sous-=super.sous;
				super.parler("J�ai tout perdu! Le monde est trop injuste...");
			}
			
			public void recevoir(int argent) {
				super.sous+=argent;
				super.parler(argent + " sous ! Je te remercie g�n�reux donateur!");
			}
		}
	
	public class Yakuza extends Humain{
		private int reputation;
		
		public 
		
	}
	
	
	
	
	public static void main(String[] args) {
		

	}

}
