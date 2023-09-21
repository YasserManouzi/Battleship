package battleship.commun;

import battleship.commun.messages.MsgAjouterJoueur;



import battleship.commun.messages.MsgAjouterPoint;
import battleship.commun.messages.MsgRetirerJoueur;
import battleship.commun.modeles.ModelePartie;
import battleship.commun.modeles.ModeleJoueur;
import battleship.commun.monde2d.Balle2d;
import battleship.commun.monde2d.MondeBattleship2d;
import battleship.commun.monde2d.Palette2d;
import battleship.commun.valeurs.Joueur;
import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerMessage(MsgAjouterJoueur.class);
		registrar.registerMessage(MsgRetirerJoueur.class);
		registrar.registerMessage(MsgAjouterPoint.class);
	
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerModel(ModeleJoueur.class);
		
		registrar.registerModel(ModelePartie.class);
		
		registrar.registerValue(Joueur.class);
		
		
		registrar.registerValue(MondeBattleship2d.class);
		
		registrar.registerValue(Balle2d.class);
		
		registrar.registerValue(Palette2d.class);
	}

	public static void declarerServeur(ServerRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerName("localhost");
		
		registrar.registerPort(8002);
    }

	}


