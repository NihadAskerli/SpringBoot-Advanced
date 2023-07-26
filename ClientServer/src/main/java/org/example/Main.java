package org.example;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
messageClient();
    }
    public static void messageClient() throws IOException {
        Socket socket= new Socket("localhost",6789);
        OutputStream outputstream =socket.getOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(outputstream);
        Scanner scanner=new Scanner(System.in);
        System.out.println("istediyiniz msj yaza bilersiniz:");
        String clientMessage=scanner.nextLine();
        outputstream.write(clientMessage.getBytes());
        socket.close();
    }
    public static void photoAsByte() throws IOException {
        Socket socket= new Socket("localhost",6789);
        OutputStream outputstream =socket.getOutputStream();
        DataOutputStream dataOutputStream=new DataOutputStream(outputstream);
        byte[] bytes=FileUtility.readbytes("C:\\Users\\Nahid\\Pictures\\Just Trust\\3.png");
        dataOutputStream.writeInt(bytes.length);
        dataOutputStream.write(bytes);
        socket.close();
    }
}