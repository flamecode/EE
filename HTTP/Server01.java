package HTTP;




import sun.nio.cs.US_ASCII;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Игорь
 * 21.02.2017.
 */
public class Server01 {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(81); // Тот, кто cлушает соединение. ждёт сообщений. 80 - HTTP
        while (true) {
            Socket socket = serverSocket.accept(); // TCP handshake. Висеть в методе пока не установлено TCP соединение, и не получен сокет
            try (InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream()) {
                byte[] request = HttpUtils.readRequestFully(in);
                System.out.print(new String(request, "US-ASCII"));
                byte[] response = new Date().toString().getBytes("US-ASCII");
                out.write(response);
            }
            finally{
                socket.close();
            }
        }
    }
}
