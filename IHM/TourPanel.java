package IHM;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;
/**
 * 
 * <p>Sert à indiquer quel joueur doit jouer <br>
 * Hérite de JPanel</p>
 * @see JPanel
 *
 */
public class TourPanel extends JPanel {

	
	private static final long serialVersionUID = 1L;
	/**
	 * <p>Valeur est une phrase à afficher<br>
	 * Elle vaut toujours "Tour de : "</p> 
	 */
	
	private String valeur; 
	
	/**
	 * <p>Appelle le super constructeur, prépare l'affichage<br>
	 * Initialise valeur<br>
	 * @param valeur chaine de caractère à afficher
	 */
	
	public TourPanel(String valeur) {
		
		super();
		
		this.setLayout(null);
		
		this.setBackground(new Color(0, 128, 0));
		
		this.valeur = valeur;

	}
	/**
	 * <p>Affiche valeur<p>
	 */
	
	public void paintComponent(Graphics g){
		
			super.paintComponent(g);
			g.setColor(Color.WHITE);
			g.setFont(new Font("Arial", Font.BOLD, 20));
			g.drawString(""+valeur, 25,20);
		
	}
	
	/**
	 * <p>Modifie la chaine de caractère</p>
	 * @param : valeur nouvelle valeur de la chaine
	 */
	
	public void setValeur(String valeur)
	{
		this.valeur = valeur;
		repaint();
	}

}