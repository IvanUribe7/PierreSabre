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
	
	public Humain() {
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	
	private String prendreParole() {
		return "(" + nom + ") - ";
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + this.nom + " et j’aime boire du " + this.boissonPreferee) ;
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
			parler("Je n'ai plus que " + this.sous + " sous en poche. Je ne peux même pas m'offrir " + bien + " à " + prix + " sous.");
		}
		else{
			parler("J'ai " + this.sous + " sous en poche. Je vais pouvoir m'offrir " + bien + " à " + prix + " sous.");
			perdreArgent(prix);
		}
	}

	public class Commerçant extends Humain{
		public Commerçant(String nom, String boissonPreferee, int sous) {
			super(nom,boissonPreferee,sous);
			super.nom = nom;
			super.boissonPreferee = boissonPreferee;
			super.sous = sous;
		}
		
		//Si un field est marqué d'un accès privé, on ne peut y accéder qu'à 
		//l'intérieur de cette classe ou de ses instances.
		//Solution 1: Redéfinir les méthodes dans la classe fille Commerçant
		//Solution 2: Faire appel au constructeur super()
			
			
		
			public void seFaireExtorquer() {
				super.sous-=super.sous;
				super.parler("J’ai tout perdu! Le monde est trop injuste...");
			}
			
			public void recevoir(int argent) {
				super.sous+=argent;
				super.parler(argent + " sous ! Je te remercie généreux donateur!");
			}
		}
	
	public class Yakuza extends Humain{
		private int reputation;
		private String clan;
		
		public Yakuza(String nom,String boissionPreferee,int sous, String clan) {
			super(nom,boissonPreferee,sous);
			this.clan = clan;
		}
		
		public void extorquer(Commerçant commerçant) {
			int pocheCommerçant = ((Humain) commerçant).sous;
			super.sous+=((Humain) commerçant).sous;
			commerçant.seFaireExtorquer();
			reputation+=1;
			super.parler("J’ai piqué les " + pocheCommerçant + " sous de " + ((Humain) commerçant).nom + ", ce qui me fait " + super.sous + " sous dans ma poche. Hi ! Hi !");
		}
		
	}
	
	
	
	
	public static void main(String[] args) {
		

	}

}
