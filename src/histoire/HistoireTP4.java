package histoire;
import personnages.Humain;
import personnages.Humain.Commer�ant;
import personnages.Humain.Yakuza;
public class HistoireTP4 {

	public static void main(String[] args) {
		Humain humain = new Humain();
		Commer�ant marco = humain.new Commer�ant("Marco","Th�",15);
		Yakuza yaku = humain.new Yakuza("Yaku Le Noir","Whisky",30,"Hyrule",0);
		yaku.parler("Tiens, tiens, ne serait-ce pas un faible marchand qui passe par l� ?");
		yaku.parler("Marco, si tu tiens � la vie donne moi ta bourse !");
		yaku.extorquer(marco);
	}

}
