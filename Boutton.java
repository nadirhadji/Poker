package IHM;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Boutton extends JButton {

	private static final long serialVersionUID = 1L;
	
	public Boutton(String x)
	{
		super();
		
		this.setText(x);
		
		setBackground(new Color(242, 1, 46));
		
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
	
	
	
