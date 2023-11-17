import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Menu extends JFrame implements ActionListener{
    JButton buttonMenuLogin, buttonListGame, buttonTransaction;
    // JFrame frame;
    
	JLabel label;

    public Menu(){        						
		label = new JLabel();		
		label.setBounds(150, 250, 150, 150);
		label.setVisible(false);

		// Menu Login
		buttonMenuLogin = new JButton();
		buttonMenuLogin.setBounds(30, 100, 200, 50);
		buttonMenuLogin.addActionListener(this);
		buttonMenuLogin.setText("Menu Login");
		
		buttonMenuLogin.setFocusable(false);		
		buttonMenuLogin.setHorizontalTextPosition(JButton.CENTER);
		buttonMenuLogin.setVerticalTextPosition(JButton.BOTTOM);
		buttonMenuLogin.setFont(new Font("Comic Sans",Font.BOLD,10));
		buttonMenuLogin.setIconTextGap(-15);
		
        // Menu List Game
        buttonListGame = new JButton();
		buttonListGame.setBounds(30, 200, 200, 50);
		buttonListGame.addActionListener(this);
		buttonListGame.setText("Menu List Game");
		
		buttonListGame.setFocusable(false);		
		buttonListGame.setHorizontalTextPosition(JButton.CENTER);
		buttonListGame.setVerticalTextPosition(JButton.BOTTOM);
		buttonListGame.setFont(new Font("Comic Sans",Font.BOLD,10));
		buttonListGame.setIconTextGap(-15);
		
        // Menu Transaction        
        buttonTransaction = new JButton();
		buttonTransaction.setBounds(30, 300, 200, 50);
		buttonTransaction.addActionListener(this);
		buttonTransaction.setText("Menu Transaction");
		
		buttonTransaction.setFocusable(false);		
		buttonTransaction.setHorizontalTextPosition(JButton.CENTER);
		buttonTransaction.setVerticalTextPosition(JButton.BOTTOM);
		buttonTransaction.setFont(new Font("Comic Sans",Font.BOLD,10));
		buttonTransaction.setIconTextGap(-15);
		
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);
		this.setVisible(true);
		this.add(buttonMenuLogin);
        this.add(buttonListGame);
        this.add(buttonTransaction);
		this.add(label);
        
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonMenuLogin) {
			this.dispose();
            new MenuLogin();
		} else if(e.getSource()==buttonListGame) {
			this.dispose();
            new MenuListGame();
		} else if (e.getSource()==buttonTransaction) {
			this.dispose();
            new MenuTransaction();
		}
	}    
}
