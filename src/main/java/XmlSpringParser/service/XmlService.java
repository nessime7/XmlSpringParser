package XmlSpringParser.service;

import XmlSpringParser.model.Document;
import XmlSpringParser.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;


@Service
public class XmlService {
    // metoda zwraca Listę Userów, jako parametr MultipartFile, całą resztę rozpisywałam już wcześniej
    public List<User> processXmlFile(MultipartFile file) throws JAXBException, IOException {
        final var jaxbContext = JAXBContext.newInstance(Document.class);
        final var jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        final var users = (Document) jaxbUnmarshaller.unmarshal(file.getInputStream());
        return users.getUsers();
    }
}