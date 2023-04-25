package org.narvasoft;

import controller.Server;
import model.User;

public class Main {
    public static void main(String[] args) {
        Server request = new Server("POST", "http://localhost:8080/api/users", "Content-Type: application/json", "Yeshúa,narva@gmail.com,123456789");

        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------------");
        request = new Server("POST", "http://localhost:8080/api/users", "Content-Type: application/json", "Sophia,gug@gmail.com,3021564");
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------------");

        request = new Server("POST", "http://localhost:8080/api/users", "Content-Type: application/json", "Sarah,sarah@gmail.com,303330");
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------------");


        request = new Server("GET", "http://localhost:8080/api/users", "Content-Type: application/json", "");
        System.out.println(request);//respuesta del servidor

        System.out.println("---------------------------------------------------");
        request = new Server("PUT", "http://localhost:8080/api/users", "Content-Type: application/json", "Sophia,gug@gmail.com,5555", 2);
        System.out.println(request);//respuesta del servidor
        System.out.println("---------------------------------------------------");

        request = new Server("DELETE", "http://localhost:8080/api/users", "Content-Type: application/json", "",2);

        System.out.println("---------------------------------------------------");
        request = new Server("GET", "http://localhost:8080/api/users", "Content-Type: application/json", "",1);
    }
}