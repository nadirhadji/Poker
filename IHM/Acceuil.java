package IHM;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.Partie;

public class Acceuil extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Image image;
	private JButton jouer;
	private JButton parametrer;
	private JButton continuer;
	
	public Acceuil() 
	{
		
		super();
		
		this.setLayout(null);
		
		continuer = new JButton("Continuer partie");
		
		continuer.setBounds(344, 90, 174, 75);
		this.add(continuer);
		
		
		jouer = new JButton("Jouer");
		
		jouer.setBounds(344, 181, 174, 75);
		this.add(jouer);
		
		parametrer = new JButton("Parametre");
		
		parametrer.setBounds(350, 284, 168, 75);
		this.add(parametrer);

	}
	
	public Image redimensionner(Image image , int width , int height)
	{
	  BufferedImage	img = new BufferedImage(width , height , BufferedImage.TYPE_INT_ARGB);
	  Graphics2D graphic = (Graphics2D) img.getGraphics();
	  graphic.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	  graphic.drawImage(image ,0,0,width,height,null);
	  graphic.dispose();
	  
	  return img;
	
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		try
		{
			
			this.image = ImageIO.read(new File("Image/background2.jpg"));
	        image = this.redimensionner(image, this.getWidth(), this.getHeight());
			g.drawImage(image, 0, 0, this);
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	
	public void actionJouer(final  Acceuil acceuil , final JPanel jeu )
	{
		jouer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
			acceuil.setVisible(false);
			jeu.setVisible(true);
			
			}
			});
		
		
	}
	
	public void actionJouer( final  Acceuil acceuil , final Parametre parametre )
	{
		parametrer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			acceuil.setVisible(false);
			parametre.setVisible(true);
			
			}
			});
			
	}
	
	public JButton getContinuer()
	{
		return continuer;
	}
	
	public JButton getButton()
	{
		return jouer;
	}
	
}
