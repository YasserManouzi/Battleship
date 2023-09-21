package battleship.frontal.taches;

import battleship.frontal.evenements.EvntAfficherMenu;
import battleship.frontal.evenements.EvtAfficherPartie;
import battleship.frontal.evenements.EvtAfficherJoueur;
import battleship.frontal.evenements.EvtAfficherStatistiquesJoueur;
import battleship.frontal.vues.VueMenu;
import battleship.frontal.vues.VuePartie;
import battleship.frontal.vues.VueRacine;
import battleship.frontal.vues.VueJoueur;
import battleship.frontal.vues.VueStatistiquesJoueur;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;
import ca.ntro.app.frontend.ViewLoader;



public class Navigation {

	public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("Navigation")

             .waitsFor("Initialisation")

             .andContains(subTasks -> {

               
                  afficherVueJoueur(subTasks);
                  
                  afficherVueMenu(subTasks);
                  
                  afficherVueStatistiquesJoueur(subTasks);
                  afficherVuePartie(subTasks);

             });
    }
	
	

	private static void afficherVueMenu(FrontendTasks subTasks) {

	    subTasks.task("afficherVueMenu")

	         .waitsFor(created(VueMenu.class))

	         .waitsFor(event(EvntAfficherMenu.class))

	         .thenExecutes(inputs -> {

	             VueRacine vueRacine = inputs.get(created(VueRacine.class));
	             VueMenu vueMenu = inputs.get(created(VueMenu.class));

	             vueRacine.afficherSousVue(vueMenu);
	         });
	}

	private static void afficherVueJoueur(FrontendTasks subTasks) {

	    subTasks.task("afficherVueJoueur")

	          .waitsFor(event(EvtAfficherJoueur.class))

	          .thenExecutes(inputs -> {

	              VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
	              VueJoueur vueJoueur = inputs.get(created(VueJoueur.class));

	              vueRacine.afficherSousVue(vueJoueur);
	              
	              AfficherPartie.partieSurPause = true;

	          });
	}
	
	private static void afficherVueStatistiquesJoueur(FrontendTasks subTasks) {

	    subTasks.task("afficherVueStatistiquesJoueur")

	         .waitsFor(created(VueStatistiquesJoueur.class))

	         .waitsFor(event(EvtAfficherStatistiquesJoueur.class))

	         .thenExecutes(inputs -> {

	             VueRacine vueRacine = inputs.get(created(VueRacine.class));
	             VueStatistiquesJoueur vueStatistiquesJoueur = inputs.get(created(VueStatistiquesJoueur.class));

	             vueRacine.afficherSousVue(vueStatistiquesJoueur);
	         });
	}
	
	private static void afficherVuePartie(FrontendTasks subTasks) {

	    subTasks.task("afficherVuePartie")

	         .waitsFor(created(VuePartie.class))

	         .waitsFor(event(EvtAfficherPartie.class))

	         .thenExecutes(inputs -> {

	             VueRacine vueRacine = inputs.get(created(VueRacine.class));
	             VuePartie vuePartie = inputs.get(created(VuePartie.class));

	             vueRacine.afficherSousVue(vuePartie);
	             
	             AfficherPartie.partieSurPause = false;
	         });
	
	
}
}
