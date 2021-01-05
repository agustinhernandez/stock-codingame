package com.agustinhp.stockCodingame.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.agustinhp.stockCodingame.dto.PriceDto;
import com.agustinhp.stockCodingame.service.PriceService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("prices")
public class PriceController {

    @Autowired
    private PriceService priceService;

    @GetMapping
    public List<PriceDto> listPrices() {
        return priceService.listPrices();
    }

    @GetMapping("/{productId}")
    public PriceDto getPrice(@PathVariable Long productId, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd_HH:mm:ss") LocalDateTime date,
            @RequestParam Long brandId) {
        return priceService.getPrice(date, productId, brandId);
    }

}
