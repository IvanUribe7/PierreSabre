package histoire;
import personnages.Humain;
import personnages.Humain.Commerçant;
import personnages.Humain.Ronin;
public class HistoireTP4 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Commerçant marco = humain.new Commerçant("Marco","Thé",15);
		Ronin roro = humain.new Ronin("Roro","Shochu",60,1);
		roro.direBonjour();
		roro.donner(marco);
	}

}
