package com.agustinhp.stockCodingame.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.agustinhp.stockCodingame.domain.enums.Currency;

import lombok.Data;

@Data
@Entity
public class Price implements Serializable {

    private static final long serialVersionUID = -3240833732417436967L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(nullable = false)
    private LocalDateTime startDate;

    @Column(nullable = false)
    private LocalDateTime endDate;

    @Column(nullable = false)
    private Long priceList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private int priority;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false, name = "curr")
    @Enumerated(EnumType.STRING)
    private Currency currency;

}
