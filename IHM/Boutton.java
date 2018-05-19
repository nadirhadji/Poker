package IHM;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.awt.event.MouseListener.*;

import Modele.ActionUtilisateur;
import Modele.Joueur;
import Modele.Partie;

import javax.swing.JButton;

public class Boutton extends JButton {

	private static final long serialVersionUID = 1L;
	
	private Partie partie;
	private int mise;
	private Color couleurBas = Color.WHITE;
	private Color couleurNormale=Color.BLACK;
	private final Font inactif = new Font("MS Gothic", Font.BOLD, 16);
	private Font font = inactif;
		
	public Boutton(Partie partie , String x, int mise )
	{
		super();
		this.partie = partie;
		this.mise = mise;
		this.setText(x);
		this.setBackground(new Color(191, 209, 229));
	}
	
	public Boutton(String x )
	{
		super();
		this.setText(x);
		this.setBackground(new Color(191, 209, 229));

	}
	
	public void paintComponent(Graphics g){
		Paint paint;
		
		Graphics2D g2d;
		if (g instanceof Graphics2D) {
			g2d = (Graphics2D) g;
		}
		else {
			System.out.println("Error");
			return;
		}
		
		paint = new GradientPaint(0,0, couleurBas, getWidth(), 70, getBackground());
		g2d.setPaint(paint);
		g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
		g2d.setColor(couleurNormale);
		g2d.setStroke(new BasicStroke(1));
		g2d.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
		g.setColor(getForeground());
		g.setFont(font);
		
		FontMetrics fm = g2d.getFontMetrics();
		int x = (this.getWidth() - fm.stringWidth(getText())) / 2;
		int y = (fm.getAscent() + (this.getHeight() -(fm.getAscent() + fm.getDescent())) / 2);
		g2d.drawString(getText(), x, y);
		
	}

	
	public void setMise(int mise)
	{
		this.mise = mise;
	}
	
    public void setPartie(Partie partie)
    {
            this.partie = partie;
    }


	public ActionUtilisateur conversion(String msg)
	{

            if (msg == "Miser") return  ActionUtilisateur.MISER;

            if (msg == "Parole") return  ActionUtilisateur.PAROLE;

            if (msg == "Passer") return  ActionUtilisateur.PASSER;

            else return  ActionUtilisateur.SUIVRE;

    }

    

    public Partie getPartie()

    {
            return partie;
    }

	
	
	
	
}