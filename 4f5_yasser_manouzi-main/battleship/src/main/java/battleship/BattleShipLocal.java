package battleship;

import battleship.commun.Declarations;
import battleship.dorsal.DorsalBattleship;
import battleship.frontal.FrontalBattleship;
import battleship.maquettes.MaquetteSession;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class BattleShipLocal implements NtroClientFx{

	public static void main(String[] args)  {
		
		NtroClientFx.launch(args);
		MaquetteSession.initialiser(args);
	}
	@Override
	public void registerBackend(BackendRegistrar registrar) {
		
		
		registrar.registerBackend(new DorsalBattleship());
		
	}

	@Override

	
	public void registerFrontend(FrontendRegistrarFx registrar) {
		registrar.registerFrontend(new FrontalBattleship());
		
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		Declarations.declarerMessages(registrar);
	}
	@Override
	public void registerModels(ModelRegistrar registrar) {
		Declarations.declarerModeles(registrar);
	}

}
