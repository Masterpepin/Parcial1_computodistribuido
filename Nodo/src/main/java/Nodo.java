import java.io.*;
import java.net.*;

public class Nodo {
    public static void main(String[] args) {
        int puerto = 31010;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Nodo esperando conexiones en el puerto " + puerto + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado desde " + socket.getInetAddress());

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println("Se ha establecido conexión al nodo");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
