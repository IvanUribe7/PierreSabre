package histoire;

import personnages.Humain;
import personnages.Humain.Commercant;
import personnages.Humain.Ronin;
import personnages.Humain.Yakuza;
import personnages.Humain.Samourai;

public class HistoireTP5 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Commercant marco = humain.new Commercant("Marco","Thé", 20);
		Samourai akimoto = humain.new Samourai("Miyamoto","Akimoto", "saké", 80);
		akimoto.boire("thé");
		akimoto.faireConnaissanceAvec(marco);
		akimoto.listerConnaissance();
	}

}
