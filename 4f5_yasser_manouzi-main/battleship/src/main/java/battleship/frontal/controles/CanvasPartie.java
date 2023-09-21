package battleship.frontal.controles;

import battleship.commun.monde2d.MondeBattleship2d;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;

public class CanvasPartie extends ResizableWorld2dCanvasFx{

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		setInitialWorldSize(MondeBattleship2d.LARGEUR_MONDE, MondeBattleship2d.HAUTEUR_MONDE);
	}

	public void afficherFps(String imagesParSeconde) {
		drawOnCanvas(gc -> {
			
			gc.fillText(imagesParSeconde, 60, 12);
		});
		
	}

}
