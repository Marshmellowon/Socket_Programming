package com.company.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleChatClient {
    public class RecvHandler implements Runnable {

        private BufferedReader br;

        public RecvHandler(Socket socket) {
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            /*수신부*/
            try {
                while (true) {
                    String message = br.readLine();
                    System.out.println("[RECV]: " + message);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void start() {
        try {
            Socket socket = new Socket("117.16.243.99", 5000);
            Scanner sc = new Scanner(System.in); /*inputStream*/

            PrintWriter pw = new PrintWriter(socket.getOutputStream());

            RecvHandler handler = new RecvHandler(socket);
            Thread t = new Thread(handler);
            t.start();

            while (true) {
                /*송신부*/
                String message = sc.nextLine();
                pw.println(message);
                pw.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
