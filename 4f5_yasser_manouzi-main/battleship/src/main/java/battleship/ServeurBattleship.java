package battleship;

import battleship.commun.Declarations;
import battleship.dorsal.DorsalBattleship;
import ca.ntro.app.NtroServerJdk;
import ca.ntro.app.ServerRegistrarJdkImpl;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;

public class ServeurBattleship implements NtroServerJdk{

	
	public static void main(String[] args) {
        NtroServerJdk.launch(args);
    }
	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		registrar.registerBackend(new DorsalBattleship());
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

	@Override
	public void registerServer(ServerRegistrarJdkImpl registrar) {
		// TODO Auto-generated method stu
		Declarations.declarerServeur(registrar);
	}

}
