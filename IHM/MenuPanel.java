package IHM;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * <p>Affiche le menu<br>
 * Hérite de JPanel</p>
 * @see JPanel
 *
 */
public class MenuPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	/**
	 * <p>Image est une image de fond </p>
	 */
	private Image image;
	
	/**
	 * <p>Appelle le super constructeur<p>
	 */
	
	public MenuPanel() {
		
		super();
		
		this.setLayout(null);

	}
	
	/**
	 * <p>Initialise image<br>
	 * Affiche l'image</p>
	 */
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		try
		{
			this.image = ImageIO.read(new File("Image/carte.png"));
			g.drawImage(image, 0, 0, this);
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}

}
