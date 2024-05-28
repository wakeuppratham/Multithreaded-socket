import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public void run() throws IOException {
        int port = 8010;
        ServerSocket serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
        
        
        while (true) {
            try {
                System.out.println("Server is Listening on port "+port);
                Socket acceptedConnection = serverSocket.accept();
                System.out.println("Connection accepted from client " + acceptedConnection.getRemoteSocketAddress());
                
                PrintWriter toClient = new PrintWriter(acceptedConnection.getOutputStream(), true);
                BufferedReader fromClient = new BufferedReader(new InputStreamReader(acceptedConnection.getInputStream()));
                
                String clientMessage = fromClient.readLine();
                System.out.println("Message from client: " + clientMessage); // Print the message from the client
                
                toClient.println("Hello from the server");
                
                toClient.close();
                fromClient.close();
                acceptedConnection.close();

            } catch (java.net.SocketTimeoutException ste) {
                System.out.println("Socket timeout, no connection within the time limit. Continuing to listen...");
            }  catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        try {
            server.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
