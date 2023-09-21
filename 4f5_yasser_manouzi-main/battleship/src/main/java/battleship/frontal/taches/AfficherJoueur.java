package battleship.frontal.taches;
import ca.ntro.app.tasks.frontend.FrontendTasks;

import ca.ntro.core.reflection.observer.Modified;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import battleship.commun.modeles.ModeleJoueur;
import battleship.frontal.donnees.DonneesVuePartie;
import battleship.frontal.vues.VueJoueur;
import battleship.frontal.vues.VueStatistiquesJoueur;
import battleship.maquettes.MaquetteSession;



public class AfficherJoueur {
	
	public static void creeTaches(FrontendTasks tasks, String idJoueur) {
		tasks.taskGroup("AfficherJoueur")
		.waitsFor("Initialisation")
		.andContains(subTasks -> {
			afficherStatistique(subTasks, idJoueur);
			
					
		});
	}
	
	
	
	private static void afficherStatistique(FrontendTasks tasks, String idJoueur) {
	
		tasks.task("afficherJoueur")
		.waitsFor(modified(ModeleJoueur.class, idJoueur))
		.executes(inputs -> {
			VueJoueur vueJoueur = inputs.get(created(VueJoueur.class));
			VueStatistiquesJoueur vueStatistiquesJoueur = inputs.get(created(VueStatistiquesJoueur.class));
			Modified<ModeleJoueur> joueur = inputs.get(modified(ModeleJoueur.class, idJoueur));
			ModeleJoueur ancienJoueur = joueur.previousValue();
			ModeleJoueur joueurCourant = joueur.currentValue();
			joueurCourant.afficherSur(vueJoueur);
			joueurCourant.afficherDetailsJoueurSur(vueStatistiquesJoueur, MaquetteSession.idJoueur);
			});
	}
	
	
	

}
