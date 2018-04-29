package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Sers à afficher la mise <br>
 * Hérite de JPanel
 * @see JPanel
 *
 *
 */
public class MisePanel extends JPanel{

	private static final long serialVersionUID = 1L;

	/**
	 * valeur de la mise
	 */
	private int valeur ;
	/**
	 * image de fond
	 */
	private Image img;
	/**
	 * appelle le super constructeur <br>
	 * initialise valeur
	 * 
	 * @param valeur
	 */
	
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
	
	/**
	 * permet à l'objet de s'afficher
	 */
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
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
	
	/**
	 * 
	 * @return valeur
	 */

	public int getValeur() {
		return valeur;
	}
	/**
	 * Met à jour la valeur
	 * @param valeur : nouvelle valeur
	 */
	public void setValeur(int valeur) {
		this.valeur = valeur;
		repaint();
	}

	

	
	
	
	
	
	
}
