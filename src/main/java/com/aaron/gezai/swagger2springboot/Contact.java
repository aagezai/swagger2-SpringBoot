package com.aaron.gezai.swagger2springboot;

/**
 * this contact class is simply Contact a pojo class
 * with id , name, phone.
 */
public class Contact {
    private String id;
    private  String name;
    private String phone;
    //

    /**
     * the no-arg constructor
     */
    public Contact() {

    }

    /**
     *
     * The Getters and Setters
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
