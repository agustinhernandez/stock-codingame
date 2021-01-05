package com.agustinhp.stockCodingame.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Brand implements Serializable {

    private static final long serialVersionUID = -653747305957236961L;

    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

}
