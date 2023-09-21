package battleship.maquettes;

import java.util.List;


import battleship.commun.valeurs.Joueur;
import ca.ntro.core.initialization.Ntro;

public class MaquetteJoueurs {

	


	 public static List<String> statistiquesJoueur(){
	        return List.of("joueur1","joueur2","joueur3");
	    }
	
    public static void prochainJoueur() {
    	MaquetteSession.joueurCourant = eviterRepetitionDuPrenom(joueurAleatoire());
    	
    }
    
    public static Joueur joueurCourant () {
        return MaquetteSession.joueurCourant;
    }

    public static Joueur joueurAleatoire() {
    	Joueur joueur = new Joueur();
    	
    	joueur.setId(idAleatoire());
    	joueur.setPrenom(prenomAleatoire());
    	joueur.setNom(nomAleatoire());
    	joueur.setPoints(pointsAleatoire());
    	joueur.setJetons(jetonsAleatoire());
    	joueur.setVictoires(victoiresAleatoire());
    	joueur.setDefaites(defaitesAleatoire());
    	joueur.setCouleur(couleurAleatoire());
    	

        return joueur;
    }

    private static Joueur eviterRepetitionDuPrenom(Joueur joueurAleatoire) {

      
          while(joueurAleatoire.getPrenom().equals(MaquetteSession.joueurCourant.getPrenom())) {
     

        	  joueurAleatoire.setNom(nomAleatoire());
        }
  
        return joueurAleatoire;
    }
    
    
    
    


     static String idAleatoire() {
        return Ntro.random().nextId(4);
    }

     static String prenomAleatoire() {

        List<String> choixDePrenoms = List.of("Alice", 
                                           "Bob", 
                                           "Chaaya", 
                                           "Dominic", 
                                           "�lisabeth", 
                                           "Firas", 
                                           "Gregson",
                                           "Mehdi",
                                           "Louis",
                                           "Marcel",
                                           "Ashwin",
                                           "Ichiro",
                                           "Jun");

        return Ntro.random().choice(choixDePrenoms);
    }

     static String nomAleatoire() {

        List<String> choixDeNoms = List.of("Abdenouri", 
                                           "Ahmadi", 
                                           "Augustin", 
                                           "Chauss�", 
                                           "Delisle", 
                                           "Heer", 
                                           "Lagrois",
                                           "Daverna",
                                           "Gonzales",
                                           "Medjoubi",
                                           "Castillo",
                                           "Josan",
                                           "Yi");

        return Ntro.random().choice(choixDeNoms);
    }
     
     static int pointsAleatoire() {
    	 return Ntro.random().nextInt(1001);
     }
     
     static int jetonsAleatoire() {
    	 return Ntro.random().nextInt(1001);
     }
     
     static int victoiresAleatoire() {
    	 return Ntro.random().nextInt(1001);
     }
     
     static int defaitesAleatoire() {
    	 return Ntro.random().nextInt(1001);
     }
     
     static String couleurAleatoire() {
    	 List<String> choixDeCouleurs = List.of("Jaune", 
                 "Bleu", 
                 "Rouge", 
                 "Vert", 
                 "Mauve", 
                 "Turquoise", 
                 "Majenta",
                 "Orange",
                 "Noir",
                 "Rose");
    	 
    	 return Ntro.random().choice(choixDeCouleurs);
     }
    
    

   						
    

}

