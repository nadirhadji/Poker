package IHM;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class NamePanel extends JPanel{

	
	private static final long serialVersionUID = 1L;
	
	private String valeur;
	
	
	public NamePanel(String valeur) {
		
		super();
		
		this.setLayout(null);
		
		this.setBackground(new Color(191, 209, 229));
		
		this.valeur = valeur;
		
		//this.setHorizontalAlignment(SwingConstants.CENTER);
		//this.setHorizontalTextPosition(SwingConstants.CENTER);

	}
	
	public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			Paint paint;
			
			Graphics2D g2d;
			if (g instanceof Graphics2D) {
				g2d = (Graphics2D) g;
			}
			else {
				System.out.println("Error");
				return;
			}
			
			g.setColor(Color.BLACK);
			g.setFont(new Font("Cooper Black", Font.BOLD, 20));
			FontMetrics fm = g2d.getFontMetrics();
			int x = (this.getWidth() - fm.stringWidth(valeur)) / 2;
			int y = (fm.getAscent() + (this.getHeight() -(fm.getAscent() + fm.getDescent())) / 2);
			g2d.drawString(valeur, x, y);
		
			
	}
	
	public void setValeur(String name)
	{
		this.valeur = name;
		repaint();
	}
	
	
	
	
	

	
	

}
