package battleship.commun.modeles;

import battleship.commun.enums.Cadran;
import battleship.commun.monde2d.MondeBattleship2d;
import battleship.frontal.donnees.DonneesVuePartie;
import battleship.frontal.vues.VuePartie;
import ca.ntro.app.NtroApp;
import ca.ntro.app.models.Model;

public class ModelePartie implements Model{

	private MondeBattleship2d mondeBattleship2d = new MondeBattleship2d();

    private String nomPremierJoueur = "Alice";
    private String nomDeuxiemeJoueur = "Bob";

    private int scorePremierJoueur = 0;
    private int scoreDeuxiemeJoueur = 0;
    
   

    

    public void afficherInfoPartieSur(VuePartie vuePartie) {
        vuePartie.afficherNomPremierJoueur(nomPremierJoueur);
        vuePartie.afficherNomDeuxiemeJoueur(nomDeuxiemeJoueur);

        vuePartie.afficherScorePremierJoueur(String.valueOf(scorePremierJoueur));
        vuePartie.afficherScoreDeuxiemeJoueur(String.valueOf(scoreDeuxiemeJoueur));
    }

    public void copierDonneesDans(DonneesVuePartie donneesVuePartie) {
        donneesVuePartie.copierDonnesDe(mondeBattleship2d);
    }

    public void copierDonnesDe(MondeBattleship2d mondeBattleship2d) {
        this.mondeBattleship2d.copyDataFrom(mondeBattleship2d);
    }

    public void ajouterPointPour(Cadran cadran) {
        switch(cadran) {
        case GAUCHE:
        default:
            scorePremierJoueur++;
            break;

        case DROITE:
            scoreDeuxiemeJoueur++;
            break;
        }
    }

	public int getScorePremierJoueur() {
		return scorePremierJoueur;
	}

	public void setScorePremierJoueur(int scorePremierJoueur) {
		this.scorePremierJoueur = scorePremierJoueur;
	}

	public int getScoreDeuxiemeJoueur() {
		return scoreDeuxiemeJoueur;
	}

	public void setScoreDeuxiemeJoueur(int scoreDeuxiemeJoueur) {
		this.scoreDeuxiemeJoueur = scoreDeuxiemeJoueur;
	}
}
