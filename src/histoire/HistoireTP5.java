package histoire;

import personnages.Humain;
import personnages.Humain.Commercant;
import personnages.Humain.Ronin;
import personnages.Humain.Yakuza;
import personnages.Humain.Samourai;
import personnages.Humain.Traitre;
public class HistoireTP5 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Ronin roro = humain.new Ronin("Roro","Shochu", 20);
		Yakuza yaku = humain.new Yakuza("Yaku Le Noir","whisky", 10,"Warsong");
		Commercant marco = humain.new Commercant("Marco","Thé", 20);
		Commercant chonin = humain.new Commercant("Chonin","Thé", 40);
		Commercant kumi = humain.new Commercant("Kumi","Thé", 10);
		Samourai akimoto = humain.new Samourai("Miyamoto","Akimoto", "saké", 80);
		Traitre masako = humain.new Traitre("Miyamoto","Masako", "whisky", 100);
		masako.faireLeGentil();
		masako.ranconner(kumi);
		masako.ranconner(chonin);
		masako.ranconner(marco);
		akimoto.faireConnaissanceAvec(masako);
		masako.ranconner(kumi);
		masako.faireConnaissanceAvec(yaku);
		masako.faireLeGentil();
		masako.faireConnaissanceAvec(roro);
	}

}
