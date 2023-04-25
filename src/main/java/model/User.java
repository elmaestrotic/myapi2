package model;

import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger count = new AtomicInteger(0);
    private   int id=0;
    private String names;
    private String email;
    private String phone;

    public User(int id,String names, String email, String phone) {
        this.id = count.incrementAndGet();
        //this.setId(id++);//sino se le asigna el id, el id siempre será el mismo
        //User.id=id;//incrementamos el id automaticamente cada vez que se cree un nuevo usuario
        this.names = names;
        this.email = email;
        this.phone = phone;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
       this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}