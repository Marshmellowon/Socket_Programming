package com.company.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleFileTransferClient extends JFrame implements ActionListener {
    public void start() {
        /*process fin*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*set size*/
        this.setSize(400, 200);
        this.setTitle("File Transfer");
        /*component 추가*/
        JPanel panel = new JPanel();

        JLabel label = new JLabel("IP");
        JTextField jTextField = new JTextField("글자 입력");
        JButton jButton = new JButton("click");
        jButton.addActionListener(this);
        panel.add(label);
        panel.add(jTextField);
        panel.add(jButton);
        this.add(panel);

        JPanel mid = new JPanel();
        JButton transfer = new JButton("파일전송");
        mid.add(transfer);
        this.add(mid);

        JLabel state = new JLabel("상태 메세지");
        this.add(state);

        /*layout 설정*/
        this.setLayout(new GridLayout(0, 1));

        /*visible*/
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("hello");
        System.out.println(e.getActionCommand());
        System.out.println(e.getWhen());
        System.out.println(e.paramString());
        System.out.println(e.getSource());
        System.out.println(e.getID());
    }
}
