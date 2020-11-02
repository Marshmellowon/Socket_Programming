package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public void Socket() throws IOException {
        ServerSocket server = new ServerSocket(5000);
        Socket client = server.accept();

        BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
        String str = br.readLine();

        PrintWriter pw = new PrintWriter(client.getOutputStream(), true);
        pw.println("hello world");
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("helo world");
    }
}
