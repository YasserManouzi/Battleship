package battleship.maquettes;

import battleship.commun.enums.Cadran;

import battleship.commun.valeurs.Joueur;


public class MaquetteSession {
	
	 public static boolean modeTest = true;

	  static Joueur joueurCourant = MaquetteJoueurs.joueurAleatoire();
	    private static Cadran cadranCourant = Cadran.DROITE;
	    
	    public static String idJoueur = null;

	 

	    public static Joueur getJoueurCourant() {
			return joueurCourant;
		}

		public static void setJoueurCourant(Joueur joueurCourant) {
			MaquetteSession.joueurCourant = joueurCourant;
		}

		public static String getIdJoueur() {
			return idJoueur;
		}

		public static void setIdJoueur(String idJoueur) {
			MaquetteSession.idJoueur = idJoueur;
		}

		public static boolean siOnPeutJouerGauche() {
	        return cadranCourant == Cadran.GAUCHE 
	                || cadranCourant == Cadran.LES_DEUX;

	    }

	    public static boolean siOnPeutJouerDroite() {
	        return cadranCourant == Cadran.DROITE 
	                || cadranCourant == Cadran.LES_DEUX;

	    }

	    public static void memoriserCadranCourant(String prenom, String nom) {

	        if(prenom.equals(joueurCourant.getId())) {

	            cadranCourant = Cadran.GAUCHE;

	        }else if(nom.equals(joueurCourant.getId())) {

	            cadranCourant = Cadran.DROITE;

	        }else {

	            cadranCourant = Cadran.LES_DEUX;
	        }
	    }

	    public static void initialiser(String[] args) {
	        
	        String prenom = null;
	        String nom = null;
	        int points = 0;
	        int jetons = 0;
	        int victoires = 0;
	         int defaites = 0;
	         String couleur = null;
	      
	        
	       

	        if(args.length > 0) {
	            idJoueur = args[0];
	            modeTest = false;
	      
	        }           

	        if(args.length > 1) {
	        	prenom = args[1];
	        }else {
	        	prenom = MaquetteJoueurs.prenomAleatoire();
	        }

	        if(args.length > 2) {
	        	nom = args[2];
	        }else {
	        	nom = MaquetteJoueurs.nomAleatoire();
	        }
	        if(args.length > 3) {
	        	String points_str = String.valueOf(points);
	        	points_str = args[3];
	        }else {
	        	points = MaquetteJoueurs.pointsAleatoire();
	        }
	        
	        if(args.length > 4) {
	        	String jetons_str = String.valueOf(jetons);
	        	jetons_str = args[4];
	        }else {
	        	jetons = MaquetteJoueurs.jetonsAleatoire();
	        }
	        
	        if(args.length > 5) {
	        	String victoire_str = String.valueOf(victoires);
	        	victoire_str = args[5];
	        }else {
	        	victoires = MaquetteJoueurs.victoiresAleatoire();
	        }
	        if(args.length > 6) {
	        	String defaites_str = String.valueOf(defaites);
	        	defaites_str = args[6];
	        	
	        }else {
	        	defaites = MaquetteJoueurs.defaitesAleatoire();
	        }
	        
	        if(args.length > 7) {
	        	couleur = args[7];
	        }else {
	        couleur = MaquetteJoueurs.couleurAleatoire();		
	        	}
	        
	        	

	        joueurCourant = new Joueur(idJoueur, prenom, nom, points, jetons, victoires, defaites, couleur);
	    }

}
