package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import game.Cezmi;
import game.Firildak;
import game.Gizmo;
import game.HadiCezmi;
import game.LeftTokat;
import game.RightTokat;
import game.SquareTakoz;
import game.Takoz;
import game.Tokat;
import game.TriangleTakoz;
import ui.StartFrame.StartPane;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class EditFrame {
    private JFrame frame;
    private HadiCezmi hadi;
    private EditFrameController editFrameController;

    public EditFrame(HadiCezmi hadi) {
        this.editFrameController = new EditFrameController();
        this.hadi = hadi;

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

                //adding index toolbar
                JToolBar indexToolBar = new JToolBar();
                indexToolBar.setLayout(new GridLayout(1, 5));
                addIndex(indexToolBar);
                contentPane.add(indexToolBar, BorderLayout.SOUTH);

                //adding edit pane
                contentPane.add(new EditPane(hadi), BorderLayout.CENTER);

                frame.setContentPane(contentPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

    public void addButtons(JToolBar toolBar) {
        JButton button;
        button = new JButton("Start Game");
        button.setToolTipText("Start the game");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (true) {
//					File file = new File("xml");
//					hadi.readXML(file);
                    frame.setVisible(false);
                    editFrameController.doAction("Play", hadi);

                } else {
                    String message = "The map is faulty. Please check the cezmi placement. There has to be 2 green squares next to each other on the bottom row.";
                    JOptionPane.showMessageDialog(null, message, "Map Status", JOptionPane.WARNING_MESSAGE);
                }

            }
        });
        toolBar.add(button);


        button = new JButton("Check");
        button.setToolTipText("Checks the validity of gizmo placement.");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message;
                if (checkMap()) {
                    message = "The map is complete.";
                } else {
                    message = "The map is faulty. Please check the cezmi placement. There has to be 2 green squares next to each other on the bottom row.";
                }
                JOptionPane.showMessageDialog(null, message, "Map Status", JOptionPane.WARNING_MESSAGE);
            }
        });
        toolBar.add(button);

        button = new JButton("Save");
        button.setToolTipText("Saves the map.");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                PrintWriter writer = null;
//                try {
//                    if(checkMap()) {
//
//                    }else{
//                        String message = "The map is faulty. Please check the cezmi placement. There has to be 2 green squares next to each other on the bottom row.";
//                        JOptionPane.showMessageDialog(null, message,"Map Status",JOptionPane.WARNING_MESSAGE);
//                    }
//                    writer.close();
//                } catch (FileNotFoundException e1) {
//                    e1.printStackTrace();
//                } catch (UnsupportedEncodingException e1) {
//                    e1.printStackTrace();
//                }
            }
        });
        toolBar.add(button);

        button = new JButton("Back");
        button.setToolTipText("Goes back to main screen.");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new StartFrame(hadi);
            }
        });
        toolBar.add(button);
    }

    public void addIndex(JToolBar toolBar) {
        JButton button;
        button = new JButton("Square Takoz");
        button.setToolTipText("Square Takoz is represented by YELLOW Color.");
        button.setBackground(Color.yellow);
        toolBar.add(button);

        JButton button2;
        button2 = new JButton("Triangle Takoz");
        button2.setToolTipText("Triangle Takoz is represented by RED Color.");
        button2.setBackground(Color.red);
        toolBar.add(button2);

        JButton button3;
        button3 = new JButton("Tokat");
        button3.setToolTipText("Square Takoz is represented by MAGENTA Color.");
        button3.setBackground(Color.MAGENTA);
        toolBar.add(button3);

        JButton button4;
        button4 = new JButton("Fırıldak");
        button4.setToolTipText("Square Takoz is represented by ORANGE Color.");
        button4.setBackground(Color.ORANGE);
        toolBar.add(button4);

        JButton button5;
        button5 = new JButton("Cezmi");
        button5.setToolTipText("Cezmi is represented by GREEN Color.");
        button5.setBackground(Color.GREEN);
        toolBar.add(button5);
    }

    public boolean checkMap() {
        int status = 0;
        //0: no gizmo so far - fail
        //1: there is one green - fail
        //2: there is one green after the first one - success
        //3: fail
        /*int mode;
		for(int i = 0; i < 19; i++){
			mode = gridSquares[i][19].getMode();
			if(status == 0) {
				if (mode == 2) status = 1;
			}else if(status == 1){
				if(mode == 2) status = 2;
				if(mode == 0) status = 3;
			}else if(status == 2){
				if(mode == 2) status = 3;
			}
		}*/
        return status == 2;
    }


    public class EditPane extends JPanel {
        private StartFrameController editFrameController;

        private final int FRAME_WIDTH = 500;
        private final int FRAME_HEIGHT = 500;
        JPanel editBoard;
        EditableJButton[][] gridSquares;
        HadiCezmi hadi;

        public EditPane(HadiCezmi hadi) {
            this.hadi = hadi;

            setBackground(Color.BLACK);
            setOpaque(true);
            setLayout(new GridLayout(25, 25));
            setBorder(new LineBorder(Color.BLACK));

            gridSquares = new EditableJButton[25][25];
            for (int ii = 0; ii < gridSquares.length; ii++) {
                for (int jj = 0; jj < gridSquares[ii].length; jj++) {
                    EditableJButton b = new EditableJButton(jj, ii);
                    gridSquares[jj][ii] = b;
                    add(b);
                }
            }

            ArrayList<Gizmo> gizmos = hadi.getBoard().getGizmoArrayList();
            for (Gizmo g : gizmos) {
                int x = g.getX() / 20;
                int y = g.getY() / 20;

                if (g instanceof Firildak) {
                    gridSquares[x][y].setBackground(Color.orange);
                } else if (g instanceof SquareTakoz) {
                    gridSquares[x][y].setBackground(Color.yellow);
                } else if (g instanceof TriangleTakoz) {
                    gridSquares[x][y].setBackground(Color.red);
                } else if (g instanceof Tokat) {
                    gridSquares[x][y].setBackground(Color.magenta);
                }

            }

            Cezmi cezmi1 = hadi.getBoard().getCezmi1();
            int x1 = (int) cezmi1.getX() / 20;
            int y1 = (int) cezmi1.getY() / 20;
            gridSquares[x1][y1 - 1].setBackground(Color.green);
            gridSquares[x1 + 1][y1 - 1].setBackground(Color.green);

            Cezmi cezmi2 = hadi.getBoard().getCezmi2();
            int x2 = (int) cezmi2.getX() / 20;
            int y2 = (int) cezmi2.getY() / 20;
            gridSquares[x2][y2 - 1].setBackground(Color.green);
            gridSquares[x2 + 1][y2 - 1].setBackground(Color.green);
        }
    }
	
	



	/*public void clearEditMap(){

		for (int ii = 0; ii < gridSquares.length; ii++) {
			for (int jj = 0; jj < gridSquares[ii].length; jj++) {
				gridSquares[ii][jj].setMode(0);
			}
		}
	}

	public String cezmiXmlBuilder(){
		int x = 0;
		for (int i = 0; i < 20 ; i++){
			if(gridSquares[i][19].getMode() == 2){
				x = i;
			}
		}
		return "<cezmi x=\""+x+"\" score=\"0\"  />";
	}

	public String takozlarXmlBuilder(){
		String result = "";
		for (int ii = 0; ii < gridSquares.length; ii++) {
			for (int jj = 0; jj < gridSquares[ii].length; jj++) {
				if(gridSquares[jj][ii].getMode() == 1){
					result += " <takoz   x=\""+jj+"\"  y=\""+ii+"\" />\n";
					System.out.println("\n"+result);
				}

			}
		}

		return result;
	}
	
	}
	
	/*public void updateEditMapFromXml(String fileName) throws IOException, SAXException, ParserConfigurationException {
		XmlParser parser = new XmlParser(fileName);
        clearEditMap();
        ArrayList<Takoz> takozlar = parser.createTakozFromXml();
        for (Takoz takoz : takozlar) {
            gridSquares[takoz.getX()/Game.UNIT_LENGHT][takoz.getY()/Game.UNIT_LENGHT].setMode(1);
        }

        if(parser.cezmiExistsInXml()){
            gridSquares[parser.getCezmiLocationFromXml()][19].setMode(2);
            gridSquares[parser.getCezmiLocationFromXml()+1][19].setMode(2);
        }
}*/
}





		/*button = new JButton("Quit");
		button.setToolTipText("Quit the application");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		toolBar.add(button);

	}


*/

	 /*
	 */
