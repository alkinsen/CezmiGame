package ui;
import game.*;
import ui.domain.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Created by ASEN14 on 28.11.2016.
 */
public class GameFrame extends JFrame{
    GameFrameController gameFrameController;
    private HadiCezmi hadiCezmi;
    private UiBoardPanel uiBoardPanel;


    //ADDED DUMMY OBJECTS FOR TESTING
//    Ball b = new Ball();
//    UiBall uib = new UiBall(b);
//    Cezmi c = new Cezmi(150,200,1);
//    UiCezmi uc1 = new UiCezmi(c);
//    SquareTakoz sq = new SquareTakoz(10,10);
//    UiSquareTakoz usq = new UiSquareTakoz(sq);
//    TriangleTakoz tq = new TriangleTakoz(50, 50);
//    UiTriangleTakoz utq = new UiTriangleTakoz(tq);U
    //ADDED DUMMY OBJECTS FOR TESTING

    public GameFrame(HadiCezmi hadiCezmi) {
        super("Welcome to Cezmi Game");

        this.hadiCezmi = hadiCezmi;
        this.uiBoardPanel = new UiBoardPanel(hadiCezmi);



        //CONTROLLER PATTERN
        gameFrameController = new GameFrameController();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel gizmoPanel = new JPanel(new GridLayout(0,2));
        JPanel board = new JPanel();

        JPanel toolbarPanel = new JPanel();

        //creating and adding buttons to top toolbar
        JButton btnPlay = new JButton("Play");
        JButton btnPause = new JButton("Pause");
        JButton btnEdit = new JButton("Edit");
        toolbarPanel.add(btnPlay);
        toolbarPanel.add(btnPause);
        toolbarPanel.add(btnEdit);

        //creating and adding buttons to gizmo panel
        JButton leftTokatButton = new JButton("Test Play");
        leftTokatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hadiCezmi.play();
                gameFrameController.doAction("addLeftTokat");
            }
        });
        JButton rightTokatButton = new JButton("Test Repaint");
        rightTokatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uiBoardPanel.repaint();
                gameFrameController.doAction("addRightTokat");
            }
        });
        JButton squareTakozButton = new JButton("Square Takoz");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrameController.doAction("addSquareTakoz");
            }
        });
        JButton triangleTakozButton = new JButton("Triange Takoz");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrameController.doAction("addTriangleTakoz");
            }
        });

        gizmoPanel.add(leftTokatButton);
        gizmoPanel.add(rightTokatButton);
        gizmoPanel.add(squareTakozButton);
        gizmoPanel.add(triangleTakozButton);

        JScrollPane boardPane = new JScrollPane(uiBoardPanel);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(800, 800));
        contentPane.add(toolbarPanel, BorderLayout.NORTH);
        contentPane.add(gizmoPanel, BorderLayout.WEST);
        contentPane.add(boardPane, BorderLayout.CENTER);
        setContentPane(contentPane);
    }


    //this will do the repainting
    public void paint(Graphics g) {
        super.paint(g);
    }


}

