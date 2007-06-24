package com.javamaniac.rd.designpatterns.chp02_observer.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserver {

	JFrame frame;
	
	public static void main(String[] args) {
		SwingObserver example = new SwingObserver();
		example.go();
	}

	private void go() {
		frame = new JFrame();
		JButton button = new JButton("Devrais-je?");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.pack();
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
