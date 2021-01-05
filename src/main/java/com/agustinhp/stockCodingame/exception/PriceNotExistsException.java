package com.agustinhp.stockCodingame.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PriceNotExistsException extends RuntimeException {

    private static final long serialVersionUID = -8546823088744648473L;

    public PriceNotExistsException(Long productId) {
        super("Not exists a price for product: " + productId);
    }

}
