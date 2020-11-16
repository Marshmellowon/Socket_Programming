package com.company;

import com.company.client.SimpleChatClient;
import com.company.client.SimpleClient;
import com.company.client.SimpleFileTransferClient;


public class Main {
    public static void main(String[] args) {
        // write your code here
       /* SimpleClient client = new SimpleClient();
        client.run("117.16.243.99", 5000);*/
        /*SimpleChatClient client = new SimpleChatClient();
        client.start();*/

        new SimpleFileTransferClient().start();

    }
}
