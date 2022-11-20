package histoire;

//import personnages.Humain;
import personnages.Commercant;
//import personnages.Ronin;
import personnages.Yakuza;
import personnages.Samourai;
import personnages.Traitre;
import personnages.GrandMere;
public class HistoireTP5 {

	public static void main(String[] args) {
		Yakuza yaku = new Yakuza("Yaku Le Noir","whisky", 10,"Warsong");
		Commercant marco = new Commercant("Marco","Thé", 20);
		Commercant chonin = new Commercant("Chonin","Thé", 40);
		Commercant kumi = new Commercant("Kumi","Thé", 10);
		Samourai akimoto = new Samourai("Miyamoto","Akimoto", "saké", 80);
		Traitre masako = new Traitre("Miyamoto", "Masako", "whisky", 100);
		GrandMere grandMere = new GrandMere("Grand-Mère", 10);
		masako.ranconner(marco);
		masako.ranconner(kumi);
		grandMere.faireConnaissanceAvec(akimoto);
		grandMere.faireConnaissanceAvec(yaku);
		grandMere.faireConnaissanceAvec(masako);
		grandMere.faireConnaissanceAvec(kumi);
		grandMere.faireConnaissanceAvec(marco);
		grandMere.faireConnaissanceAvec(chonin);
		grandMere.ragoter();
	}

}
