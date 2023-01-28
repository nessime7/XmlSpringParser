package com.XmlSpringParser.service;

import XmlSpringParser.service.XmlService;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import javax.xml.bind.JAXBException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;


class XmlServiceTest {

    // zdefiniowanie prywatnego, finalnego pola obiektu xmlService typu XmlService i przypisanie do niej
    // nowej klasy XmlService bez parametrów
    private final XmlService xmlService = new XmlService();

    @Test
    void should_return_users() throws IOException, JAXBException {
        // given
        // zdefiniowanie zmiennej file typu MockMultipartFile jako nowy obiekt MockMultipartFile z poniższymi parametrami
        final var file = new MockMultipartFile("file", "users.xml",
                MediaType.TEXT_PLAIN_VALUE,
                this.getClass().getClassLoader().getResourceAsStream("user/users.xml"));

        // when
        // zdefiniowanie zmiennej result jako wynik metody process z parametrem file uruchomionej z xmlService,
        // zmienna typu List<User>.
        var result = xmlService.processXmlFile(file);

        // then
        // sprawdzenie czy wynik metody getName uruchomionej na pierwszym obiekcie result równa się "Kelly Anka"
        assertEquals(result.get(0).getName(), "Kalle Anka");
        assertEquals(result.get(0).getUsername(), "donaldd");
        assertEquals(result.get(0).getEmail(), "donald@email.dt");

        assertEquals(result.get(1).getName(), "Joakim von Anka");
        assertEquals(result.get(1).getUsername(), "onkelscrooge");
        assertEquals(result.get(1).getEmail(), "scrooge@email.dt");

        assertEquals(result.get(2).getName(), "Arne Anka");
        assertEquals(result.get(2).getUsername(), "arneanka");
        assertEquals(result.get(2).getEmail(), "arne@email.com");

        // sprawdzamy czy wynik metody size uruchomionej na zmiennej result = 3
        assertEquals(result.size(), 3);
    }
}