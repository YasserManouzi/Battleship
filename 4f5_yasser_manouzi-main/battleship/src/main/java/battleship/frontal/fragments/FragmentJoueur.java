package battleship.frontal.fragments;

import battleship.commun.messages.MsgAjouterJoueur;
import battleship.commun.messages.MsgRetirerJoueur;
import battleship.frontal.evenements.EvntAfficherMenu;
import battleship.frontal.evenements.EvtAfficherStatistiquesJoueur;
import battleship.maquettes.MaquetteSession;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FragmentJoueur extends ViewFragmentFx {


		@FXML
		private Button boutonSupprimerPartie;
		
		private String idJoueur;
		
	    
		@FXML
		private Button boutonJoindreStatistiquesJoueur;

	    @FXML
	    private Label labelNomJoueur;
	    
	
	    public void memoriserIdJoueur(String idJoueur) {
	        this.idJoueur = idJoueur;
	        installerMsgSupprimerPartie();
	    }
	    
	    public String getIdJoueur() {
			return idJoueur;
		}

		public void setIdJoueur(String idJoueur) {
			this.idJoueur = idJoueur;
		}

		@Override
	    public void initialiser() {

	        
	        Ntro.assertNotNull("boutonJoindreStatistiquesJoueur", boutonJoindreStatistiquesJoueur);
	        
	        Ntro.assertNotNull("labelNomJoueur", labelNomJoueur);
	        
	       

	        
	        
	        installerEvtAfficherStatistiquesJoueur();
	    }
	    
	   
	    
	    protected void installerMsgSupprimerPartie() {

	        MsgRetirerJoueur msgRetirerPartie = NtroApp.newMessage(MsgRetirerJoueur.class, MaquetteSession.idJoueur);
	        msgRetirerPartie.setIdJoueur(idJoueur);
	        
	        boutonSupprimerPartie.setOnAction(evtFx -> {
	        	msgRetirerPartie.send();
	        });
	    }

	    
	    
	    private void installerEvtAfficherStatistiquesJoueur() {

	        EvtAfficherStatistiquesJoueur evtNtro = NtroApp.newEvent(EvtAfficherStatistiquesJoueur.class);

	        boutonJoindreStatistiquesJoueur.setOnAction(evtFx -> {

	            evtNtro.trigger();
	        });
	    }

	    public void afficherNomJoueur(String nomJoueur) {
	    	labelNomJoueur.setText(nomJoueur);
	    }
	   
	    
	    
	    

}
