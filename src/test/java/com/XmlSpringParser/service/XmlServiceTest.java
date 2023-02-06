package com.XmlSpringParser.service;

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
        final var file = new MockMultipartFile("file", "users.xml",
                MediaType.TEXT_PLAIN_VALUE,
                this.getClass().getClassLoader().getResourceAsStream("user/users.xml"));

        // when
        var result = xmlService.processXmlFile(file);

        // then
        assertEquals(result.get(0).getName(), "Kalle Anka");
        assertEquals(result.get(0).getUsername(), "donaldd");
        assertEquals(result.get(0).getEmail(), "donald@email.dt");

        assertEquals(result.get(1).getName(), "Joakim von Anka");
        assertEquals(result.get(1).getUsername(), "onkelscrooge");
        assertEquals(result.get(1).getEmail(), "scrooge@email.dt");

        assertEquals(result.get(2).getName(), "Arne Anka");
        assertEquals(result.get(2).getUsername(), "arneanka");
        assertEquals(result.get(2).getEmail(), "arne@email.com");

        assertEquals(result.size(), 3);
    }
}