package org.bunesoftware.heronchat.gui;

import org.bunesoftware.heronchat.Utils;
import org.bunesoftware.heronchat.functionality.CredentialsProcessing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionWindow {
	
	private JFrame frmConSet;
	private CredentialsProcessing credentialsProcessing;

    public ConnectionWindow() {
        credentialsProcessing = new CredentialsProcessing();
        initialize();
    }

    private void initialize() {
        frmConSet = new JFrame();
        frmConSet.setResizable(false);
        frmConSet.setTitle("HeronChat");
        frmConSet.setBounds(100, 100, 257, 109);
        frmConSet.getContentPane().setLayout(null);
        frmConSet.setLocationRelativeTo(null);
        frmConSet.setVisible(false);

        JTextField ipField = new JTextField();
        ipField.setBounds(10, 11, 127, 20);
        frmConSet.getContentPane().add(ipField);
        ipField.setColumns(10);
        ipField.setText(credentialsProcessing.getCredentials().getIp());

        JTextField nameField = new JTextField();
        nameField.setBounds(10, 42, 127, 20);
        frmConSet.getContentPane().add(nameField);
        nameField.setColumns(10);
        nameField.setText(credentialsProcessing.getCredentials().getUsername());

        JButton connectBtn = new JButton("Connect");
        connectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String ip = ipField.getText();
                String username = nameField.getText();
                if (isRegexValid(ip) && !username.isEmpty() && username != null) {
                    credentialsProcessing.writeCredentials(ip, username);
                    frmConSet.setVisible(false);
                } else {
                    ipField.setText("Set valid IP");
                }
            }
        });
        connectBtn.setBounds(152, 10, 89, 23);
        frmConSet.getContentPane().add(connectBtn);
    }
    
    public void show() {
    	frmConSet.setVisible(true);
    }

    private boolean isRegexValid(String ip) {
        return ip.matches(Utils.IP_REGEX);
    }
}