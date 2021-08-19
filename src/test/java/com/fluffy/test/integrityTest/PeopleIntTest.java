package com.fluffy.test.integrityTest;


import com.fluffy.test.controller.PeopleDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeopleIntTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void greetingShouldReturnDefaultMessage() {
        PeopleDto dto = new PeopleDto();
        dto.setEmail("fluffy@fluffy.fluf");
        dto.setName("fluffy");

        Assertions.assertThat(this.restTemplate.postForEntity("http://localhost:" + port + "/people",
                dto, Void.class)).matches( x -> x.getStatusCode().is2xxSuccessful() );
    }

}
