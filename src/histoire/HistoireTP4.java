package histoire;
import personnages.Humain;
import personnages.Humain.Commer�ant;
import personnages.Humain.Ronin;
public class HistoireTP4 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Commer�ant marco = humain.new Commer�ant("Marco","Th�",15);
		Ronin roro = humain.new Ronin("Roro","Shochu",60,1);
		roro.direBonjour();
		roro.donner(marco);
	}

}
