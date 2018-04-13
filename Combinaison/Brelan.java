package Combinaison;

import java.util.ArrayList;
import java.util.Collections;

import Modele.Carte;
import Modele.Table;

public class Brelan extends Combinaison{
	
	private String nom;
	
	public Brelan(Carte c1, Carte c2, Table table) {
		super(c1, c2, table);
		this.nom = "Brelan";
	}

	public int brelan(Carte c1, Carte c2, Table table)
	{
		
		Carte tabCartes[] = new Carte[5];
		
		ArrayList<Integer> tabValeur = new ArrayList<Integer>();
		
		int i = 0;
		
		for(i=0; i<5; i++)
		
		// les 5 premieres case de notre tableau tabCartes  contiendront les 5 cartes de la table
		
			tabCartes[i] = table.getTable()[i];
		
		
		//Récupère cartes de la table + 2 cartes
		
		for(i = 0; i<5; i++)
			tabValeur.add(tabCartes[i].getValeur());
		
		Collections.sort(tabValeur);
		
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
				
				int compteur1 = 1;
				int compteur2 = 1;
				int p = 0;
				int in;
				
				//teste si la main du joueur n'est elle meme pas une paire
				if (element1.getValeur() == element2.getValeur())
				{
					compteur1++;
					compteur2 = 0;
				}
			
				for (in = 4 ; in >= 0 ; in--)
				{
					if(element1.getValeur() == tabValeur.get(in))
						compteur1++;
					
					if(element2.getValeur() == tabValeur.get(in))
						compteur2++;
				}
				
				if ( (compteur1 == 3) &&  (compteur2 == 1) ) 
				{
					p = element1.getValeur();
				}
				
				else if ( (compteur2 == 3) && (compteur1 == 1) )
				{
					p = element2.getValeur();
				}
				
				else 
				{	
					p = 0;		
				}
				
				//methode paire ne sert a retourner une valeur si et seulement si le joueur a UNE et UNE SEULE main.
				
				return p;	
	}

	public String getNom()
	{
		return this.nom;
	}
	
	

}
