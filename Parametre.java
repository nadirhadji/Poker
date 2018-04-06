package IHM;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class Parametre extends JPanel {

	JLabel NomJoueur1;
	JLabel NomJoueur2;
	JLabel SoldeJ1;
	JLabel SoldeJ2;
	JTextField nom1;
	JTextField nom2;
	JSpinner spinner_1;
	JSpinner spinner_2;
	JButton OK;
	
	public Parametre() {
		
		this.setLayout(null);
		
		NomJoueur1 = new JLabel("Nom Joueur 1");
		NomJoueur1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		NomJoueur1.setBounds(218, 113, 156, 52);
		this.add(NomJoueur1);
		
		NomJoueur2 = new JLabel("Nom Joueur 2");
		NomJoueur2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		NomJoueur2.setBounds(218, 177, 156, 52);
		this.add(NomJoueur2);
		
		SoldeJ1 = new JLabel("Solde Joueur 1");
		SoldeJ1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		SoldeJ1.setBounds(218, 241, 156, 52);
		this.add(SoldeJ1);
		
		SoldeJ2 = new JLabel("Solde Joueur 2");
		SoldeJ2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		SoldeJ2.setBounds(218, 305, 156, 52);
		this.add(SoldeJ2);
		
		nom1 = new JTextField();
		nom1.setBounds(433, 119, 156, 41);
		this.add(nom1);
		nom1.setColumns(10);
		
		nom2 = new JTextField();
		nom2.setColumns(10);
		nom2.setBounds(433, 174, 156, 41);
		this.add(nom2);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(433, 251, 156, 34);
		this.add(spinner_1);
		
		spinner_2 = new JSpinner();
		spinner_2.setBounds(433, 315, 156, 34);
		this.add(spinner_2);
		
		OK = new JButton("OK");
		
		OK.setBounds(328, 402, 150, 52);
		this.add(OK);

	}
	
	
	public void actionOK(JPanel acceuil , Parametre parametre)
	{
		OK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			parametre.setVisible(false);
			acceuil.setVisible(true);
			
			}
			});
			
	}

}
