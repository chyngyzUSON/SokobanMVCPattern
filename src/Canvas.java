import javax.swing.JPanel;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {

    private Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;
    private Image imageFloor;
    private final Color canvasColor;
    private Image backgroundImage;

    public Canvas(Model model) {
        this.model = model;
        setBackground(Color.BLACK);
        setOpaque(true);
        canvasColor = new Color(0, 0, 0, 0);
        File fileNameImageGamer = new File("src/images/gamer.png");
        File fileNameImageWall = new File("src/images/wall.png");
        File fileNameImageBox = new File("src/images/box.png");
        File fileNameImageGoal = new File("src/images/goal.png");
        File fileNameImageFloor = new File("src/images/floor.png");
        File fileNameImageBackground = new File("src/images/background.jpg");
        try {
            imageGamer = ImageIO.read(fileNameImageGamer);
            imageWall = ImageIO.read(fileNameImageWall);
            imageBox = ImageIO.read(fileNameImageBox);
            imageGoal = ImageIO.read(fileNameImageGoal);
            imageFloor = ImageIO.read(fileNameImageFloor);
            backgroundImage = ImageIO.read(fileNameImageBackground);
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(backgroundImage, 0, 0, null);
        drawDesktop(g);
    }

    private void drawDesktop(Graphics g) {
        int [][] desktop = model.getDesktop();
        int start = 20;
        int x = start;
        int y = start;
        int width = 50;
        int height = 50;
        int offset = 0;

        for (int i = 0; i < desktop.length; i++) {
            for (int j = 0; j < desktop[i].length; j++) {
                if (desktop[i][j] == 1) {
                    g.drawImage(imageGamer, x, y, null);
                } else if (desktop[i][j] == 2) {
                    g.drawImage(imageWall, x, y, null);
                } else if (desktop[i][j] == 3) {
                    g.drawImage(imageBox, x, y, null);
                } else if (desktop[i][j] == 4) {
                    g.drawImage(imageGoal, x, y, null);
                } else if (desktop[i][j] == 5) {
                    g.drawImage(imageFloor, x, y, null);
                } else {
                    g.setColor(canvasColor);
                    g.fillRect(x, y, width, height);
                }
                x = x + width + offset;
            }
            x = start;
            y = y + height + offset;
        }
    }
}
