package battleship.dorsal;

import battleship.dorsal.taches.ModifierPartie;
import battleship.dorsal.taches.ModifierJoueur;
import battleship.maquettes.MaquetteJoueurs;
import battleship.maquettes.MaquetteParties;
import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;

public class DorsalBattleship extends LocalBackendNtro{

	@Override
	public void createTasks(BackendTasks tasks) {
		// TODO Auto-generated method stub
		
		for(String idPartie : MaquetteParties.partie()) {
            ModifierPartie.creerTaches(tasks, idPartie);
        }
		
		for(String idJoueur : MaquetteJoueurs.statistiquesJoueur()) {
            ModifierJoueur.creerTaches(tasks, idJoueur);
        }
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}

}
