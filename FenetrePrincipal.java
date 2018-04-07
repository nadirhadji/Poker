package IHM;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.MatteBorder;

import Modele.Carte;
import Modele.Couleur;
import Modele.Partie;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.CardLayout;
import javax.swing.JTable;
import javax.swing.JList;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;

import java.net.Socket;
import java.net.SocketAddress;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.InetSocketAddress;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class FenetrePrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private Partie partie;
	private JPanel TableImg;
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
	private Socket	client;
	private SocketAddress serverSockAddress;
	private InetAddress serverIPAddress;
	private int serverPort = 10000;
	private String hostName = "127.0.0.1";
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	// ajouter un attribut socket
	
	// LArgeur des petite cartes
	private static final int CLP=49;
	// Hauteur des petites cartes
	private static final int CHP=68;
	//Largeur des Grandes cartes
	private static final int CLG=68;
	//Hauteur des grandes cartes
	private static final int CHG=108;

	
	
	
	public FenetrePrincipal() {
		// constructeur, créer le socket ici
		// on ouvre le canal de communication
		
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
		
		getContentPane().setBounds(new Rectangle(0, 0, 0, 0));
		
		getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		setType(Type.UTILITY);
		
		this.setBounds(100, 100, 900, 600);
		
		this.setTitle("Poker");
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		 
		getContentPane().setLayout(null);
		
		//	Fond d'ecran de la table. ( Panel Principal 
		JPanel Conteneur = new JPanel();
		
		
		
			
		
		
		
		this.TableImg = new JPanel();
		
		
		TableImg.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		
		TableImg.setBounds(3, 6, this.getHeight(), this.getWidth());
				TableImg.setLayout(new BorderLayout(0, 0));
				
				JPanel ButtonPanel = new JPanel();
				TableImg.add(ButtonPanel, BorderLayout.SOUTH);
				ButtonPanel.setLayout(new GridLayout(0, 5, 0, 0));
			
		
		//Boutton Miser	
		
				this.BtnMiser = new Boutton("Miser", writer);
				ButtonPanel.add(BtnMiser);
				BtnMiser.act(BtnMiser.getName(), partie.getTourDe(),
						Integer.parseInt(spinner.getValue().toString())  );
				
				
				
		//Boutton Spinner
				
				SpinnerModel valeur = new SpinnerNumberModel(10,10,1000,1); 
				spinner = new JSpinner(valeur);
				ButtonPanel.add(spinner);
				
		
				
		//Boutton Suivre		
				
				this.btnSuivre = new Boutton("Suivre", writer);
				ButtonPanel.add(btnSuivre);
				btnSuivre.act(btnSuivre.getName(), partie.getTourDe(), 0);
				
		//Boutton Passer
				
				this.btnPasser = new Boutton("Passer", writer);
				ButtonPanel.add(btnPasser);
				btnPasser.act(btnPasser.getName(), partie.getTourDe(), 0);
				
		//Boutton Parole		
				
				this.btnParole = new Boutton("Parole", writer);
				ButtonPanel.add(btnParole);
				btnParole.act(btnParole.getName(), partie.getTourDe(), 0);
				
				CardPanel = new TablePanel();
				TableImg.add(CardPanel, BorderLayout.CENTER);
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
			
				
				carteAdversaire2 = new Carteimg(false , CLG ,CHG );
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
				
				Boutton btnFermer = new Boutton("Fermer",writer);
				btnFermer.setBounds(12, 12, 117, 25);
				CardPanel.add(btnFermer);

		
		this.setContentPane(TableImg);   
		
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
	
	new FenetrePrincipal();

}}