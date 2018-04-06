package IHM;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import Modele.Partie;

public class FP extends JFrame {

	private JPanel contentPane;
private static final long serialVersionUID = 1L;
	
	private JPanel Acceuil;
	private JPanel Parametrage;
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
	private JPanel CardPanel;
	private MisePanel mise;
	private MisePanel Pot;
	private MisePanel miseAdversaire;
	private int SpinnerMise;
	private Socket	client;
	private SocketAddress serverSockAddress;
	private InetAddress serverIPAddress;
	private int serverPort = 10000;
	private String hostName = "127.0.0.1";
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private Partie partie;
	
	// LArgeur des petite cartes
	private static final int CLP=49;
	// Hauteur des petites cartes
	private static final int CHP=68;
	//Largeur des Grandes cartes
	private static final int CLG=68;
	//Hauteur des grandes cartes
	private static final int CHG=108;
	private JTextField textField;
	private JTextField textField_1;
	

	/**
	 * Create the frame.
	 */
	public FP() {
		
		client = new Socket();
		
		try 
		{
			serverIPAddress = InetAddress.getByName(hostName);
		}
		catch(UnknownHostException ex)
		{
			System.out.println("Aucun hote");
			return;
		}
		
		serverSockAddress = new InetSocketAddress(serverIPAddress, serverPort);
		
		try
		{
			client.connect(serverSockAddress);
			System.out.println("Connection établie");
		}
		catch(IOException ex)
		{
			System.out.println("Client : echec de la connection");
		}
		
		try
		{
			reader = new ObjectInputStream(client.getInputStream());
			writer = new ObjectOutputStream(client.getOutputStream());
			
			System.out.println("Reader et writer opérationels");
		}
		catch(SocketException ex){
			System.out.println("Error in socket reader or writer ");
			return;
		}
		catch(IOException ex)
		{
			System.out.println("Error in readSocket");
			return;

		} 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setType(Type.UTILITY);
		
		this.setBounds(100, 100, 900, 600);
		
		this.setTitle("Poker");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
				
				////////////////////////////////Fenetre Parametrage /////////////////////////
				
				Parametrage = new JPanel();
				contentPane.add(Parametrage, "Parametre");
				Parametrage.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Nom Joueur 1");
				lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				lblNewLabel.setBounds(218, 113, 156, 52);
				Parametrage.add(lblNewLabel);
				
				JLabel label = new JLabel("Nom Joueur 2");
				label.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				label.setBounds(218, 177, 156, 52);
				Parametrage.add(label);
				
				JLabel label_1 = new JLabel("Solde Joueur 1");
				label_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				label_1.setBounds(218, 241, 156, 52);
				Parametrage.add(label_1);
				
				JLabel label_2 = new JLabel("Solde Joueur 2");
				label_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
				label_2.setBounds(218, 305, 156, 52);
				Parametrage.add(label_2);
				
				textField = new JTextField();
				textField.setBounds(433, 119, 156, 41);
				Parametrage.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(433, 174, 156, 41);
				Parametrage.add(textField_1);
				
				JSpinner spinner_1 = new JSpinner();
				spinner_1.setBounds(433, 251, 156, 34);
				Parametrage.add(spinner_1);
				
				JSpinner spinner_2 = new JSpinner();
				spinner_2.setBounds(433, 315, 156, 34);
				Parametrage.add(spinner_2);
				
				JButton btnNewButton = new JButton("OK");
				btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
				Parametrage.setVisible(false);
				Acceuil.setVisible(true);
				
				}
				});
				btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
				});
				btnNewButton.setBounds(328, 402, 150, 52);
				Parametrage.add(btnNewButton);
		
				
		
				
				///////////////////////////////  Fenetre d'acceuil  /////////////////////////////////////
				
				Acceuil = new JPanel();
				contentPane.add(Acceuil, "Acceuil");
				Acceuil.setLayout(null);
				
				JButton jouer = new JButton("Jouer");
				jouer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						Acceuil.setVisible(false);
						FPP.setVisible(true);
					}
				});
				jouer.setBounds(344, 181, 174, 75);
				Acceuil.add(jouer);
				
				JButton parametrer = new JButton("Parametre");
				parametrer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						Acceuil.setVisible(false);
						Parametrage.setVisible(false);
						
						
					}
				});
				parametrer.setBounds(350, 284, 168, 75);
				Acceuil.add(parametrer);
		
		
		
		
		////////////////////////////  Fenetre de Jeu  /////////////////////
		
		this.FPP = new JPanel();
		contentPane.add(FPP, "Table");
		FPP.setLayout(new BorderLayout(0, 0));
		FPP.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		FPP.setBounds(3, 6, this.getHeight(), this.getWidth());
				FPP.setLayout(new BorderLayout(0, 0));
				
				JPanel ButtonPanel = new JPanel();
				FPP.add(ButtonPanel, BorderLayout.SOUTH);
				ButtonPanel.setLayout(new GridLayout(0, 5, 0, 0));
				//Boutton Miser	
				
				this.BtnMiser = new Boutton("Miser",writer);
				ButtonPanel.add(BtnMiser);
				BtnMiser.act(BtnMiser.getName(), partie.getTourDe(),
						SpinnerMise  );
				
		//Boutton Spinner
				
				this.spinner = new JSpinner();
				spinner.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						
						SpinnerMise = Integer.parseInt(spinner.getValue().toString());
						
					}
				});
				ButtonPanel.add(spinner);
				
		//Boutton Suivre		
				
				this.btnSuivre = new Boutton("Suivre", writer);
				ButtonPanel.add(btnSuivre);
				btnSuivre.act(btnSuivre.getName(), partie.getTourDe(),
						0  );
				
		//Boutton Passer
				
				this.btnPasser = new Boutton("Passer", writer);
				ButtonPanel.add(btnPasser);
				btnPasser.act(btnPasser.getName(), partie.getTourDe(),
						0  );
				
		//Boutton Parole		
				
				this.btnParole = new Boutton("Parole", writer);
				
				ButtonPanel.add(btnParole);
				
				CardPanel = new TablePanel();
				FPP.add(CardPanel, BorderLayout.CENTER);
				CardPanel.setLayout(null);
				
				
				river = new Carteimg(false , CLP , CHP);
				river.setBounds(514, 215, CLP, CHP);
				CardPanel.add(river);
				
				turn = new Carteimg(false, CLP , CHP);
				turn.setBounds(465, 215, CLP, CHP);
				CardPanel.add(turn);
				
				flop3 = new Carteimg(false , CLP , CHP);
				flop3.setBounds(416, 215, CLP, CHP);
				CardPanel.add(flop3);
				
				flop2 = new Carteimg(false, CLP , CHP);
				flop2.setBounds(367, 215, CLP, CHP);
				CardPanel.add(flop2);
				
				
				flop1 = new Carteimg(false , CLP , CHP);
				
				flop1.setBounds(318, 215, CLP, CHP);
				CardPanel.add(flop1);
				
				carteAdversaire1 = new Carteimg(false , CLG , CHG);
				CardPanel.add(carteAdversaire1);
				carteAdversaire1.setBounds(387, 12, CLG, CHG);
			
				
				carteAdversaire2 = new Carteimg(false , CLG ,CHG);
				carteAdversaire2.setBounds(455, 12, CLG, CHG);
				CardPanel.add(carteAdversaire2);
				
				carte1 = new Carteimg(false , CLG, CHG);
				carte1.setBounds(387, 371, CLG, CHG);
				CardPanel.add(carte1);
				
				carte2 = new Carteimg(false , CLG , CHG);
				carte2.setBounds(455, 371, CLG, CHG);
				CardPanel.add(carte2);
				
				Pot = new MisePanel(15);
				Pot.setBounds(606, 227, 92, 35);
				CardPanel.add(Pot);
				
				
				mise = new MisePanel(15);
				mise.setBounds(416, 324, 92, 35);
				CardPanel.add(mise);
				
				
				miseAdversaire = new MisePanel(20);
				miseAdversaire.setBounds(410, 132, 92, 35);
				CardPanel.add(miseAdversaire);		
				
				JButton btnQuitter = new JButton("Quitter");
				
				btnQuitter.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						
						FPP.setVisible(false);
						Acceuil.setVisible(true);
					}
				});
				btnQuitter.setBounds(12, 12, 117, 25);
				CardPanel.add(btnQuitter);
				
		
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



	public int getMiseAdversaire() {
		return miseAdversaire.getValeur();
	}
	
	
	public static void main(String[] args) {
		
		new FP();

	}
}
