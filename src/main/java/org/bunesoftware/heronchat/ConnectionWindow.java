package org.bunesoftware.heronchat;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectionWindow {

    public ConnectionWindow() {
        initialize();
    }

    private void initialize() {
        JFrame frmConSet = new JFrame();
        frmConSet.setResizable(false);
        frmConSet.setTitle("HeronChat");
        frmConSet.setBounds(100, 100, 268, 109);
        frmConSet.getContentPane().setLayout(null);

        JTextField ipField = new JTextField();
        ipField.setBounds(10, 11, 127, 20);
        frmConSet.getContentPane().add(ipField);
        ipField.setColumns(10);

        JButton connectBtn = new JButton("Connect");
        connectBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                if (isRegexValid(ipField.getText())) {
                    //todo:functionality
                } else {
                    ipField.setText("Input valid IP");
                }
            }
        });
        connectBtn.setBounds(147, 10, 89, 23);
        frmConSet.getContentPane().add(connectBtn);

        JTextField nameField = new JTextField();
        nameField.setBounds(10, 42, 127, 20);
        frmConSet.getContentPane().add(nameField);
        nameField.setColumns(10);

        JButton setNameBtn = new JButton("Set Name");
        setNameBtn.setBounds(147, 41, 89, 23);
        frmConSet.getContentPane().add(setNameBtn);
        frmConSet.setVisible(true);
    }

    private boolean isRegexValid(String ip) {
        return ip.matches(Utils.IP_REGEX);
    }
}