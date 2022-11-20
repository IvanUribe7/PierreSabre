package personnages;

public class Yakuza extends Humain{
	private int reputation;
	private String clan;
	
	public Yakuza(String nom,String boissonPreferee,int sous, String clan) {
		super(nom,boissonPreferee,sous);
		this.clan = clan;
	}
		
	public int getReputation() {
		return reputation;
	}

	public void extorquer(Commercant commercant) {
		int pocheCommercant = ((Humain) commercant).sous;
		super.sous+=((Humain) commercant).sous;
		commercant.seFaireExtorquer();
		this.reputation+=1;
		super.parler("J’ai piqué les " + pocheCommercant + " sous de " + commercant.getNom() + ", ce qui me fait " + super.sous + " sous dans ma poche. Hi ! Hi !");
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
		super.parler("Ce ronin pensait vraiment battre " + super.getNom() + " du clan " + this.clan + "? Je l'ai dépouillé de ses " + gain + " sous.");
		return this.getReputation();
	}
	
	//@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mon clan est celui de " + this.clan);
	}
	
}
