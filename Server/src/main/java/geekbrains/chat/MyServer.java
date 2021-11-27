package geekbrains.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
    public static void main(String[] args) {
        Socket socket = null;
        Scanner scanner = new Scanner(System.in);
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидает подключения клиента... ");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился.");
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            String str, massage;

            new Thread(()->{

            }).start();

            while (true) {
                str = scanner.nextLine();
                outputStream.writeUTF(str);
                massage = inputStream.readUTF();
                if (!str.equals(null))System.out.println("[Server] " + str);
                if (!massage.equals(null))System.out.println("[Client] " + massage);
                            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
