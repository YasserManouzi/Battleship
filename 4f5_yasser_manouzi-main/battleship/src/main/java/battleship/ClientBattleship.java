package battleship;

import battleship.commun.Declarations;
import battleship.dorsal.DorsalBattleshipDistant;
import battleship.frontal.FrontalBattleship;
import battleship.maquettes.MaquetteSession;
import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class ClientBattleship implements NtroClientFx{

	public static void main(String[] args)  {
		MaquetteSession.initialiser(args);
		NtroClientFx.launch(args);
	}
	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerBackend(new DorsalBattleshipDistant());
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		// TODO Auto-generated method stub
		registrar.registerFrontend(new FrontalBattleship());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		// TODO Auto-generated method stub
		Declarations.declarerMessages(registrar);
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		// TODO Auto-generated method stub
		Declarations.declarerModeles(registrar);
	}

}
