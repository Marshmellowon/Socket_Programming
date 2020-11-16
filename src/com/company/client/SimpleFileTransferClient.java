package com.company.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class SimpleFileTransferClient extends JFrame implements ActionListener {
    JTextField jTextField;
    JButton jButton;
    JLabel state;
    Socket socket;


    public void start() {
        /*process fin*/
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*set size*/
        this.setSize(400, 200);
        this.setTitle("File Transfer");
        /*component 추가*/
        JPanel panel = new JPanel();

        JLabel label = new JLabel("IP");
        jTextField = new JTextField("117.16.243.99");
        jButton = new JButton("click");
        jButton.addActionListener(this);
        panel.add(label);
        panel.add(jTextField);
        panel.add(jButton);
        this.add(panel);

        JPanel mid = new JPanel();
        JButton transfer = new JButton("파일전송");
        transfer.addActionListener(this);
        mid.add(transfer);
        this.add(mid);

        state = new JLabel("상태 메세지");
        this.add(state);

        /*layout 설정*/
        this.setLayout(new GridLayout(0, 1));

        /*visible*/
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            switch (e.getActionCommand()) {
                case "click" -> {
                    state.setText(String.format("서버 %s 에 연결 합니다.\n", jTextField.getText()));
                    socket = new Socket(jTextField.getText(), 5000);
                    state.setText("연결되었습니다.");
                    jButton.setEnabled(false);
                }
                case "파일전송" -> {
                    JFileChooser chooser = new JFileChooser();
                    int ret = chooser.showOpenDialog(null);
                    String path = chooser.getSelectedFile().getPath();
                    String filename = chooser.getSelectedFile().getName();
                    File file = new File(path);
                    FileInputStream inputStream = new FileInputStream(file);

                    DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

                    /*파일 길이 명시, 파일명 전송*/
                    dos.writeLong(filename.getBytes().length);
                    dos.write(filename.getBytes());

                    long size = file.length();
                    /*파일크기*/
                    dos.writeLong(file.length());
                    byte[] buffer = new byte[1024];
                    while (size != 0) {
                        int nRead = inputStream.read(buffer, 0, buffer.length);
                        dos.write(buffer, 0, nRead);
                        size -= nRead;
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            state.setText("ERROR");
        }
    }
}
