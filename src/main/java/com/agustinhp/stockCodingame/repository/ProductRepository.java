package com.agustinhp.stockCodingame.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.agustinhp.stockCodingame.domain.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
