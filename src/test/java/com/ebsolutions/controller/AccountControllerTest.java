package com.ebsolutions.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.RxHttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MicronautTest
@DisplayName("Account Controller")
//@ExtendWith(MockitoExtension.class)
public class AccountControllerTest {
    @Inject
    @Client("/")
    RxHttpClient client;

//    @Mock
//    AccountRepository accountRepository;

    @Test
    @DisplayName("should return the correct account")
    public void getAccount() {
        HttpRequest<String> request = HttpRequest.GET("/account/123");
        String body = client.toBlocking().retrieve(request);

        assertNotNull(body);
        String expectedResult = "{\"accountId\":1,\"accountNumber\":\"123\",\"accountOwner\":\"Aaron Sisler\",\"accountBalance\":0.0}";
        assertEquals(expectedResult, body);
    }
}