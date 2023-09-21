package battleship.frontal.taches;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import battleship.frontal.fragments.FragmentJoueur;
import battleship.frontal.vues.VueMenu;
import battleship.frontal.vues.VuePartie;
import battleship.frontal.vues.VueRacine;
import battleship.frontal.vues.VueJoueur;
import battleship.frontal.vues.VueStatistiquesJoueur;
import ca.ntro.app.frontend.View;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class Initialisation {
	
	public static void creeTaches(FrontendTasks tasks) {
		tasks.taskGroup("Initialisation").andContains(subTasks -> {
			
			creerVueJoueur(subTasks);	
			creerVueRacine(subTasks);
			creerVueMenu(subTasks);
			creerVueStatistiquesJoueur(subTasks);
			creerVuePartie(subTasks);
			
			installerVueRacine(subTasks);
			
			installerVueJoueur(subTasks);
			afficherFenetre(subTasks);
				
		});
	}
	
	
	private static void afficherFenetre(FrontendTasks subTasks) {
		subTasks.task("afficherFenetre").waitsFor(window()).thenExecutes(inputs -> {
			Window window = inputs.get(window());
			
			window.show();
			
		});
	}
	
	private static void creerVueRacine(FrontendTasks tasks) {
	
		tasks.task(create(VueRacine.class))
		.waitsFor(viewLoader(VueRacine.class))
		.thenExecutesAndReturnsValue(inputs -> {
			ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));
			
			VueRacine vueRacine = viewLoader.createView();
			
			return vueRacine;
		});
	}
	
	private static void installerVueRacine(FrontendTasks tasks) {
		tasks.task("installerVueRacine")
		.waitsFor(window())
		.waitsFor(created(VueRacine.class))
		.thenExecutes(inputs -> {
			
			VueRacine vueRacine = inputs.get(created(VueRacine.class));
			Window window = inputs.get(window());
			window.installRootView(vueRacine);
		});
	}
	
	private static void creerVueJoueur(FrontendTasks tasks) {
		
		tasks.task(create(VueJoueur.class))
		.waitsFor(viewLoader(VueJoueur.class))
		.waitsFor(viewLoader(FragmentJoueur.class))
		.thenExecutesAndReturnsValue(inputs -> {
			ViewLoader<VueJoueur> viewLoader = inputs.get(viewLoader(VueJoueur.class));
			ViewLoader<FragmentJoueur> viewLoaderJoueur = inputs.get(viewLoader(FragmentJoueur.class));
			VueJoueur vueJoueur = viewLoader.createView();
			vueJoueur.setViewLoaderJoueur(viewLoaderJoueur);
			return vueJoueur;
		});
	}
	
	private static void installerVueJoueur(FrontendTasks tasks) {
		tasks.task("installerVueJoueur")
		.waitsFor(created(VueRacine.class))
		.waitsFor(create(VueJoueur.class))
		.thenExecutes(inputs -> {
			
			VueRacine vueRacine = inputs.get(created(VueRacine.class));
			VueJoueur vueJoueur = inputs.get(created(VueJoueur.class));
			
			vueRacine.afficherSousVue(vueJoueur);
		});

}
	private static void creerVueMenu(FrontendTasks subTasks) {

	    subTasks.task(create(VueMenu.class))

	         .waitsFor(viewLoader(VueMenu.class))

	         .thenExecutesAndReturnsValue(inputs -> {

	             ViewLoader<VueMenu> viewLoader = inputs.get(viewLoader(VueMenu.class));

	             VueMenu vueMenu = viewLoader.createView();

	             return vueMenu;
	         });
	}
	
	private static void creerVueStatistiquesJoueur(FrontendTasks subTasks) {

	    subTasks.task(create(VueStatistiquesJoueur.class))

	         .waitsFor(viewLoader(VueStatistiquesJoueur.class))

	         .thenExecutesAndReturnsValue(inputs -> {

	             ViewLoader<VueStatistiquesJoueur> viewLoader = inputs.get(viewLoader(VueStatistiquesJoueur.class));

	             VueStatistiquesJoueur vueStatistiquesJoueur = viewLoader.createView();

	             return vueStatistiquesJoueur;
	         });
	}
	
	private static void creerVuePartie(FrontendTasks subTasks) {

	    subTasks.task(create(VuePartie.class))

	         .waitsFor(viewLoader(VuePartie.class))

	         .thenExecutesAndReturnsValue(inputs -> {

	             ViewLoader<VuePartie> viewLoader = inputs.get(viewLoader(VuePartie.class));

	             VuePartie vuePartie = viewLoader.createView();

	             return vuePartie;
	         });
	}
}
