package XmlSpringParser.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlUsers {

        @XmlElement(name = "user")
        List<XmlUser> users = new ArrayList<XmlUser>();

        public List<XmlUser> getUsers() {
                return users;
        }

        public void setUsers(List<XmlUser> users) {
                this.users = users;
        }
}
