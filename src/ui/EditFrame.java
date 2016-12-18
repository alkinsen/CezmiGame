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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

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
import xml.XMLBuilder;

/**
 * Created by ASEN14 on 28.11.2016.
 */
public class EditFrame {

	private JFrame frame;
	private HadiCezmi hadi;
	private EditFrameController editFrameController;
	private Boolean rotateMode;
	private EditPane editPane;

	public EditFrame(HadiCezmi hadi) {
		this.editFrameController = new EditFrameController();
		this.hadi = hadi;
		this.rotateMode = false;

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
				editPane = new EditPane(hadi);
				contentPane.add(editPane, BorderLayout.CENTER);

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

//				if(checkMap()){
//					HadiCezmi hadi = new HadiCezmi(1, "Player 1", "Player 2");
//					File file = new File("xml");
//					hadi.readXML(file);
//					new GameFrame(hadi);
//				}else{
//					String message = "The map is faulty. Please check the cezmi placement. There has to be 2 green squares next to each other on the bottom row.";
//					JOptionPane.showMessageDialog(null, message,"Map Status",JOptionPane.WARNING_MESSAGE);
//				}
				if(checkMap()){
					frame.setVisible(false);
					editFrameController.doAction(hadi, "play", editPane.getGridSquares());

				}

			}
		});
		toolBar.add(button);


		button = new JButton("Check");
		button.setToolTipText("Checks the validity of gizmo placement.");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

//				String message;
//				if(checkMap()){
//					message = "The map is complete.";
//				}else{
//					message = "The map is faulty. Please check the cezmi placement. There has to be 2 green squares next to each other on the bottom row.";
//				}
//				JOptionPane.showMessageDialog(null, message,"Map Status",JOptionPane.WARNING_MESSAGE);
				System.out.println("girdi");
				checkMap();
				

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
            	if(checkMap()){
            		
            		try {
            			XMLBuilder xmlBuilder=new XMLBuilder(hadi);
						xmlBuilder.writeToXML();
					} catch (ParserConfigurationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (TransformerException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
            	
            }});
        toolBar.add(button); 
        
		button = new JButton("Back");
        button.setToolTipText("Goes back to main screen.");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.setVisible(false);
                new StartFrame(new HadiCezmi(1, "Player 1", "Player 2"));
            }});
        toolBar.add(button);


		JCheckBox rotateBox = new JCheckBox("Rotate Mode");
		rotateBox.setToolTipText("Enters rotate mode.");
		rotateBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rotateBox.isSelected()) rotateMode = true;
				else rotateMode = false;
			}});
		toolBar.add(rotateBox);
		
	
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
		
	
		EditableJButton[][] e=editPane.getGridSquares();
		int gizmo=0;
		int tokat=0;
		
		for(int i=0;i<12;i++){
			for(int j=0;j<25;j++){
				Color c=e[i][j].getBackground();
				if(c.equals(Color.magenta)){
					tokat++;
				} else if(c.equals(Color.yellow)){
					gizmo++;
				} else if(c.equals(Color.orange)){
					gizmo++;
				} else if (c.equals(Color.red)){
					gizmo++;
				} else {
					
				}
				
			}
		}
		if(gizmo+tokat!=4){
			System.out.println("f1");
			return false;
		}
		if(tokat>1){
			System.out.println("f2");
			return false;
		}
		gizmo=0;
		tokat=0;
		
		for(int i=13;i<25;i++){
			for(int j=0;j<25;j++){
				Color c=e[i][j].getBackground();
				if(c.equals(Color.magenta)){
					tokat++;
				} else if(c.equals(Color.yellow)){
					gizmo++;
				} else if(c.equals(Color.orange)){
					gizmo++;
				} else if (c.equals(Color.red)){
					gizmo++;
				} else {
					
				}
				
			}
		}
		if(gizmo+tokat!=4){
			System.out.println("f3");
			return false;
		}
		if(tokat>1){
			System.out.println("f4");
			return false;
		}
		int cezmi1=0;
		int cezmi2=0;
		int temp=0;
		for(int i=0;i<12;i++){
			Color c=e[i][24].getBackground();
			if(c.equals(Color.green)){
				cezmi1++;
			
			if(temp==i-1){
				cezmi1=2;
				break;
			} 
			temp=i;
		}
		}
		temp=0;
		for(int i=13;i<25;i++){
			Color c=e[i][24].getBackground();
			if(c.equals(Color.green)){
				cezmi2++;
			
			if(temp==i-1){
				cezmi2=2;
				break;
			}
			temp=i;
		}
		}
		if(cezmi1!=2 || cezmi2!=2){
			System.out.println("f5");
			return false;
		}
		System.out.println("t");
		return true;
	}
}



class EditPane extends JPanel {
	private EditFrameController editFrameController;

	private final int FRAME_WIDTH = 500;
	private final int FRAME_HEIGHT = 500;
	JPanel editBoard;
	EditableJButton[][] gridSquares;
	HadiCezmi hadi;

	public EditPane(HadiCezmi hadi) {
		this.hadi = hadi;
		setPreferredSize(new Dimension(500, 500));
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

		gridSquares[x2][y2-1].setBackground(Color.green);
		gridSquares[x2+1][y2-1].setBackground(Color.green);
		}

	public EditableJButton[][] getGridSquares() {
		return gridSquares;
	}

	public void setGridSquares(EditableJButton[][] gridSquares) {
		this.gridSquares = gridSquares;
	}
	public EditFrameController getEditFrameController(){
		return editFrameController;
	}
	 
}





