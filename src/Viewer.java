import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Viewer extends JPanel {
    private Canvas canvas;
    private JFrame frame;
    private Controller controller;
    private Model model;

    public Viewer() {
        controller = new Controller(this);
        model = controller.getModel();
        canvas = new Canvas(model);
        frame = new JFrame("Sokoban Game MVC Pattern");
        try {
            frame.setIconImage(ImageIO.read(new File("src/images/desktop_icon.png")));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        frame.setSize(960, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar jMenuBar = getMenuBar();
        frame.add(BorderLayout.NORTH, jMenuBar);
        frame.add("Center", canvas);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(controller);
    }

    public void update() {
        canvas.repaint();
    }

    public boolean showDialogWon() {
        JOptionPane.showMessageDialog(frame, "You are woooooooooon!!!");
        return true;
    }

    private JMenuBar getMenuBar() {
        JMenuItem restart = new JMenuItem("Restart");
        restart.addActionListener(controller);
        restart.setActionCommand("Restart");
        restart.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0));

        JMenu mainMenu = new JMenu("Menu");
        mainMenu.add(restart);

        JMenuItem firstLevel = new JMenuItem("Level 1");
        firstLevel.addActionListener(controller);
        firstLevel.setActionCommand("Level 1");
        firstLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0));

        JMenuItem secondLevel = new JMenuItem("Level 2");
        secondLevel.addActionListener(controller);
        secondLevel.setActionCommand("Level 2");
        secondLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0));

        JMenuItem thirdLevel = new JMenuItem("Level 3");
        thirdLevel.addActionListener(controller);
        thirdLevel.setActionCommand("Level 3");
        thirdLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0));

        JMenuItem fourthLevel = new JMenuItem("Level 4");
        fourthLevel.addActionListener(controller);
        fourthLevel.setActionCommand("Level 4");
        fourthLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, 0));

        JMenuItem fifthLevel = new JMenuItem("Level 5");
        fifthLevel.addActionListener(controller);
        fifthLevel.setActionCommand("Level 5");
        fifthLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, 0));

        JMenuItem sixthLevel = new JMenuItem("Level 6");
        sixthLevel.addActionListener(controller);
        sixthLevel.setActionCommand("Level 6");
        sixthLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_6, 0));

        JMenuItem seventhLevel = new JMenuItem("Level 7");
        seventhLevel.addActionListener(controller);
        seventhLevel.setActionCommand("Level 7");
        seventhLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_7, 0));

        JMenuItem eighthLevel = new JMenuItem("Level 8");
        eighthLevel.addActionListener(controller);
        eighthLevel.setActionCommand("Level 8");
        eighthLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_8, 0));

        JMenuItem ninthLevel = new JMenuItem("Level 9");
        ninthLevel.addActionListener(controller);
        ninthLevel.setActionCommand("Level 9");
        ninthLevel.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_9, 0));

        JMenu levelMenu = new JMenu("Level");
        levelMenu.add(firstLevel);
        levelMenu.add(secondLevel);
        levelMenu.add(thirdLevel);
        levelMenu.add(fourthLevel);
        levelMenu.add(fifthLevel);
        levelMenu.add(sixthLevel);
        levelMenu.add(seventhLevel);
        levelMenu.add(eighthLevel);
        levelMenu.add(ninthLevel);

        JMenuBar jMenuBar = new JMenuBar();
        jMenuBar.add(mainMenu);
        jMenuBar.add(levelMenu);

        return jMenuBar;
    }
}
