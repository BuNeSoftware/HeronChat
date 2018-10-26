package org.bunesoftware.heronchat;

import org.bunesoftware.heronchat.gui.ChatWindow;

public class Main {

    public static void main(String[] args) {
        if (args.length > 0 && args[0].contains("--nogui") ) {
            System.out.println("Started Heron in no-gui mode");
        } else {
            System.out.println("Started Heron in gui mode");
            new ChatWindow();
        }
    }
}
