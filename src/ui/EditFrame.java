package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
	private int[][] rotationMatrix= new int[25][25];	

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
				
				String message;
//				if(checkMap()){
//					HadiCezmi hadi = new HadiCezmi(1, "Player 1", "Player 2");
//					File file = new File("xml");
//					hadi.readXML(file);
//					new GameFrame(hadi);
//				}else{
//					String message = "The map is faulty. Please check the cezmi placement. There has to be 2 green squares next to each other on the bottom row.";
//					JOptionPane.showMessageDialog(null, message,"Map Status",JOptionPane.WARNING_MESSAGE);
//				}
				message = checkMap();
//				if(checkMap()){
//					frame.setVisible(false);
//					editFrameController.doAction(hadi, "play", editPane.getGridSquares());
//
//				}
				if(message.equalsIgnoreCase("Success")){
					frame.setVisible(false);
					editFrameController.doAction(hadi, "play", editPane.getGridSquares(),rotationMatrix);
					
				}
				else {
					JOptionPane.showMessageDialog(null, message,"Map Status",JOptionPane.WARNING_MESSAGE);
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
//				if(checkMap()){
//					message = "The map is complete.";
//				}else{
//					message = "The map is faulty. Please check the cezmi placement. There has to be 2 green squares next to each other on the bottom row.";
//				}
//				JOptionPane.showMessageDialog(null, message,"Map Status",JOptionPane.WARNING_MESSAGE);

				
				message = checkMap();
				if(!(checkMap().equalsIgnoreCase("Success"))){
//					String message= "Check your board again";
					JOptionPane.showMessageDialog(null, message,"Map Status",JOptionPane.WARNING_MESSAGE);
				}
				else {

					JOptionPane.showMessageDialog(null, message,"Map Status",JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		toolBar.add(button);

		button = new JButton("Save");

        button.setToolTipText("Saves the map.");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(checkMap().equalsIgnoreCase("Success")){
            		try {
            			XMLBuilder xmlBuilder=new XMLBuilder(hadi);
						xmlBuilder.writeToXML(editPane.getGridSquares());
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
				hadi.pause();
				frame.setVisible(false);
				frame.dispose();
				hadi.reset();
                new StartFrame(hadi);
            }});
        toolBar.add(button);


		JCheckBox rotateBox = new JCheckBox("Rotate Mode");
		rotateBox.setToolTipText("Enters rotate mode.");
		rotateBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rotateBox.isSelected()){
					rotateMode = true; 
					editPane.setMode(true);
					System.out.println("a");
				
				}
				else{
					editPane.setMode(false);
					rotateMode = false;
					rotationMatrix=editPane.getMatrix();
				}
			}});
		toolBar.add(rotateBox);
		

		JComboBox levelBox= new JComboBox();
		levelBox.setEditable(false);
		levelBox.addItem("Level 1");
		levelBox.addItem("Level 2");
		levelBox.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String level=levelBox.getSelectedItem().toString();
				int levelNo=1;
				if(level.equals("Level 1")){
					levelNo=1;
					System.out.println("level1");
					
				}else {
					levelNo=2;
				}
				hadi.setLevel(levelNo);
				hadi.getBoard().setLevel(levelNo);
				System.out.println(hadi.getBoard().getLevel());
			}
		});
		toolBar.add(levelBox);

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
		button4.setToolTipText("Square Takoz is represented by BLUE Color.");
		button4.setBackground(Color.blue);
		toolBar.add(button4);

		JButton button5;
		button5 = new JButton("Cezmi");
		button5.setToolTipText("Cezmi is represented by GREEN Color.");
		button5.setBackground(Color.GREEN);
		toolBar.add(button5);
	}

	public String checkMap() {
		int status = 0;
		String message="Success";
	
		EditableJButton[][] e=editPane.getGridSquares();
		int gizmo=0;
		int tokat=0;
		
		for(int i=0;i<12;i++){
			for(int j=0;j<25;j++){
				Color c=e[i][j].getBackground();
				if(hadi.getLevel()==HadiCezmi.LEVEL_TWO){
					if(i==0 || i==24){
						if(c.equals(Color.magenta) || c.equals(Color.yellow) || c.equals(Color.blue) ||  c.equals(Color.red)){
							message="You cannot have Gizmos in first and last columns. Check again.";
							return message;
									
						}
					}
				}
				if(c.equals(Color.magenta)){
					
					
					Color c1=e[i][j+1].getBackground();
					Color c2=e[i+1][j].getBackground();
				
					
					if(c1.equals(Color.magenta)|| c1.equals(Color.yellow) || c1.equals(Color.blue) || c1.equals(Color.red)){

						
						message= "There is a Gizmo next to a Tokat. Check again.";
//						if((j<=24) && (j>=1)){
//							Color c2=e[i][j+1].getBackground();
//							Color c3=e[i][j-1].getBackground();
//							int counter=0;
//								if(!c2.equals(Color.magenta)){
//									counter++;
//								
//								}
//								if(!c3.equals(Color.magenta)){
//									counter++;
//								}
//								if(counter==2){
//									message= "Not a valid tokat placement. Check your tokat representation again.";
//								}
//								
//							}
////							return false;
//							
							return message;

						}				
					else if(c2.equals(Color.magenta)|| c2.equals(Color.yellow) || c2.equals(Color.blue) || c2.equals(Color.red)){
						
						message= "There is a Gizmo under the Tokat. Check again.";
						return message;
					}else {
						tokat++;
					}
					
					
				} else if(c.equals(Color.yellow)){
					
					gizmo++;
				} else if(c.equals(Color.blue)){
					gizmo++;
				} else if (c.equals(Color.red)){
					gizmo++;
				} else {
					
				}
				
			}
		}
//		if(tokat==2){
			if(gizmo+tokat!=4 ){
			

//			message= "Gizmo number is not 4. Check again. ";
//			return message;
////			return false;
//			}
//		}else{
//			if(gizmo!=4){
//				
				message= "Gizmo number is not 4. Check again. ";
				return message;
//			}
		}

		if(tokat>2){
			
			message= "There are more than one Tokat at one of the sides. Check again.";
			return message;
//			return false;

		}
		gizmo=0;
		tokat=0;
		
		for(int i=13;i<25;i++){
			for(int j=0;j<25;j++){
				Color c=e[i][j].getBackground();
				if(hadi.getLevel()==HadiCezmi.LEVEL_TWO){
					if(i==0 || i==24){
						if(c.equals(Color.magenta) || c.equals(Color.yellow) || c.equals(Color.blue) ||  c.equals(Color.red)){
							message="You cannot have Gizmos in first and last columns. Check again.";
							return message;
									
						}
					}
				}
				if(c.equals(Color.magenta)){
					
					int count=0;
					Color c1=e[i-1][j].getBackground();
					Color c2=e[i][j+1].getBackground();
					if(c1.equals(Color.magenta)|| c1.equals(Color.yellow) || c1.equals(Color.blue) || c1.equals(Color.red)){
						

						
						message= "There is a Gizmo next to a Tokat. Check again.";
						
//						if((j<=24) && (j>=1)){
//						Color c2=e[i][j+1].getBackground();
//						Color c3=e[i][j-1].getBackground();
//						int counter=0;
//							if(!c2.equals(Color.magenta)){
//								counter++;
//							
//							}
//							if(!c3.equals(Color.magenta)){
//								counter++;
//							}
//							if(counter==2){
//								message= "Not a valid tokat placement. Check your tokat representation again.";
//							}
//							
//						}
////						return false;

						return message;

					}else if(c2.equals(Color.magenta)|| c2.equals(Color.yellow) || c2.equals(Color.blue) || c2.equals(Color.red)){
						
						message= "There is a Gizmo under the Tokat. Check again.";
						return message;
					}else {
						tokat++;
					}
						
					
					
					
					
				} else if(c.equals(Color.yellow)){
					gizmo++;
				} else if(c.equals(Color.blue)){
					gizmo++;
				} else if (c.equals(Color.red)){
					gizmo++;
				} else {
					
				}
				
			}
		}
//		if(tokat==2){
//			if(gizmo+tokat!=5 ){
//
//			message= "Gizmo number is not 4. Check again. ";
//			return message;
//
////			return false;
//			}
//		}else{
			if(gizmo+tokat!=4){
				
				message= "Gizmo number is not 4. Check again. ";
				return message;
			}
//		}
		if(tokat>2){
			System.out.println("f4");

			message= "There are more than one Tokat at one of the sides. Check again.";
			return message;

		}
		int cezmi1=0;
		int cezmi2=0;
		int temp=0;
		for(int i=0;i<12;i++){
			Color c=e[i][24].getBackground();
			if(c.equals(Color.green)){
//				cezmi1++;
				if((i+1)<12){
				Color d=e[i+1][24].getBackground();
				if(d.equals(Color.green)){
					cezmi1=2;
					break;
				}
				}
//				
//			
//			if(temp==i-1){
//				cezmi1=2;
//				break;
//			} 
//			temp=i;
//			}else{
//			temp=0;
			}
			
		}
		temp=0;
		for(int i=13;i<25;i++){
			Color c=e[i][24].getBackground();
			if(c.equals(Color.green)){
//				cezmi2++;
				if((i+1)<25){
					Color d=e[i+1][24].getBackground();
					if(d.equals(Color.green)){
						cezmi2=2;
						break;
					}
				}
			
//			if(temp==i-1){
//				cezmi2=2;
//				break;
//			}
//			temp=i;
//		}else{
//			temp=0;
			}
		}
		if(cezmi1!=2 || cezmi2!=2){

			message= "Cezmi is not placed in a valid way. Check again.";
			return message;
//			return false;
		}
		return message;
//		return true;
		


	}
}



class EditPane extends JPanel {
	private EditFrameController editFrameController;

	EditableJButton[][] gridSquares;
	HadiCezmi hadi;
	boolean rotateMode;
	int[][] rotationMatrix= new int[25][25];

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
				gridSquares[x][y].setBackground(Color.blue);
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
		rotateMode=false;
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
	public void setMode(boolean mode){
		rotateMode=mode;
		for(int i=0;i<25;i++){
			for(int j=0;j<25;j++){
				gridSquares[i][j].setRotateMode(mode);
			}
		}
		
		if(mode==false){
			for(int i=0;i<25;i++){
				for(int j=0;j<25;j++){
					rotationMatrix[i][j]=gridSquares[i][j].getMatrixValue();
//					System.out.println(rotationMatrix[i][j]);
					gridSquares[i][j].setMatrixValue(0);
				}
			}
			
		}
		
	}
	public int[][] getMatrix(){
		return rotationMatrix;
	}
	 
}





