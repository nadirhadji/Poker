package IHM;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Modele.Carte;

public class Carteimg extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	private Carte carte;
	private boolean afficher;

	public Carteimg(boolean afficher , int width , int height) 
	{
		super();
		this.afficher = afficher;
		setCarte(carte , width , height);
		
	}
	
	public Carteimg(Carte carte , boolean afficher, int width , int height) 
	{
		super();
		this.afficher = afficher;
		setCarte(carte , width , height);
	}

	private void setCarte(Carte carte , int width , int height )
	{
		
		this.carte = carte;
	
		this.setIcon(null);
	
		Image img = null;
		
		if (this.afficher == false )
		{
			
			try {
				img = ImageIO.read(new File("Image/verso.png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			Image img2 = redimensionner(img , width , height);
			
			ImageIcon image2 = new ImageIcon(img2);
			
			setIcon(image2);
			
		}
		else
		{
			try {
				img = ImageIO.read(new File("Image/"+carte.getValeur()+"_"+carte.getCouleur().toLowerCase()+".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
			
			Image img2 = redimensionner(img , width , height);
			
			ImageIcon image2 = new ImageIcon(img2);
			
			setIcon(image2);
		
			
		}
		
	}
	
	public Carte getCarte() 
	{
		return carte;
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
	
	public boolean isAfficher() 
	{
		return afficher;
	}

	public void setAfficher(boolean afficher) 
	{
		this.afficher = afficher;
	}
	
	
}


























