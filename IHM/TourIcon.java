package IHM;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class TourIcon extends JLabel {

	
	public TourIcon()
	{
		super();
		
		this.setLayout(null);
		
		setIcon(new ImageIcon("Image/play-button.png"));
		
	}
}
