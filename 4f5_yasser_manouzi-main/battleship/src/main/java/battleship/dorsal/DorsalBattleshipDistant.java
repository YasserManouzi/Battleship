package battleship.dorsal;

import battleship.commun.Declarations;
import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;

public class DorsalBattleshipDistant extends RemoteBackendNtro{

	@Override
	public void registerServer(ServerRegistrar registrar) {
		// TODO Auto-generated method stub
		Declarations.declarerServeur(registrar);
	}

}
