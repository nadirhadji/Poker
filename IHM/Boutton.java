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

/**
 * <p>Bouton est une classe permettant de créer les boutons avec lesquel l'utilisateur va pouvoir jouer <br>
 * Elle hérite de JButton</p>
 * @see IHM
 * @see JButton
 */
public class Boutton extends JButton {

	private static final long serialVersionUID = 1L;
	/**
	 * sert à modifier la partie en fonction des actions effectuées 
	 * @see Partie
	 */
	private Partie partie;
	/**
	 * ne sert qu'au bouton miser de l'IHM
	 */
	private int mise;
		
	/**
	 * <p>Initialise les parametres, appelle son super constructeur</p>
	 * @param partie la partie en cours
	 * @param x le nom du bouton
	 * @param mise toujours initalisée à 0 dans l'IHM
	 */
	public Boutton(Partie partie , String x, int mise )
	{
		super();
		this.partie = partie;
		this.mise = mise;
		this.setText(x);
		setBackground(new Color(242, 1, 46));
	}
	/**
	 * <p>Crée une serie de MouseEvent, qui permetttent de moifier la partie </p>
	 * @param j  le Joueur effectuant l'action
	 * @param aa une ActionUtilisateur, unique à chaque bouton, elle définit quelle action effectue le joueur
	 * @param somme  la somme à miser, utile uniquement pour le bouton miser, pour les autres, elle vaut 0
	 * @see ActionUtilisateur
	 * 
	 */
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
	
	/**
	 * <p>Mets a jour la mise </p>
	 * @param mise nouvelle valeure de la mise
	 */
	
	public void setMise(int mise)
	{
		this.mise = mise;
	}
	
	/**
	 * <p>Mets à jour la partie</p>
	 * @param partie nouvel état de la partie
	 */
	
    public void setPartie(Partie partie)
    {
            this.partie = partie;
    }
    /**
     * <p> Convertie une chaine de caractère en ActionUtilisateur
     * @param msg chatine à convertir
     * @return une ActionUtilisateur
     * @see ActionUtilisateur
     */

	public ActionUtilisateur conversion(String msg)
	{

            if (msg == "Miser") return  ActionUtilisateur.MISER;

            if (msg == "Parole") return  ActionUtilisateur.PAROLE;

            if (msg == "Passer") return  ActionUtilisateur.PASSER;

            else return  ActionUtilisateur.SUIVRE;

    }

    /**
     * 
     * @return la partie
     */

    public Partie getPartie()

    {
            return partie;
    }

	
	
	
	
}