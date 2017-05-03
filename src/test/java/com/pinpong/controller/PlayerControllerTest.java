package com.pinpong.controller;

import com.pinpong.model.Player;
import com.pinpong.service.PingPongService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.assertj.core.api.BDDAssertions.then;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"management.port=0"})
public class PlayerControllerTest {

    @LocalServerPort
    private int port;

    @Value("${local.management.port}")
    private int mgt;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private PingPongService pingPongService;

    @Test
    public void shouldReturn200WhenSendingRequestToController() throws Exception {

        given(this.pingPongService.getAllPlayer()).willReturn(new ArrayList<Player>());
        @SuppressWarnings("rawtypes")
        ResponseEntity<String> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port +
                "/pinpong/findAllPlayer", String.class);

        then(entity.getStatusCodeValue()).isEqualTo(HttpStatus.OK.value());
    }


}
