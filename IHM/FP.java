package IHM;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.ChangeListener;

import Modele.ActionUtilisateur;
import Modele.Partie;
import javax.swing.event.ChangeEvent;


public class FP extends JFrame {

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
	private TourPanel tourJ1;
	private TourPanel tourJ2;
	private JPanel CardPanel;
	private MisePanel mise;
	private MisePanel Pot;
	private MisePanel miseAdversaire;
	private int SpinnerMise;
	private Partie partie;
	
	
	// LArgeur des petite cartes
	private static final int CLP=49;
	// Hauteur des petites cartes
	private static final int CHP=68;
	//Largeur des Grandes cartes
	private static final int CLG=68;
	//Hauteur des grandes cartes
	private static final int CHG=108;

	protected static final Graphics Graphics = null;
	

	public FP() {
		
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setType(Type.UTILITY);
		
		this.setBounds(100, 100, 900, 600);
		
		this.setTitle("Poker");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
				
		////////////////////////////// Les Panels /////////////////////////////////////////////
///
		
		acceuil = new Acceuil();
		
		parametre = new Parametre();
		
		this.FPP = new JPanel();
		
		
		///////////////////////////////  Fenetre d'acceuil  //////////////////////////////////////
		
			
			contentPane.add(acceuil, "Acceuil");
			acceuil.setLayout(null);
			acceuil.actionJouer(acceuil,parametre );
			acceuil.actionJouer(acceuil,FPP );
			
			partie = new Partie("LOL","MDR",5000,5000);
			 
		
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
                            	tourJ1.setValeur("Tour de :");
                            	tourJ2.setValeur("");
                            }
                            else if (partie.getJ2() == partie.getTourDe())
                            {
                            	tourJ2.setValeur("Tour de :");
                            	tourJ1.setValeur("");
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
                            	tourJ1.setValeur("Tour de :");
                            	tourJ2.setValeur("");
                            }
                            else if (partie.getJ2() == partie.getTourDe())
                            {
                            	tourJ2.setValeur("Tour de :");
                            	tourJ1.setValeur("");
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
                            	tourJ1.setValeur("Tour de :");
                            	tourJ2.setValeur("");
                            }
                            else if (partie.getJ2() == partie.getTourDe())
                            {
                            	tourJ2.setValeur("Tour de :");
                            	tourJ1.setValeur("");
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
                            	tourJ1.setValeur("Tour de :");
                            	tourJ2.setValeur("");
                            }
                            else if (partie.getJ2() == partie.getTourDe())
                            {
                            	tourJ2.setValeur("Tour de :");
                            	tourJ1.setValeur("");
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
				
				carteAdversaire1 = new Carteimg(partie.getJ2().getMain()[0], CLG , CHG)
;
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
				
				
				mise = new MisePanel(partie.getJ1().getSolde());
				mise.setBounds(416, 324, 92, 35);
				CardPanel.add(mise);
				
				
				miseAdversaire = new MisePanel(partie.getJ2().getSolde());
				miseAdversaire.setBounds(410, 132, 92, 35);
				CardPanel.add(miseAdversaire);		
				
				JButton btnQuitter = new JButton("Quitter");
				
				btnQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						FPP.setVisible(false);
						acceuil.setVisible(true);
					}
				});
				btnQuitter.setBounds(12, 12, 117, 25);
				CardPanel.add(btnQuitter);
				
				////////////////////////////////////// Name 1 ///////////////////////////////////////////
				
				NamePanel namePanel1 = new NamePanel(parametre.getName1());
				namePanel1.setBounds(265, 371, 117, 35);
				CardPanel.add(namePanel1);
				
				
				////////////////////////////////////// Name 2 ///////////////////////////////////////////
				
				NamePanel namePanel2 = new NamePanel(parametre.getName2());
				namePanel2.setBounds(265, 85, 117, 35);
				CardPanel.add(namePanel2);
				
				//////////////////////////////////////TourPanel 1 ///////////////////////////////////////////
				
				
				tourJ1 = new TourPanel("");
				
				if( partie.getTourDe() == partie.getJ1() )
					tourJ1.setValeur("Tour de :");
					
				
				tourJ1.setBounds(149, 371, 117, 35);
				CardPanel.add(tourJ1);
				
				//////////////////////////////////////TourPanel 2///////////////////////////////////////////
				
				tourJ2 = new TourPanel("");
				
				if( partie.getTourDe() == partie.getJ2() )
					tourJ2.setValeur("Tour de :");
				
				tourJ2.setBounds(149, 85, 117, 35);
				CardPanel.add(tourJ2);
				
				JButton btnNouvellePartie = new JButton("Nouvelle Partie");
				btnNouvellePartie.setBounds(12, 39, 117, 29);
				CardPanel.add(btnNouvellePartie);
				btnQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						partie = new Partie(partie.getJ1().getNom(),partie.getJ2().getNom(),5000,5000);
						
					}
				});
				
				/////////////////////////////////////////////////////////////////////////////////////////
		
		this.setVisible(true);
	
	}
	
	
	public JButton getBtnMiser() {
		return BtnMiser;
	}

	public JButton getBtnParole() {
		return btnParole;
	}

	public JButton getBtnSuivre() {
		return btnSuivre;
	}

	public JButton getBtnPasser() {
		return btnPasser;
	}

	public JSpinner getSpinner() {
		return spinner;
	}


	public Carteimg getFlop3() {
		return flop3;
	}


	public Carteimg getFlop2() {
		return flop2;
	}


	public Carteimg getFlop1() {
		return flop1;
	}


	public Carteimg getTurn() {
		return turn;
	}


	public Carteimg getRiver() {
		return river;
	}


	public Carteimg getCarte1() {
		return carte1;
	}


	public Carteimg getCarte2() {
		return carte2;
	}


	public Carteimg getCarteAdversaire1() {
		return carteAdversaire1;
	}


	public Carteimg getCarteAdversaire2() {
		
		return carteAdversaire2;
	}

	public int getMise() {
		return mise.getValeur();
	}

	public int getPot() {
		return Pot.getValeur();
	}


	public int getMiseAdversaire() 
	{
		return miseAdversaire.getValeur();
	}
	
	public Parametre getParamtre()
	{
		return parametre;
	}
	
	
	public void setAll(Partie p)

    {
            this.partie = p;

            btnParole.setPartie(p);

            btnPasser.setPartie(p);

            btnSuivre.setPartie(p);

            BtnMiser.setPartie(p);

    }

	
	
	public static void main(String[] args) {
		
		new FP();

	}
}