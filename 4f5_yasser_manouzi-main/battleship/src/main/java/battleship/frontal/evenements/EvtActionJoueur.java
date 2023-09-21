package battleship.frontal.evenements;



import battleship.commun.valeurs.ActionJoueur;
import battleship.frontal.donnees.DonneesVuePartie;
import ca.ntro.app.frontend.events.EventNtro;

public class EvtActionJoueur extends EventNtro {

	private ActionJoueur action;

    

    public ActionJoueur getAction() {
		return action;
	}

	public void setAction(ActionJoueur action) {
		this.action = action;
	}

	public EvtActionJoueur() {
    }

    public void appliquerA(DonneesVuePartie donneesVuePartie) {
        action.appliquerA(donneesVuePartie);
    }

	

}