package personnages;
import java.util.Random;

public class Traitre extends Samourai{
	private int niveauTraitrise;
	
	public Traitre(String seigneur,String nom,String boissonPreferee,int sous) {
		super(seigneur,nom,boissonPreferee,sous);
		this.niveauTraitrise = 0;
	}
	
	@Override
	public void direBonjour() {
		super.direBonjour();
		parler("Mais je suis un traître et mon niveau de traîtrise est : " + niveauTraitrise + ". Chut !");
	}
	
	public void ranconner(Commercant commercant) {
		if (niveauTraitrise < 3) {
			int argentRanconner = ((Humain)commercant).sous;
			argentRanconner = (argentRanconner*2)/10;
			commercant.perdreArgent(argentRanconner);
			super.gagnerArgent(argentRanconner);
			parler("Si tu veux ma protection contre les Yakuzas, il va falloir payer ! Donne-moi " + argentRanconner +  " sous ou gare à toi !");
			commercant.parler("Tout de suite grand " + getNom() + ".");
			niveauTraitrise+=1;
		} 
		
		else {
			parler("Mince je ne peux plus rançonner personne sinon un samouraï risque de me démasquer !");
		}
	}
	
	public void faireLeGentil() {
		if(nbConnaissance<1) {
			parler("Je ne peux faire ami ami avec personne car  je ne connais personne ! Snif");
		}
		
		else {
			int don = getSous() / 20;
			Random random = new Random();
			Humain ami = memoire[random.nextInt(nbConnaissance)];
			String nomAmi = ami.getNom();
			parler("Il faut absolument remonter ma cote de confiance. Je vais me faire ami ami avec "+ nomAmi +".");
			parler("Bonjour l'ami ! Je voudrais vous aider en vous donnant " + don + " sous.");
			ami.gagnerArgent(don);
			perdreArgent(don);
			ami.parler("Merci " + this.getNom() + ". Vous êtes quelqu'un de bien.");
			if (niveauTraitrise > 1) {
				niveauTraitrise-=1;
				
			}
		}
	}
	
	
}
