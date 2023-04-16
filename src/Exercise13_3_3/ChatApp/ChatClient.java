package Exercise13_3_3.ChatApp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

class ChatClient implements Runnable {
    Socket socket;
    Scanner in;
    PrintStream out;
    ChatServer server;

    public ChatClient(Socket socket, ChatServer server) {
        this.socket = socket;
        this.server = server;

        // Launching new thread.
        new Thread(this).start();
    }

    // Receives a message from the server/client
    void receive(String message){
        out.println("User: " + message);
    }

    public void run() {
        try {
            // Creating IO streams
            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            // Creating IO tools.
            in = new Scanner(is);
            out = new PrintStream(os);

            // App Greeting.
            out.println("Welcome to Chat.");

            // User interaction.
            String input = in.nextLine();
            while (!input.equals("bye")) {
                server.sendAll(input);
                input = in.nextLine();
            }

            // Closing the socket(client).
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
