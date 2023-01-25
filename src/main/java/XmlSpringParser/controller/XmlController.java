package XmlSpringParser.controller;

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

@RestController
public class XmlController {

    private final XmlService xmlService;

    @Autowired
    public XmlController(XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> processXmlFile(@RequestParam("file") MultipartFile file) throws IOException, JAXBException {
        String message = "";
        try {
            final var result = xmlService.processXmlFile(file);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "! You need to parse XML File.";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }
}

//    final var jaxbContext = JAXBContext.newInstance(XmlUsers.class);
//    final var jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//    final var users = (XmlUsers) jaxbUnmarshaller.unmarshal(file.getInputStream());
//    final var result = users.getUsers();
//    final var objectMapper = new ObjectMapper();
//        return objectMapper.writeValueAsString(result);

// My first converter and it returns text
//        // convertFile pusty
//        File convertFile = new File("C:/Users/sarap/data/" + file.getOriginalFilename());
//        // stworzenie
//        convertFile.createNewFile();
//        // przetransferowanie file do convertFile
//    //    file.transferTo(convertFile);
//        // uruchomienie parsera na convertFile
//        final var parsedMessage = new XmlParser().parser(convertFile);
//        // wyświetlenie wiadomości
//   //     new XmlPrinter().print(parsedMessage);
//        // próba
//        try (FileOutputStream fout = new FileOutputStream(parsedMessage)) {
//            fout.write(file.getBytes());
//        } catch (Exception exe) {
//            exe.printStackTrace();
//        }
//        return parsedMessage;
//    }
//}

// Converter to copy my file to different direction
//    @PostMapping("/upload")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
//        File convertFile = new File("C:/Users/sarap/data/" + file.getOriginalFilename());
//        convertFile.createNewFile();
//        try (FileOutputStream fout = new FileOutputStream(convertFile)) {
//            fout.write(file.getBytes());
//
//        }
//        catch (Exception exe) {
//            exe.printStackTrace();
//        }
//        return "File has uploaded successfully";