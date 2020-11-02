package com.company.client;

import java.io.*;
import java.net.Socket;

public class SimpleClient {
    public void run(String ip, int port) {
        /*socket*/
        /*connect*/
        try {
            Socket socket = new Socket(ip, port);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = br.readLine();
            System.out.println(message);

            /*송신은 outputstream*/
            String str = "hello world";

            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);// true auto flush 기능
            pw.println("hello world");

            new DataOutputStream(socket.getOutputStream()).writeLong(8);
            pw.flush();

            /*3번째 부터 b.length개만 보냄*/
            /*byte[] b = str.getBytes();
            socket.getOutputStream().write(b, 3, b.length);
*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}