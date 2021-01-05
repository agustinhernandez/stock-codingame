package com.agustinhp.stockCodingame.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = -845997586556040099L;

    @Id
    private Long id;

}
