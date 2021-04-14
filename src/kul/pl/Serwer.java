package kul.pl;

//Serwer

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Serwer {
    public static void main(String[] args) {

        List<String> lista = new ArrayList<String>();
        lista.add("Klient 1");
        lista.add("Klient 2");
        lista.add("Klient 3");

        try {
            ServerSocket serverSocket = new ServerSocket(7000);
            System.out.println("Czekam na połączenie z klientem...");
            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("Połączono !!!");

                for(int i=0; i<lista.size(); i++)
                {
                    InputStreamReader input = new InputStreamReader(socket.getInputStream());
                    BufferedReader br = new BufferedReader(input);

                    String message = br.readLine();
                    System.out.println(lista.get(i) + ": " + message);
                    System.out.println("Serwer: ");
                    PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
                    Scanner scan = new Scanner(System.in);
                    var sentence = scan.next();
                    pr.println(sentence);
                    System.out.println("Wiadomość została wysłana do " + lista.get(i) + " !");
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
