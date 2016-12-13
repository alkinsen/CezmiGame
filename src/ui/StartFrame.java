package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * Created by ASEN14 on 28.11.2016.
 */
public class StartFrame extends JFrame {
    StartFrameController startFrameController;

    public StartFrame() {
        super("Welcome to Cezmi Game");

        startFrameController = new StartFrameController();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        JPanel btnPanel = new JPanel();
        JPanel tagPanel = new JPanel();
        JPanel inputPanel = new JPanel();

        JTextField levelTextField = new JTextField("Level");
        levelTextField.setEditable(true);
        levelTextField.setFont(new Font("Serif", Font.PLAIN, 20));
        levelTextField.setPreferredSize(new Dimension(50, 50));
        JTextField player1TextField = new JTextField("Player 1");
        player1TextField.setEditable(true);
        player1TextField.setFont(new Font("Serif", Font.PLAIN, 20));
        JTextField player2TextField = new JTextField("Player 2");
        player2TextField.setEditable(true);
        player2TextField.setFont(new Font("Serif", Font.PLAIN, 20));

        inputPanel.add(levelTextField);
        inputPanel.add(player1TextField);
        inputPanel.add(player2TextField);
        inputPanel.setSize(150, 50);

        JButton btnPlay = new JButton("Play Game");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            	StartFrame.this.setVisible(false);
                String[] args = new String[3];
                //TODO check these values.
                args[0] = levelTextField.getText();
                args[1] = player1TextField.getText();
                args[2] = player2TextField.getText();
                startFrameController.doAction("Play", args);

            }
        });
        JButton btnLoad = new JButton("Load Game");
        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] args = new String[3];
                //TODO check these values.
                args[0] = levelTextField.getText();
                args[1] = player1TextField.getText();
                args[2] = player2TextField.getText();
                startFrameController.doAction("Load", args);
            }
        });
        JButton btnEdit = new JButton("Edit Mode");
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrameController.doAction("Edit", null);
            }
        });
        btnPanel.add(btnPlay);
        btnPanel.add(btnLoad);
        btnPanel.add(btnEdit);

        JLabel label = new JLabel("HADI CEZMI");
        label.setFont(new Font("Serif", Font.PLAIN, 30));
        tagPanel.add(label);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());
        contentPane.setPreferredSize(new Dimension(450, 150));
        contentPane.add(tagPanel, BorderLayout.NORTH);
        contentPane.add(btnPanel, BorderLayout.CENTER);
        contentPane.add(inputPanel, BorderLayout.SOUTH);
        setContentPane(contentPane);

    }

    public static void main(String[] args) {
        StartFrame startFrame = new StartFrame();
        startFrame.pack();
        startFrame.setVisible(true);
    }
}
