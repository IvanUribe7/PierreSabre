package personnages;

public class Commercant extends Humain{
	public Commercant(String nom, String boissonPreferee, int sous) {
		super(nom,boissonPreferee,sous);
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
