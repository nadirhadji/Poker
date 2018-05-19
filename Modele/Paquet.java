package Modele;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Paquet implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6325900645166110915L;
	private ArrayList<Carte> paquet;
	private ArrayList<Carte> memoire; /* Sert a reinitialiser le paquet*/
	
	public Paquet()
	{
		paquet = new ArrayList<Carte>();
		memoire = new ArrayList<Carte>();
		
		int valeur=1, indice=0, nbr_couleur;
		
		for(nbr_couleur = 0;nbr_couleur<=3;nbr_couleur++)
		{
			for(valeur=1;valeur<14;valeur++)
			{
				if(indice<=13)
					paquet.add(new Carte(valeur,Couleur.PIQUE));
				if(indice>13 && indice<=26)
					paquet.add(new Carte(valeur,Couleur.CARREAU));
				if(indice>26 && indice<=39)
					paquet.add(new Carte(valeur,Couleur.TREFLE));
				if(indice>39)
				{
					paquet.add(new Carte(valeur,Couleur.COEUR));
				}
				indice++;
			}
		}
		
		for(indice=0;indice<52;indice++)
			memoire.add(paquet.get(indice));
	}
	
	public void afficherPaquet()	//Sert uniquement au test de bon fonctionnement
	{
		int i;
		for(i=0;i<52;i++)
		{
			System.out.println("Valeur : " + paquet.get(i).getValeur() + " Couleur : " +
					paquet.get(i).getCouleur() + "\n");
		}
	}
	
	
	public Carte pioche() {	/* Retourne une carte au hasard du paquet*/
	
		Random random = new Random();
		Carte res;
		int nb;
		int min=0 , max = 51 ;	// min 0 max 51 non ?
		
		nb = ( min + random.nextInt(max - min) );
		
		res = paquet.get(nb);
		paquet.remove(nb);
		
		return res;
		
		// On devra penser à retirer la carte du paquet
	}
	
	
	public void raz () {
		
		/* remet le paqeut a son etat initial*/
		
		int index;
		paquet.clear();
		
		for(index=0 ; index<52 ; index++)
			paquet.add(memoire.get(index));
		
	}
	
	public void affichePioche(){
		
		//test sur la methode pioche.
		
		Carte nb = pioche();
		
		System.out.println(nb.getValeur()+" "+nb.getCouleur());
	}
}
