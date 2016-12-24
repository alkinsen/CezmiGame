package ui;

import javax.swing.*;
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
                if (e.getButton() == MouseEvent.BUTTON1) {
                	switch(mode){
                	case 0 :
                		if (y == 24){
                			setMode(5);
                		}
                		else{
                			setMode(1);
                		}
                		break;
                	case 1 : 
                		setMode(2);
                		break;
                	case 2 : 
                		setMode(3);
                		break;
                	case 3 : 
                		setMode(4);
                		break;	
                	case 4 : 
                		setMode(0);
                		break;
                	case 5 :
                		setMode(0);
                	}

                }
                else if(e.getButton() == MouseEvent.BUTTON3){
                	setMode(0);
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
        if(mode == 0) setBackground(Color.black);
        if(mode == 1) setBackground(Color.yellow);
        if(mode == 2) setBackground(Color.red);
        if(mode == 3) setBackground(Color.magenta);
        if(mode == 4) setBackground(Color.blue);
        if(mode == 5) setBackground(Color.green);
        repaint();

    }
}
