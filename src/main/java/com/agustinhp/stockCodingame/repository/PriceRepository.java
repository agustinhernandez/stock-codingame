package com.agustinhp.stockCodingame.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.agustinhp.stockCodingame.domain.Price;

public interface PriceRepository extends PagingAndSortingRepository<Price, Long> {

    public List<Price> findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Long productId, Long brandId,
            LocalDateTime startDate, LocalDateTime endDate, Sort sort);

}
