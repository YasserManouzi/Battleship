package battleship.frontal.taches;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;


import battleship.commun.modeles.ModelePartie;
import battleship.frontal.donnees.DonneesVuePartie;
import battleship.frontal.evenements.EvtActionJoueur;
import battleship.frontal.evenements.EvtClicSouris;
import battleship.frontal.vues.VuePartie;
import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.reflection.observer.Modified;


public class AfficherPartie {
	
	public static boolean partieSurPause = true;

	 public static void creerTaches(FrontendTasks tasks, String idPartie) {

	        creerDonneesVuePartie(tasks, idPartie);

	        
	        tasks.taskGroup("AfficherPartie")

            .waitsFor(created(DonneesVuePartie.class))

            .andContains(subTasks -> {

               prochaineImagePartie(subTasks);
               observerModelePartie(subTasks, idPartie);
               
               reagirActionJoueur(subTasks, idPartie);
               reagirClicSouris(subTasks);
              
            });
	    }
	 
	 
	 
	 private static void reagirClicSouris(FrontendTasks tasks) {

			tasks.task("reagirClicSouris")

			        .waitsFor(event(EvtClicSouris.class))

			        .thenExecutes(inputs -> {

			        	DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
			        	EvtClicSouris    evtClicSouris    = inputs.get(event(EvtClicSouris.class));
			        	

			        	evtClicSouris.appliquerA(donneesVuePartie);
			        	
			        	
			        });
		}
	 
	 private static void reagirActionJoueur(FrontendTasks tasks, String idPartie) {

	        tasks.task("reagirActionJoueur")

	                .waitsFor(event(EvtActionJoueur.class))

	                .thenExecutes(inputs -> {

	                    DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
	                    EvtActionJoueur  evtActionJoueur  = inputs.get(event(EvtActionJoueur.class));

	                    evtActionJoueur.appliquerA(donneesVuePartie);
	                    
	                   
	                });
	    }
	 private static void prochaineImagePartie(FrontendTasks subTasks) {

	        subTasks.task("prochaineImagePartie")

	                 .waitsFor(clock().nextTick())

	                 .thenExecutes(inputs -> {
	                	 
	                	 if(!partieSurPause) {
	                	 
	                	 Tick             tick             = inputs.get(clock().nextTick());
	                    DonneesVuePartie donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
	                    VuePartie        vuePartie        = inputs.get(created(VuePartie.class));
	                    
	                   donneesVuePartie.reagirTempsQuiPasse(tick.elapsedTime());
                 donneesVuePartie.afficherSur(vuePartie);
                 
	                	 }

             });
	 }
	        
	 
	 private static void creerDonneesVuePartie(FrontendTasks tasks, String idPartie) {

	        tasks.task(create(DonneesVuePartie.class))

	             .waitsFor("Initialisation")

	             .executesAndReturnsCreatedValue(inputs -> {

	            	 DonneesVuePartie donneesVuePartie = new DonneesVuePartie();
	            	 
	            	 
	            	 
	            	 return donneesVuePartie;
	             });

		 
	    }
	 
	 private static void observerModelePartie(FrontendTasks tasks, String idPartie) {

	        tasks.task("observerModelePartie")

	                .waitsFor(modified(ModelePartie.class, idPartie))

	                .thenExecutes(inputs -> {

	                    VuePartie              vuePartie        = inputs.get(created(VuePartie.class));
	                    DonneesVuePartie       donneesVuePartie = inputs.get(created(DonneesVuePartie.class));
	                    Modified<ModelePartie> modifiedPartie   = inputs.get(modified(ModelePartie.class, idPartie));

	                    ModelePartie modelePartie = modifiedPartie.currentValue();

	                    modelePartie.afficherInfoPartieSur(vuePartie);
	                    modelePartie.copierDonneesDans(donneesVuePartie);

	                });
	    }
	
	
        
	   }

