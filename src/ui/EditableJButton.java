package ui;

import javax.swing.*;

import game.HadiCezmi;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

/**
 * Created by ASEN14 on 21.10.2016.
 */
public class EditableJButton extends JButton {
    private int mode = 0;
    private int x, y;
    private final static int UNIT_LENGTH = 20;
    private boolean rotateMode=false;
    private int matrixValue=0;
    
    
    //mode 0 = null, 
    //mode 1 = SquareTakoz  = sarı
    //mode 2 = TriangleTakoz = kırmızı
    //mode 3 = Tokat = magenta
    //mode 4 = Fırıldak = turuncu
    //mode 5 = cezmi = yeşil
    
    public EditableJButton(int x, int y){
        this.x = x;
        this.y = y;
        this.setMargin(new Insets(0,0,0,0));
       // ImageIcon icon = new ImageIcon(new BufferedImage(UNIT_LENGTH, UNIT_LENGTH, BufferedImage.TYPE_INT_ARGB));
       // this.setIcon(icon);
        this.setOpaque(true);
        this.setBackground(Color.black);
        if(x == 12 && y == 22) this.setBackground(Color.cyan);
        if(x == 12 && y == 23) this.setBackground(Color.cyan);
        else if(x == 12 && y == 24) this.setBackground(Color.cyan);
        else if(!(y == 19 || y == 20 || y == 21 || y == 22 || y == 23)){
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1 && !rotateMode) {
                	switch(mode){
                	case HadiCezmi.hadiCezmi_Null :
                		if(x==12){
                			setMode(HadiCezmi.hadiCezmi_Null);
                			break;
                		}
                		if (y == 24){
                			setMode(HadiCezmi.hadiCezmi_Cezmi);
                		} 
                		else{
                			setMode(HadiCezmi.hadiCezmi_SquareTakoz);
                		}
                		
                		break;
                	case HadiCezmi.hadiCezmi_SquareTakoz : 
                		setMode(HadiCezmi.hadiCezmi_TriangleTakoz);
                		break;
                	case HadiCezmi.hadiCezmi_TriangleTakoz : 
                		setMode(HadiCezmi.hadiCezmi_Tokat);
                		break;
                	case HadiCezmi.hadiCezmi_Tokat : 
                		setMode(HadiCezmi.hadiCezmi_Firildak);
                		break;	
                	case HadiCezmi.hadiCezmi_Firildak : 
                		setMode(HadiCezmi.hadiCezmi_Null);
                		break;
                	case HadiCezmi.hadiCezmi_Cezmi :
                		setMode(HadiCezmi.hadiCezmi_Null);
                	}

                }
                else if(e.getButton() == MouseEvent.BUTTON3){
                	setMode(0);
                }
                else if(e.getButton() == MouseEvent.BUTTON1 && rotateMode){
                	int x=e.getX();
                	int y=e.getY();
                	if(mode!=HadiCezmi.hadiCezmi_Null){
//                	System.out.println(x+" "+y);
                	matrixValue++;
//                	System.out.println(matrixValue);
                	}
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        }
    }

    public int getMode() {
        return mode;
    }
    public void setMode(int mode) {
        this.mode = mode;
        if(mode == HadiCezmi.hadiCezmi_Null) setBackground(Color.black);
        if(mode == HadiCezmi.hadiCezmi_SquareTakoz) setBackground(Color.yellow);
        if(mode == HadiCezmi.hadiCezmi_TriangleTakoz) setBackground(Color.red);
        if(mode == HadiCezmi.hadiCezmi_Tokat) setBackground(Color.magenta);
        if(mode == HadiCezmi.hadiCezmi_Firildak) setBackground(Color.blue);
        if(mode == HadiCezmi.hadiCezmi_Cezmi) setBackground(Color.green);
        repaint();

    }
    public void setRotateMode(boolean mode){
    	rotateMode=mode;
    }
    public int getMatrixValue(){
    	System.out.println("Editabledaki deger "+matrixValue);
    	return matrixValue;
    }
    public void setMatrixValue(int newMatrixValue){
    	matrixValue=newMatrixValue;
    }
}
