package ui;

import game.*;
import ui.domain.*;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * Created by ASEN14 on 28.11.2016.
 */
public class GameFrame {
    
	private HadiCezmi hadi;
	private GameFrameController gameFrameController;
	private UiBoardPanel uiBoardPanel;
	private JFrame frame;
	
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
				addButtons(toolBar);
				contentPane.add(toolBar, BorderLayout.NORTH);
		
				//adding edit pane
				uiBoardPanel.setPreferredSize(new Dimension(500, 500));
				
				contentPane.add(uiBoardPanel, BorderLayout.CENTER);

				frame.setContentPane(contentPane);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				
				 frame.addKeyListener(new KeyListener() {
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
//			                System.out.println(Thread.currentThread().getName());
			                frame.repaint();
			                frame.requestFocus();
			            }
			        });
			        timer.start();
		
			}
		});
	
	}
	
	public void addButtons(JToolBar toolBar) {
		JButton button;
		button = new JButton("Play");
		button.setToolTipText("Play the game");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrameController.doAction("Play", hadi, frame);
				//uiBoardPanel.repaint();
			}
		});
		toolBar.add(button);
		
		button = new JButton("Pause");
		button.setToolTipText("Pause the game");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrameController.doAction("Pause", hadi , frame);

			}
		});
		toolBar.add(button);
	
		button = new JButton("Back");
		button.setToolTipText("Return to main screen");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrameController.doAction("Back", hadi , frame);

			}
		});
		toolBar.add(button);
		
		button = new JButton("Edit Mode");
		button.setToolTipText("Enter to edit mode");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gameFrameController.doAction("Edit", hadi, frame);

			}
		});
		toolBar.add(button);
		
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
	
	/*GameFrameController gameFrameController;
    private HadiCezmi hadiCezmi;
    private UiBoardPanel uiBoardPanel;




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

        JPanel gizmoPanel = new JPanel(new GridLayout(0, 2));
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
                String[] arg = new String[1];
                gameFrameController.doAction(hadiCezmi, "addLeftTokat", arg);
            }
        });
        JButton rightTokatButton = new JButton("Test Repaint");
        rightTokatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                uiBoardPanel.repaint();
                String[] arg = new String[1];

                gameFrameController.doAction(hadiCezmi, "addRightTokat", arg);
            }
        });
        JButton squareTakozButton = new JButton("Square Takoz");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] arg = new String[1];
                gameFrameController.doAction(hadiCezmi, "addSquareTakoz", arg);
            }
        });
        JButton triangleTakozButton = new JButton("Triange Takoz");
        btnPlay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] arg = new String[1];
                gameFrameController.doAction(hadiCezmi, "addTriangleTakoz", arg);
            }
        });

        gizmoPanel.add(leftTokatButton);
        gizmoPanel.add(rightTokatButton);
        gizmoPanel.add(squareTakozButton);
        gizmoPanel.add(triangleTakozButton);

        uiBoardPanel.setPreferredSize(new Dimension(500, 500));
        JScrollPane boardPane = new JScrollPane(uiBoardPanel);
        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        contentPane.add(toolbarPanel, BorderLayout.NORTH);
        contentPane.add(gizmoPanel, BorderLayout.WEST);
        contentPane.add(boardPane, BorderLayout.CENTER);
        setContentPane(contentPane);
    }


    //this will do the repainting
    public void paint(Graphics g) {
        super.paint(g);
    }*/




