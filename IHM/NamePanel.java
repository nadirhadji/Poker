package IHM;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class NamePanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	private String valeur;
	
	
	public NamePanel(String valeur) {
		
		super();
		
		this.setLayout(null);
		
		//this.setBackground(new Color(0, 0, 0));
		
		this.valeur = valeur;

	}
	
	public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString(""+valeur, 25,20);
			
	}
	
	public void setValeur(String name)
	{
		this.valeur = name;
		repaint();
	}
	
	
	
	
	

	
	

}
