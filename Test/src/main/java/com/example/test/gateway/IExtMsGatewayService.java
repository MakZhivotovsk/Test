package com.example.test.gateway;

import com.example.test.data.ProductCostEntity;
import com.example.test.dto.ProductDTO;

import java.util.List;

public interface IExtMsGatewayService {
    ProductCostEntity getProductCost(List<ProductDTO> products);
}