package histoire;

import personnages.Humain;
import personnages.Humain.Commercant;
import personnages.Humain.Ronin;
import personnages.Humain.Yakuza;
import personnages.Humain.Samourai;

public class HistoireTP5 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Commercant marco = humain.new Commercant("Marco","Th�", 20);
		Samourai akimoto = humain.new Samourai("Miyamoto","Akimoto", "sak�", 80);
		akimoto.boire("th�");
		akimoto.faireConnaissanceAvec(marco);
		akimoto.listerConnaissance();
	}

}
