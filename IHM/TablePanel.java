package IHM;

import java.awt.Image;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 
 * <p>Sert à afficher l'image de la table<p>
 * <p>Hérite de JPanel </p>
 * @see JPanel
 *
 */
public class TablePanel extends JPanel {

	private static final long serialVersionUID = 168155420156856L;
	/**
	 * <p>image est une image de fond</p>
	 */
	private Image image;
	/**
	 * <p>Appelle le super constructeur<p>
	 */
	public TablePanel(){
		
		super();
		
		super.setBounds(0, 0, 885, 508);
	
	}
	/**
	 * <p>Initialise l'image et l'affiche</p>
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		try
		{
			this.image = ImageIO.read(new File("Image/table.png"));
			g.drawImage(image, 0, 0, this);
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
}
