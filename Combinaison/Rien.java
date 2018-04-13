package Combinaison;

import Modele.Carte;
import Modele.Table;

public class Rien extends Combinaison {

	private String nom;
	
	public Rien(Carte c1, Carte c2, Table table) {
		super(c1, c2, table);
		this.nom = "Rien";
	}
	
	public int rien(Carte c1, Carte c2, Table table)
	{
		if (c1.getValeur() > c2.getValeur())
		{
			return c1.getValeur();
		}
		
		else if (c1.getValeur() < c2.getValeur() )
		{
			return c2.getValeur();
		}
		
		else
			return c1.getValeur();
	}
	
	public String getNom()
	{
		return this.nom;
	}
	
	

}
