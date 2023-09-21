package battleship.frontal.vues;

import java.net.URL;




import java.util.List;



import battleship.commun.messages.MsgAjouterJoueur;
import battleship.commun.modeles.ModeleJoueur;
import battleship.commun.valeurs.Joueur;
import battleship.frontal.evenements.EvntAfficherMenu;
import battleship.frontal.evenements.EvtAfficherPartie;
import battleship.frontal.fragments.FragmentJoueur;
import battleship.maquettes.MaquetteJoueurs;
import battleship.maquettes.MaquetteSession;
import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;


public class VueJoueur extends ViewFx {

	
	
	@FXML
	private Button boutonMenuStatistique;
	
	@FXML
	private Button boutonPartie;
	
	@FXML
	private Button boutonAjouterJoueur;

	
	@FXML
	private VBox conteneurJoueur;
	
	private ViewLoader<FragmentJoueur> viewLoaderJoueur;
	
	

	
	
	public ViewLoader<FragmentJoueur> getViewLoaderJoueur() {
		return viewLoaderJoueur;
	}





	public void setViewLoaderJoueur(ViewLoader<FragmentJoueur> viewLoaderJoueur) {
		this.viewLoaderJoueur = viewLoaderJoueur;
	}





	@Override
	public void initialiser() {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("boutonMenuStatistique", boutonMenuStatistique);
		Ntro.assertNotNull("boutonAjouterJoueur", boutonAjouterJoueur);
		Ntro.assertNotNull("boutonPartie", boutonPartie);
		Ntro.assertNotNull("conteneurJoueur", conteneurJoueur);

		

		installerEvtAfficherMenu();
		
		installerMsgAjouterJoueur();
		installerEvtAfficherPartie();
		
	
	}
	

	

	private void installerEvtAfficherMenu() {

        EvntAfficherMenu evtNtro = NtroApp.newEvent(EvntAfficherMenu.class);

        boutonMenuStatistique.setOnAction(evtFx -> {

            evtNtro.trigger();
        });
    }
	private void installerMsgAjouterJoueur() {

        MsgAjouterJoueur msgAjouterJoueur = NtroApp.newMessage(MsgAjouterJoueur.class, MaquetteSession.idJoueur);
        
        boutonAjouterJoueur.setOnAction(evtFx -> {
        
        	msgAjouterJoueur.setUnJoueur(MaquetteJoueurs.joueurCourant());	
        	msgAjouterJoueur.send();
        MaquetteJoueurs.prochainJoueur();
        });
        
    }
	
	private void installerEvtAfficherPartie() {

        EvtAfficherPartie evtNtro = NtroApp.newEvent(EvtAfficherPartie.class);

        boutonPartie.setOnAction(evtFx -> {

            evtNtro.trigger();
        });
    }
	
	public void afficher(ModeleJoueur modele) {
		List<Joueur> joueur = modele.getLesJoueurs();
	}
	
	public void ajouterJoueur(Joueur joueur) {
		FragmentJoueur fragment = joueur.creeFragment(viewLoaderJoueur);
		joueur.afficherSur(fragment);
		
		conteneurJoueur.getChildren().add(fragment.rootNode());
	}
	
	
	
	public void viderListeParties() {
		conteneurJoueur.getChildren().clear();
    }
	
	
	
	
	


	

}
