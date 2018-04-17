package IHM;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Modele.Partie;
import java.io.IOException;
import java.awt.event.MouseListener.*;

import Modele.ActionUtilisateur;
import Modele.Joueur;
import Modele.Message;

import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Boutton extends JButton {

	private static final long serialVersionUID = 1L;
	private Joueur j;
	private int mise;
	private String nom;
	private Partie partie;
	//private Message message;
	private ActionUtilisateur action;
	
	public Boutton(String x, int mise , Partie partie)
	{
		super();
		this.mise = mise;
		this.partie = partie;
		
		this.setText(x);
		
		this.action = conversion(nom);
		
		setBackground(new Color(242, 1, 46));
	}
		
	
	public void act(final Joueur j)
	{
	
		this.addMouseListener(new MouseAdapter() {
			
			public void mouseEntered(MouseEvent e) {
				if(isEnabled()){
					

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
				
				// envoie le message
				// generer le msg en fonction des attributs
				// recuperer la valeur du spiner pour miser
				if(isEnabled()){
					
					
				setBackground(Color.WHITE);
				System.out.println("ceci est un test");
				
				if(partie.do_action(action, j, mise) )
				
				partie.IA();
				
				System.out.println(partie);
				System.out.println("Bouton push");
					
					
					/*message.setMessage(mise, nom, j);
					System.out.println(mise);
					
					try
					{
						writer.writeObject(message);
						writer.flush();
					}catch(IOException x)
					{
						System.out.println("Erreur lors de l'envoie du message");
					}
					*/
				}
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
			
		

	
	
	
