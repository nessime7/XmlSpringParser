package com.XmlSpringParser.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "user")

@XmlAccessorType(XmlAccessType.FIELD)
public class User {

    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "username")
    private String username;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }
}