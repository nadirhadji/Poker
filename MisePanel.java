package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class MisePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int valeur ;
	private Image img;
	
	public MisePanel(int valeur)
	{
		super();
		
		this.setLayout(null);
		
		this.setBackground(new Color(0, 128, 0));
		
		this.valeur = valeur;
		
		try
		{
			this.img = ImageIO.read(new File("Image/Governor-Of-Poker-icon.png"));
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public void paintComponent(Graphics g){
		if(valeur>0){
			g.drawImage(img, 0, 0, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString(""+valeur, 25,20);
		}
		else if (valeur==0){
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString("0", 0, 35);
		}
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	

	
	
	
	
	
	
}
