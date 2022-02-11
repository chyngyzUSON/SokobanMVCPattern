import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

public class LevelsFromServer {

    public synchronized static int[][] getLevelFromServer(int level) {
        try {
            Socket socket = null;
            ObjectOutputStream outputStream = null;
            ObjectInputStream inputStream = null;

//            socket = new Socket("194.152.37.7", 4446);
            socket = new Socket("192.168.0.109", 4446); //my IP

            outputStream = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            outputStream.writeInt(level);
            outputStream.flush();

            inputStream = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            int[][] myMessageArray = (int[][]) inputStream.readObject();

            inputStream.close();
            outputStream.close();
            socket.close();
            return myMessageArray;

        } catch (IOException | ClassNotFoundException ioe) {
            System.out.println("Error: " + ioe);
        }
        System.out.println("Close connection");
        return null;
    }
}
