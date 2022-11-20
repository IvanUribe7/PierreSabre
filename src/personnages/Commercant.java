package personnages;

public class Commercant extends Humain{
	public Commercant(String nom, String boissonPreferee, int sous) {
		super(nom,boissonPreferee,sous);
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
