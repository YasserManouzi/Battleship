package battleship.commun.messages;

import battleship.commun.enums.Cadran;
import battleship.commun.modeles.ModelePartie;
import battleship.commun.monde2d.MondeBattleship2d;
import ca.ntro.app.messages.MessageNtro;

public class MsgAjouterPoint extends MessageNtro {

    private String cadran;
    private MondeBattleship2d mondeBattleship2d;

    

    public String getCadran() {
		return cadran;
	}

	public void setCadran(String cadran) {
		this.cadran = cadran;
	}

	public MondeBattleship2d getMondeBattleship2d() {
		return mondeBattleship2d;
	}

	public void setMondeBattleship2d(MondeBattleship2d mondeBattleship2d) {
		this.mondeBattleship2d = mondeBattleship2d;
	}

	public void ajouterPointA(ModelePartie partie) {
        partie.ajouterPointPour(Cadran.valueOf(cadran));
    }

    public void copierDonneesDans(ModelePartie partie) {
        partie.copierDonnesDe(mondeBattleship2d);
    }

	public boolean estPlusRecentQue(ModelePartie partie) {
		// TODO Auto-generated method stub
		return false;
	}

}