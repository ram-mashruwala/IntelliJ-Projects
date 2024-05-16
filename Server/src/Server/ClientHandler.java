package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    private Socket client;
    private BufferedReader in;
    private PrintWriter out;
    ArrayList<ClientHandler> clients;

    private static String[] names = {"Wily", "Felix", "Carlsbad", "Hobob"};
    private static String[] adjs1 = {"the gentle", "the un-gentle", "the overwrought", "the urbane"};

    public ClientHandler(Socket clientSocket, ArrayList<ClientHandler> clients) throws IOException {

        client = clientSocket;
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(), true);
        this.clients = clients;

    }

    @Override
    public void run() {

        try {
            while (true) {
                String request = in.readLine();
                if (request.contains("name")) {
                    String name = getRandomName();
                    System.out.println("[SERVER] Sending name.");
                    out.println(name);
                } else if(request.startsWith("say")){
                    int firstSpace = request.indexOf(" ");
                    if(firstSpace != -1){
                        outToAll(request.substring(firstSpace + 1));
                    }
                } else {
                    out.println("Type 'tell me a name' to get a random name");
                }
            }
        } catch (IOException e){
            System.err.println("IO exception in client handler");
            System.err.println(e.getStackTrace());
        } finally {
            System.out.println("[SERVER] Client disconnected");

            out.close();
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void outToAll(String msg) {

        for(ClientHandler aClient : clients){
            aClient.out.println(msg);
        }

    }

    public static String getRandomName(){

        String name = names[(int) (Math.random() * names.length)];
        String adjs = adjs1[(int) (Math.random() * adjs1.length)];
        return name + " " + adjs;

    }

}
