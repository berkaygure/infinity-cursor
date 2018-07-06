package com.bgure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    static InfinityCursor infinityCursor;

    public static void setTray()
    {
        if(!SystemTray.isSupported()){
            return ;
        }

        PopupMenu trayPopupMenu = new PopupMenu();
        final MenuItem startStopButton = new MenuItem("Start/Stop : [Started]");
        final MenuItem exitMenuItem = new MenuItem("Exit");

        startStopButton.addActionListener(e -> {
            System.out.println(infinityCursor.isStart());
            if(infinityCursor.isStart()) {
                infinityCursor.setStart(false);
                startStopButton.setLabel("Start/Stop : [Stopped]");
            }else {
                infinityCursor.setStart(true);
                startStopButton.setLabel("Start/Stop : [Started]");
            }

        });

        exitMenuItem.addActionListener(e -> {
            System.out.println("Exiting...");
            System.exit(0);
        });

        trayPopupMenu.add(startStopButton);
        trayPopupMenu.add(exitMenuItem);

        Image imgTrayIcon = Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/images/icon.png"));
        TrayIcon trayIcon = new TrayIcon(imgTrayIcon, "Infinity Cursor", trayPopupMenu);
        trayIcon.setImageAutoSize(true);

        try{
            SystemTray systemTray = SystemTray.getSystemTray();
            systemTray.add(trayIcon);
        }catch(AWTException awtException){
            awtException.printStackTrace();
        }
    }

    public static void main(String[] args) {

        infinityCursor = new InfinityCursor();
        setTray();
        infinityCursor.run();

    }
}
