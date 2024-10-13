import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        while (true) {
            ServerSocket serverSocket = new ServerSocket(8080);
            System.out.println("server running");
            Socket socket1 = serverSocket.accept();
            Socket socket2 = serverSocket.accept();
            ClientThread clientThread = new ClientThread(socket1,socket2);
            clientThread.run();
        }


//        DataInputStream dis1 = new DataInputStream(socket1.getInputStream());
//        DataInputStream dis2 = new DataInputStream(socket1.getInputStream());
//        DataOutputStream dos1 = new DataOutputStream(socket1.getOutputStream());
//        DataOutputStream dos2 = new DataOutputStream(socket1.getOutputStream());
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        String message1 = "";
//        String message2 = "";
//
//        String text1 = "";
//        String text2 = "";
//        while (!message1.equals("Stop connection")) {
//           message1 = dis1.readUTF();
//            System.out.println("client1 : " + message1);
//            message2 = br.readLine();
//            dos1.writeUTF(message2);
//            dos1.flush();
//
//            text1 = dis2.readUTF();
//            System.out.println("client2 : " + text1);
//            text2 = br.readLine();
//            dos1.writeUTF(text2);
//            dos1.flush();
//        }
//        dis1.close();
//        socket1.close();
//        serverSocket.close();

    }
}
