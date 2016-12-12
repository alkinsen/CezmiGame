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

        JButton btnPlay = new JButton("Play Game");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	StartFrame.this.setVisible(false);
                startFrameController.doAction("Play", null);
            }
        });
        JButton btnLoad = new JButton("Load Game");
        btnLoad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startFrameController.doAction("Load", null);
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
        contentPane.setPreferredSize(new Dimension(400, 100));
        contentPane.add(tagPanel, BorderLayout.NORTH);
        contentPane.add(btnPanel, BorderLayout.CENTER);
        setContentPane(contentPane);

    }

    public static void main(String[] args) {
        StartFrame startFrame = new StartFrame();
        startFrame.pack();
        startFrame.setVisible(true);
    }
}
