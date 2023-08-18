/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Server {
    
    public static void serverWork() throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.print("Zehmet olmasa portu daxil edin : ");
        int port = scanner.nextInt();
        
        ServerSocket outFirstServerSocket = new ServerSocket(port);
        
        while(true){
           System.out.println("Yeni client uchun gozleyirem......");
           Socket connection = outFirstServerSocket.accept();
           System.out.println("Urra yeni musteri geldi....");
           
           DataInputStream dataStream = new DataInputStream(connection.getInputStream());
           byte[] bytesArray = readMessageBytes(dataStream);
           FileUtility.writeBytes( "/Users/user/Desktop/Yeni Dokument.docx",bytesArray);
           
        }
    }
    public static byte[] readMessageBytes(DataInputStream din) throws Exception{
        int msgLen = din.readInt();
        byte[] msg = new byte[msgLen];
        
        din.readFully(msg);
        return msg;
    }
    
    public static void server() throws Exception{
        ServerSocket outFirstServerSocket = new ServerSocket(6789);
        
        while(true){
           System.out.println("Yeni client uchun gozleyirem......");
           Socket connection = outFirstServerSocket.accept();
           System.out.println("Urra yeni musteri geldi....");
           
           DataInputStream dataStream = new DataInputStream(connection.getInputStream());
           byte[] bytesArray = readMessageBytes(dataStream);
           System.out.println("Message length : " + bytesArray.length);
           FileUtility.writeBytes( "/Users/user/Desktop/Yeni Dokument.docx",bytesArray);
        }
    }
}
