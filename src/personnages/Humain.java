package personnages;


public class Humain {
	private String nom;
	private String boissonPreferee;
	protected int sous;
	protected int nbConnaissance = 0;
	protected Humain[] memoire ;
	
	public Humain(String nom, String boissonPreferee, int sous) {
		this.nom = nom;
		this.boissonPreferee = boissonPreferee;
		this.sous = sous;
		this.memoire = new Humain[30];
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "«" + texte + "»");
	}
	
	public String prendreParole() {
		return "(" + nom + ") - ";
	}
	
	public void direBonjour() {
		parler("Bonjour ! Je m’appelle " + this.nom + " et j’aime boire du " + this.boissonPreferee) ;
	}

	public void boire() {
		parler("Mmmm, un bon verre de " +  this.boissonPreferee + "! GLOUPS !");
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getSous() {
		return sous;
	}

	public int gagnerArgent(int gain) {
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
	
	protected void memoriser(Humain humain) {
		if(memoire[memoire.length-1]!=null){
			for(int i = 0;i<nbConnaissance-1;i++) {
				memoire[i] = memoire[i+1];
			}
			memoire[29] = humain;
		}
		if(nbConnaissance<30) {
			memoire[nbConnaissance] = humain;
			nbConnaissance++;
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
			texte = memoire[0].getNom();
		}
		else {
			texte = memoire[0].getNom();
			for(int i = 1; i<=nbConnaissance-1; i++) {
				texte+=","+memoire[i].getNom();
			}
		}
		parler("Je connais beaucoup de monde dont :" + texte);
	}

	
	
	
	
	public static void main(String[] args) {
		

	}

}
