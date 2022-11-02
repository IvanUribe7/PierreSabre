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
		
		public Yakuza(String nom,String boissonPreferee,int sous, String clan,int reputation) {
			super(nom,boissonPreferee,sous);
			this.clan = clan;
			this.reputation = reputation;
		}
			
		public int getReputation() {
			return reputation;
		}

		public void extorquer(Commerçant commerçant) {
			int pocheCommerçant = ((Humain) commerçant).sous;
			super.sous+=((Humain) commerçant).sous;
			commerçant.seFaireExtorquer();
			this.reputation+=1;
			super.parler("J’ai piqué les " + pocheCommerçant + " sous de " + ((Humain) commerçant).nom + ", ce qui me fait " + super.sous + " sous dans ma poche. Hi ! Hi !");
		}
		
		public int perdre() {
			super.parler("J’ai perdu mon duel et mes " + super.sous + " sous, snif... J'ai déshonoré le clan de " + this.clan );
			super.sous -= super.sous;
			this.reputation-=1;
			return this.getReputation();
		}		
		
		public int gagner(int gain) {
			super.sous+=gain;
			this.reputation+=1;
			super.parler("Ce ronin pensait vraiment battre " + super.nom + " du clan " + this.clan + "? Je l'ai dépouillé de ses " + gain + " sous.");
			return this.getReputation();
		}
		
	}
	
	public class Ronin extends Humain{
		private int honneur;	

		public Ronin(String nom,String boissionPreferee,int sous,int honneur) {
			super(nom,boissonPreferee,sous);
			this.honneur = honneur;
		}
		
		public void donner(Commerçant commerçant) {
			int donnation = (super.sous*10)/100;
			super.parler("Prend ces " + donnation + " sous.");
			commerçant.recevoir(donnation);
		}
		public void provoquer(Yakuza yakuza) {
			int forceRonin = this.honneur * 2 ;
			if(forceRonin >= yakuza.reputation) {
				super.sous+=((Humain)yakuza).sous;
				this.honneur+=1;
				super.parler("Je t'ai retrouvé vermine, tu vas payer pour ce que tu as fait à ce pauvre marchand!");
				super.parler("Je t’ai eu petit yakuza!");
				yakuza.perdre();
			}
			
			else {
				super.parler("J'ai perdu contre ce yakuza, mon honneur et ma bourse ont en pris un coup.");
				this.honneur-=1;
				yakuza.gagner(super.sous);
				super.sous-=super.sous;
				
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		

	}

}
