package controller;

import Service.JPAUsers;
import Service.JPAUsersImpl;
import model.User;

import java.util.ArrayList;
import java.util.List;

public class Server {
    private String method;
    private String url = "http://localhost:8080/api/users";
    private final String versionProtocol = "HTTP/1.1";
    private String headers;

    private String body;
    private int id;//para consultas por Id

    @Autowired
    private JPAUsers user;//principio de Inversión de Dependencias (IoD)

    public Server(String method, String url, String headers, String body) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.user = new JPAUsersImpl();//una referencia q se ha creado en el constructor de la clase Server JPAUsersImpl
        //validamos que tipo de Método nos llegó al servidor

        switch (method) {
            case "GET":
                if (url.equals("http://localhost:8080/api/users")) {
                    GetUsers();
                }
                if (url.equals("http://localhost:8080/api/users")) {
                    GetUserById(1);
                }
                break;
            case "POST":
                if (url.equals("http://localhost:8080/api/users")) {
                    PostUser(body);
                }
                break;


            default:
                System.out.println("Método no soportado");
                break;
        }


    }//fin si


    public Server(String method, String url, String headers, String body, int id) {
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.body = body;
        this.id = id;
        this.user = new JPAUsersImpl();//una referencia q se ha creado en el constructor de la clase Server JPAUsersImpl

        switch (method) {
            case "PUT":
                if (url.equals("http://localhost:8080/api/users")) {
                    PutUserById(body, id);
                }
                break;
            case "DELETE":
                if (url.equals("http://localhost:8080/api/users")) {
                    DeleteUserById(id);
                }
                break;
            case "GET":
                if (url.equals("http://localhost:8080/api/users")) {
                    GetUserById(id);
                }
                break;
            default:
                System.out.println("Método no soportado");
                break;
        }


    }//end constructor


    String GetUsers() {
        user.readAll();
        String response = versionProtocol + " 200 Ok\r\n" +
                "Content-Type: application/json\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;
        return response;

    }

    String GetUserById(int id) {
        String response = versionProtocol + " 200 OK\n" +
                "Content-Type: application/json\r\n" +
                "Content-Length: " + id + "\r\n";
        user.findById(id);
        return response;
    }

    public String PostUser(@RequestBody String body) {
        user.create(body);//acá estamos haciendo la inyección de dependencias

        String response = versionProtocol + " 201 Created\r\n" +
                "Content-Type: application/json\r\n" +
                "Content-Length: " + body.length() + "\r\n" +
                "\r\n" +
                body;
        return response;
    }


    private void DeleteUserById(int i) {
        user.deleteById(id);
    }

    private void PutUserById(@RequestBody String body, @RequestBody int i) {
        user.updateById(body, id);
    }


    @Override
    public String toString() {
        return "Server{" +
                "url='" + url + '\'' +
                ", headers='" + headers + '\'' +
                ", method='" + method + '\'' +
                ",\n body='" + body + '\'' +

                '}';

    }


}