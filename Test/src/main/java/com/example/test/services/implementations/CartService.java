package com.example.test.services.implementations;

import com.example.test.data.ProductCost;
import com.example.test.data.ProductCostEntity;
import com.example.test.dto.CalculatedCartDTO;
import com.example.test.dto.CartDTO;
import com.example.test.dto.ProductDTO;
import com.example.test.exception.CostNotFoundException;
import com.example.test.gateway.IExtMsGatewayService;
import com.example.test.services.interfaces.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService implements ICartService {

    @Autowired
    IExtMsGatewayService extMsGatewayService;

    public CalculatedCartDTO calculateCart(CartDTO cartDTO) {
        ProductCostEntity productCostEntity = getP(cartDTO.getProducts());
        if (productCostEntity == null || productCostEntity.getProductCostList() == null) {
            throw new CostNotFoundException();
        }
        Float sum = productCostEntity.getProductCostList().stream()
                .map(ProductCost::getCost)
                .reduce(0f, Float::sum);
        return new CalculatedCartDTO(productCostEntity.getProductCostList(), sum);
    }

    @Cacheable(cacheNames = "productCost")
    public ProductCostEntity getP(List<ProductDTO> products) {
        return extMsGatewayService.getProductCost(products);
    }

}
