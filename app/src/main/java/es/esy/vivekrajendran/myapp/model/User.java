/**
 * Copyright will updated soon
 */

package es.esy.vivekrajendran.myapp.model;

public class User {


    private String name;
    private String email;
    private String password;
    private int id;
    private String description;

    public User(String name, String email, String description, int id) {
        this.name = name;
        this.email = email;
        this.description = description;
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

}
