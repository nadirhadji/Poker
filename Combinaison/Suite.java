package Combinaison;

import java.util.ArrayList;
import java.util.Collections;

import Modele.Carte;
import Modele.Table;

public class Suite extends Combinaison {

	private String nom;
	
	public Suite(Carte c1, Carte c2, Table table) {
		super(c1, c2, table);
		this.nom = "Suite";
	}
	
	public int suite(Carte c1, Carte c2, Table table)
	{
		Carte tabCartes[] = new Carte[7];		
		ArrayList<Carte> tabCarte = new ArrayList<Carte>();
		
		int i = 0;
		
		for(i=0; i<5; i++)
		
		// les 5 premieres case de notre tableau tabCartes  contiendront les 5 cartes de la table
		
			tabCartes[i] = table.getTable()[i];
		
		// la 6 eme case de notre tableau tabCartes contiendra la premiere carte c1
		
		tabCartes[5] = c1;
		
		//  la 7 eme case de notre tableau tabCartes contiendra la deuxieme carte c2
		
		tabCartes[6] = c2;
		
		//Récupère cartes de la table + 2 cartes
		
		for(i = 0; i<7; i++)
		{	
			tabCarte.add(tabCartes[i]);
		}
		
		//Récupère valeur des 7 cartes
	
		Collections.sort(tabCarte);
	
		//	int max = tabCarte.get(0).getValeur();
		
		ArrayList<Carte> Buffer = new ArrayList<Carte>();
		
		
		for(int x = 6 ; ( (x > 3) && (Buffer.size() < 4)) ; x--)
		{	
			
			Buffer.clear();
			int z;
			
			int taille = (Buffer.size());
			
			for( z = x ; z > 0 ; z-- )
			{
				
				if( (taille == 0) && ( ( tabCarte.get(z).getValeur() - tabCarte.get(z-1).getValeur() ) == 1) )
				{
					Buffer.add(tabCarte.get(z));
					taille = (Buffer.size());
				}
				
				if (taille > 0)
				{
					if ( Buffer.get(taille-1).getValeur() - tabCarte.get(z).getValeur()  == 1)
					 {
						Buffer.add(tabCarte.get(z));
						taille = (Buffer.size());
						
					 }
	
				
					else if ( ( tabCarte.get(z).getValeur() - tabCarte.get(z-1).getValeur()  ) == 0)
					 {
						if( c1.compare(tabCarte.get(z)) || c2.compare(tabCarte.get(z)))
						{
							Buffer.add(tabCarte.get(z));
							taille = (Buffer.size());
						}
						
					 }
				}
			}
			
			if ( (z == 0) && (Buffer.size() > 0) )
			{
				if ( Buffer.get( Buffer.size() - 1).getValeur() - tabCarte.get(z).getValeur()  == 1)
					Buffer.add(tabCarte.get(z));
				taille = (Buffer.size());
			}	

			
		}
		
		boolean existIn = false;
		int positionc1 = -1;
		int positionc2 = -1;
		int max;
		
		for (int e = 0 ; e < Buffer.size()-1 ; e++)
		{
			if ( Buffer.get(e).compare(c1) == true )
			{
				existIn = true;
				positionc1 = e;
				
			}	
			else if (Buffer.get(e).compare(c2) == true )
			{
				existIn = true;
				positionc2 = e;
				
			}
		}
		
		int position;
		
		if (positionc1 > positionc2)
			position = positionc2;
		else
			position = positionc2;
		
		
		if ( (Buffer.size() >= 5) && (existIn == true) )
		{
			
			if (Buffer.size() == 5)
				return Buffer.get(0).getValeur();
			else if ( (Buffer.size() == 6) && (position == 5) )
				return Buffer.get(1).getValeur();
			else if ( (Buffer.size() == 6) )
				return Buffer.get(0).getValeur();
			else if ( (Buffer.size() == 7) && (position == 5 ) )
				return Buffer.get(1).getValeur();
			else if ( (Buffer.size() == 7) && (position == 6 ) )
				return Buffer.get(2).getValeur();
			else if ( (Buffer.size() == 7) )
				return Buffer.get(0).getValeur();
		}
			return 0;
	}
	
	public String getNom()
	{
		return this.nom;
	}

}
