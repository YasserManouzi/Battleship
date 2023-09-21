package battleship.commun.valeurs;

import battleship.commun.enums.Action;

import battleship.commun.enums.Cadran;
import battleship.commun.modeles.ModelePartie;
import battleship.frontal.donnees.DonneesVuePartie;
import ca.ntro.app.models.ModelValue;

public class ActionJoueur implements ModelValue {

	private Cadran cadran;
    private Action action;

    

    public String getCadran() {
        return cadran.name();
    }

    public void setCadran(String cadran) {
        this.cadran = Cadran.valueOf(cadran);
    }

    public String getAction() {
    	return action.name();
    }

    public void setCadran(Cadran cadran) {
		this.cadran = cadran;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	public void setAction(String action) {
        this.action = Action.valueOf(action);
    }

    public ActionJoueur() {

    }

    public ActionJoueur(Cadran cadran, Action action) {
        this.cadran = cadran;
        this.action = action;
    }

    public void appliquerA(DonneesVuePartie donneesVuePartie) {
        donneesVuePartie.appliquerActionJoueur(cadran, action);
    }
}