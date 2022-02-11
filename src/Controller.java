import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener, ActionListener {

    private Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case 37:
                model.move("Left");
                break;
            case 38:
                model.move("Up");
                break;
            case 39:
                model.move("Right");
                break;
            case 40:
                model.move("Down");
                break;
            default:
                return;
        }
    }
    public void keyReleased(KeyEvent event) {}
    public void keyTyped(KeyEvent event) {}

    public Model getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        model.doAction(command);
    }
}
