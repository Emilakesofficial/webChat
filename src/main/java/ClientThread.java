import java.io.*;
import java.net.Socket;

public class ClientThread implements Runnable {
    private final Socket clientSocket1;
    private final Socket clientSocket2;

    public ClientThread(Socket clientSocket1, Socket clientSocket2) {
        this.clientSocket1 = clientSocket1;
        this.clientSocket2 = clientSocket2;
    }

    @Override
    public void run() {
        try {

            DataInputStream dis1 = new DataInputStream(clientSocket1.getInputStream());
            DataOutputStream dos1 = new DataOutputStream(clientSocket1.getOutputStream());
            DataInputStream dis2 = new DataInputStream(clientSocket2.getInputStream());
            DataOutputStream dos2 = new DataOutputStream(clientSocket2.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


//            PrintWriter out1 = new PrintWriter(clientSocket1.getOutputStream(), true);
//            BufferedReader in1 = new BufferedReader(new InputStreamReader(clientSocket1.getInputStream()));
//            PrintWriter out2 = new PrintWriter(clientSocket2.getOutputStream(), true);
//            BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket2.getInputStream()));
            String message1 = "";
            String message2 = "";

            String text1 = "";
            String text2 = "";
        while (true) {
           message1 = dis1.readUTF();
            System.out.println("client1 : " + message1);
            message2 = br.readLine();
            dos1.writeUTF(message2);
            dos1.flush();

                while (true){
                    if (!text1.equals("exit connection")){
                        text1 = br.readLine();
                        dos2.writeUTF(text1);
                        dos2.flush();
                        text2 = dis2.readUTF();
                        System.out.println("client2: " + text2);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//            while ((message = in1.readLine()) != null) {
//                System.out.println("client1: " + message);
//                out1.println(message);
//
//                String text1 = "";
//                String text2 = "";
//                while ((text1 = in2.readLine()) != null) {
//                    System.out.println("client2: " + text1);
//                    out2.println(text1);
//
//
