package Combinaison;

import java.util.ArrayList;
import java.util.Collections;

import Modele.Carte;
import Modele.Table;

public class Full extends Combinaison {

	private String nom;
	
	public Full(Carte c1, Carte c2, Table table) {
		super(c1, c2, table);
		this.nom = "Full";
	}
	
	public int[] full(Carte c1, Carte c2, Table table)
	{
		ArrayList<Carte> tabCarte = new ArrayList<Carte>();
		int tableau[] = new int[2];
		int compteurc1 = 1;
		int compteurc2 = 1;
		
		for(int i=0; i<5; i++)
			tabCarte.add(table.getTable()[i]);
		
		Collections.sort(tabCarte);
		
		// Si les 2 cartes sont egales , la combininaison n'est pas un full. 
		
		if (c1.getValeur() == c2.getValeur())
		{
			tableau[0] = 0;
			tableau[1] = 0;
			
		}
		
		// Cas ou la main du joueur est differente 
		else
		{
			
			// Teste si la valeur de la premiere carte est presente 1 ou 2 fois sur la table.
		
			for(int i=0; i<5; i++)
			{
				if( tabCarte.get(i).getValeur() == c1.getValeur() )
					compteurc1++;
			}
			
			if ( ( compteurc1 == 2 ) || (compteurc1 == 3) )
			{
				if (compteurc1 == 2)
				{
					tableau[0] = c1.getValeur();
				}
					
				else
				{
					tableau[1] = c1.getValeur();
				}
					
			}
			
			else
			{
				tableau[0] = 0;
				tableau[1] = 0;
				
			}
			
			// En fonction de la premiere carte teste si la valeur de la carte 2 est presente: 2 fois si carte 1 presente 3 fois
			//																				   3 fois si carte 1 presente 2 fois
			//									     		sinon on est assurer que la main differennte de ces 2 cas , pas un full		
			
			for(int i=0; i<5; i++)
			{
				
				if ( tabCarte.get(i).getValeur() == c2.getValeur() )
					compteurc2++;
			}
			
			if ( ( ( compteurc2 == 2 ) && (compteurc1 == 3)) || ( ( compteurc2 == 3 ) && (compteurc1 == 2)) )
			{
				if (compteurc2 == 2)
				{
					tableau[0] = c2.getValeur();
				}
					
				else
				{
					tableau[1] = c2.getValeur();
				}
					
			}
			
			else
			{
				tableau[0] = 0;
				tableau[1] = 0;
				
			}
		
			
		}
		
		return tableau;
	}
	
	public String getNom()
	{
		return this.nom;
	}
}
