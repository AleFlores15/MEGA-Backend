package com.mega.back.service;

import com.mega.back.model.ProductDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private static final List<ProductDto> PRODUCTS = List.of(
            new ProductDto("CA-BOB", "Caja de Ahorro", "BOB"),
            new ProductDto("DPF-UFV", "Depósito a Plazo Fijo", "UFV"),
            new ProductDto("CC-USD", "Cuenta Corriente", "USD")
    );

    @Override
    public List<ProductDto> listAll() {
        return PRODUCTS;
    }

    @Override
    public Optional<ProductDto> findByCode(String code) {
        return PRODUCTS.stream().filter(p -> p.code().equalsIgnoreCase(code)).findFirst();
    }
}
