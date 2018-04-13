package Combinaison;

import java.util.ArrayList;
import java.util.Collections;

import Modele.Carte;
import Modele.Table;

public class DoublePaire extends Combinaison {

	private String nom;
	
	public DoublePaire(Carte c1, Carte c2, Table table) {
		super(c1, c2, table);
		this.nom = "Double Paire";
	}

	public int[] doublePaire(Carte c1, Carte c2, Table table)
	{
		Carte tabCartes[] = new Carte[5];
		
		ArrayList<Carte> Carte = new ArrayList<Carte>();
		ArrayList<Carte> Buffer = new ArrayList<Carte>();
		ArrayList<Carte> Buffer2 = new ArrayList<Carte>();
		
		
		int i = 0;
		
		for(i=0; i<5; i++)
		
		// les 5 premieres case de notre tableau tabCartes  contiendront les 5 cartes de la table
		
			tabCartes[i] = table.getTable()[i];
		
		
		//Récupère cartes de la table + 2 cartes
		
		for(i = 0; i<5; i++)
			Carte.add(tabCartes[i]);
		
		Collections.sort(Carte);
		
		Carte element1;
		Carte element2;
		
		//recheche de l'element le plus grand entre c1 et c2
				if (c1.getValeur() >= c2.getValeur())
				{	
					element1 = c1;
					element2 = c2;
				}
				else
				{	
					element1 = c2;
					element2 = c1;
				}	
		//////////////////////////////// Recherche de la premiere paire ///////////////////////////////
	
		int p1;
		int in;
		
		for (in = 4 ; in > 0 ; in--)
		{
			if(element1.getValeur() == Carte.get(in).getValeur())
				Buffer.add(Carte.get(in));
		}
		Buffer.add(element1);
		
		if (Buffer.size() == 2)
		{
			p1 = element1.getValeur();
		}
		
		else 
			
			p1 = 0;
		
		
		//////////////////////////////////// Recherche de la deuxieme paire ///////////////////////////////////
		
		int p2;
		
		for (in = 4 ; in > 0 ; in--)
		{
			if(element2.getValeur() == Carte.get(in).getValeur())
				Buffer2.add(Carte.get(in));
		}
		
		Buffer2.add(element2);
		
		if (Buffer2.size() == 2)
		{
			p2 = element2.getValeur();
		}
		
		else 
			p2 = 0;
		
		//servira a retourner un tableau de la forme [p1;p2]
		
		int[] tab;
		tab = new int[2];
		tab[0] = p1 ;
		tab[1] = p2 ;
		
		int[] tab2;
		tab2 = new int[2];
		tab2[0] = 0 ;
		tab2[1] = 0 ;
		
		
		if ( (p1 == 0) || (p2 == 0) )
		{	
			return tab2;
		}	
		else
		{
		return tab;
		}
	}
	
	public String getNom()
	{
		return this.nom;
	}

}
