package personnages;

public class Humain {
	private String nom;
	private String boissonPreferee;
	private int argentPerso;
	
	public Humain(String nom, String boissonPreferee, int argentPerso) {
		this.nom = nom;
		this.boissonPreferee = boissonPreferee;
		this.argentPerso = argentPerso;
	}
	public String getNom() {
		return nom;
	}


	public String getBoissonPreferee() {
		return boissonPreferee;
	}


	public int getArgentPerso() {
		return argentPerso;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
