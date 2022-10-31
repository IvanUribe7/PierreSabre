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

	public class Commer�ant extends Humain{
		public Commer�ant(String nom, String boissonPreferee, int sous) {
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
		private String clan;
		
		public Yakuza(String nom,String boissonPreferee,int sous, String clan,int reputation) {
			super(nom,boissonPreferee,sous);
			this.clan = clan;
			this.reputation = reputation;
		}
		
		public void extorquer(Commer�ant commer�ant) {
			int pocheCommer�ant = ((Humain) commer�ant).sous;
			super.sous+=((Humain) commer�ant).sous;
			commer�ant.seFaireExtorquer();
			this.reputation+=1;
			super.parler("J�ai piqu� les " + pocheCommer�ant + " sous de " + ((Humain) commer�ant).nom + ", ce qui me fait " + super.sous + " sous dans ma poche. Hi ! Hi !");
		}
		
	}
	
	public class Ronin extends Humain{
		private int honneur;
		
		public Ronin(String nom,String boissionPreferee,int sous,int honneur) {
			super(nom,boissonPreferee,sous);
			this.honneur = honneur;
		}
	
		public void donner(Commer�ant commer�ant) {
			int donnation = (super.sous*10)/100;
			super.parler("Prend ces " + donnation + " sous.");
			commer�ant.recevoir(donnation);
		}
	}
	
	
	public static void main(String[] args) {
		

	}

}
