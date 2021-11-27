import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Chat {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8189);
        Scanner scanner = new Scanner(System.in);
        DataInputStream inputStream = new DataInputStream(socket.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
        Thread thread = new Thread(() -> {
            try {
                String str, massage;
                while (true) {
                    str = scanner.nextLine();
                    outputStream.writeUTF(str);
                    massage=inputStream.readUTF();
                    if (!str.equals(null))System.out.println("[Client] " + str);
                    if (!massage.equals(null))System.out.println("[Server] " + massage);

                }

            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
        thread.start();

    }
}
