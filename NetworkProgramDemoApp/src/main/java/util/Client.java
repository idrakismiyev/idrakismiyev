/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Client {
 
    
    public static void clientWork() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Bu datani göndermek istediyiniz şexsin(serverin) ip ve portunu daxil edin :");
        String str = sc.nextLine();
        
        String[] arr = str.split(":");
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);
         
        Socket clientSocket = new Socket(ip,port);  
        OutputStream out = clientSocket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(out);
     
        byte[] bytes =  FileUtility.readBytes("C:\\Users\\user\\Desktop\\Java Nəzəri Biliklər Üçün Qeydlər\\1 -ci ay Java qeydləri.docx");
        long len = bytes.length;
        dataOutputStream.writeInt((int) len);
        dataOutputStream.write(bytes);
        clientSocket.close();
    }
    
    public static void client()throws Exception{
        Socket clientSocket = new Socket("localhost",6789);  
        OutputStream out = clientSocket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(out);
        
        byte[] bytes =  FileUtility.readBytes("D:\\Idrakin Faylları\\Word faylları\\1 -ci ay Java qeydləri.docx");
        long len = bytes.length;
        dataOutputStream.writeInt((int) len);
        dataOutputStream.write(bytes);
        clientSocket.close();
    }
}
