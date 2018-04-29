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
/**
 *
 * <p>Accueil est une classe permettant d'aficher une fenetre d'accueil dans le cadre de l'interface graphique <b>
 * Elle herite de JPanel </p>
 * @see IHM
 * @see JPanel
 *
 */
public class Acceuil extends JPanel {

	private static final long serialVersionUID = 1L;
	
	/**
	 * image de fond 
	 */
	
	private Image image;
	/**
	 * bouton "jouer"
	 */
	private JButton jouer;
	
	/**
	  *bouton "parametrer"
	 */
	private JButton parametrer;
	/**
	 *  bouton "continuer" 
	 */
	private JButton continuer;
	/**
	 * <p>Ce constructeur appelle son super constructeur <br>
	 * Il initialise les boutons, leur donne leur taille et leur nom </p>
	 * 
	 */
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
	
	/**
	 * 
	 * @param image  l'image a redimentionner
	 * @param width  la largeure de l'image voulue
	 * @param height la hauteur de l'image voulue
	 * @return l'image passée en paramètre, redimmentionnée à la taille voulue
	 */
	
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
	
	/**
	 * <p> Créer un mouseEvent qui permet de passe d'un JPanel à l'autre <p>
	 * @param acceuil  premier JPanel, celui dans lequel on se trouve au moment du clique
	 * @param jeu		deuxième JPanel, celui qui apparait après le clique
	 */
	
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
	
	/**
	 * <p> Créer un mouseEvent qui permet de passe d'un JPanel à l'autre <p>
	 * @param acceuil  premier JPanel, celui dans lequel on se trouve au moment du clique
	 * @param parametre		deuxième JPanel, celui qui apparait après le clique
	 */
	
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
	
	/**
	 * 
	 * @return le bouton continuer
	 */
	
	public JButton getContinuer()
	{
		return continuer;
	}
	/**
	 * 
	 * @return le bouton jouer
	 */
	public JButton getButton()
	{
		return jouer;
	}
	
}
