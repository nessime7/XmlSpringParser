package XmlSpringParser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

// Adnotacja która służy do wskazania, że klasa powinna być traktowana jako element główny dokumentu XML
@XmlRootElement(name = "users")
// Adnotacja  określa, w jaki sposób pola i właściwości klasy
// powinny być powiązane z elementami i atrybutami XML, tutaj poprzez pola
@XmlAccessorType(XmlAccessType.FIELD)
// publiczna klasa Document
public class Document {

        // Adnotacja w celu wskazania, że pole lub właściwość powinny
        // być zorganizowane jako element XML, tutaj dostosowujemy nazwę elementu
        @XmlElement(name = "user")
        // zdefiniowanie prywatnego finalnego pola obiektu users typu List zawierającą Users
        // oraz przypisanie do niej nowej ArrayList
        private final List<User> users = new ArrayList<User>();

        // metoda getUsers typu List zawierającą User, ma zwracać z prywatnego
        // pola obiektu users.
        public List<User> getUsers() {
                return users;
        }
}