package IHM;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.awt.event.MouseListener.*;
import Modele.Joueur;
import Modele.Message;

import javax.swing.JButton;

public class Boutton extends JButton {

	private static final long serialVersionUID = 1L;
	private ObjectOutputStream writer;
	private Message message;
	
	public Boutton(String x, ObjectOutputStream writer)
	{
		super();
		this.writer = writer;
		message = new Message();
		
		this.setText(x);
		
		setBackground(new Color(242, 1, 46));
		}
		
		
	
	
	public void act(final String nom, final Joueur j, final int mise)
	{
	
		
		this.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		}
		
		});
			
			addMouseListener(
					
					new MouseListener() 
				
				{

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub
					// envoie le message
					// generer le msg en fonction des attributs
					// recuperer la valeur du spiner pour miser
					message.setMessage(mise, nom, j);
					System.out.println(mise);
					try
					{
						writer.writeObject(message);
						writer.flush();
					}catch(IOException e)
					{
						System.out.println("Erreur lors de l'envoie du message");
					}
				}

				@Override
				public void mouseExited(MouseEvent e) {
					if(isEnabled()){
						setBackground(new Color(242, 1, 46));
					}

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					if(isEnabled()){
						setBackground(Color.WHITE);
					}
				}

				@Override
				public void mouseClicked(MouseEvent e) {}
			
				}
					);
		}
	}
		
	}
	
	
	
