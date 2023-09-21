package battleship.commun.monde2d;

import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;


public class Palette2d extends ObjetBattleship2d {

    private static final double VITESSE_PALETTE = 200;
    
    private static final double SECONDES_UN_EFFET = 0.4;

   
    private double secondesRestantesPourEffet = 0;
    private InnerShadow innerShadow = new InnerShadow();
    
    private boolean selectionnee;

    public Palette2d() {
        super();
    }

    public Palette2d(double topLeftX) {
        super();

        setTopLeftX(topLeftX);
    }

    @Override
    public void initialize() {
        setWidth(10);
        setHeight(100);

        setTopLeftY(getWorld2d().getHeight()/2 - getHeight()/2);
    }

    @Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {

        canvas.drawOnWorld(gc -> {

            gc.save();
            
            if(selectionnee) {
                gc.setFill(Color.CYAN);
            }
            
            if(secondesRestantesPourEffet > 0) {
                innerShadow.setOffsetX(getWidth() * secondesRestantesPourEffet / SECONDES_UN_EFFET);
                innerShadow.setOffsetY(0);
                innerShadow.setColor(Color.DARKBLUE);
                gc.setEffect(innerShadow);
            }

            gc.fillRect(getTopLeftX(),
                        getTopLeftY(),
                        getWidth(), 
                        getHeight());

            gc.restore();

        });

    }
    public void insererEffet() {
        secondesRestantesPourEffet = SECONDES_UN_EFFET;
    }


    public void onTimePasses(double secondsElapsed) {
        super.onTimePasses(secondsElapsed);

        if(secondesRestantesPourEffet > 0) {
            secondesRestantesPourEffet -= secondsElapsed;
        }
    }
   

    @Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
    	 selectionnee = !selectionnee;

         return true;
    }
    
    public void deselectionner() {
        selectionnee = false;
    }

    public void monter() {
        setSpeedY(-VITESSE_PALETTE);
    }

    public void descendre() {
        setSpeedY(+VITESSE_PALETTE);
    }

    public void arreter() {
        setSpeedY(0);
    }
}
