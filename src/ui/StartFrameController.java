package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import org.xml.sax.SAXException;

import game.HadiCezmi;
import xml.XMLChecker;
import xml.XMLFilter;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class StartFrameController {
    File file;

    public StartFrameController() {
    }

    public void doAction(String action, HadiCezmi hadiCezmi) {
        switch (action) {
            case "Play":
                playGame(hadiCezmi);
                break;
            case "Load":
                loadGame(hadiCezmi);
                break;
            case "Edit":
                editGame();
                break;
            default:
                break;
        }
    }

    public void playGame(HadiCezmi hadiCezmi) {
        HadiCezmi hadi = hadiCezmi;
        GameFrame gameFrame = new GameFrame(hadi);
        gameFrame.pack();
        gameFrame.setVisible(true);

        gameFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int keynum = e.getKeyCode();
                System.out.println(keynum);
                if (keynum == hadi.getCezmi1Left()) {
                    hadi.moveCezmi(1, "left");
                } else if (keynum == hadi.getCezmi1Right()) {
                    hadi.moveCezmi(1, "right");
                } else if (keynum == hadi.getCezmi2Left()) {
                    hadi.moveCezmi(2, "left");
                } else if (keynum == hadi.getCezmi2Right()) {
                    hadi.moveCezmi(2, "right");
                } else if (keynum == hadi.getTokatLeftKey()) {
                    hadi.rotateTokat("left");
                } else if (keynum == hadi.getTokatRightKey()) {
                    hadi.rotateTokat("right");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        final Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println(Thread.currentThread().getName());
                gameFrame.repaint();
                gameFrame.requestFocus();
            }
        });
        timer.start();
    }

    public void loadGame(HadiCezmi hadiCezmi) {
        JFileChooser fc = new JFileChooser();
        fc.addChoosableFileFilter(new XMLFilter());
        fc.setAcceptAllFileFilterUsed(false);
        int returnVal = fc.showOpenDialog(fc);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = fc.getSelectedFile();
            HadiCezmi hadi = hadiCezmi;
            hadi.readXML(file);
            GameFrame gameFrame = new GameFrame(hadi);
            gameFrame.pack();
            gameFrame.setVisible(true);
        }
    }

    public void editGame() {
    
    }
}