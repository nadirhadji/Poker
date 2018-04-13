package Combinaison;

import Modele.Carte;
import Modele.Table;

public abstract class Combinaison {
	
	private Carte c1;
	private Carte c2;
	private Table table;
	
	public Combinaison(Carte c1, Carte c2, Table table )
	{
		this.c1 = c1;
		this.c2 = c2;
		this.table = table;
	}
	
	
	public Carte getC1()
	{
		return c1;
	}
	
	public Carte getC2()
	{
		return c2;
	}
	
	public Table getTable()
	{
		return table;
	}

	
	

	
	
	
	

}
