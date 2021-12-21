package com.example.test.dto;

import com.example.test.data.ProductCost;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CalculatedCartDTO {

    private List<ProductCost> productCostList;
    private Float sum;
}