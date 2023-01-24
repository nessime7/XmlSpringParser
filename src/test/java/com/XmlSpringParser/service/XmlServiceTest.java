package com.XmlSpringParser.service;

import XmlSpringParser.service.XmlService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XmlServiceTest {

    private final XmlService xmlService = new XmlService();

    @Test
    void should_return_users() throws IOException, JAXBException {
        // given
        MockMultipartFile file = new MockMultipartFile("file", "users.xml",
                MediaType.TEXT_PLAIN_VALUE,
                this.getClass().getClassLoader().getResourceAsStream("user/users.xml"));

        // when
        var result = xmlService.processXmlFile(file);

        // then
        assertEquals(result, "[{\"name\":\"Kalle Anka\",\"email\":\"donald@email.dt\",\"username\":\"donaldd\"},{\"name\":\"Joakim von Anka\",\"email\":\"scrooge@email.dt\",\"username\":\"onkelscrooge\"},{\"name\":\"Arne Anka\",\"email\":\"arne@email.com\",\"username\":\"arneanka\"}]");
    }

}