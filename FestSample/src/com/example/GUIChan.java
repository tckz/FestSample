package com.example;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class GUIChan extends JFrame implements ActionListener  {
	JButton button = new JButton("push me");
	String message = "yo";

	GUIChan(String[] args) {
		this.setBounds(100, 100, 300, 250);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("GUIChan");

		this.button.setName("pushbutton");
		if (args.length > 0) {
			this.message = args[0];
		}

		Container pane = getContentPane();
		pane.add(this.button);
		this.button.addActionListener(this);
	}

	/**
	 * @param args
	 */
	public static void main(final String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				GUIChan f = new GUIChan(args);
				f.setVisible(true);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.button) {
			JOptionPane.showMessageDialog(this, message);
		}
	}

}
