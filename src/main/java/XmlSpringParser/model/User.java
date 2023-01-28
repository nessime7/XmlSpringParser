package XmlSpringParser.model;

import javax.xml.bind.annotation.*;
// tak jak w Document
@XmlRootElement(name = "user")
// tak jak w Document
@XmlAccessorType(XmlAccessType.FIELD)
public class User {
    // tak jak w Document, dostosowujemy nazwę pola obiektu name
    @XmlElement(name = "name")
    // prywatne pole obiektu name typu String
    private String name;
    // dostosowujemy nazwę pola obiektu email
    @XmlElement(name = "email")
    // prywatne pole obiektu email typu String
    private String email;
    // dostosowujemy nazwę pola obiektu username
    @XmlElement(name = "username")
    private String username;

    // metoda getName zwracająca name typu String z prywatnego pola obiektu
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