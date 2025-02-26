import java.io.*;
import java.net.*;

public class Nodo {
    public static void main(String[] args) {

        int puerto = 20020;

        try (ServerSocket serverSocket = new ServerSocket(puerto)) {
            System.out.println("Nodo listo y recibiendo" + puerto + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Conexión recibida desde: " + socket.getInetAddress());
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);
                writer.println("Conexión establecida");

                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
