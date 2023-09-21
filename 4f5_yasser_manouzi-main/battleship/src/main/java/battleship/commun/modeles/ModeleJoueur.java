package battleship.commun.modeles;

import java.time.zone.ZoneRulesProvider;


import java.util.ArrayList;



import java.util.List;
import java.util.Map;

import battleship.commun.valeurs.Joueur;
import battleship.frontal.vues.VueJoueur;
import battleship.frontal.vues.VueStatistiquesJoueur;
import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;

public class ModeleJoueur implements Model, WriteObjectGraph{

	private long idAutreJoueur = 1;
	private List<Joueur> lesJoueurs = new ArrayList<>();
	
	public ModeleJoueur() {
		
	}
	
	
	

	public long getIdAutreJoueur() {
		return idAutreJoueur;
	}




	public void setIdAutreJoueur(long idAutreJoueur) {
		this.idAutreJoueur = idAutreJoueur;
	}




	public List<Joueur> getLesJoueurs() {
		return lesJoueurs;
	}


	public void setLesJoueurs(List<Joueur> lesJoueurs) {
		this.lesJoueurs = lesJoueurs;
	}


	public void afficherSur(VueJoueur vueJoueur) {
		vueJoueur.viderListeParties();
		for(Joueur joueur : lesJoueurs) {
			vueJoueur.ajouterJoueur(joueur);	
		}
	}

		public void afficherDetailsJoueurSur(VueStatistiquesJoueur vueStatistiquesJoueur, String idJoueur) {
			
			for(Joueur joueur : lesJoueurs) {
			joueur.afficherSur(vueStatistiquesJoueur, idJoueur);
			}
	}





	public String toString() {
		StringBuilder builder = new StringBuilder();
		int numeroJoueur = 1;
		
		for(Joueur joueur: lesJoueurs) {
			builder.append(numeroJoueur);
			builder.append(". ");
			if (joueur != null) {
		        builder.append(joueur.toString());
		    } else {
		        builder.append("null"); // ou un message d'erreur personnalis�
		    }
			
			builder.append("\n");
			
			numeroJoueur++;
		}
		return builder.toString();
	}
	
	public void ajouterJoueur(Joueur unJoueur) {
		  
		    
		
		lesJoueurs.add(unJoueur);
	}
	
	public void retirerJoueur(String idAutreJoueur) {
        int indiceJoueur = -1;
        
        for(int i = 0; i < lesJoueurs.size(); i++) {
            if(lesJoueurs.get(i).getId().equals(idAutreJoueur)) {
            	indiceJoueur = i;
                break;
            }
        }
        
        if(indiceJoueur >= 0) {
            lesJoueurs.remove(indiceJoueur);
        }
    }
	
	

	
	
	
}
