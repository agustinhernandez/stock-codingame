package com.agustinhp.stockCodingame.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.agustinhp.stockCodingame.domain.Price;
import com.agustinhp.stockCodingame.dto.PriceDto;
import com.agustinhp.stockCodingame.exception.PriceNotExistsException;
import com.agustinhp.stockCodingame.repository.PriceRepository;

@Service
public class PriceService {

    @Autowired
    private PriceRepository priceRepository;

    public PriceDto getPrice(LocalDateTime date, Long productId, Long brandId) {
        Sort sort = Sort.by(Sort.Direction.DESC, "priority");
        List<Price> prices = priceRepository.findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(productId, brandId, date,
                date, sort);

        if (prices.isEmpty()) {
            throw new PriceNotExistsException(productId);
        }

        return domainToDto(prices.get(0));
    }

    public List<PriceDto> listPrices() {
        return ((List<Price>) priceRepository.findAll()).stream().map(this::domainToDto).collect(Collectors.toList());
    }

    private PriceDto domainToDto(Price price) {
        return new PriceDto() {
            {
                setBrandId(price.getBrand().getId());
                setProductId(price.getProduct().getId());
                setStartDate(Date.from(price.getStartDate().atZone(ZoneId.systemDefault()).toInstant()));
                setEndDate(Date.from(price.getEndDate().atZone(ZoneId.systemDefault()).toInstant()));
                setPrice(price.getPrice().doubleValue());
                setPriceList(price.getPriceList());
            }
        };
    }

}
