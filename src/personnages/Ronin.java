package personnages;

public class Ronin extends Humain{
	private int honneur = 1;	

	public Ronin(String nom,String boissonPreferee,int sous) {
		super(nom,boissonPreferee,sous);
	}
	
	public void donner(Commercant commercant) {
		int donnation = (super.sous*10)/100;
		super.parler("Prend ces " + donnation + " sous.");
		commercant.recevoir(donnation);
	}
	public void provoquer(Yakuza yakuza) {
		int forceRonin = this.honneur * 2 ;
		if(forceRonin >= yakuza.getReputation()) {
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
