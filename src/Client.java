import java.net.*;
import java.io.*;
import java.util.Scanner;

// Client sends to a server messages


public class Client {
    Socket sock;
    PrintWriter writer;
    Scanner scan;

    public void run() {

        scan = new Scanner(System.in);
        try {
            System.out.println("Connecting to server...");
            sock = new Socket("127.0.0.1", 5000);
            System.out.println("Server is connected!");
            writer = new PrintWriter(sock.getOutputStream());

            String line = "";
            while(!line.equals("q")) {
                line = scan.nextLine();
                writer.println(line);
                writer.flush();
            }

            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }

}
