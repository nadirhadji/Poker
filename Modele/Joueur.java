package Modele;

import java.io.File;
import java.io.Serializable;

public class Joueur implements Serializable {
	
	//*********************************Variables***************************************//
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7773699324207132442L;
	private String nom;
	int solde;
	private Carte c1 = null;
	private Carte c2 = null;
	private boolean possedeCarte;
	int derniereMise;
	int totalMiser;

	//******************************Constructeur**************************************//
	
	
	/* Saisie par le joueur*/
	public Joueur(String nom, int solde){
		
		this.nom = nom;
		this.solde = solde;
		c1 = new Carte();
		c2 = new Carte();
	}
	
	public Joueur()
	{
		c1 = new Carte();
		c2 = new Carte();
	}
	
	//*******************************Méthodes***************************************//


	public void incrementer(int x){
		/* methode servant a incrementer le solde d'un jouer apres une victoire*/
		solde+=x;

	}
	
	

	public void jeterLaMain(){
	possedeCarte = false;
	}

	
	public void nouvelle_main(Carte c1 , Carte c2) {
		
	possedeCarte = true;
		
		this.c1 = c1;
		this.c2 = c2;
		

	}
	
	public void mise(int mise){
		
		solde = solde-mise;
		derniereMise = mise;
		totalMiser += mise;
		
	}

	
	/* retourne les cartes c1 et c2 dans un tableau */
	public Carte[] getMain() {
		
		Carte tab[] = new Carte[2];
		tab[0] = c1;
		tab[1] = c2;		
		return tab;
	}
	
	public int getSolde()
	{
		return solde;
	}
	
	public boolean getPossedeCarte()
	{
		return possedeCarte;
	}
	
	public boolean check()
	{
		return true;
	}
	
	
	public int getDerniereMise()
	{
		return derniereMise;
	}
	
	public void RAZtotalMiser()
	{
		this.totalMiser = 0;
	}
	
	public int getTotalMiser() 
	{
		return totalMiser;
	}
	
	
	public String getNom()
	{
		return this.nom;
	}
	
	public String toString()
	{
		return nom + " " +
				solde + " " +
				c1 + " " +
				c2;
	}
	
	public void setSolde(int sum)
	{
		this.solde = sum;
	}
	
	public void setNom(String nom)
	{
		this.nom = nom;
	}
	
				
}
