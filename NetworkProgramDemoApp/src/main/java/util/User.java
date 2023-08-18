/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Scanner;

/**
 *
 * @author user
 */
public class User {
    private String name;
    private String surname;
    private int id;

    public User() {
    }

    public User(int id,String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public static void userRegistration() throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.print("Zehmet olmasa adinizi daxil edin : ");
        String name = sc.nextLine();
        System.out.print("Zehmet olmasa soyadinizi daxil edin : ");
        String surname = sc.nextLine();
        System.out.print("Zehmet olmasa id - nizi daxil edin : ");
        int id = sc.nextInt(); 
        
        User user = new User(id,name,surname);
        printUserData(user);
    }
    public static void exit(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Proqramdan chixmaq isteyirsinizmi ? y/n");
        String res = sc.nextLine();
            
        if(res.equalsIgnoreCase("y")){
            System.exit(0);
        }
    }
    public static void printUserData(User user){
         System.out.println("Id -si  : " + user.getId());
         System.out.println("Adi  : " + user.getName());
         System.out.println("Soyadi  : " + user.getSurname());
            
    }
    
}