package com.driver.model;

import javax.persistence.*;

public class Connection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // child of service provider
    @ManyToOne
    @JoinColumn
    private ServiceProvider serviceProvider;

    // child of user class
    @ManyToOne
    @JoinColumn
    private User user;


    public Connection() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
