package battleship.commun.valeurs;

import java.util.Map;


import battleship.frontal.fragments.FragmentJoueur;
import battleship.frontal.vues.VueStatistiquesJoueur;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue{

	private String id;
	private String prenom;
	private String nom;
	private int points;
	private int jetons;
	private int victoires;
	private int defaites;
	private String couleur;
	
	

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	
	public int getJetons() {
		return jetons;
	}

	public void setJetons(int jetons) {
		this.jetons = jetons;
	}

	public int getVictoires() {
		return victoires;
	}

	public void setVictoires(int victoires) {
		this.victoires = victoires;
	}

	public int getDefaites() {
		return defaites;
	}

	public void setDefaites(int defaites) {
		this.defaites = defaites;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public Joueur() {
		
	}
	
	public Joueur(String id, String prenom, String nom, int points, int jetons, int victoires, int defaites, String couleur) {
		setId(id);
		setPrenom(prenom);
		setNom(nom);
		setPoints(points);
		setJetons(jetons);
		setVictoires(victoires);
		setDefaites(defaites);
		setCouleur(couleur);
		
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return prenom + " " + nom;
	}
	
	
	
	public void afficherSur(FragmentJoueur fragmentJoueur) {
		fragmentJoueur.afficherNomJoueur(prenom);
	
		
		fragmentJoueur.memoriserIdJoueur(id);
		
		
	}

	public FragmentJoueur creeFragment(ViewLoader<FragmentJoueur> viewLoaderJoueur) {
		
		return viewLoaderJoueur.createView();
		
	}
	
	
	public void afficherSur(VueStatistiquesJoueur vueStatistiquesJoueur, String idJoueur) {
		vueStatistiquesJoueur.afficherId(id);
		vueStatistiquesJoueur.afficherPrenom(prenom);
		vueStatistiquesJoueur.afficherNomJoueur(nom);
		vueStatistiquesJoueur.afficherPoints(points);
		vueStatistiquesJoueur.afficherJetons(jetons);
		vueStatistiquesJoueur.afficherVictoires(victoires);
		vueStatistiquesJoueur.afficherDefaites(defaites);
		vueStatistiquesJoueur.afficherCouleur(couleur);
	
		
		
		
		
	}
	
	   
	
}
