import java.io.*;
import java.net.Socket;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8080);
        System.out.println("connected");
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message1 = "";
        String message2 = "";
        while (!message1.equals("exit connection")){
            System.out.println("enter message: ");
            message1 = br.readLine();
            dos.writeUTF(message1);
            dos.flush();
            message2 = dis.readUTF();
            System.out.println("server: " + message2);
        }
        br.close();
        dos.close();
        dis.close();
        socket.close();


    }
}
