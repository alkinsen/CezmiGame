package ui;

import game.HadiCezmi;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EditFrameController {

    public EditFrameController() {

    }

    public void doAction(String action, HadiCezmi hadiCezmi) {
        switch (action) {
            case "Play":
                playGame(hadiCezmi);
                break;
            default:
                break;
        }
    }

    public void playGame(HadiCezmi hadiCezmi) {
        GameFrame gameFrame = new GameFrame(hadiCezmi);
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
                if (keynum == hadiCezmi.getCezmi1Left()) {
                    hadiCezmi.moveCezmi(1, "left");
                } else if (keynum == hadiCezmi.getCezmi1Right()) {
                    hadiCezmi.moveCezmi(1, "right");
                } else if (keynum == hadiCezmi.getCezmi2Left()) {
                    hadiCezmi.moveCezmi(2, "left");
                } else if (keynum == hadiCezmi.getCezmi2Right()) {
                    hadiCezmi.moveCezmi(2, "right");
                } else if (keynum == hadiCezmi.getTokatLeftKey()) {
                    hadiCezmi.rotateTokat("left");
                } else if (keynum == hadiCezmi.getTokatRightKey()) {
                    hadiCezmi.rotateTokat("right");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        final Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
//                System.out.println(Thread.currentThread().getName());
                gameFrame.repaint();
                gameFrame.requestFocus();
            }
        });
        timer.start();
    }
}
