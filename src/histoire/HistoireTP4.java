package histoire;
import personnages.Humain;
import personnages.Humain.Commercant;
public class HistoireTP4 {

	public static void main(String[] args) {
		Humain commercant = new Humain("Commercant","Th�",20);
		Commercant marco = commercant.new Commercant("Marco","Th�",20);
		marco.direBonjour();
		marco.seFaireExtorquer();
		marco.recevoir(15);
		marco.boire();
	}

}
