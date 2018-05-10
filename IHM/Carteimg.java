package IHM;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Modele.ActionUtilisateur;
import Modele.Carte;

public class Carteimg extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	private Carte carte;

	
	public Carteimg(Carte carte , int width , int height) 
	{
		super();
		
	}

	public void setCarteTable(Carte carte , int width , int height )
	{
		
		this.carte = carte;
	
		this.setIcon(null);
	
		Image img = null;
		
		if  ( (carte.getValeur() > 0 ) || (carte.getValeur() < 14) )
		{
			try {
				img = ImageIO.read(new File("Image/"+carte.getValeur()+"_"+carte.getCouleur().toString().toLowerCase()+".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			Image img2 = redimensionner(img , width , height);
			
			ImageIcon image2 = new ImageIcon(img2);
			
			setIcon(image2);
		
		}
		
	}
	
	public void setCarteFaceCache(Carte carte , int width , int height ) {
		
		this.carte = carte;
		
		this.setIcon(null);
	
		Image img = null;
		
		try {
			img = ImageIO.read(new File("Image/verso.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		Image img2 = redimensionner(img , width , height);
		
		ImageIcon image2 = new ImageIcon(img2);
		
		setIcon(image2);
		
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
	
	public void clikListener(final int  width ,final int height ) {
		
		this.addMouseListener(new MouseAdapter(){

        	public void mousePressed(MouseEvent e) 
			{
        			setCarteTable(carte,width,height);
        			
        			
            }
         	
        	public void mouseReleased(MouseEvent e) 
			{
        			setCarteFaceCache(carte,width,height);
        			
            }
        	

		});

	}
	
	public Carte getCarte() 
	{
		return carte;
	}


}
