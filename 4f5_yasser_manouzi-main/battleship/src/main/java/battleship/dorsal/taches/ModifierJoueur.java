package battleship.dorsal.taches;
import static ca.ntro.app.tasks.backend.BackendTasks.*;


import battleship.commun.messages.MsgAjouterJoueur;
import battleship.commun.messages.MsgRetirerJoueur;
import battleship.commun.modeles.ModeleJoueur;
import ca.ntro.app.tasks.backend.BackendTasks;

public class ModifierJoueur {

	
	public static void creerTaches(BackendTasks tasks, String idJoueur) {
		tasks.taskGroup("ModifierJoueur" + "/" + idJoueur)
		.waitsFor(model(ModeleJoueur.class, idJoueur))
		.andContains(subTasks -> {
		
			
			ajouterJoueur(subTasks, idJoueur);
			supprimerJoueur(subTasks, idJoueur);
			
		});
	}
	
	
	
	private static void ajouterJoueur(BackendTasks subTasks, String idJoueur) {
		subTasks.task("ajouterJoueur" + "/" +  idJoueur)
		
		.waitsFor(message(MsgAjouterJoueur.class, idJoueur))
		
		.thenExecutes(inputs -> {
			
			MsgAjouterJoueur msgAjouterJoueur = inputs.get(message(MsgAjouterJoueur.class, idJoueur));
			
			
			ModeleJoueur joueur = inputs.get(model(ModeleJoueur.class, idJoueur));
			
			
			msgAjouterJoueur.ajouterA(joueur);
		});
	}
	
	
	 private static void supprimerJoueur(BackendTasks subTasks, String idJoueur) {
	        subTasks.task("supprimerJoueur" + "/" + idJoueur)

	             .waitsFor(message(MsgRetirerJoueur.class, idJoueur))
	             
	             .thenExecutes(inputs -> {

	            	 MsgRetirerJoueur msgRetirerJoueur = inputs.get(message(MsgRetirerJoueur.class, idJoueur));
	                 ModeleJoueur    joueur          = inputs.get(model(ModeleJoueur.class, idJoueur));

	                 msgRetirerJoueur.retirerDe(joueur);
	             });

	    }
	 
	 
}
