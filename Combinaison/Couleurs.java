package Combinaison;

import java.util.ArrayList;
import java.util.Collections;
import Modele.Carte;
import Modele.Table;

public class Couleurs extends Combinaison {

	private String nom;
	
	public Couleurs(Carte c1, Carte c2, Table table) 
	{
		super(c1, c2, table);
		this.nom = "Couleur";
	}
	
	public int couleur(Carte c1, Carte c2, Table table)
	{

		Carte tabCartes[] = new Carte[7];		
		ArrayList<Carte> Carte = new ArrayList<Carte>();
		ArrayList<Carte> Buffer = new ArrayList<Carte>();
		String c = null;
		
		int compteur = 0;
		
		for(int i=0; i<5; i++)
		tabCartes[i] = table.getTable()[i];
		
		tabCartes[5] = c1;
		
		tabCartes[6] = c2;
		
		//Récupère cartes de la table + 2 cartes
		
		for(int l = 0; l<7; l++)
			Carte.add(tabCartes[l]);
		//Récupère couleur des 7 cartes
		
		
		for ( int k = 0; ( (k<3) && (Buffer.size() < 5) ) ; k++ )
		{
			Buffer.clear();
			compteur = 0;
			
			for ( int j = 0; j<7; j++)
			{
				if ( Carte.get(j).getCouleur().toString() == Carte.get(k).getCouleur().toString()  ) 
				{
					compteur++;
				
					c = Carte.get(k).getCouleur().toString();
					
					Buffer.add( Carte.get(j) );
				}
				
			}
		}
		
		Collections.sort(Buffer);
		
		boolean existIn = false;
		int positionc1 = -1;
		int positionc2 = -1;
		
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
			int size = Buffer.size();
			
			if (Buffer.size() == 5)
				return Buffer.get(size-1).getValeur();
			else if ( (Buffer.size() == 6) && (position == 5) )
				return Buffer.get(size-2).getValeur();
			else if ( (Buffer.size() == 6) )
				return Buffer.get(size-1).getValeur();
			else if ( (Buffer.size() == 7) && (position == 5 ) )
				return Buffer.get(size-2).getValeur();
			else if ( (Buffer.size() == 7) && (position == 6 ) )
				return Buffer.get(size-3).getValeur();
			else if ( (Buffer.size() == 7) )
				return Buffer.get(size-1).getValeur();
		}
			return 0;
	}
	
	public String getNom()
	{
		return this.nom;
	}

}
