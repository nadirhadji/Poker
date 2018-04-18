package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

public class TourPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	private String valeur; 
	
	public TourPanel(String valeur) {
		
		super();
		
		this.setLayout(null);
		
		this.setBackground(new Color(0, 128, 0));
		
		this.valeur = valeur;

	}
	
	public void paintComponent(Graphics g){
		
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString(""+valeur, 25,20);
		
	}
	
	public void setValeur(String valeur)
	{
		this.valeur = valeur;
		repaint();
	}

}