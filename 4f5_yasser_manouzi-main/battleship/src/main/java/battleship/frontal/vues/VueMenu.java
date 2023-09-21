package battleship.frontal.vues;

import java.net.URL;


import java.util.ResourceBundle;

import battleship.frontal.controles.CanvasPartie;
import battleship.frontal.evenements.EvtAfficherJoueur;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VueMenu extends ViewFx{
	
	@FXML
	private Button boutonJoindreJoueur;
	
	
	@Override
	public void initialiser() {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("boutonJoindreJoueur", boutonJoindreJoueur);
		
		
		
		installerEvtJoueur();
	}
	
	private void installerEvtJoueur() {

		EvtAfficherJoueur evtNtro = NtroApp.newEvent(EvtAfficherJoueur.class);

		boutonJoindreJoueur.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}

}
