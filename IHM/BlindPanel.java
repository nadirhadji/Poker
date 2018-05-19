package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import Modele.Partie;

public class BlindPanel extends JLabel{

	private static final long serialVersionUID = 1L;

	private String valeur;
	private Image Grosse;
	private Image Petite;
	
	public BlindPanel(String valeur )
	{
		super();
		
		this.setLayout(null);
		
		this.valeur = valeur;
		
		if (valeur == "Grande Blinde") {
		
		try
		{
			this.Grosse = ImageIO.read(new File("Image/poker-token.png"));
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		}
		
		else if (valeur == "Petite Blinde")	
		{
			try
			{
				this.Petite = ImageIO.read(new File("Image/casino-chip.png"));
			}
			catch(IOException e) 
			{
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
				
		if(valeur == "Grande Blinde"){
			g.setColor(Color.WHITE);
			g.setFont(new Font("MS Gothic", Font.BOLD, 15));
			g.drawString("Grande Blinde",0,20);
			g.drawImage(Grosse, 115, 0, null);
		}
		else if (valeur=="Petite Blinde"){
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("MS Gothic", Font.BOLD, 15));
			g.drawString("Petite Blinde",0,20);
			g.drawImage(Petite, 100, 0, null);
		}
	}


	public void setValeur(String valeur) {
		this.valeur = valeur;
		repaint();
	}
 

}
