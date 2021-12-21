package com.example.test.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.lang.Nullable;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDTO {

    private List<ProductDTO> products;
    private String paymentType;
    @Nullable
    private Integer addressId;

}
