package histoire;
import personnages.Humain;
import personnages.Humain.Yakuza;
import personnages.Humain.Ronin;
public class HistoireTP4 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Yakuza yaku = humain.new Yakuza("Yaku Le Noir","Whisky",45,"Warsong",0);
		Ronin roro = humain.new Ronin("Roro","Shochu",54,1);
		roro.provoquer(yaku);
	}

}
