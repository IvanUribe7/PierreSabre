package personnages;

public class Humain {
	private String nom;
	private String boissonPreferee;
	private int sous;
	private int nbConnaissance;
	private String[] memoire = new String[30];
	
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
	
	public void memoriser(Humain humain) {
		if(memoire[memoire.length-1]!=null){
			for(int i = 0;i<nbConnaissance-1;i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[nbConnaissance-1] = humain.nom;
		}
		else {
			memoire[nbConnaissance] = humain.nom;
			nbConnaissance+=1;
		}	
	}
	
	public void repondre(Humain humain) {
		direBonjour();
		memoriser(humain);
	}
	
	public void faireConnaissanceAvec(Humain humain) {
		direBonjour();
		humain.repondre(this);
		memoriser(humain);
	}
	
	public void listerConnaissance() {
		String texte;
		if(nbConnaissance==1) {
			texte = memoire[0];
		}
		else {
			texte = memoire[0];
			for(int i = 1; i<=nbConnaissance-1; i++) {
				texte+=","+memoire[i];
			}
		}
		parler("Je connais beaucoup de monde dont :" + texte);
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
		private String clan;
		
		public Yakuza(String nom,String boissonPreferee,int sous, String clan,int reputation) {
			super(nom,boissonPreferee,sous);
			this.clan = clan;
			this.reputation = reputation;
		}
			
		public int getReputation() {
			return reputation;
		}

		public void extorquer(Commercant commercant) {
			int pocheCommercant = ((Humain) commercant).sous;
			super.sous+=((Humain) commercant).sous;
			commercant.seFaireExtorquer();
			this.reputation+=1;
			super.parler("J�ai piqu� les " + pocheCommercant + " sous de " + ((Humain) commercant).nom + ", ce qui me fait " + super.sous + " sous dans ma poche. Hi ! Hi !");
		}
		
		public int perdre() {
			super.parler("J�ai perdu mon duel et mes " + super.sous + " sous, snif... J'ai d�shonor� le clan de " + this.clan );
			super.sous -= super.sous;
			this.reputation-=1;
			return this.getReputation();
		}		
		
		public int gagner(int gain) {
			super.sous+=gain;
			this.reputation+=1;
			super.parler("Ce ronin pensait vraiment battre " + super.nom + " du clan " + this.clan + "? Je l'ai d�pouill� de ses " + gain + " sous.");
			return this.getReputation();
		}
		
	}
	
	public class Ronin extends Humain{
		private int honneur;	

		public Ronin(String nom,String boissionPreferee,int sous,int honneur) {
			super(nom,boissonPreferee,sous);
			this.honneur = honneur;
		}
		
		public void donner(Commercant commercant) {
			int donnation = (super.sous*10)/100;
			super.parler("Prend ces " + donnation + " sous.");
			commercant.recevoir(donnation);
		}
		public void provoquer(Yakuza yakuza) {
			int forceRonin = this.honneur * 2 ;
			if(forceRonin >= yakuza.reputation) {
				super.sous+=((Humain)yakuza).sous;
				this.honneur+=1;
				super.parler("Je t'ai retrouv� vermine, tu vas payer pour ce que tu as fait � ce pauvre marchand!");
				super.parler("Je t�ai eu petit yakuza!");
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
