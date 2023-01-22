package com.XmlSpringParser;

import XmlSpringParser.XmlSpringParserApplication;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = {XmlSpringParserApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class XmlControllerTest {


//        given().contentType(ContentType.XML)
//                .body(TestUtils.getRequestBodyFromFile("users.xml", CONTEXT))
//                .when().post("/upload")
//                .then()
//                .statusCode(HttpStatus.SC_OK)
//                .and()
//                .body("", equalTo(TestUtils.getPath("response/return-users.json", CONTEXT).get("")));
//    }
    }