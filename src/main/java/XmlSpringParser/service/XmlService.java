package XmlSpringParser.service;

import XmlSpringParser.model.Document;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class XmlService {
    public String processXmlFile(MultipartFile file) throws JAXBException, IOException {
        final var jaxbContext = JAXBContext.newInstance(Document.class);
        final var jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        final var users = (Document) jaxbUnmarshaller.unmarshal(file.getInputStream());
        final var result = users.getUsers();
        final var objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }
}