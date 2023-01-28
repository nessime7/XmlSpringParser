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
        // zdefiniowanie zmiennej file jako nowy obiekt MockMultipartFile z poniższymi parametrami
        final var file = new MockMultipartFile("file", "users.xml",
                MediaType.TEXT_PLAIN_VALUE,
                this.getClass().getClassLoader().getResourceAsStream("user/users.xml"));

        // when
        // zdefiniowanie zmiennej result jako wynik metody process z parametrem file uruchomionej z xmlService,
        // zmienna typu List<User>.
        var result = xmlService.processXmlFile(file);

        // then
        // sprawdzamy czy imię pierwszego użystkownika to "Kalle Anka"
        assertEquals(result.get(0).getName(), "Kalle Anka");
        assertEquals(result.get(0).getUsername(), "donaldd");
        assertEquals(result.get(0).getEmail(), "donald@email.dt");

        assertEquals(result.get(1).getName(), "Joakim von Anka");
        assertEquals(result.get(1).getUsername(), "onkelscrooge");
        assertEquals(result.get(1).getEmail(), "scrooge@email.dt");

        assertEquals(result.get(2).getName(), "Arne Anka");
        assertEquals(result.get(2).getUsername(), "arneanka");
        assertEquals(result.get(2).getEmail(), "arne@email.com");

        // sprawdzamy czy rozmiar naszego pliku to 3 użytkowników
        assertEquals(result.size(), 3);
    }
}