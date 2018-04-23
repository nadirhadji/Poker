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
		
	public Boutton(Partie partie , String x, int mise )
	{
		super();
		this.partie = partie;
		this.mise = mise;
		this.setText(x);
		setBackground(new Color(242, 1, 46));
	}
	
	public void act(final Joueur j , final  ActionUtilisateur aa , final int somme)
	{
	
		this.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				if(isEnabled()){
					setBackground(Color.WHITE);
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				if(isEnabled()){
					setBackground(new Color(242, 1, 46));
				}
			}
			
			
			@Override
			public void mouseClicked(MouseEvent e) 
			{
			
				partie.do_action(aa, j, somme);
				
			}
			
			});
		
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