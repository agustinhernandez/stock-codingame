package com.agustinhp.stockCodingame.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.agustinhp.stockCodingame.domain.Brand;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Long> {

}
