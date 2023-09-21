package battleship.frontal.donnees;

import battleship.commun.enums.Action;
import battleship.commun.enums.Cadran;
import battleship.commun.monde2d.MondeBattleship2d;
import battleship.frontal.vues.VuePartie;
import ca.ntro.app.frontend.ViewData;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.input.MouseEvent;

public class DonneesVuePartie implements ViewData{

	    private MondeBattleship2d mondeBattleship2d = new MondeBattleship2d();
	    private String fpsCourant = "0";
	    
	    private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;


	  
	    private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
	    private long imagesAfficheesDepuisDernierCalculFps = 0;


	    
	    public void afficherSur(VuePartie vuePartie) {

	        vuePartie.viderCanvas();
	        vuePartie.afficherImagesParSeconde("FPS " + fpsCourant);
	        vuePartie.afficherBattleship2d(mondeBattleship2d);
	        
	        imagesAfficheesDepuisDernierCalculFps++;

	    }
	    
	    private void calculerFpsSiNecessaire() {
	        long horodatageMaintenant = Ntro.time().nowMilliseconds();
	        long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;

	        if(millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
	            calculerFpsMaintenant(millisecondesEcoulees);

	            imagesAfficheesDepuisDernierCalculFps = 0;
	            horodatageDernierCalculFps = horodatageMaintenant;
	        }
	    }

	   
	    private void calculerFpsMaintenant(long millisecondesEcoulees) {
	        double secondesEcoulees = millisecondesEcoulees / 1E3;
	        double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
	        fpsCourant = String.valueOf(Math.round(fps));
	    }

		public void reagirTempsQuiPasse(double elapsedTime) {
			mondeBattleship2d.onTimePasses(elapsedTime);
			
		}
		public void copierDonnesDe(MondeBattleship2d mondeBattleship2d) {
			mondeBattleship2d.copyDataFrom(mondeBattleship2d);

	}

		public void appliquerActionJoueur(Cadran cadran, Action action) {
			mondeBattleship2d.appliquerActionJoueur(cadran, action);
			
		}

		

		public void reagirClicSouris(World2dMouseEventFx mouseEvent) {
			mondeBattleship2d.dispatchMouseEvent(mouseEvent);
			
		}
}

