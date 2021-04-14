package kul.pl;

//Klient

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Klient {
    public static void main(String[] args) {

        List<String> lista = new ArrayList<String>();
        lista.add("Klient 1");
        lista.add("Klient 2");
        lista.add("Klient 3");
        try{
            Socket socket = new Socket("localhost", 7000);

            for(int i=0; i<lista.size(); i++)
            {
                System.out.println(lista.get(i) + ": ");
                PrintWriter pr = new PrintWriter(socket.getOutputStream(), true);
                Scanner scan = new Scanner(System.in);
                var sentence = scan.next();
                pr.println(sentence);
                System.out.println("Wiadomość została wysłana do serwera!");


                InputStreamReader input = new InputStreamReader(socket.getInputStream());
                BufferedReader br = new BufferedReader(input);

                String message = br.readLine();
                System.out.println("Serwer : " + message);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}





