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

/**
 * <p>Sert à afficher les noms des joueurs, et autres chaine de caractère<br>
 * Hérite de JPanel</p>
 * @see JPanel
 *
 */
public class NamePanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	/**
	 * <p>Valeur est la chaine à afficher</p>
	 */
	private String valeur;
	
	/**
	 * <p>Appelle le super constructeur <br>
	 * Initialise valeur</p>
	 * @param valeur : chaine de caractère à afficher avec et objet
	 */
	public NamePanel(String valeur) {
		
		super();
		
		this.setLayout(null);
		
		//this.setBackground(new Color(0, 0, 0));
		
		this.valeur = valeur;

	}
	
	/**
	 * <p>Affiche la chaine de caractère
	 */
	
	public void paintComponent(Graphics g){
			
			super.paintComponent(g);
			
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString(""+valeur, 25,20);
			
	}
	
	/**
	 * <p>Modifie la chaine de caractère et l'affiche
	 * @param name : la nouvelle chaine
	 */
	
	public void setValeur(String name)
	{
		this.valeur = name;
		repaint();
	}
	
	
	
	
	

	
	

}
