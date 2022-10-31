package histoire;
import personnages.Humain;
import personnages.Humain.Commerçant;
import personnages.Humain.Yakuza;
public class HistoireTP4 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Commerçant marco = humain.new Commerçant("Marco","Thé",15);
		Yakuza yaku = humain.new Yakuza("Yaku Le Noir","Whisky",30,"Hyrule");
		yaku.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par là ?");
		yaku.parler("Marco, si tu tiens à la vie donne moi ta bourse !");
		yaku.extorquer(marco);
	}

}
