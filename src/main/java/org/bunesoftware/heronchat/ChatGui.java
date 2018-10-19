package org.bunesoftware.heronchat;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatGui {

	public ChatGui() {
		initialize();
	}

	private void initialize() {
		JFrame heronFrame = new JFrame();
		heronFrame.setResizable(false);
		heronFrame.setTitle("HeronChat");
		heronFrame.setBounds(100, 100, 465, 300);
		heronFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		heronFrame.getContentPane().setLayout(null);
		heronFrame.setLocationRelativeTo(null);
		
		TextArea textArea = new TextArea();
		textArea.setEditable(false);
		textArea.setBounds(10, 10, 435, 160);
		heronFrame.getContentPane().add(textArea);
		
		JTextField textField = new JTextField();
		textField.setBounds(10, 176, 321, 20);
		heronFrame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setBounds(335, 175, 110, 23);
		heronFrame.getContentPane().add(btnNewButton);
		
		JButton connectionWindowGui = new JButton("Set Connection");
		connectionWindowGui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new ConnectionWindow();
			}
		});
		connectionWindowGui.setBounds(335, 249, 124, 23);
		heronFrame.getContentPane().add(connectionWindowGui);
		heronFrame.setVisible(true);
	}
}
