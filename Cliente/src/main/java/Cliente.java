import java.io.*;
import java.net.*;

public class Cliente {
    public static void main(String[] args) {
        String servidor = "127.0.0.1";
        int puerto = 20020;

        try (Socket socket = new Socket(servidor, puerto)) {
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String mensaje = reader.readLine();
            System.out.println("Mensaje proveniente del nodo: " + mensaje);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
