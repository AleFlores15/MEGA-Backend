package com.mega.back.api;

import com.mega.back.model.ProductDto;
import com.mega.back.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @Autowired
    MockMvc mvc;

    @MockitoBean
    ProductService service;

    @Test
    void list_returnsProducts() throws Exception {
        Mockito.when(service.listAll()).thenReturn(List.of(
                new ProductDto("CA-BOB", "Caja de Ahorro", "BOB")
        ));

        mvc.perform(get("/api/products"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].code").value("CA-BOB"))
                .andExpect(jsonPath("$[0].currency").value("BOB"));
    }

    @Test
    void get_returns404_whenNotFound() throws Exception {
        Mockito.when(service.findByCode("X")).thenReturn(Optional.empty());
        mvc.perform(get("/api/products/X"))
                .andExpect(status().isNotFound());
    }
}
