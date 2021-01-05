package com.agustinhp.stockCodingame.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.agustinhp.stockCodingame.dto.PriceDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(PriceControllerTest.class);

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPriceList() throws Exception {
        List<PriceDto> prices = restTemplate
                .exchange("http://localhost:" + port + "/prices", HttpMethod.GET, null, new ParameterizedTypeReference<List<PriceDto>>() {
                }).getBody();

        LOGGER.info("List [{}]", prices);

        assertNotNull(prices);

        LOGGER.info("size = [{}]", prices.size());
        assertEquals(4, prices.size());
    }

    @Test
    public void testPriceByProductId() throws Exception {
        Map<String, String> pathVars = new HashMap<>();
        pathVars.put("productId", "35455");

        ResponseEntity<PriceDto> response = restTemplate.exchange(
                "http://localhost:" + port + "/prices/{productId}?date=2020-11-29_00:00:00&brandId=1", HttpMethod.GET, null, PriceDto.class,
                pathVars);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        PriceDto price = response.getBody();
        LOGGER.info("price = [{}]", price);

        assertNotNull(price);
        assertEquals(4, price.getPriceList());
    }

    @Test
    public void testPriceByProductIdNotExistsBadRequest() throws Exception {
        Map<String, String> pathVars = new HashMap<>();
        pathVars.put("productId", "1234");

        ResponseEntity<Map<String, String>> response = restTemplate.exchange(
                "http://localhost:" + port + "/prices/{productId}?date=2020-11-29_00:00:00&brandId=1", HttpMethod.GET, null,
                new ParameterizedTypeReference<Map<String, String>>() {
                }, pathVars);

        LOGGER.info("exception=[{}]", response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
