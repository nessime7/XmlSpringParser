package com.XmlSpringParser.controller;

import com.XmlSpringParser.model.User;
import com.XmlSpringParser.service.XmlService;
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
    public ResponseEntity<List<User>> processXmlFile(@RequestParam("file") MultipartFile file) throws IOException, JAXBException {
        final var result = xmlService.processXmlFile(file);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}