package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import game.HadiCezmi;


public class StartFrame {
    public JFrame frame;
    public HadiCezmi hadiCezmi;

    public StartFrame(HadiCezmi hadiCezmi) {
        this.hadiCezmi = hadiCezmi;

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
                frame.add(new StartPane(frame));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class StartPane extends JPanel {
        private StartFrameController startFrameController;
        private JFrame frame;
        private List<String> menuItems;
        private String selectMenuItem;
        private String focusedItem;

        private MenuItemPainter painter;
        private Map<String, Rectangle> menuBounds;

        public StartPane(final JFrame frame) {
            this.frame = frame;
            startFrameController = new StartFrameController();
            setBackground(Color.BLACK);
            painter = new SimpleMenuItemPainter();
            menuItems = new ArrayList<>(25);
            menuItems.add("A PLUS");
            menuItems.add("Play Game");
            menuItems.add("Load Game");

            MouseAdapter ma = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    String newItem = null;
                    for (String text : menuItems) {
                        Rectangle bounds = menuBounds.get(text);
                        if (bounds.contains(e.getPoint())) {
                            newItem = text;
                            break;
                        }
                    }
                    if (newItem != null && !newItem.equals(selectMenuItem)) {
                        //selectMenuItem = newItem;
                        //repaint();
                        if (newItem.equals("Play Game")) {
                            startFrameController.doAction("Play", hadiCezmi);
                            frame.setVisible(false);
                        } else if (newItem.equals("Load Game")) {
                            startFrameController.doAction("Load", hadiCezmi);
                            frame.setVisible(false);
                        }
                    }

                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    focusedItem = null;
                    for (String text : menuItems) {
                        Rectangle bounds = menuBounds.get(text);
                        if (bounds.contains(e.getPoint())) {
                            focusedItem = text;
                            repaint();
                            break;
                        }
                    }
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);


        }

        @Override
        public void invalidate() {
            menuBounds = null;
            super.invalidate();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            if (menuBounds == null) {
                menuBounds = new HashMap<>(menuItems.size());
                int width = 0;
                int height = 0;

                for (String text : menuItems) {
                    Dimension dim = new Dimension((int) painter.getPreferredSize(g2d, text).getWidth() * 2, (int) painter.getPreferredSize(g2d, text).getHeight() * 2);
                    width = Math.max(width, dim.width);
                    height = Math.max(height, dim.height);
                }

                int x = (getWidth() - (width + 10)) / 2;

                int totalHeight = (height + 10) * menuItems.size();
                totalHeight += 5 * (menuItems.size() - 1);

                int y = (getHeight() - totalHeight) / 2;

                for (String text : menuItems) {
                    menuBounds.put(text, new Rectangle(x, y, width + 10, height + 10));
                    y += height + 10 + 5;
                }

            }
            for (String text : menuItems) {
                Rectangle bounds = menuBounds.get(text);
                boolean isSelected = text.equals(selectMenuItem);
                boolean isFocused = text.equals(focusedItem);
                painter.paint(g2d, text, bounds, isSelected, isFocused);
            }


            g2d.dispose();
        }


    }

    public interface MenuItemPainter {

        public void paint(Graphics2D g2d, String text, Rectangle bounds, boolean isSelected, boolean isFocused);

        public Dimension getPreferredSize(Graphics2D g2d, String text);

    }

    public class SimpleMenuItemPainter implements MenuItemPainter {

        public Dimension getPreferredSize(Graphics2D g2d, String text) {
            return g2d.getFontMetrics().getStringBounds(text, g2d).getBounds().getSize();
        }

        @Override
        public void paint(Graphics2D g2d, String text, Rectangle bounds, boolean isSelected, boolean isFocused) {
            FontMetrics fm = g2d.getFontMetrics();
            if (text != "A PLUS") {
                if (isSelected) {
                    paintBackground(g2d, bounds, Color.BLUE, Color.WHITE);
                } else if (isFocused) {
                    paintBackground(g2d, bounds, Color.MAGENTA, Color.BLACK);
                } else {
                    paintBackground(g2d, bounds, Color.DARK_GRAY, Color.LIGHT_GRAY);
                }
                int x = bounds.x + ((bounds.width - fm.stringWidth(text)) / 2);
                int y = bounds.y + ((bounds.height - fm.getHeight()) / 2) + fm.getAscent();
                g2d.setColor(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
                g2d.drawString(text, x, y);
            } else {
                paintBackground(g2d, bounds, Color.RED, Color.RED);
                int x = bounds.x + ((bounds.width - fm.stringWidth(text)) / 2);
                int y = bounds.y + ((bounds.height - fm.getHeight()) / 2) + fm.getAscent();
                g2d.setColor(isSelected ? Color.WHITE : Color.LIGHT_GRAY);
                g2d.drawString(text, x, y);
            }
        }

        protected void paintBackground(Graphics2D g2d, Rectangle bounds, Color background, Color foreground) {
            g2d.setColor(background);
            g2d.fill(bounds);
            g2d.setColor(foreground);
            g2d.draw(bounds);
        }

    }

}
    
    
    
    
    /*public StartFrame() {
    	
        super("Welcome to Cezmi Game");
        startFrameController = new StartFrameController();

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
    }*/
