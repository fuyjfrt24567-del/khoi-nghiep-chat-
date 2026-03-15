import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Server {

    JFrame frame;
    JTextArea chatArea;
    JTextField chatField;

    BufferedReader in;
    PrintWriter out;

    public Server() throws Exception {

        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("Server started...");

        Socket socket = serverSocket.accept();

        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        out = new PrintWriter(socket.getOutputStream(), true);

        frame = new JFrame("Chat Server");

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        chatField = new JTextField();

        frame.setLayout(new BorderLayout());

        frame.add(new JScrollPane(chatArea), BorderLayout.CENTER);
        frame.add(chatField, BorderLayout.SOUTH);

        frame.setSize(400,400);
        frame.setVisible(true);

        chatField.addActionListener(e -> {

            String msg = chatField.getText();

            chatArea.append("Server: " + msg + "\n");

            out.println(msg);

            chatField.setText("");

        });

        while(true){

            String msg = in.readLine();

            chatArea.append("Client: " + msg + "\n");

        }
    }

    public static void main(String[] args) throws Exception {

        new Server();

    }
}