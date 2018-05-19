package Modele;

import java.io.Serializable;

import javax.swing.JOptionPane;

import Combinaison.*;

public class Partie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 16584758473847L;
	
	private Joueur j1;
	private Joueur j2;
	private Table table;
	private Paquet paquet;
	private int Pot;
	
	private static int blindIndice = 1;
	private static final int Blind = 10;
	private int Tour = 0;
	private int tourDeTour = 0;

	private Joueur tourDe = null;
	private Joueur attendTour = null;
	private boolean StadeDeBlind = true;
	
	private Joueur gagnant = null ;
	private boolean egalite = false; 
	private Boolean encours = null;
	private int newgame ;
	
	
	
	public Partie()
	{
		this.paquet = new Paquet();
		this.table = new Table();
		this.j1 = new Joueur("Joueur 1",5000);
		this.j2 = new Joueur("Joueur 2",5000);
		this.Pot = 0;
		this.encours = true;
		
	}
	
	
	public Partie(String j1 , String j2 , int solde1 , int solde2)
	{
		this.paquet = new Paquet();
		this.table = new Table();
		this.j1 = new Joueur(j1,solde1);
		this.j2 = new Joueur(j2,solde2);
		this.Pot = 0;
		this.encours = true;
		
	}
	
	public boolean do_action (ActionUtilisateur action , Joueur j, int mise)
	{
		
		switch(this.Tour)
		{
		
		case 0: 
				switch(action)
					{	
							case PASSER:
											if (tourDe == j) 
											
											{
												attendTour.incrementer(Pot);
												tourDeTour = 0;
												attendTour.RAZtotalMiser();
												tourDe.RAZtotalMiser();
												Pot = 0;
												encours= false;
												gagnant = attendTour;
												phaseFinal();
												return true;
												
											}
											else
											
											{
												return false;
											}	
											
							case PAROLE:	
											
											if ( (tourDe == j) && (tourDeTour == 3)) 
											
											{
												System.out.println(attendTour.getNom()+" "+attendTour.getTotalMiser()+" "+tourDe.getNom()+" "+tourDe.getTotalMiser());
												
												
												if (attendTour.getTotalMiser() == tourDe.getTotalMiser())
												
												{
													parole(j);
													Tour++;
													tourDeTour = 0;
													attendTour.RAZtotalMiser();
													tourDe.RAZtotalMiser();
													table.tour1();
													return true;
												}											
												
												else
								
												{
													return false;
												}
											
											}
											
											else 
											{
												return false;
											}
											
											
							
							case SUIVRE:	
											
											if( (tourDe == j) && (tourDeTour == 2) )
											{
												suivre(j);
												tourDeTour++;
												return true;
												
											}
								
											else if ( (tourDe == j) && ( tourDeTour >= 3) )
											{
												if(tourDe.getTotalMiser() < attendTour.getTotalMiser())
												{
												suivre(j);
												Tour++;
												tourDeTour = 0;
												attendTour.RAZtotalMiser();
												tourDe.RAZtotalMiser();
												table.tour1();
												return true;
												}
											}
											
								
											else
											
											{
												return false;
											}
													
		
							
							case MISER :
								
											if ( (tourDe == j) )
											{
												
												if ( (tourDe.getSolde() > (attendTour.getDerniereMise() - tourDe.getDerniereMise())) && ( mise > (attendTour.getDerniereMise() - tourDe.getDerniereMise())) && (mise <= tourDe.getSolde())  )                                
												{
													Joueur Buffer;
													miser(j,mise);
													Buffer = tourDe;
													tourDe = attendTour;
													attendTour = Buffer;
													
													tourDeTour++;
													return true;
												}
												
												else if ((tourDe.getSolde() > (attendTour.getDerniereMise() - tourDe.getDerniereMise())) && ( mise == (attendTour.getDerniereMise() - tourDe.getDerniereMise())) && (mise <= tourDe.getSolde())  )                                
												{
													Joueur Buffer;
													suivre(j);
													Buffer = tourDe;
													tourDe = attendTour;
													attendTour = Buffer;
													Tour++;
													tourDeTour = 0;
													attendTour.RAZtotalMiser();
													tourDe.RAZtotalMiser();
													table.tour1();
													return true;
												}
												
												else if ( (mise == tourDe.getSolde()) && (attendTour.getSolde() == 0) ) 
												{
													Allin();
													phaseFinal();
												}
													
											}
											else
											{
												return false;
												
											}
					
					}
					break;
		case 1:
			
			
					switch(action)
					{
					
						case PASSER:
										if (tourDe == j) 
											
										{
											attendTour.incrementer(Pot);
											tourDeTour = 0;
											attendTour.RAZtotalMiser();
											tourDe.RAZtotalMiser();
											Pot = 0;
											encours = false;
											gagnant = attendTour; 
											phaseFinal();
											return true;
										}
										else
										
										{
											return false;
										}	
						
						case PAROLE:	
										
										if (tourDe == j ) 
											
										{
											if (tourDeTour == 0)
											{
												parole(tourDe);
												tourDeTour++;
											}
											
											
											else
											{
											
												if (attendTour.getTotalMiser() == tourDe.getTotalMiser())
												
												{
													parole(tourDe);
													Tour++;
													tourDeTour = 0;
													attendTour.RAZtotalMiser();
													tourDe.RAZtotalMiser();
													table.tour2();
													return true;
													
												}											
												
												else
								
												{
													return false;
												}
											}	
										
										}
										
										else 
										{
											return false;
										}
						
						case SUIVRE:		
										
										if ((tourDe == j) && (tourDeTour == 0)) 
										{
											return false;
											
										}
							
										else if ( (tourDe == j) && ( tourDeTour > 0) )
										{
											if(tourDe.getTotalMiser() < attendTour.getTotalMiser())
											{
											suivre(j);
											Tour++;
											tourDeTour = 0;
											attendTour.RAZtotalMiser();
											tourDe.RAZtotalMiser();
											table.tour2();
											return true;
											}
										}
										
							
										else
										
										{
											return false;
										}
						
						case MISER :
							
										if ( (tourDe == j) )
										{
											
											if ( (mise <= tourDe.getSolde()) && (tourDeTour == 0) )                              
											{
												Joueur Buffer;
												miser(j,mise);
												Buffer = tourDe;
												tourDe = attendTour;
												attendTour = Buffer;
												
												tourDeTour++;
												return true;
											}
											
											else if ( (mise < tourDe.getSolde()) && (tourDeTour > 0) && ( mise > (attendTour.getTotalMiser() - tourDe.getTotalMiser()))	)					  
											{
										
												Joueur Buffer;
												miser(j,mise);
												Buffer = tourDe;
												tourDe = attendTour;
												attendTour = Buffer;
												
												tourDeTour++;
												return true;
													
											}
											
											else if ( (tourDe.getSolde() > (attendTour.getDerniereMise() - tourDe.getDerniereMise())) && ( mise == (attendTour.getDerniereMise() - tourDe.getDerniereMise())) )                                
											{
												Joueur Buffer;
												suivre(j);
												
												Buffer = tourDe;
												tourDe = attendTour;
												attendTour = Buffer;
												Tour++;
												tourDeTour = 0;
												attendTour.RAZtotalMiser();
												tourDe.RAZtotalMiser();
												table.tour2();
												
												return true;
											}
											
											else if ( (mise == tourDe.getSolde()) && (attendTour.getSolde() == 0) ) 
											{
												Allin();
												phaseFinal();
											}
											
											else
											{
												return false;
											}
												
										}
										else
										{
											return false;
											
										}
					
					}
					break;
		case 2:
			
					switch(action)
					{
					
					case PASSER:
										if (tourDe == j) 
											
										{
											attendTour.incrementer(Pot);
											tourDeTour = 0;
											attendTour.RAZtotalMiser();
											tourDe.RAZtotalMiser();
											Pot = 0;
											encours = false;
											gagnant = attendTour;
											phaseFinal();
											return true;
										}
										else
										
										{
											return false;
										}	
					
					case PAROLE:		
										if (tourDe == j ) 
											
										{
											if (tourDeTour == 0)
											{
												parole(tourDe);
												tourDeTour++;
											}
											
											
											else
											{
											
												if (attendTour.getTotalMiser() == tourDe.getTotalMiser())
												
												{
													parole(tourDe);
													Tour++;
													attendTour.RAZtotalMiser();
													tourDe.RAZtotalMiser();
													table.tour3();
													return true;
												}											
												
												else
								
												{
													return false;
												}
											}	
										
										}
										
										else 
										{
											return false;
										}
					
					case SUIVRE:
						
										if ((tourDe == j) && (tourDeTour == 0)) 
										{
											return false;
											
										}
							
										else if ( (tourDe == j) && ( tourDeTour > 0) )
										{
											if(tourDe.getTotalMiser() < attendTour.getTotalMiser())
											{
											suivre(j);
											Tour++;
											tourDeTour = 0;
											attendTour.RAZtotalMiser();
											tourDe.RAZtotalMiser();
											table.tour3();
											return true;
											}
										}
										
							
										else
										
										{
											return false;
										}
					
					case MISER :
						
										if ( (tourDe == j) )
										{
											
											if ( (mise <= tourDe.getSolde()) && (tourDeTour == 0) )                              
											{
												Joueur Buffer;
												miser(j,mise);
												Buffer = tourDe;
												tourDe = attendTour;
												attendTour = Buffer;
												tourDeTour++;
												return true;
											}
												
											else if ( (mise < tourDe.getSolde()) && (tourDeTour > 0) && ( mise > (attendTour.getTotalMiser() - tourDe.getTotalMiser()))	)					  
											{
										
												Joueur Buffer;
												miser(j,mise);
												Buffer = tourDe;
												tourDe = attendTour;
												attendTour = Buffer;
												tourDeTour++;
												return true;
													
											}
											
											else if ((tourDe.getSolde() > (attendTour.getDerniereMise() - tourDe.getDerniereMise())) && ( mise == (attendTour.getDerniereMise() - tourDe.getDerniereMise())) )                                
											{
												Joueur Buffer;
												suivre(j);
												Buffer = tourDe;
												tourDe = attendTour;
												attendTour = Buffer;
												Tour++;
												tourDeTour = 0;
												attendTour.RAZtotalMiser();
												tourDe.RAZtotalMiser();
												table.tour3();
												return true;
											}
											
											else if ( (mise == tourDe.getSolde()) && (attendTour.getSolde() == 0) ) 
											{
												Allin();
												phaseFinal();
											}
											
											else
											{
												return false;
											}
												
										}
										else
										{
											return false;
											
										}
					
					}
					break;
		case 3:
					switch(action)
					{
					
					case PASSER:		

									if (tourDe == j) 
										
									{
										attendTour.incrementer(Pot);
										tourDeTour = 0;
										attendTour.RAZtotalMiser();
										tourDe.RAZtotalMiser();
										Pot = 0;
										encours = false;
										gagnant = attendTour;
										phaseFinal();
										return true;
									}
									else
									
									{
										return false;
									}	
					
					case PAROLE:
						
									if (tourDe == j ) 
										
									{
										if (tourDeTour == 0)
										{
											parole(tourDe);
											tourDeTour++;
										}
										
										
										else
										{
										
											if (attendTour.getTotalMiser() == tourDe.getTotalMiser())
											
											{
												Joueur Buffer;
												parole(tourDe);
												Buffer = tourDe;
												tourDe = attendTour;
												attendTour = Buffer;
												Tour++;
												tourDeTour = 0;
												attendTour.RAZtotalMiser();
												tourDe.RAZtotalMiser();
												phaseFinal();
												return true;
												
											}												
											
											else
							
											{
												return false;
											}
										}	
									
									}
									
									else 
									{
										return false;
									}
					
					case SUIVRE:
						
									if ((tourDe == j) && (tourDeTour == 0)) 
									{
										return false;
										
									}
						
									else if ( (tourDe == j) && ( tourDeTour > 0) )
									{
										if(tourDe.getTotalMiser() < attendTour.getTotalMiser())
										{
										Joueur Buffer;
										suivre(j);
										Buffer = tourDe;
										tourDe = attendTour;
										attendTour = Buffer;
										Tour++;
										tourDeTour = 0;
										attendTour.RAZtotalMiser();
										tourDe.RAZtotalMiser();
										phaseFinal();
										return true;
										}
									}
									
						
									else
									
									{
										return false;
									}
					
					case MISER :
						
									if ( (tourDe == j) )
									{
										
										if ( (mise <= tourDe.getSolde()) && (tourDeTour == 0) )                              
										{
											Joueur Buffer;
											miser(j,mise);
											Buffer = tourDe;
											tourDe = attendTour;
											attendTour = Buffer;
											tourDeTour++;
											return true;
										}
										
										else if ( (mise < tourDe.getSolde()) && (tourDeTour > 0) && ( mise > (attendTour.getTotalMiser() - tourDe.getTotalMiser())))					  
										{
									
											Joueur Buffer;
											miser(j,mise);
											this.PotPlus(tourDe,mise);
											Buffer = tourDe;
											tourDe = attendTour;
											attendTour = Buffer;
											
											tourDeTour++;
											return true;
												
										}
										
										else if ((tourDe.getSolde() > (attendTour.getDerniereMise() - tourDe.getDerniereMise())) && ( mise == (attendTour.getDerniereMise() - tourDe.getDerniereMise())) )                                
										{
											Joueur Buffer;
											suivre(j);
											Buffer = tourDe;
											tourDe = attendTour;
											attendTour = Buffer;
											Tour++;
											tourDeTour = 0;
											attendTour.RAZtotalMiser();
											tourDe.RAZtotalMiser();
											phaseFinal();
											return true;
										}
										
										else if ( (mise == tourDe.getSolde()) && (attendTour.getSolde() == 0) ) 
										{
											Allin();
											phaseFinal();
										}
										
										else
										{
											return false;
										}
											
									}
									else
									{
										return false;
										
									}
								
								}
					break;
		}
		return false;
					
					
		
	}
	
	public boolean phaseFinal() {
		JOptionPane pane = new JOptionPane();
		
		if (gagnant != null)
		{
			
			encours = false;
			gagnant.incrementer(Pot);
			Pot = 0;
			
			JOptionPane.showMessageDialog(pane, "Le vainqueur est  "+gagnant.getNom()+" avec la combinaison "+JoueurCombinaison(gagnant.getMain()[0],gagnant.getMain()[1],table));                                     
			
			int dialogButton = JOptionPane.YES_NO_OPTION;
			
			int dialogRes = JOptionPane.showConfirmDialog(null, "Nouvelle partie ?", "Title on Box", dialogButton);
			
			if (dialogRes == 0)
			{	
				this.tourDeTour = 0;
				this.Tour = 0;
				this.Pot = 0;
				this.table.aZero();
				this.paquet.raz();
				this.StadeDeBlind = true;
				Blinde();
			}
			
			return true;
			
			
		}
		
		else 
		{
			HandComparator();
			
			if (egalite)
			{
				j1.incrementer(Pot/2);
				j2.incrementer(Pot/2);
				Pot = 0;
				
				JOptionPane.showMessageDialog(pane, "Egalite ");
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				
				int dialogRes = JOptionPane.showConfirmDialog(null, "Nouvelle partie ?", "Title on Box", dialogButton);
				
				if (dialogRes == 0)
				{
					
					this.tourDeTour = 0;
					this.Tour = 0;
					this.Pot = 0;
					this.table.aZero();
					this.paquet.raz();
					this.StadeDeBlind = true;
					Blinde();
				}
				
				encours = false;
				return true;
			}
			
			else
			{
				gagnant.incrementer(Pot);
				Pot = 0;
				
				JOptionPane.showMessageDialog(pane, "Le vainqueur est :"+gagnant.getNom()+"avec la combinaison "+JoueurCombinaison(gagnant.getMain()[0],gagnant.getMain()[1],table));
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				
				int dialogRes = JOptionPane.showConfirmDialog(null, "Nouvelle partie ?", "Title on Box", dialogButton);
				
				if (dialogRes == 0)
				{
					
					this.tourDeTour = 0;
					this.Tour = 0;
					this.Pot = 0;
					this.table.aZero();
					this.paquet.raz();
					this.StadeDeBlind = true;
					Blinde();
				}
				
				
				encours = false;
				return true;
			}
		}
			
	}

	
	public void PotPlus(Joueur j, int sum)
	{
		Pot = (Pot + sum);
	}
	
	
	public void miser(Joueur j, int sum)
	{
		j.mise(sum);
		this.PotPlus(j,sum);
		

	}
	
	public void suivre(Joueur j)
	{
		Joueur Buffer;
		
		if (j.getSolde() > attendTour.getDerniereMise())
			
		{
			int x = attendTour.getTotalMiser();
			int y = tourDe.getTotalMiser();
			
			int suivr = ( x - y );
			
			j.mise(suivr);
			this.PotPlus(j, suivr);
			
			
			
			Buffer = tourDe;
			tourDe = attendTour;
			attendTour = Buffer;
		}
		
		else
		
		{	
			miser(j,j.getSolde());
			Buffer = tourDe;
			tourDe = attendTour;
			attendTour = Buffer;
			Allin();
			phaseFinal();
		}
	}
	
	public void parole(Joueur j)
	{
		Joueur Buffer;
		Buffer = tourDe;
		tourDe = attendTour;
		attendTour = Buffer;

		
	}
	
	public void Allin() 
	{
		if (Tour == 0) {
			table.tour1();
			table.tour2();
			table.tour3();
			
		}
			
		if(Tour == 1) {
			table.tour2();
			table.tour3();
			
		}
			
		if (Tour == 2) {
			table.tour3();
			
		}
			
		if (Tour == 3) {
			
		}
		
	}
	
	public void Blinde()
	{
		if ( (blindIndice %2 == 0) && (StadeDeBlind == true) )
		{
			tourDe = this.j1;
			attendTour = this.j2;
			
			miser(tourDe,Blind);
			tourDeTour++;
			
			miser(attendTour,(2*Blind));
			tourDeTour++;
			
			distributionCarte();
			
			tourDe = this.j1;
			attendTour = this.j2;
	
		}
		
		
		if ( (blindIndice %2 == 1) && (StadeDeBlind == true) )
		{
			miser(this.j2,Blind);
			tourDeTour++;
			
			miser(this.j1,(2*Blind));
			tourDeTour++;
			
			
			distributionCarte();
			
			tourDe = this.j2;
			attendTour = this.j1;
		}
		
		
		StadeDeBlind = false;
		blindIndice++;
	}
	public String JoueurCombinaison(Carte c1,Carte c2, Table table)
	{
				
		String res;
		Couleurs couleur = new Couleurs(c1,c2,table);
		Brelan brelan = new Brelan(c1,c2,table);
		Carre carre = new Carre(c1,c2,table);
		DoublePaire doublepaire = new DoublePaire(c1,c2,table);
		Full full = new Full(c1,c2,table);
		Paire paire = new Paire(c1,c2,table);
		Rien rien = new Rien(c1,c2,table);
		Suite suite = new Suite(c1,c2,table);
		SuiteRoyal suiteroyal = new SuiteRoyal(c1,c2,table);
		
		int resSuiteRoyal = suiteroyal.suiteRoyal(c1, c2, table);
		
		int rescarre = carre.carre(c1,c2,table);
		
		//une Carte suffie car si la combinaison n'est pas un full paire les 2 element du tableau seront 0
		int resfullc1 = full.full(c1,c2,table)[0];
		
		
		int rescouleur = couleur.couleur(c1,c2,table);	
		
		int ressuite = suite.suite(c1,c2,table);	
		
		int resbrelan = brelan.brelan(c1,c2,table);
		
		//une Carte suffie car si la combinaison n'est pas une Double paire les 2 element du tableau seront 0
		
		int resdoublePaircarte1 = doublepaire.doublePaire(c1,c2,table)[0];	
		
		int respaire = paire.paire(c1,c2,table);
		
		int resrien = rien.rien(c1,c2,table);	
		
		
		if (resSuiteRoyal != 0)
		{
			res = suiteroyal.getNom();
		}
		
		else if (rescarre != 0)
		{
			res = carre.getNom();
		}
			
		else if (resfullc1 != 0)
		{
			res =  full.getNom();
		}
		
		else if (rescouleur != 0)
		{
			res =  couleur.getNom();
		}
		
		else if (ressuite != 0)
		{
			res = suite.getNom();
		}
		
		else if (resbrelan != 0)
		{
			res = brelan.getNom();
		}
		
		else if (resdoublePaircarte1 != 0)
		{
			res =  doublepaire.getNom();
		}
		
		else if (respaire != 0)
		{
			res =  paire.getNom();
		}
		
		else if (resrien != 0)
		{
			res =  rien.getNom();
		}
		
		else
			
		res = rien.getNom();
		
		return res;
		
		
	}
	
	
	
	public void HandComparator()
	{
		Carte c1j1 = this.j1.getMain()[0];
		Carte c2j1 = this.j1.getMain()[1];
		Carte c1j2 = this.j2.getMain()[0];
		Carte c2j2 = this.j2.getMain()[1];
		Table tab = new Table(table.getTable()[0], table.getTable()[1], table.getTable()[2], table.getTable()[3], table.getTable()[4]);
		
		Couleurs couleur = new Couleurs(c1j1,c2j1,tab);
		Brelan brelan = new Brelan(c1j1,c2j1,tab);
		Carre carre = new Carre(c1j1,c2j1,tab);
		DoublePaire doublepaire = new DoublePaire(c1j1,c2j1,tab);
		Full full = new Full(c1j1,c2j1,tab);
		Paire paire = new Paire(c1j1,c2j1,tab);
		Rien rien = new Rien(c1j1,c2j1,tab);
		Suite suite = new Suite(c1j1,c2j1,tab);
		SuiteRoyal suiteroyal = new SuiteRoyal(c1j1,c2j1,tab);
		
		// suite royal
		int suiteRoyalJ1 = suiteroyal.suiteRoyal(c1j1, c2j1, tab);
		int suiteRoyalJ2 = suiteroyal.suiteRoyal(c1j2, c2j2, tab);

		// carre
		int carreJ1 = carre.carre(c1j1,c2j1,tab);
		int carreJ2 = carre.carre(c1j2,c2j2,tab);
		
		//full
		
		//Joueur 1
	
			//joueur 1 carte 1
			int fullJ1c1 = full.full(c1j1,c2j1,tab)[0];
			//joueur 1 carte 2
			int fullJ1c2 = full.full(c1j2,c2j2,tab)[1];
	
		//Joueur 2
			
			//joueur 2 carte 1
			int fullJ2c1 = full.full(c1j1,c2j1,tab)[0];
			//joueur 2 carte 2
			int fullJ2c2 = full.full(c1j2,c2j2,tab)[0];
			
		//Couleur
		
		int couleurJ1 = couleur.couleur(c1j1,c2j1,tab);	
		int couleurJ2 = couleur.couleur(c1j2,c2j2,tab);
		
		//Suite
		
		int suiteJ1 = suite.suite(c1j1,c2j1,tab);	
		int suiteJ2 = suite.suite(c1j2,c2j2,tab);
	
		//Brelan
		
		int brelanJ1 = brelan.brelan(c1j1,c2j1,tab);	
		int brelanJ2 = brelan.brelan(c1j2,c2j2,tab);
		
		//Double Paire
		
		//Joueur 1	
			//Carte 1
			int doublePairJ1carte1 = doublepaire.doublePaire(c1j1,c2j1,tab)[0];	
			//Carte 2
			int doublePairJ1carte2 = doublepaire.doublePaire(c1j1,c2j1,tab)[1];
			
		//Joueur 2
			//Carte 1
			int doublePairJ2carte1 = doublepaire.doublePaire(c1j2,c2j2,tab)[0];	
			//Carte 2
			int doublePairJ2carte2 = doublepaire.doublePaire(c1j2,c2j2,tab)[1];
			
		//Paire
		
		int paireJ1 = paire.paire(c1j1,c2j1,tab);	
		int paireJ2 = paire.paire(c1j2,c2j2,tab);	
		
		//Rien
		
		int rienJ1 = rien.rien(c1j1,c2j1,tab);	
		int rienJ2 = rien.rien(c1j2,c2j2,tab);
	
///------------------------------------------------------------------------------
		
	if ( ( (suiteRoyalJ1 != 0) || (suiteRoyalJ2 != 0) ) )
		{
			if (suiteRoyalJ1 == suiteRoyalJ2)
			{
				gagnant = null;
				egalite = true;
			}
			
			else if ( (suiteRoyalJ1 > 0) && (suiteRoyalJ2 == 0) )
			{
				gagnant = j1;
			}
			
			else if ( (suiteRoyalJ2 > 0) && (suiteRoyalJ1 == 0) )
			{
				gagnant = j2;
			}
			
			else if ((suiteRoyalJ1 > 0) && (suiteRoyalJ2 == 0))
			{
				if(suiteRoyalJ1 > suiteRoyalJ2 )
				{
					gagnant = j1;
				}
				else
					gagnant = j2; 
			}
			
		}
		
		
///--------------------------------------------------------------------------------
	else if ( ( (carreJ1 != 0) || ( carreJ2  != 0) ) )
		{
				
		
				
				if (carreJ1 == carreJ2)
				{
					gagnant = null;
					egalite = true;
				}
				
				else if ( (carreJ1 > 0) && (carreJ2 == 0) )
				{
					gagnant = j1;
				}
				
				else if ( (carreJ2 > 0) && (carreJ1 == 0) )
				{
					gagnant = j2;
				}
				
				else if ((carreJ1 > 0) && (carreJ2 == 0))
				{
					if(carreJ1 > carreJ2 )
					{
						gagnant = j1;
					}
					else
						gagnant = j2; 
				}
			
		}
///------------------------------------------------------------------------------
				
		else if( ( ((fullJ1c1 != 0) && (fullJ1c2 != 0)) || ( (fullJ2c1 != 0) ) && (fullJ2c2 != 0))  )
		{
				
	
				if ( (fullJ1c1 == fullJ2c1) && (fullJ1c2 == fullJ2c2))
				{
					gagnant = null;
					egalite = true;
				}
				
				else if ( (fullJ1c2 > 0) && (fullJ2c2 == 0) )
				{
					gagnant = j1;
				}
				
				else if ( (fullJ2c2 > 0) && (fullJ1c2 == 0) )
				{
					gagnant = j2;
				}
				
				else if ((fullJ1c2 > 0) && (fullJ2c2 == 0))
				{
					if(fullJ1c2 > fullJ2c2)
					{
						gagnant = j1;
					}
					else
						gagnant = j2; 
				}
			
		}
///------------------------------------------------------------------------------
					
					
		else if( ( (couleurJ1 != 0) || (couleurJ2 != 0) ) )
		{
			if ( ( couleurJ1 > 0) && (couleurJ2 == 0) )
			{
				gagnant = j1;
			}
			
			else if ( (couleurJ2 > 0) && (couleurJ1 == 0) )
			{
				gagnant = j2;
			}
			
			else if ((couleurJ1 > 0) && (couleurJ2 == 0))
			{
				if(couleurJ1 > couleurJ2 )
				{
					gagnant = j1;
				}
				else
					gagnant = j2; 
			}
		
						
		}			
	///------------------------------------------------------------------------------
						
		else if ( ( (suiteJ1 != 0) || (suiteJ2 != 0) ) )
		{
	
			if ( ( suiteJ1 > 0) && (suiteJ2 == 0) )
			{
				gagnant = j1;
			}
			
			else if ( (suiteJ2 > 0) && (suiteJ1 == 0) )
			{
				gagnant = j2;
			}
			
			else if ((suiteJ1 > 0) && (suiteJ2 == 0))
			{
				if(suiteJ1 > suiteJ2 )
				{
					gagnant = j1;
				}
				else
					gagnant = j2; 
			}	
								
								
		}					
	///------------------------------------------------------------------------------		-	
							
							
		else if ( ( (  brelanJ1 != 0) || (brelanJ2 != 0) ) )
		{
			
				if ( ( brelanJ1 > 0) && (brelanJ2 == 0) )
				{
					gagnant = j1;
				}
				
				else if ( (brelanJ2 > 0) && (brelanJ1 == 0) )
				{
					gagnant = j2;
				}
				
				else if ((brelanJ1 > 0) && (brelanJ2 == 0))
				{
					if(brelanJ1 > brelanJ2 )
					{
						gagnant = j1;
					}
					else
						gagnant = j2;
					
					}
			
			
		}							
	///------------------------------------------------------------------------------
									
									
		else if ( ( ((doublePairJ1carte1 != 0) && (doublePairJ1carte2 != 0)) || ( (doublePairJ2carte1 != 0) ) && (doublePairJ2carte2 != 0))  )
		{
		
					if ( (doublePairJ1carte2 > 0) && (doublePairJ2carte2 == 0) )
					{
						gagnant = j1;
					}
					
					else if ( (doublePairJ2carte2 > 0) && (doublePairJ1carte2 == 0)
 )
					{
						gagnant = j2;
					}
					
					else if ((doublePairJ1carte2 > 0) && (doublePairJ2carte2 == 0))
					{
						if(doublePairJ1carte2 > doublePairJ2carte2)
						{
							gagnant = j1;
						}
						else
							gagnant = j2; 
					}
				
				
		}								
											
///------------------------------------------------------------------------------
											
											
		else if ( ( (paireJ1 != 0) || (paireJ2 != 0) ) )
			{
				
				
					if ( ( paireJ1 > 0) && (paireJ2 == 0) )
					{
						gagnant = j1;
					}
					
					else if ( (paireJ2 > 0) && (paireJ1 == 0) )
					{
						gagnant = j2;
					}
					
					else if ((paireJ1 > 0) && (paireJ2 == 0))
					{
						if(paireJ1 > paireJ2 )
						{
							gagnant = j1;
						}
						else
							gagnant = j2;
						
					}
				
				
			}								
	///------------------------------------------------------------------------------
												
												
		else if ( ( (rienJ1 != 0) || (rienJ2 != 0) ) )
		{
			
				if ( ( rienJ1 > 0) && (rienJ2 == 0) )
				{
					gagnant = j1;
				}
				
				else if ( (rienJ2 > 0) && (rienJ1 == 0) )
				{
					gagnant = j2;
				}
				
				else if ((rienJ1 > 0) && (rienJ2 == 0))
				{
					if(rienJ1 > rienJ2 )
					{
						gagnant = j1;
					}
					else
						gagnant = j2;
					
				}
		}
		
	}
	
	public void distributionCarte()
	{
		// Initialisation des mains
		
					//Joueur 1
					Carte c1j1 = paquet.pioche();
					Carte c2j1 = paquet.pioche();
					j1.nouvelle_main(c1j1, c2j1);
					
					//Joueur 2
					Carte c1j2 = paquet.pioche();
					Carte c2j2 = paquet.pioche();
					j2.nouvelle_main(c1j2, c2j2);
		//Fin initialisation des mains.
					
	}
	
	public void afficherEtatPartie()
	{
		System.out.println(" ");
		System.out.println("			"+j1.getNom()+" "+j1.getSolde()+"             "+j1.getTotalMiser()+"   "+j1.getDerniereMise());	
		System.out.println("         "+j1.getMain()[0].getValeur()+j1.getMain()[0].getCouleur()+" "+j1.getMain()[1].getValeur()+j1.getMain()[1].getCouleur());
		System.out.println(table.getTable()[0].getValeur() + table.getTable()[0].getCouleur().toString() + " "+ table.getTable()[1].getValeur() + table.getTable()[1].getCouleur().toString() + " "+ table.getTable()[2].getValeur() + table.getTable()[2].getCouleur().toString() + " "+ table.getTable()[3].getValeur() + table.getTable()[3].getCouleur().toString() + " "+ table.getTable()[4].getValeur() + table.getTable()[4].getCouleur().toString() + "                "+ Pot);
		
		System.out.println("			"+j2.getNom()+" "+j2.getSolde()+"             "+j2.getTotalMiser()+"    "+j2.getDerniereMise());
		System.out.println("         "+j2.getMain()[0].getValeur()+j2.getMain()[0].getCouleur()+" "+j2.getMain()[1].getValeur()+j2.getMain()[1].getCouleur());
		
		//System.out.println("			C'est le tour de : "+this.getattendTour().getNom()+"             ");
		
		System.out.println(" ");
	}
	
	public void afficherGagant()
	{
		System.out.println("Le gagant est :"+gagnant.getNom());
	}
	
	public Joueur getJ1()
	{
		return j1;
	}
	
	public Joueur getJ2()
	{
		return j2;
	}
	
	public boolean getEtatPartie()
	{
		return encours;
	}
	
	public Joueur getTourDe()
	{
		return tourDe;
	}
	
	public Joueur getattendTour()
	{
		return tourDe;
	}
	
	public void RAZPOT ()
	{
		this.Pot = 0;
	}
	
	public int getTour()
	{
		return Tour;
	}
	
	public int getPot()
	{
		return Pot;
	}
	
	public Carte getFlop1()
	{
		return table.getFlop1();
	}
	
	public Carte getFlop2()
	{
		return table.getFlop2();
	}
	
	public Carte getFlop3()
	{
		return table.getFlop3();
	}
	
	public Carte getTurn()
	{
		return table.getTurn();
	}
	
	public Carte getRiver()
	{
		return table.getRiver();
	}
	
	public int getTourDeTour()
	{
		return tourDeTour;
	}
	
	public int getBlind() {
		return blindIndice;
	}
	
	
	
		
}