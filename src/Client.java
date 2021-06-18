import java.net.*;
import java.io.*;
import java.util.Scanner;


public class Client {
    Socket sock;
    PrintWriter writer;
    Scanner scan;

    public void run() throws IOException {

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
        } catch (ConnectException ex) {
            System.out.print("Connection failed. Give it another try? Y/N: ");
            String choice = scan.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                run();
            } else {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.run();
    }

}
