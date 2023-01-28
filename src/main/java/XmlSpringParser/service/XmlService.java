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
    // metoda zwraca Listę Userów, jako parametr MultipartFile, metoda może wyrzucić wyjątek typu IOException, JAXBException
    public List<User> processXmlFile(MultipartFile file) throws JAXBException, IOException {
        // zdefiniowanie finalnej zmiennej jaxContext i przypisanie do niej wyniku metody
        // newInstance uruchomionej na klasie JAXBContext z parametrem Document.class
        final var jaxbContext = JAXBContext.newInstance(Document.class);
        // zdefiniowanie finalnej zmiennej jaxbUnmarshaller i przypisanie do niej
        // wyniku metody createUnmarshaller uruchomionej na zmiennej jaxbContext
        final var jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        // zdefiniowanie finalnej zmiennej users i przypisanie do niej wyniku metody unmarshal uruchomionej
        // na zmiennej jaxbUnmarshaller z parametrami wyniku metody getInputStream uruchomionej
        // na zmiennej file
        // nie wiem co oznacza tutaj "(Document)"
        final var users = (Document) jaxbUnmarshaller.unmarshal(file.getInputStream());
       // zwrócenie wyniku metody getUsers wywołanej na zmiennej users
        return users.getUsers();
    }
}