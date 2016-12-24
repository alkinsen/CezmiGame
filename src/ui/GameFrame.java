package ui;

import game.*;
import ui.domain.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * Created by ASEN14 on 28.11.2016.
 */
public class GameFrame {

    private HadiCezmi hadi;
    private GameFrameController gameFrameController;
    private UiBoardPanel uiBoardPanel;
    private JFrame frame;
    JLabel score1;
    JLabel score2;

    public GameFrame(HadiCezmi hadi) {
        this.gameFrameController = new GameFrameController();
        this.hadi = hadi;
        this.uiBoardPanel = new UiBoardPanel(hadi);

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                frame = new JFrame("Hadi Cezmi");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel contentPane = new JPanel();
                contentPane.setLayout(new BorderLayout());


                //adding button toolbar
                JToolBar toolBar = new JToolBar();
                toolBar.setLayout(new GridLayout(1, 6));
                toolBar.setOpaque(true);
                toolBar.setFloatable(false);
                addButtons(toolBar);
                contentPane.add(toolBar, BorderLayout.NORTH);


                //adding edit pane
                uiBoardPanel.setPreferredSize(new Dimension(500, 500));

                contentPane.add(uiBoardPanel, BorderLayout.CENTER);

                frame.setContentPane(contentPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                frame.addKeyListener(new MultiKeyPressListener(hadi));

                final Timer timer = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(final ActionEvent e) {
//			                System.out.println(Thread.currentThread().getName());
                        updateScore();
                        frame.repaint();
                        frame.requestFocus();

                    }
                });
                timer.start();

            }
        });

    }

    public void updateScore(){
        score1.setText(hadi.getPlayer1().getName()+": "+Integer.toString(hadi.getPlayer1().getScore()));
        score2.setText(hadi.getPlayer2().getName()+": "+Integer.toString(hadi.getPlayer2().getScore()));

    }
    public void addButtons(JToolBar toolBar) {
        score1 = new JLabel(hadi.getPlayer1().getName()+": "+ Integer.toString(hadi.getPlayer1().getScore()), SwingConstants.CENTER);
        score1.setOpaque(true);
        score1.setBackground(Color.green);
        toolBar.add(score1);

        JButton button;
        button = new JButton("Play");
        button.setToolTipText("Play the game");
        button.setOpaque(true);
        //button.setBackground(Color.yellow);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrameController.doAction("Play", hadi, frame);
            }
        });
        toolBar.add(button);

        button = new JButton("Pause");
        button.setToolTipText("Pause the game");
        button.setOpaque(true);
        //button.setBackground(Color.red);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrameController.doAction("Pause", hadi, frame);

            }
        });
        toolBar.add(button);

        button = new JButton("Back");
        button.setToolTipText("Return to main screen");
        button.setOpaque(true);
        //button.setBackground(Color.magenta);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrameController.doAction("Back", hadi, frame);

            }
        });
        toolBar.add(button);

        button = new JButton("Edit Mode");
        button.setToolTipText("Enter to edit mode");
        button.setOpaque(true);
        //button.setBackground(Color.blue);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrameController.doAction("Edit", hadi, frame);

            }
        });
        toolBar.add(button);

        score2 = new JLabel(hadi.getPlayer2().getName()+": "+ Integer.toString(hadi.getPlayer2().getScore()), SwingConstants.CENTER);
        score2.setOpaque(true);
        score2.setBackground(Color.green);
        toolBar.add(score2);
    }


}

class GamePane extends JPanel {
    private StartFrameController editFrameController;

    private final int FRAME_WIDTH = 500;
    private final int FRAME_HEIGHT = 500;
    HadiCezmi hadi;

    public GamePane(HadiCezmi hadi) {
        this.hadi = hadi;

        setBackground(Color.BLACK);
        setOpaque(true);
        setLayout(new GridLayout(25, 25));
        setBorder(new LineBorder(Color.BLACK));


    }
}

class MultiKeyPressListener implements KeyListener, ActionListener {
    private HadiCezmi hadi;
    public MultiKeyPressListener(HadiCezmi hadi){
        this.hadi = hadi;
    }
    // Set of currently pressed keys
    private final Set<Integer> pressed = new HashSet<Integer>();

    @Override
    public synchronized void keyPressed(KeyEvent e) {

        pressed.add(e.getKeyCode());
        Iterator iter = pressed.iterator();
        while(iter.hasNext()){
            int keynum = (Integer) iter.next();
            if (hadi.isRunningMode()) {
                if (keynum == hadi.getCezmi1Left()) {
                    hadi.moveCezmi(1, "left");
                } else if (keynum == hadi.getCezmi1Right()) {
                    hadi.moveCezmi(1, "right");
                } else if (keynum == hadi.getCezmi2Left()) {
                    hadi.moveCezmi(2, "left");
                } else if (keynum == hadi.getCezmi2Right()) {
                    hadi.moveCezmi(2, "right");
                } else if (keynum == hadi.getTokatLeftKey()) {
                    hadi.setLeftPressed(true);
                } else if (keynum == hadi.getTokatRightKey()) {
                    hadi.setRightPressed(true);
                }
            }
        }
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {
        int keynum = e.getKeyCode();
        pressed.remove(keynum);
        if (hadi.isRunningMode()) {
            if (keynum == hadi.getTokatLeftKey()) {
                hadi.setLeftPressed(false);
            } else if (keynum == hadi.getTokatRightKey()) {
                hadi.setRightPressed(false);
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {/* Not used */ }

    @Override
    public void actionPerformed(ActionEvent e) {
        Iterator iter = pressed.iterator();
        while(iter.hasNext()){
            int keynum = (Integer) iter.next();
            if (hadi.isRunningMode()) {
                if (keynum == hadi.getCezmi1Left()) {
                    hadi.moveCezmi(1, "left");
                } else if (keynum == hadi.getCezmi1Right()) {
                    hadi.moveCezmi(1, "right");
                } else if (keynum == hadi.getCezmi2Left()) {
                    hadi.moveCezmi(2, "left");
                } else if (keynum == hadi.getCezmi2Right()) {
                    hadi.moveCezmi(2, "right");
                } else if (keynum == hadi.getTokatLeftKey()) {
                    hadi.setLeftPressed(true);
                } else if (keynum == hadi.getTokatRightKey()) {
                    hadi.setRightPressed(true);
                }
            }
        }
    }
}


