package Combinaison;

import java.util.ArrayList;
import java.util.Collections;

import Modele.Carte;
import Modele.Table;

public class SuiteRoyal extends Combinaison {

	private String nom;
	
	public SuiteRoyal(Carte c1, Carte c2, Table table) {
		super(c1, c2, table);
		this.nom = "Suite Royal";
	}
	
	public int suiteRoyal(Carte c1, Carte c2, Table table)
	{
		Suite Suite = new Suite(super.getC1(),super.getC2(),super.getTable());
		ArrayList<Carte> tabCartes = new ArrayList<Carte>();		
		ArrayList<Integer> tabValeur = new ArrayList<Integer>();
		int i = 0;
		
		int compteur = 1; // compte le nombre de carte de la suite ayant la même couleure
		
		// les 5 premieres case de notre tableau tabCartes  contiendront les 5 cartes de la table
		
		for(i=0; i<5; i++)
		
			tabCartes.add(table.getTable()[i]);
		
		// la 6 eme case de notre tableau tabCartes contiendra la premiere carte c1
		
		tabCartes.add(c1);
		
		//  la 7 eme case de notre tableau tabCartes contiendra la deuxieme carte c2
		
		tabCartes.add(c2);
		
		Collections.sort(tabCartes);
		
		//Récupère cartes de la table + 2 cartes
		
		if( Suite.suite(c1, c2, table) > 0)	// on vérifie qu'une suite est formée
		
		{	
			for(int i1 = 0; i1 < 7  ; i1++)
			{
				// on parcourt le tableau pour recupere la carte de la suite ayant la valeure maximale
				
				if ( tabCartes.get(i1).getValeur() == Suite.suite(c1, c2, table) )  
				{
					
					// on parcourt le tableau une deuxième fois pour comparer les cartes avec la carte récupérée précédament
					
					for(int j = 0; j < i1; j++) 						
					{
						// on s'assure que la carte a la même couleure
						if ( ( tabCartes.get(i1).getCouleur() == tabCartes.get(j).getCouleur() ) && ( ( tabCartes.get(i1).getValeur() - tabCartes.get(j).getValeur() ) <= 4 ) ) 
								// on s'assure que la carte fasse paertie de la suite
						{																
							// on incrémente le compteur si les conditions sont vérifiées
							compteur++; 										
						}
					}
				}
			}
		}
	
		if (compteur >= 5) 
			return Suite.suite(c1, c2, table); // si les 5 cartes ont la même couleur la suite est royale
		
		else 
			return 0;
	}
	
	public String getNom()
	{
		return this.nom;
	}

}
