package battleship.commun.monde2d;

import battleship.commun.enums.Cadran;

import battleship.commun.messages.MsgAjouterPoint;
import battleship.maquettes.MaquetteSession;
import ca.ntro.app.NtroApp;
import ca.ntro.app.fx.controls.ResizableWorld2dCanvasFx;
import ca.ntro.app.fx.controls.World2dMouseEventFx;
import ca.ntro.core.initialization.Ntro;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.ArcType;

public class Balle2d extends ObjetBattleship2d{

	 private Palette2d paletteGauche;
	    private Palette2d paletteDroite;
	    
	    private Image image = new Image("/balle.png");
	
	    private static final double DUREE_ANIMATION = 2.5;

	    
	    private double secondes_restantes_animation = 0;
	    
	    private AudioClip sonPoc = new AudioClip(Balle2d.class.getResource("/poc.wav").toString());

	    

	private static final double EPSILON = 1;
	public Balle2d() {
        super();
    }
	
	public Palette2d getPaletteGauche() {
		return paletteGauche;
	}

	public void setPaletteGauche(Palette2d paletteGauche) {
		this.paletteGauche = paletteGauche;
	}

	public Palette2d getPaletteDroite() {
		return paletteDroite;
	}

	public void setPaletteDroite(Palette2d paletteDroite) {
		this.paletteDroite = paletteDroite;
	}
	

	public Balle2d(Palette2d paletteGauche, Palette2d paletteDroite) {
        super();

        setPaletteGauche(paletteGauche);
        setPaletteDroite(paletteDroite);
    }

    @Override
    public void initialize() {
        setWidth(10);
        setHeight(10);
        
        choisirEtatInitial();
        
        
    }

    
    private void choisirEtatInitial() {

        setTopLeftY(10);
        setSpeedY(100 + Ntro.random().nextInt(20));

        if(Ntro.random().nextBoolean()) {

            setTopLeftX(100);
            setSpeedX(100 + Ntro.random().nextInt(20));

        }else {

            setTopLeftX(MondeBattleship2d.LARGEUR_MONDE - 100 - getWidth());
            setSpeedX(-100 - Ntro.random().nextInt(20));

        }
    }
    @Override
    public void drawOn(ResizableWorld2dCanvasFx canvas) {

        canvas.drawOnWorld(gc -> {

        	 double echelonnage = 1.0;
             if(secondes_restantes_animation > 0) {
                 double pourcentage_ecoule_animation = secondes_restantes_animation / DUREE_ANIMATION;
                 echelonnage = 1 + 2*Math.sin(Math.PI * pourcentage_ecoule_animation);
             }
        	
             gc.drawImage(image,
                     getTopLeftX(),
                     getTopLeftY(),
                     getWidth() * echelonnage,
                     getHeight() * echelonnage);

        });
    }
    
    public void demarrerAnimation() {
        secondes_restantes_animation = DUREE_ANIMATION;
    }
         
    private void jouerSonPoc() {
	    sonPoc.play();
	}
    
    @Override
    protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
        return false;
    }

    @Override
    public String id() {
        return "balle";
    }
    

        @Override
        public void onTimePasses(double secondsElapsed) {
            super.onTimePasses(secondsElapsed);

            if(secondes_restantes_animation > 0) {
                secondes_restantes_animation -= secondsElapsed;
            }
            if(balleFrappeMurGauche()) {

                choisirEtatInitial();
                ajouterPoint(Cadran.DROITE);
                

            } else if(balleFrappeMurDroit()) {

                choisirEtatInitial();
                ajouterPoint(Cadran.GAUCHE);
                
               

        }else if(balleFrappePlafond()) {

            balleRebondiSurPlafond();

        }else if(balleFrappePlancher()) {

            balleRebondiSurPlancher();
        
            
        }else if(balleFrappePalette(paletteGauche)) {

            balleRebondiSurPalette(paletteGauche);
        

        }else if(balleFrappePalette(paletteDroite)) {

            balleRebondiSurPalette(paletteDroite);

        }
            
}

	private void balleRebondiSurPalette(Palette2d palette) {
	
		jouerSonPoc();
	    if(getTopLeftX() < palette.getTopLeftX()) {
	
	        setTopLeftX(palette.getTopLeftX() - getWidth() - EPSILON);
	
	    } else {
	
	        setTopLeftX(palette.getTopLeftX() + palette.getWidth() + EPSILON);
	
	    }
	
	    setSpeedX(-getSpeedX());
	    palette.insererEffet();
	}
	
	private boolean balleFrappePalette(Palette2d palette) {
        return collidesWith(palette);
    }

	
	private boolean balleFrappePlancher() {
        return collidesWith(0,
                            getWorld2d().getHeight(),
                            getWorld2d().getWidth(),
                            1);
    }

    private boolean balleFrappePlafond() {
        return collidesWith(0,
                            0,
                            getWorld2d().getWidth(),
                            1);
    }

    private boolean balleFrappeMurDroit() {
        return collidesWith(getWorld2d().getWidth(),
                            0,
                            1,
                            getWorld2d().getHeight());
    }

    private boolean balleFrappeMurGauche() {
        return collidesWith(0,
                            0,
                            1,
                            getWorld2d().getHeight());
    }

    private void balleRebondiSurPlancher() {
    	jouerSonPoc();
        setTopLeftY(getWorld2d().getHeight() - this.getHeight() - EPSILON);
        setSpeedY(-getSpeedY());
    }

    private void balleRebondiSurPlafond() {
    	jouerSonPoc();
        setTopLeftY(0 + EPSILON);
        setSpeedY(-getSpeedY());
    }

    private void balleRebondiSurMurDroit() {
        setTopLeftX(getWorld2d().getWidth() - this.getWidth() - EPSILON);
        setSpeedX(-getSpeedX());
    }

    private void balleRebondiSurMurGauche() {
        setTopLeftX(0 + EPSILON);
        setSpeedX(-getSpeedX());
    }
	
	private void ajouterPoint(Cadran cadran) {
        MsgAjouterPoint msgAjouterPoint = NtroApp.newMessage(MsgAjouterPoint.class, MaquetteSession.idJoueur);
        msgAjouterPoint.setMondeBattleship2d(getWorld2d());
        msgAjouterPoint.setCadran(cadran.name());
        msgAjouterPoint.send();
    }
}
