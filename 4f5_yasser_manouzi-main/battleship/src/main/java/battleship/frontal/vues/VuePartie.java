package battleship.frontal.vues;

import battleship.commun.enums.Action;
import battleship.commun.enums.Cadran;
import battleship.commun.monde2d.MondeBattleship2d;
import battleship.commun.valeurs.ActionJoueur;
import battleship.frontal.controles.CanvasPartie;
import battleship.frontal.evenements.EvtActionJoueur;
import battleship.frontal.evenements.EvtAfficherJoueur;
import battleship.frontal.evenements.EvtClicSouris;
import battleship.maquettes.MaquetteSession;
import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class VuePartie extends ViewFx{

	
	@FXML
    private VBox vboxPartie;
	
	@FXML
	private Button boutonQuitterPartie;
	
	@FXML
	    private Label labelNomPremierJoueur;

	    @FXML
	    private Label labelNomDeuxiemeJoueur;

	    @FXML
	    private Label labelScorePremierJoueur;

	    @FXML
	    private Label labelScoreDeuxiemeJoueur;
	
	@FXML
	private CanvasPartie canvasPartie;
	@Override
	public void initialiser() {
		// TODO Auto-generated method stub
		
		Ntro.assertNotNull("vboxPartie", vboxPartie);

        
        installerEvtActionJoueur();
		
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
		
		 Ntro.assertNotNull("labelNomPremierJoueur", labelNomPremierJoueur);
	        Ntro.assertNotNull("labelNomDeuxiemeJoueur", labelNomDeuxiemeJoueur);

	        Ntro.assertNotNull("labelScorePremierJoueur", labelScorePremierJoueur);
	        Ntro.assertNotNull("labelScoreDeuxiemeJoueur", labelScoreDeuxiemeJoueur);
		
	        installerEvtAfficherJoueur();
		installerEvtClicSouris();
		Ntro.assertNotNull(canvasPartie);
	}
	
	 @SuppressWarnings("unchecked")
	    private void installerEvtClicSouris() {

	        EvtClicSouris evtClicSouris = NtroApp.newEvent(EvtClicSouris.class);

	        canvasPartie.onMouseEvent(mouseEventNtro -> {

	            if(mouseEventNtro.mouseEventFx().getEventType().equals(MouseEvent.MOUSE_CLICKED)) {

	                evtClicSouris.setMouseEvent(mouseEventNtro);
	                evtClicSouris.trigger();
	            }
	        });
	    }
	
	private void installerEvtActionJoueur() {

        EvtActionJoueur evtNtro = NtroApp.newEvent(EvtActionJoueur.class);

        vboxPartie.addEventFilter(KeyEvent.KEY_PRESSED, evtFx -> {

            if(evtFx.getCode().equals(KeyCode.W)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.HAUT));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.S)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.BAS));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.UP)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.HAUT));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.DOWN)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.BAS));
                evtNtro.trigger();
            }
        });

        vboxPartie.addEventFilter(KeyEvent.KEY_RELEASED, evtFx -> {

            if(evtFx.getCode().equals(KeyCode.W)
                    || evtFx.getCode().equals(KeyCode.S)) {

                evtNtro.setAction(new ActionJoueur(Cadran.GAUCHE, Action.ARRET));
                evtNtro.trigger();

            }else if(evtFx.getCode().equals(KeyCode.UP)
                    || evtFx.getCode().equals(KeyCode.DOWN)) {

                evtNtro.setAction(new ActionJoueur(Cadran.DROITE, Action.ARRET));
                evtNtro.trigger();
            }
        });
	}
	
	private void installerEvtAfficherJoueur() {

		EvtAfficherJoueur evtNtro = NtroApp.newEvent(EvtAfficherJoueur.class);

		boutonQuitterPartie.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}
	public void viderCanvas() {
		canvasPartie.clearCanvas();
		
	}
	public void afficherImagesParSeconde(String fps) {
		canvasPartie.afficherFps(fps);
		
	}
	public void afficherBattleship2d(MondeBattleship2d mondeBattleship2d) {
		mondeBattleship2d.drawOn(canvasPartie);
		
	}
	
	public void afficherNomPremierJoueur(String nomPremierJoueur) {
        labelNomPremierJoueur.setText(nomPremierJoueur);
    }


    public void afficherNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
        labelNomDeuxiemeJoueur.setText(nomDeuxiemeJoueur);
    }


    public void afficherScorePremierJoueur(String scorePremierJoueur) {
        labelScorePremierJoueur.setText(scorePremierJoueur);
    }


    public void afficherScoreDeuxiemeJoueur(String scoreDeuxiemeJoueur) {
        labelScoreDeuxiemeJoueur.setText(scoreDeuxiemeJoueur);
    }


}
