package com.agustinhp.stockCodingame.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.agustinhp.stockCodingame.dto.PriceDto;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PricesServiceTestSteps {

    private static final Logger LOGGER = LoggerFactory.getLogger(PricesServiceTestSteps.class);

    @Autowired
    private PriceService priceService;

    private LocalDateTime date;
    private PriceDto price;

    @Given("A price with date {string}")
    public void givenPrice(String date) throws Throwable {
        this.date = parseDate(date).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    @When("I check the product {int} and brand {int}")
    public void whenCheckProductAndBrand(Integer productId, Integer brandId) throws Throwable {
        LOGGER.info("DATE: {}", date);
        price = priceService.getPrice(date, Long.valueOf(productId), Long.valueOf(brandId));
    }

    @Then("The system returns the price {double}")
    public void thenReturnsPrice(Double price) throws Throwable {
        LOGGER.info("PRICE: {}", this.price);
        assertEquals(price, this.price.getPrice());
    }

    @And("The system returns priceList {int}")
    public void andReturnsAmount(int priceList) throws Throwable {
        assertEquals(priceList, price.getPriceList());
    }

    private Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
        } catch (ParseException e) {
            return new Date();
        }
    }
}
