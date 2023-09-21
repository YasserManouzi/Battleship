package battleship.frontal.vues;

import java.util.List;


import battleship.commun.modeles.ModeleJoueur;
import battleship.commun.valeurs.Joueur;
import battleship.frontal.evenements.EvtAfficherJoueur;
import battleship.frontal.evenements.EvtAfficherStatistiquesJoueur;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VueStatistiquesJoueur extends ViewFx{

	@FXML
	private Button boutonQuitterStatistiqueJoueur;
	
	private String idJoueur;
	
	 public String getIdJoueur() {
		return idJoueur;
	}




	public void setIdJoueur(String idJoueur) {
		this.idJoueur = idJoueur;
	}
	
	@FXML
    private Label labelIdJoueur;
 

	@FXML
	    private Label labelPrenom;
	 
	 @FXML
	    private Label labelNom;
	 
	 @FXML
	    private Label labelPoints;
	 
	 @FXML
	 	private Label labelJetons;
	 
	 @FXML
	 	private Label labelVictoires;
	 
	 @FXML
	 	private Label labelDefaites;
	 
	 @FXML
	 	private Label labelCouleur;
	 

		
	 
	 
	 
	 
	 
	@Override
	public void initialiser() {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("boutonQuitterStatistiqueJoueur", boutonQuitterStatistiqueJoueur);
		Ntro.assertNotNull("labelIdJoueur", labelIdJoueur);
		Ntro.assertNotNull("labelPrenom", labelPrenom);
		Ntro.assertNotNull("labelNom", labelNom);
		Ntro.assertNotNull("labelPoints", labelPoints);
		Ntro.assertNotNull("labelJetons", labelJetons);
		Ntro.assertNotNull("labelVictoires", labelVictoires);
		Ntro.assertNotNull("labelDefaites", labelDefaites);
		Ntro.assertNotNull("labelCouleur", labelCouleur);
		
		
		installerEvtAfficherJoueur();
		
	}
	
	  private void installerEvtAfficherJoueur() {

		  EvtAfficherJoueur evtNtro = NtroApp.newEvent(EvtAfficherJoueur.class);
		  boutonQuitterStatistiqueJoueur.setOnAction(evtFx -> {

	            evtNtro.trigger();

	        });
	    }
	  
	  public void afficher(ModeleJoueur modele) {
			List<Joueur> joueur = modele.getLesJoueurs();
		}
	  public void afficherId(String id) {
		  labelIdJoueur.setText(id);
	  }
	  
	  public void afficherPrenom(String prenom) {
	    	labelPrenom.setText(prenom);
	    }
	  
	  public void afficherNomJoueur(String nomJoueur) {
		  labelNom.setText(nomJoueur);
	    }
	  
	  public void afficherPoints(int points) {
		 
		  labelPoints.setText(Integer.toString(points));
	    }
	  
	  public void afficherJetons(int jetons) {
			 
		  labelJetons.setText(Integer.toString(jetons));
	    }
	  
	  public void afficherVictoires(int victoires) {
			 
		  labelVictoires.setText(Integer.toString(victoires));
	    }
	  
	  public void afficherDefaites(int defaites) {
			 
		  labelDefaites.setText(Integer.toString(defaites));
	    }
	  
	  public void afficherCouleur(String couleur) {
			 
		  labelCouleur.setText(couleur);
	    }
	  
	  
	  
	 
	  
	  

	
}
