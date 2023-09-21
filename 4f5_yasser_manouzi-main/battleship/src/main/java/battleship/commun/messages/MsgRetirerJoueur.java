package battleship.commun.messages;

import battleship.commun.modeles.ModeleJoueur;
import ca.ntro.app.messages.MessageNtro;

public class MsgRetirerJoueur extends MessageNtro{
	
	private String idJoueur;

 

    public String getIdJoueur() {
		return idJoueur;
	}



	public void setIdJoueur(String idJoueur) {
		this.idJoueur = idJoueur;
	}



	public void retirerDe(ModeleJoueur joueur) {
		joueur.retirerJoueur(idJoueur);
    }

}
