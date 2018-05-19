package Modele;

import java.io.Serializable;

public class Table implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1442819834634109377L;
	private Carte c1;
	private Carte c2;
	private Carte c3;
	private Carte c4;
	private Carte c5;
	private Paquet pq;
	
	public Table()
	{
		c1 = new Carte();
		c2 = new Carte();
		c3 = new Carte();
		c4 = new Carte();
		c5 = new Carte();
		pq = new Paquet();
	}
	
	public Table(Carte c1, Carte c2, Carte c3, Carte c4, Carte c5)
	// Uniquement pour faire des tests
	{
		this.c1 = c1;
		this.c2 = c2;
		this.c3 = c3;
		this.c4 = c4;
		this.c5 = c5;
	}
	
	//Méthodes
	
	public Carte[] getTable()
	{
		Carte tab[] = new Carte[5];
		tab[0] = c1;
		tab[1] = c2;
		tab[2] = c3;
		tab[3] = c4;
		tab[4] = c5;
		return tab;
	}
	
	public void aZero()
	{
		Carte cZero = new Carte(-1,Couleur.NONE);
		pq.raz();
		c1 = cZero;
		c2 = cZero;
		c3 = cZero;
		c4 = cZero;
		c5 = cZero;
	}
	
	public void tour1()
	{
		c1 = pq.pioche();
		c2 = pq.pioche();
		c3 = pq.pioche();
	}
	
	public void tour2()
	{
		c4 = pq.pioche();
	}
	
	public void tour3()
	{
		c5 = pq.pioche();
	}
	
	public void affiche()
	{
		Carte[] tab = this.getTable();
		
		for(int i = 0 ; i < 5 ; i++)
		{
			System.out.println( tab[i].getValeur()+" "+ tab[i].getCouleur());
		}
		
	}
	
	public Carte getFlop1()
	{
		return this.c1;
	}
	
	public Carte getFlop2()
	{
		return this.c2;
	}
	
	public Carte getFlop3()
	{
		return this.c3;
	}
	
	public Carte getTurn()
	{
		return this.c4;
	}
	
	public Carte getRiver()
	{
		return this.c5;
	}
	

}