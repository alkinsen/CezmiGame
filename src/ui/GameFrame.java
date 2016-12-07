package ui;
import game.Takoz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Created by ASEN14 on 28.11.2016.
 */
public class GameFrame extends JFrame{

    GameFrameController gameFrameController;

    public GameFrame() {
        super("Welcome to Cezmi Game");

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
        JButton leftTokatButton = new JButton("Left Tokat");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameFrameController.doAction("addLeftTokat");
            }
        });
        JButton rightTokatButton = new JButton("Right Tokat");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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

        JScrollPane boardPane = new JScrollPane(board);
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

    //main to test this class
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();
        gameFrame.pack();
        gameFrame.setVisible(true);
    }
}
