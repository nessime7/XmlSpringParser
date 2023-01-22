package XmlSpringParser.service;

import XmlSpringParser.model.XmlUsers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public class XmlService {
    public String handleFileUpload(MultipartFile file) throws JAXBException, IOException {

        return null;
    }
}
