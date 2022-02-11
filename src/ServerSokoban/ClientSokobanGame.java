package ServerSokoban;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientSokobanGame implements Runnable {

    private Thread thread;
    private Socket clientSocket;

    public ClientSokobanGame(Socket clientSocket) {
        this.clientSocket = clientSocket;
        thread = new Thread(this);
    }

    public void sendLevelToClient() {
        thread.start();
    }

    public void run() {
        try {

            ObjectInputStream inputStream = new ObjectInputStream(new BufferedInputStream(clientSocket.getInputStream()));
            int level = inputStream.readInt();
            System.out.println("Client is waiting level : " + level);

            ObjectOutputStream outputStream = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
            if (level < 20) {
                switch (level) {
                    case 7:
                        outputStream.writeObject(LevelsForClient.getSeventhLevel());
                        break;
                    case 8:
                        outputStream.writeObject(LevelsForClient.getEightLevel());
                        break;
                    case 9:
                        outputStream.writeObject(LevelsForClient.getNinthLevel());
                        break;
                    default:
                        outputStream.writeObject(LevelsForClient.getDefaultLevel());
                }
            }
            outputStream.close();
            inputStream.close();
            clientSocket.close();
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
}