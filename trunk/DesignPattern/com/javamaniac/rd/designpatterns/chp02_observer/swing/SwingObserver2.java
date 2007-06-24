package com.javamaniac.rd.designpatterns.chp02_observer.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SwingObserver2 extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;

	private JButton quit = null;

	/**
	 * This method initializes quit	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getQuit() {
		if (quit == null) {
			quit = new JButton("Quitter");
			quit.setEnabled(false);
			quit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Bye!"); // TODO Auto-generated Event stub actionPerformed()
					System.exit(0);
				}
			});
		}
		return quit;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SwingObserver2 thisClass = new SwingObserver2();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public SwingObserver2() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Title");
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosing(java.awt.event.WindowEvent e) {
				System.out.println("windowClosing()"); // TODO Auto-generated Event stub windowClosing()
			}
		});
		
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		JButton button = new JButton("Devrais-je?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		button.addMouseListener(new java.awt.event.MouseListener() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				System.out.println("mouseEntered()"); // TODO Auto-generated Event stub mouseEntered()
			}
			public void mouseClicked(java.awt.event.MouseEvent e) {
				quit.setEnabled(true);
			}
			public void mousePressed(java.awt.event.MouseEvent e) {
			}
			public void mouseReleased(java.awt.event.MouseEvent e) {
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
			}
		});
		
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(button, BorderLayout.CENTER);
			jContentPane.add(getQuit(), BorderLayout.WEST);
		}
		return jContentPane;
	}

	
	class AngelListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Non, tu vas le regreter!");
		}
	}

	class DevilListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.out.println("Oui fais-le!");
		}
	}	
}
