package com.mega.back.service;

import com.mega.back.model.ProductDto;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductDto> listAll();
    Optional<ProductDto> findByCode(String code);
}
