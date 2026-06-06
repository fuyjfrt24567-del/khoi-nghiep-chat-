import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Client {

    JFrame frame;
    JTextArea chatArea;
    JTextField chatField;

    BufferedReader in;
    PrintWriter out;

    public Client() throws Exception {

        Socket socket = new Socket("localhost",9999);

        in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        out = new PrintWriter(socket.getOutputStream(),true);

        frame = new JFrame("Chat Client");

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        chatField = new JTextField();

        frame.setLayout(new BorderLayout());

        frame.add(new JScrollPane(chatArea),BorderLayout.CENTER);
        frame.add(chatField,BorderLayout.SOUTH);

        frame.setSize(400,400);
        frame.setVisible(true);

        chatField.addActionListener(e -> {

            String msg = chatField.getText();

            chatArea.append("Me: " + msg + "\n");

            out.println(msg);

            chatField.setText("");

        });

        new Thread(() -> {
    try {
        while(true){
            String msg = in.readLine();
            chatArea.append("Server: " + msg + "\n");
        }
    } catch(Exception e){
        e.printStackTrace();
    }
}).start();
    }

    public static void main(String[] args) throws Exception {

        new Client();

    }
}