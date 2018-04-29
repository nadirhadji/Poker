package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.event.ChangeListener;

import Modele.ActionUtilisateur;
import Modele.Partie;
import javax.swing.event.ChangeEvent;

import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;

/**
 * 
 * <p>Gére l'interface graphique<br>
 * Herite de JFrame</p>
 * @see JFrame
 */

public class FP extends JFrame  {
	
	public FP() {
	}

	private JPanel contentPane;
	
	private static final long serialVersionUID = 1L;
	
	private Acceuil acceuil;
	private Parametre parametre;
	private JPanel FPP;
	private Boutton BtnMiser;
	private Boutton btnParole;
	private Boutton btnSuivre;
	private Boutton btnPasser;
	private JSpinner spinner;
	private Carteimg flop3;
	private Carteimg flop2;
	private Carteimg flop1 ;
	private Carteimg turn;
	private Carteimg river;
	private Carteimg carte1;
	private Carteimg carte2;
	private Carteimg carteAdversaire1;
	private Carteimg carteAdversaire2;
	private TourPanel tourDe;
	File f;

	private JPanel CardPanel;
	private MisePanel mise;
	private MisePanel Pot;
	private MisePanel miseAdversaire;
	private int SpinnerMise;
	private NamePanel namePanel1;
	private NamePanel namePanel2;
	private Partie partie;
	private JOptionPane pane;
	
	
	// LArgeur des petite cartes
	private static final int CLP=49;
	// Hauteur des petites cartes
	private static final int CHP=68;
	//Largeur des Grandes cartes
	private static final int CLG=68;
	//Hauteur des grandes cartes
	private static final int CHG=108;

	protected static final Graphics Graphics = null;
	
	/**
	 *<p> Lance l'interface,<br>
	 *Initialise tous les paramètres <br>
	 *Créer les MouseEvent qui n'ont pas put être défini dans des sous classes</p>
	 */
	
	public void runn()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setType(Type.UTILITY);
		
		this.setBounds(100, 100, 900, 600);
		
		this.setTitle("Poker");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
				
		////////////////////////////// Les Panels ////////////////////////////////////////////////
		
		acceuil = new Acceuil();
		
		parametre = new Parametre();
		
		this.FPP = new JPanel();
		
		partie = new Partie();
		
		
		///////////////////////////////  Fenetre d'acceuil  //////////////////////////////////////
		
			
			contentPane.add(acceuil, "Acceuil");
			acceuil.setLayout(null);
			acceuil.actionJouer(acceuil,parametre );
			acceuil.actionJouer(acceuil,FPP );
			
			acceuil.getButton().addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) 
    			{
					if ( (partie.getTour() == 0) && (partie.getTourDeTour() == 0) )
							{
					
					//initilisation de la partie avec les donnees parametre
					partie.getJ1().setNom(parametre.getName1());
					partie.getJ1().setSolde(parametre.getSolde1());
					partie.getJ2().setNom(parametre.getName2());
					partie.getJ2().setSolde(parametre.getSolde2());
					
					// Statde de binde 
					partie.Blinde();	
					
					//Initialisation de la vue.
					mise.setValeur(partie.getJ1().getSolde());
					miseAdversaire.setValeur(partie.getJ2().getSolde());
					Pot.setValeur(partie.getPot());
					namePanel1.setValeur(partie.getJ1().getNom());
					namePanel2.setValeur(partie.getJ2().getNom());
					carteAdversaire1.setCarte(partie.getJ2().getMain()[0], CLG , CHG);
					carteAdversaire2.setCarte(partie.getJ2().getMain()[1], CLG , CHG);
					carte1.setCarte(partie.getJ1().getMain()[0], CLG , CHG);
					carte2.setCarte(partie.getJ1().getMain()[1], CLG , CHG);
					
					//envoie de la partie a tout les bouttons (afin que ceux ci sache qu'elle est l'etat de la partie.
					setAll(partie);
							}
					
					else
						
						// Si une partie est deja commencer, le reparametrage est impossible.
						JOptionPane.showMessageDialog(pane, "Une partie est en cours, parametrage interdit");
					
							
    			}
			});
			
			
			//Boutton Continuer Partie : recupere l'objet enregister apres le clique et initlialise cette objet partie a toute
			//les objets l'utilisant.
			
			
			acceuil.getContinuer().addMouseListener(new MouseAdapter() 
			{
				
				public void mouseClicked(MouseEvent e) 
    			{
					
					Partie p = charger();
					
					 flop1.setCarte(p.getFlop1(), CLP, CHP);
                     flop2.setCarte(p.getFlop2(), CLP, CHP);
                     flop3.setCarte(p.getFlop3(), CLP, CHP);
                     turn.setCarte(p.getTurn(), CLP, CHP);
                     river.setCarte(p.getRiver(), CLP, CHP);
                     Pot.setValeur(p.getPot());
                     mise.setValeur(p.getJ1().getSolde());
                     miseAdversaire.setValeur(p.getJ2().getSolde());
                     
                     if(partie.getJ1() == partie.getTourDe())
                     {
                     	tourDe.setBounds(149, 371, 117, 35);
                     	
                     }
                     else if (partie.getJ2() == partie.getTourDe())
                     {
                     	tourDe.setBounds(149, 85, 117, 35);
                     }
					
					
					setAll(p);
					
    			}
			
			});
			
		//////////////////////////////  Fenetre Parametrage ///////////////////////////////////////
				

				contentPane.add(parametre, "Parametre");
				Parametre.actionOK(acceuil,parametre);
				
				
		////////////////////////////  Fenetre de Jeu  ////////////////////////////////////////////
		
		
		contentPane.add(FPP, "Table");
		FPP.setLayout(new BorderLayout(0, 0));
		FPP.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		FPP.setBounds(3, 6, this.getHeight(), this.getWidth());
				FPP.setLayout(new BorderLayout(0, 0));
				JPanel ButtonPanel = new JPanel();
				FPP.add(ButtonPanel, BorderLayout.SOUTH);
				ButtonPanel.setLayout(new GridLayout(0, 5, 0, 0));
						
		
				
				
		//Boutton Miser	
				
				this.BtnMiser = new Boutton(partie,"Miser",0);
				ButtonPanel.add(BtnMiser);
			
				BtnMiser.addMouseListener(new MouseAdapter(){

                	public void mouseClicked(MouseEvent e) 
        			{
                			
                				BtnMiser.act(partie.getTourDe(), ActionUtilisateur.MISER,SpinnerMise);
                		
                            Partie p = BtnMiser.getPartie();

                            setAll(p);  
                            
                            flop1.setCarte(p.getFlop1(), CLP, CHP);
                            flop2.setCarte(p.getFlop2(), CLP, CHP);
                            flop3.setCarte(p.getFlop3(), CLP, CHP);
                            turn.setCarte(p.getTurn(), CLP, CHP);
                            river.setCarte(p.getRiver(), CLP, CHP);
                            Pot.setValeur(p.getPot());
                            mise.setValeur(p.getJ1().getSolde());
                            miseAdversaire.setValeur(p.getJ2().getSolde());
                            
                            if(partie.getJ1() == partie.getTourDe())
                            {
                            	tourDe.setBounds(149, 371, 117, 35);
                            	
                            }
                            else if (partie.getJ2() == partie.getTourDe())
                            {
                            	tourDe.setBounds(149, 85, 117, 35);
                            }
                         
                            

                    }

				});

				
		//Boutton Spinner
				
				this.spinner = new JSpinner();
				
				spinner.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						
						SpinnerMise = Integer.parseInt(spinner.getValue().toString());
						BtnMiser.setMise(SpinnerMise);
						
					}
				});
				
				
				ButtonPanel.add(spinner);
				
		//Boutton Suivre		
				
				this.btnSuivre = new Boutton(partie,"Suivre",0);
				ButtonPanel.add(btnSuivre);
				btnSuivre.addMouseListener(new MouseAdapter(){

                	public void mouseClicked(MouseEvent e) 
        			{
                			
                				btnSuivre.act(partie.getTourDe(), ActionUtilisateur.SUIVRE,0);
                		
                            Partie p = btnSuivre.getPartie();

                            setAll(p);
                            
                            flop1.setCarte(p.getFlop1(), CLP, CHP);
                            flop2.setCarte(p.getFlop2(), CLP, CHP);
                            flop3.setCarte(p.getFlop3(), CLP, CHP);
                            turn.setCarte(p.getTurn(), CLP, CHP);
                            river.setCarte(p.getRiver(), CLP, CHP);
                            Pot.setValeur(p.getPot());
                            mise.setValeur(p.getJ1().getSolde());
                            miseAdversaire.setValeur(p.getJ2().getSolde());
                            
                            if(partie.getJ1() == partie.getTourDe())
                            {
                            	tourDe.setBounds(149, 371, 117, 35);
                            }
                            else if (partie.getJ2() == partie.getTourDe())
                            {
                            	tourDe.setBounds(149, 85, 117, 35);
                            }

                    }

				});
				
		//Boutton Passer
				
				this.btnPasser = new Boutton(partie,"Passer",0);
				ButtonPanel.add(btnPasser);
				btnPasser.addMouseListener(new MouseAdapter(){

                	public void mouseClicked(MouseEvent e) 
        			{
                			btnPasser.act(partie.getTourDe(), ActionUtilisateur.PASSER,0);
                		
                            Partie p = btnPasser.getPartie();

                            setAll(p);  
                            
                            flop1.setCarte(p.getFlop1(), CLP, CHP);
                            flop2.setCarte(p.getFlop2(), CLP, CHP);
                            flop3.setCarte(p.getFlop3(), CLP, CHP);
                            turn.setCarte(p.getTurn(), CLP, CHP);
                            river.setCarte(p.getRiver(), CLP, CHP);
                            Pot.setValeur(p.getPot());
                            mise.setValeur(p.getJ1().getSolde());
                            miseAdversaire.setValeur(p.getJ2().getSolde());
                            
                            if(partie.getJ1() == partie.getTourDe())
                            {
                            	tourDe.setBounds(149, 371, 117, 35);
                            }
                            else if (partie.getJ2() == partie.getTourDe())
                            {
                            	tourDe.setBounds(149, 85, 117, 35);
                            }
                    }

				});
				
		//Boutton Parole		
				
				this.btnParole = new Boutton(partie,"Parole",0);
				ButtonPanel.add(btnParole);
				btnParole.addMouseListener(new MouseAdapter(){

                	public void mouseClicked(MouseEvent e) 
        			{
                			
                			btnParole.act(partie.getTourDe(), ActionUtilisateur.PAROLE,0);
                		
                            Partie p = btnParole.getPartie();

                            setAll(p);  
                            
                            flop1.setCarte(p.getFlop1(), CLP, CHP);
                            flop2.setCarte(p.getFlop2(), CLP, CHP);
                            flop3.setCarte(p.getFlop3(), CLP, CHP);
                            turn.setCarte(p.getTurn(), CLP, CHP);
                            river.setCarte(p.getRiver(), CLP, CHP);
                           
                            
                            Pot.setValeur(p.getPot());
                            mise.setValeur(p.getJ1().getSolde());
                            miseAdversaire.setValeur(p.getJ2().getSolde());
                            
                            if(partie.getJ1() == partie.getTourDe())
                            {
                            	tourDe.setBounds(149, 371, 117, 35);
                            }
                            else if (partie.getJ2() == partie.getTourDe())
                            {
                            	tourDe.setBounds(149, 85, 117, 35);
                            }

                    }

				});
		
		
		//Carte de la table
				
				CardPanel = new TablePanel();
				FPP.add(CardPanel, BorderLayout.CENTER);
				CardPanel.setLayout(null);
				
				
				river = new Carteimg(partie.getRiver(), CLP , CHP);
				river.setBounds(514, 215, CLP, CHP);
				CardPanel.add(river);
				
				
				turn = new Carteimg(partie.getTurn(), CLP , CHP);
				turn.setBounds(465, 215, CLP, CHP);
				CardPanel.add(turn);
				
				flop3 = new Carteimg(partie.getFlop3(), CLP , CHP);
				flop3.setBounds(416, 215, CLP, CHP);
				CardPanel.add(flop3);
				
				flop2 = new Carteimg(partie.getFlop2(), CLP , CHP);
				flop2.setBounds(367, 215, CLP, CHP);
				CardPanel.add(flop2);
				
				
				flop1 = new Carteimg(partie.getFlop1(), CLP , CHP);
				flop1.setBounds(318, 215, CLP, CHP);
				CardPanel.add(flop1);
				
				carteAdversaire1 = new Carteimg(partie.getJ2().getMain()[0], CLG , CHG);
				CardPanel.add(carteAdversaire1);
				carteAdversaire1.setBounds(387, 12, CLG, CHG);
			
				
				carteAdversaire2 = new Carteimg(partie.getJ2().getMain()[1], CLG ,CHG);
				carteAdversaire2.setBounds(455, 12, CLG, CHG);
				CardPanel.add(carteAdversaire2);
				
				carte1 = new Carteimg(partie.getJ1().getMain()[0], CLG, CHG);
				carte1.setBounds(387, 371, CLG, CHG);
				CardPanel.add(carte1);
				
				carte2 = new Carteimg(partie.getJ1().getMain()[1], CLG , CHG);
				carte2.setBounds(455, 371, CLG, CHG);
				CardPanel.add(carte2);
				
				Pot = new MisePanel(partie.getPot());
				Pot.setBounds(606, 227, 92, 35);
				CardPanel.add(Pot);
				//////////////////////////////////// Solde des 2 joueurs ////////////////////////////////////////
				
				mise = new MisePanel(partie.getJ1().getSolde());
				mise.setBounds(416, 324, 92, 35);
				CardPanel.add(mise);
				
				
				miseAdversaire = new MisePanel(partie.getJ2().getSolde());
				miseAdversaire.setBounds(410, 132, 92, 35);
				CardPanel.add(miseAdversaire);		
				
				
				////////////////////////////////////// Name 1 ///////////////////////////////////////////
				
				namePanel1 = new NamePanel(partie.getJ1().getNom());
				namePanel1.setBounds(265, 371, 117, 35);
				CardPanel.add(namePanel1);
				
				
				////////////////////////////////////// Name 2 ///////////////////////////////////////////
				
				namePanel2 = new NamePanel(partie.getJ2().getNom());
				namePanel2.setBounds(265, 85, 117, 35);
				CardPanel.add(namePanel2);
				
				//////////////////////////////////////TourPanel ///////////////////////////////////////////
				
				
				tourDe = new TourPanel("Tour de ");
				
				if( partie.getTourDe() == partie.getJ1() )
					tourDe.setBounds(149, 371, 117, 35);
				
				CardPanel.add(tourDe);
				
				
				if( partie.getTourDe() == partie.getJ2() )
					tourDe.setBounds(149, 85, 117, 35);
				
				CardPanel.add(tourDe);
				
				//////////////////////////////////// Boutton quitter detruit la partie ( ou sauvegarde) /////////////////////////////////
				
				// Ne pas oublier de faire perdre le joueur a qui le tour de jouer.
				
				JButton btnQuitter = new JButton("Quitter");
				
				btnQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						sauver(partie);
						//partie = new Partie();
						//setAll(partie);
						FPP.setVisible(false);
						acceuil.setVisible(true);
						
					}
				});
				btnQuitter.setBounds(12, 12, 117, 25);
				CardPanel.add(btnQuitter);
				
				///////////////////////////////////// le joueur qui cliaue sur nouvelle partie , perd la partie /////////////////////////////
				
				JButton btnNouvellePartie = new JButton("Nouvelle Partie");
				btnNouvellePartie.setBounds(12, 39, 117, 29);
				CardPanel.add(btnNouvellePartie);
				btnQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						
						
					}
				});
				
				////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
				
				
				
				this.setVisible(true);
	}
	
	public void setAffichage()
	{
		
	}
	
	/**
	 * 
	 * @return le bouton miser
	 */
	
	public JButton getBtnMiser() {
		return BtnMiser;
	}

	/**
	 * 
	 * @return le bouton Parole
	 */
	public JButton getBtnParole() {
		return btnParole;
	}
	
	/**
	 * 
	 * @return le bouton Suivre
	 */
	public JButton getBtnSuivre() {
		return btnSuivre;
	}
	
	/**
	 * 
	 * @return le bouton passer
	 */

	public JButton getBtnPasser() {
		return btnPasser;
	}

	public JSpinner getSpinner() {
		return spinner;
	}
	
	/**
	 * 
	 * @return la troisième carte du flop
	 */


	public Carteimg getFlop3() {
		return flop3;
	}
	
	/**
	 * 
	 * @return la deuxième carte du flop
	 */

	public Carteimg getFlop2() {
		return flop2;
	}

	/**
	 * 
	 * @return la premère carte du flop
	 */

	public Carteimg getFlop1() {
		return flop1;
	}
	
	/**
	 * 
	 * @return la carte du tournant
	 */

	public Carteimg getTurn() {
		return turn;
	}
	
	/**
	 * 
	 * @return la carte de la rivière
	 */

	public Carteimg getRiver() {
		return river;
	}
	
	/**
	 * 
	 * @return la première carte en main
	 */

	public Carteimg getCarte1() {
		return carte1;
	}
	
	/**
	 * 
	 * @return la deuxième carte en main
	 */

	public Carteimg getCarte2() {
		return carte2;
	}
	/**
	 * 
	 * @return la première carte de l'adversaire
	 */

	public Carteimg getCarteAdversaire1() {
		return carteAdversaire1;
	}
	
	/**
	 * 
	 * @return la deuxième carte de l'adversaire
	 */


	public Carteimg getCarteAdversaire2() {
		
		return carteAdversaire2;
	}
	/**
	 * 
	 * @return la mise
 	 */
	public int getMise() {
		return mise.getValeur();
	}
	/**
	 * 
	 * @return le pot
 	 */

	public int getPot() {
		return Pot.getValeur();
	}
	/**
	 * 
	 * @return la mise de l'adversaire
	 */

	public int getMiseAdversaire() 
	{
		return miseAdversaire.getValeur();
	}
	
	/**
	 * 
	 * @return la fenetre de parametre
	 */
	
	public Parametre getParamtre()
	{
		return parametre;
	}
	
	/**
	 * <p> Mets à jour la partie de FP et de tous ses boutons <p>
	 * @param p l'état actuel de la partie
	 */
	
	public void setAll(Partie p)

    {
            this.partie = p;

            btnParole.setPartie(p);

            btnPasser.setPartie(p);

            btnSuivre.setPartie(p);

            BtnMiser.setPartie(p);
            
            parametre.setPartie(p);

    }
	
	/**
	 * <p>Sauvegarde la partie dans le fichier save</p>
	 * @param p : l'état actuel de la partie
	 */
	
	public void sauver(Partie p)
    {
		
		f = new File ("save"); 
		
		try
		{
		    ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream (f));
		    oos.writeObject (p);
		    oos.close();
		}
		catch (IOException exception)
		{
		    System.out.println ("Erreur lors de l'écriture : " + exception.getMessage());
		}
            
            
    }
	/**
	 * <p>Charge la partie</p>
	 * @return l'état dans lequel la partie a été sauvegardée
	 */
    
    public Partie charger()
    {            
           Partie p = new Partie();
    			
           try
            {
               
            		ObjectInputStream ois = new ObjectInputStream (new FileInputStream ("save"));
                p = (Partie) ois.readObject();
                ois.close();
             
                System.out.println (p);
            }
            catch (ClassNotFoundException exception)
            {
                System.out.println ("Impossible de lire l'objet : " + exception.getMessage());
            }
            catch (IOException exception)
            {
                System.out.println ("Erreur lors de l'écriture : " + exception.getMessage());
            }
            
            
            return p;
    } 
		

		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FP frame = new FP();
						frame.runn();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		

	}
