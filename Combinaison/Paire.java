package Combinaison;

import java.util.ArrayList;
import java.util.Collections;

import Modele.Carte;
import Modele.Table;

public class Paire extends Combinaison {

	private String nom;
	
	public Paire(Carte c1, Carte c2, Table table) {
		super(c1, c2, table);
		this.nom = "Paire";
	}
	
	public int paire(Carte c1, Carte c2, Table table)
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
		
		Carte element1 = null;
		Carte element2 = null;
		Carte element = null;
		
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
				
				
				//Detrmination d'une pere avec c1. si elle exite p1 prend la valeur 
				
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
				
				
				//Detrmination d'une pere avec c2. si elle exite p2 prend la valeur 
				
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
				
				if (element1.getValeur() == element2.getValeur())
				{
					if ( (p1 == 0) && (p2 == 0) )
						return element1.getValeur();
					else 
						return 0;
				}
				else
				{
					if ( (p1 > 0) && (p2 == 0) )
							return p1;
					else if ( (p1 == 0) && (p2 > 0) )
							return p2;
					else 
						return 0;
				}	
	}
	
	public String getNom()
	{
		return this.nom;
	}

}
