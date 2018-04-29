package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Modele.Partie;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * <p>Sert à afficher un menu parametre<br>
 * Hérite de JPanel<br> </p>
 
  * <p> NomJoueur1 : sert à afficher le nom du joueur 1 <br>
	 * NomJoueur2 : sert à afficher le nom du joueur 2 <br>
	 * SoldeJ1 : sert à afficher le solde du joueur 1 <br>	 
	 * SoldeJ2 : sert à afficher le solde du joueur 2 <br>
	 * nom1 : sert à mettre à jour le nom du joueur 1<br>
	 * nom2 : sert à mettre à jour le nom du joueur 2<br>
	 * spinner_1 : sert à mettre à jour le solde du joueur 1<br>
	 * spinner_2 : sert à mettre à jour le solde du joueur 2 <br>
	 * SpinnerSolde1 : initialise la valeure du solde du joueur 1 à 5000<br>
	 * SpinnerSolde2 : initialise la valeure du solde du joueur 2 à 5000<br>
	 * OK  : sert au déclenchement des MouseEvent<br>
	 * partie : sert à mettre à jour la partie </p>
	 * @see Partie
	 * @see NamePanel
	 * @see JTextField
	 * @see JSpinner
	 * @see JButton
	 * @see JPanel
 *
 */

public class Parametre extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	
	 */

	NamePanel NomJoueur1;
	NamePanel NomJoueur2;
	NamePanel SoldeJ1;
	NamePanel SoldeJ2;
	JTextField nom1;
	JTextField nom2;
	JSpinner spinner_1;
	JSpinner spinner_2;
	String Joueur1 = "Joueur 1" ;
	String Joueur2 = "Joueur 2"; 		
	int SpinnerSolde1 = 5000;
	int SpinnerSolde2 = 5000;
	static JButton OK;
	Partie partie;
	
	/**
	 * <p>Initialise tous les attributs<br>
	 * Créer les boutons, les mouseEvent et les zones de texte nécessaire au  parametrage de la partie <br>
	 * Affiche les JPanel nécessaires</p>
	 * 
	 */
	
	public Parametre() 
	
	{
		
		this.setLayout(null);
		
		NomJoueur1 = new NamePanel("Nom joueur 1");
		NomJoueur1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		NomJoueur1.setFont(new Font("Arial", Font.BOLD, 20));
		NomJoueur1.setBounds(218, 113, 156, 52);
		this.add(NomJoueur1);
		
		NomJoueur2 = new NamePanel("Nom Joueur 2");
		NomJoueur2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		NomJoueur2.setFont(new Font("Arial", Font.BOLD, 20));
		NomJoueur2.setBounds(218, 177, 156, 52);
		this.add(NomJoueur2);
		
		SoldeJ1 = new NamePanel("Solde Joueur 1");
		SoldeJ1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		SoldeJ1.setFont(new Font("Arial", Font.BOLD, 20));
		SoldeJ1.setBounds(218, 241, 156, 52);
		this.add(SoldeJ1);
		
		SoldeJ2 = new NamePanel("Solde Joueur 2");
		SoldeJ2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		SoldeJ2.setFont(new Font("Arial", Font.BOLD, 20));
		SoldeJ2.setBounds(218, 305, 156, 52);
		this.add(SoldeJ2);
		
		
		//////////////////////////// Zone de texte associé au nom du joueur 1   ////////////////////////////////////

		
		nom1 = new JTextField();
		
		nom1.getDocument().addDocumentListener(new DocumentListener(){

			
			public void insertUpdate(DocumentEvent e) {
				
				Joueur1 = nom1.getText();
				System.out.println(Joueur1);
			
			}

			
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			public void changedUpdate(DocumentEvent e) {
				
				
			}
			
				});
		
		//NomJoueur1.setLabelFor(nom1);
		nom1.setBounds(433, 119, 156, 41);
		this.add(nom1);
		nom1.setColumns(10);
		
		//////////////////////////// Zone de texte associé au nom du joueur 2   ////////////////////////////////////

		
		nom2 = new JTextField();
		

		nom2.getDocument().addDocumentListener(new DocumentListener(){

			
			public void insertUpdate(DocumentEvent e) {
				Joueur2 = nom2.getText();
				System.out.println(Joueur2);

			}

			
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			
			public void changedUpdate(DocumentEvent e) {
				
				
			}
			
				});
		
		
		nom2.setColumns(10);
		nom2.setBounds(433, 174, 156, 41);
		this.add(nom2);
		
		//////////////////////////// Spinner servant a recuper Le solde du joueur 2 ////////////////////////////////////
		
		spinner_1 = new JSpinner();
		
		this.spinner_1 = new JSpinner();
		
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				SpinnerSolde1 = Integer.parseInt(spinner_1.getValue().toString());
				System.out.println(SpinnerSolde1);
				
			}
		});
		
		spinner_1.setBounds(433, 251, 156, 34);
		this.add(spinner_1);
		
		
		//////////////////////////// Spinner servant a recuper Le solde du joueur 2 ////////////////////////////////////
		
		spinner_2 = new JSpinner();
		
		this.spinner_2 = new JSpinner();
		
		
		
		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				SpinnerSolde2 = Integer.parseInt(spinner_2.getValue().toString());
				System.out.println(SpinnerSolde2);

			
			}
		});
		
		spinner_2.setBounds(433, 315, 156, 34);
		this.add(spinner_2);
		
		////////////////////////////////////// Boutton de Validation ////////////////////////////////////////////////////
		
		
		OK = new JButton("OK");
		
		OK.setBounds(328, 402, 150, 52);
		this.add(OK);

	}
	
		
	/**
	 * <p>Créer un MouseEvent permetant le retour à l'écran d'accueil
	 * @param acceuil écran affiché
	 * @param parametre écran fermé
	 */
	public static void actionOK(final JPanel acceuil ,final Parametre parametre)
	{
		OK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			parametre.setVisible(false);
			acceuil.setVisible(true);
			
			}
			});
			
	}
	
	/**
	 * <p>Redimensionne un image</p>
	 * @param image : image à redimensionner
	 * @param width : longueur de l'image voulue
	 * @param height : hauteur de l'image voulue
	 * @return L'image aux dimentions souhaitées
	 */
	
	public Image redimensionner(Image image , int width , int height)
	{
	  BufferedImage	img = new BufferedImage(width , height , BufferedImage.TYPE_INT_ARGB);
	  Graphics2D graphic = (Graphics2D) img.getGraphics();
	  graphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	  graphic.drawImage(image ,0,0,width,height,null);
	  graphic.dispose();
	  
	  return img;
	
	}
	/*
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		try
		{
			this.image = ImageIO.read(new File("Image/parametre.jpg"));
	        image = this.redimensionner(image, this.getWidth(), this.getHeight());
			g.drawImage(image, 0, 0, this);
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	*/
	
	/**
	 * 
	 * @return le premier spinnerSolde 
	 */
	
	public int getSolde1()
	{
		return SpinnerSolde1; 
	}
	
	/**
	 * 
	 * @return le deuxième SpinnerSolde
	 */
	
	public int getSolde2()
	{
		return SpinnerSolde2;
	}
	
	/**
	 * 
	 * @return le Joueur 1
	 */
	
	public String getName1()
	{
		return Joueur1;
	}
	
	/**
	 * 
	 * @return le joueur 2
	 */
	
	public String getName2()
	{
		return Joueur2;
	}
	
	/**
	 * <p>Mets à jour la partie
	 * @param partie : nouvel état de la partie
	 */
	
	public void setPartie(Partie partie)
	{
		this.partie = partie;
	}
	
	
	
	
	
	

}
