package battleship.frontal;

import battleship.frontal.donnees.DonneesVuePartie;

import battleship.frontal.evenements.EvntAfficherMenu;
import battleship.frontal.evenements.EvtActionJoueur;
import battleship.frontal.evenements.EvtAfficherPartie;
import battleship.frontal.evenements.EvtAfficherJoueur;
import battleship.frontal.evenements.EvtAfficherStatistiquesJoueur;
import battleship.frontal.evenements.EvtClicSouris;
import battleship.frontal.fragments.FragmentJoueur;
import battleship.frontal.taches.AfficherPartie;
import battleship.frontal.taches.AfficherJoueur;

import battleship.frontal.taches.Initialisation;
import battleship.frontal.taches.Navigation;
import battleship.frontal.vues.VueRacine;
import battleship.frontal.vues.VueMenu;
import battleship.frontal.vues.VuePartie;
import battleship.frontal.vues.VueJoueur;
import battleship.frontal.vues.VueStatistiquesJoueur;
import battleship.maquettes.MaquetteSession;
import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;

public class FrontalBattleship implements FrontendFx {

	@Override
	public void createTasks(FrontendTasks tasks) {
		Initialisation.creeTaches(tasks);
		
		
		
		Navigation.creerTaches(tasks);
		
		AfficherJoueur.creeTaches(tasks, MaquetteSession.idJoueur);
		
		AfficherPartie.creerTaches(tasks, MaquetteSession.idJoueur);
	}
	

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		// TODO Auto-generated method stub
		
		registrar.registerEvent(EvtAfficherJoueur.class);
		
		registrar.registerEvent(EvntAfficherMenu.class);
		
		registrar.registerEvent(EvtAfficherPartie.class);
		
		registrar.registerEvent(EvtAfficherStatistiquesJoueur.class);
		
		registrar.registerEvent(EvtActionJoueur.class);
		
		registrar.registerEvent(EvtClicSouris.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		// TODO Auto-generated method stub
		registrar.registerView(VueRacine.class, "/racine.xml");
		
		
		registrar.registerView(VueJoueur.class, "/statistique.xml");
		registrar.registerView(VueMenu.class, "/menu.xml");
		registrar.registerView(VueStatistiquesJoueur.class, "/statistiquesJoueur.xml");
		registrar.registerView(VuePartie.class, "/partie.xml");
		
		registrar.registerViewData(DonneesVuePartie.class);
		registrar.registerStylesheet("/dev.css");
		//registrar.registerStylesheet("/prod.css");
		
		registrar.registerDefaultResources("/chaines_fr.properties");
		
		registrar.registerResources(NtroApp.locale("en"), "/chaines_en.properties");
		
		registrar.registerFragment(FragmentJoueur.class, "/fragments/joueur.xml");
		
		
	}
	
	
	
	

}
