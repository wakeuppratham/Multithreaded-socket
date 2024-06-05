import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
    private static class ClientRunnable implements Runnable {
        @Override
        public void run() {
            int port = 8010;
            try {
                InetAddress address = InetAddress.getByName("localhost");
                Socket socket = new Socket(address, port);
                
                PrintWriter toSocket = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader fromSocket = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                toSocket.println("Hello from Client " + socket.getLocalSocketAddress());
                String line = fromSocket.readLine();
                System.out.println("Response from Server " + line);

                toSocket.close();
                fromSocket.close();
                socket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            try {
                Thread thread = new Thread(new ClientRunnable());
                thread.start();
            } catch (Exception ex) {
                return;
            }
        }
        return;
    }
}
