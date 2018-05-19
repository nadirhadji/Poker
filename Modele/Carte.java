package Modele;

import java.io.Serializable;

public class Carte implements Comparable<Carte> , Serializable{
	
	//Attributs
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7310793156038938174L;

	private int valeur;	//A mettre en private a la fin du test
	
	private Couleur couleur; // Meme chose
	
	
	//Constructeurs
	
	//public Carte(Valeur valeur, Couleur couleur) //change nom de valeur!
	
	public Carte(int valeur, Couleur couleur)
	{
		this.valeur = valeur;
		this.couleur = couleur;
	}
	
	public Carte()
	{
		valeur = -1;
		couleur = Couleur.NONE;
	}
	
	//Méthodes
	

	public void affiche(){
      		System.out.println(this.valeur+" de "+this.couleur);
   	}
	
	public int getValeur() {
		
		return valeur;
	}
	
	public Couleur getCouleur()
	{
		return couleur;
	}
	
	public boolean compare(Carte c1)
	{
		if ((this.valeur == c1.valeur) && (this.couleur == c1.couleur))
				return true;
		else 
			return false;
	}
	
	public int compareTo(Carte c1)
	{		
		if (this.valeur > c1.valeur)
			return 1;
		else if (this.valeur == c1.valeur)
			return 0;
		else
			return -1;
	}
	
	
}