package com.XmlSpringParser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")

@XmlAccessorType(XmlAccessType.FIELD)
public class Document {

        @XmlElement(name = "user")
        private final List<User> users = new ArrayList<>();

        public List<User> getUsers() {
                return users;
        }
}