package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import org.xml.sax.SAXException;

import game.HadiCezmi;
import xml.XMLChecker;
import xml.XMLFilter;

/**
 * Created by ASEN14 on 8.12.2016.
 */
public class StartFrameController {
	File file;

	public StartFrameController() {
	}

	public void doAction(String action, HadiCezmi hadiCezmi, JFrame frame) {
		switch (action) {
		case "Play":
			new EditFrame(hadiCezmi);
			frame.setVisible(false);
			break;
		case "Load":
			loadGame(hadiCezmi, frame);
			break;
		default:
			break;
		}
	}

	public void loadGame(HadiCezmi hadiCezmi, JFrame frame) {
		JFileChooser fc = new JFileChooser();
		fc.addChoosableFileFilter(new XMLFilter());
		fc.setAcceptAllFileFilterUsed(false);
		int returnVal = fc.showOpenDialog(fc);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();
			HadiCezmi hadi = hadiCezmi;
			hadi.readXML(file);

			frame.setVisible(false);
			new GameFrame(hadi);

		}
	}

}