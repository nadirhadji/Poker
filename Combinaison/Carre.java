package Combinaison;

import java.util.ArrayList;
import java.util.Collections;

import Modele.Carte;
import Modele.Table;

public class Carre extends Combinaison {

	private String nom;
	
	public Carre(Carte c1, Carte c2, Table table) {
		super(c1, c2, table);
		this.nom = "Carré";
	}
	
	public int carre(Carte c1, Carte c2, Table table)
	{
Carte tabCartes[] = new Carte[7];		
		
		ArrayList<Carte> Carte = new ArrayList<Carte>();
		ArrayList<Carte> Buffer = new ArrayList<Carte>();
		
		
		int i = 0;
		int compteur = 0; // compte le nombre de carte de la suite ayant la même couleure
		
		// les 5 premieres case de notre tableau tabCartes  contiendront les 5 cartes de la table
		for(i=0; i<5; i++)
		tabCartes[i] = table.getTable()[i];
		// la 6 eme case de notre tableau tabCartes contiendra la premiere carte c1
		
		tabCartes[5] = c1;
		//  la 7 eme case de notre tableau tabCartes contiendra la deuxieme carte c2
		
		tabCartes[6] = c2;
		
		//Récupère cartes de la table + 2 cartes
		
		
		for(i = 0; i<7; i++)
			Carte.add(tabCartes[i]);
		//Récupère valeur des 7 cartes
		
		Collections.sort(Carte);
		
		for ( int k = 0; ( (k<4) && (Buffer.size() < 4) ) ; k++ )
		{
			Buffer.clear();
			compteur = 0;
			
			for ( int j = 0; j<7; j++)
			{
				if ( Carte.get(j).getValeur() == Carte.get(k).getValeur()  ) 
				{
					compteur++;
					
					Buffer.add( Carte.get(j) );
				}
			}
		}
	
		Collections.sort(Buffer);
		
		boolean existIn = false;
		
		for (int e = 0 ; e < Buffer.size()-1 ; e++)
		{
			if ( Buffer.get(e).compare(c1) == true )
			{
				existIn = true;
			}	
			else if (Buffer.get(e).compare(c2) == true )
			{
				existIn = true;
			}
		}
		
		if ( (Buffer.size() >= 4) && (existIn == true) )
			return Buffer.get(0).getValeur();

		return 0;
	}
	
	public String getNom()
	{
		return this.nom;
	}

}
