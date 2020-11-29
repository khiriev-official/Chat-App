import java.io.*;
import java.net.*;

// Server recieves messages and outputs them in console

public class Server {
    ServerSocket serverSock;
    Socket clientSock;
    int messageCount = 0;

    public void run() {
        try {
            serverSock = new ServerSocket(5000);
            System.out.println("Server is running");
            clientSock = serverSock.accept();
            System.out.println("Client is connected");
            InputStreamReader inputStream = new InputStreamReader(clientSock.getInputStream());
            BufferedReader reader = new BufferedReader(inputStream);
            while(true) {
                String message = reader.readLine();
                System.out.println("Message №" + messageCount + ": " + message);
                messageCount++;
                if (clientSock.isClosed()){
                    System.out.println("Client is disconnected.");
                    break;
                }
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }

}
