package IHM;

import java.awt.Image;
import java.io.IOException;
import java.awt.Graphics;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TablePanel extends JPanel {

	private static final long serialVersionUID = 168155420156856L;
	
	private Image image;
	
	public TablePanel(){
		
		super();
		
		super.setBounds(0, 0, 885, 508);
	
	}
	
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
