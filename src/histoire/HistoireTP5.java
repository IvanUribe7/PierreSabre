package histoire;

import personnages.Humain;
import personnages.Humain.Commercant;
import personnages.Humain.Ronin;
import personnages.Humain.Yakuza;

public class HistoireTP5 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Commercant marco = humain.new Commercant("Marco","Thé", 20);
		Commercant chonin = humain.new Commercant("Chonin","Thé", 40);
		Commercant kumi = humain.new Commercant("Kumi","Thé", 10);
		Yakuza yaku = humain.new Yakuza("Yaku Le Noir", "whisky", 30, "Warsong",0);
		Ronin roro = humain.new Ronin("Roro", "shochu", 60,1);
		marco.faireConnaissanceAvec(roro);
		marco.faireConnaissanceAvec(yaku);
		marco.faireConnaissanceAvec(chonin);
		marco.faireConnaissanceAvec(kumi);
		marco.listerConnaissance();
		roro.listerConnaissance();
		yaku.listerConnaissance();
	}

}
