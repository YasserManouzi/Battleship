package battleship.commun.messages;

import battleship.commun.modeles.ModeleJoueur;

import battleship.commun.valeurs.Joueur;
import ca.ntro.app.messages.MessageNtro;

public class MsgAjouterJoueur extends MessageNtro{

	private Joueur unJoueur;
	public MsgAjouterJoueur() {
		
	}
	
	
	public Joueur getUnJoueur() {
		return unJoueur;
	}


	public void setUnJoueur(Joueur unJoueur) {
		this.unJoueur = unJoueur;
	}


	public void ajouterA(ModeleJoueur joueur) {
		joueur.ajouterJoueur(unJoueur);
	}
	
	
}
