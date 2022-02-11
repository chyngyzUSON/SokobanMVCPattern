package ServerSokoban;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSokoban {

    private ServerSocket serverSocket;

    public ServerSokoban(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void runServer() {
        while(true) {
            try {
                System.out.println("The Server has been started and waiting a client ... ");
                Socket clientSocket = serverSocket.accept();
                ClientSokobanGame clientSokobanGame = new ClientSokobanGame(clientSocket);
                clientSokobanGame.sendLevelToClient();
            } catch(IOException ioe) {
                System.out.println(ioe);
            }
        }
    }

    public static void main(String[] args) {
        ServerSokoban serverMain = new ServerSokoban(4446);
        serverMain.runServer();
    }
}
