package XmlSpringParser.controller;

import XmlSpringParser.model.User;
import XmlSpringParser.service.XmlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RestController
public class XmlController {

    private final XmlService xmlService;

    @Autowired
    public XmlController(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @PostMapping("/upload")
    // metoda processXmlFile typu ResponseEntity zawierającego typ List z User, z parametrami typu MultipartFile
    // z adnotacją @RequestParam z parametrem "file", metoda może wyrzucić wyjątek typu IOException, JAXBException
    public ResponseEntity<List<User>> processXmlFile(@RequestParam("file") MultipartFile file) throws IOException, JAXBException {
     // przypisanie do zmiennej result wyniku metody processXmlFile uruchomionej z parametrem file
        final var result = xmlService.processXmlFile(file);
        // zwrócenie nowej klasy ResponseEntity z parametrem result oraz polu klasy OK na referencji klasy HttpStatus
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}