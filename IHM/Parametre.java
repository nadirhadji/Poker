package IHM;

import java.awt.Color;
import java.awt.ComponentOrientation;
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


public class Parametre extends JPanel{

	Image image;
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
	
	public Parametre() 
	
	{
		
		this.setLayout(null);
		
		NomJoueur1 = new NamePanel("Nom joueur 1");
		NomJoueur1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		NomJoueur1.setFont(new Font("Cooper Black", Font.BOLD,20));
		NomJoueur1.setBounds(218, 113, 165, 52);
		this.add(NomJoueur1);
		
		NomJoueur2 = new NamePanel("Nom joueur 2");
		NomJoueur2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		NomJoueur2.setFont(new Font("Cooper Black", Font.BOLD, 20));
		NomJoueur2.setBounds(218, 177, 165, 52);
		this.add(NomJoueur2);
		
		SoldeJ1 = new NamePanel("Solde joueur 1");
		SoldeJ1.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		SoldeJ1.setFont(new Font("Cooper Black", Font.BOLD, 20));
		SoldeJ1.setBounds(218, 241, 165, 52);
		this.add(SoldeJ1);
		
		SoldeJ2 = new NamePanel("Solde joueur 2");
		SoldeJ2.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		SoldeJ2.setFont(new Font("Cooper Black", Font.BOLD, 20));
		SoldeJ2.setBounds(218, 305, 165, 52);
		this.add(SoldeJ2);
		
		
		//////////////////////////// Zone de texte associé au nom du joueur 1   ////////////////////////////////////

		
		nom1 = new JTextField();
		
		nom1.getDocument().addDocumentListener(new DocumentListener(){

			@Override
			public void insertUpdate(DocumentEvent e) {
				
				Joueur1 = nom1.getText();
				System.out.println(Joueur1);
			
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
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

			@Override
			public void insertUpdate(DocumentEvent e) {
				Joueur2 = nom2.getText();
				System.out.println(Joueur2);

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
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
	
		
	
	public static void actionOK(JPanel acceuil , Parametre parametre)
	{
		OK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			parametre.setVisible(false);
			acceuil.setVisible(true);
			
			}
			});
			
	}
	
	public Image redimensionner(Image image , int width , int height)
	{
	  BufferedImage	img = new BufferedImage(width , height , BufferedImage.TYPE_INT_ARGB);
	  Graphics2D graphic = (Graphics2D) img.getGraphics();
	  graphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	  graphic.drawImage(image ,0,0,width,height,null);
	  graphic.dispose();
	  
	  return img;
	
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		try
		{
			this.image = ImageIO.read(new File("Image/parametre1.jpg"));
	        image = this.redimensionner(image, this.getWidth(), this.getHeight());
			g.drawImage(image, 0, 0, this);
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	
	public int getSolde1()
	{
		return SpinnerSolde1; 
	}
	
	public int getSolde2()
	{
		return SpinnerSolde2;
	}
	
	public String getName1()
	{
		return Joueur1;
	}
	
	public String getName2()
	{
		return Joueur2;
	}
	
	public void setPartie(Partie partie)
	{
		this.partie = partie;
	}
	
	
	
	
	
	

}
