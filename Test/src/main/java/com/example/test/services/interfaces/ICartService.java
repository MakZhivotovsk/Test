package com.example.test.services.interfaces;

import com.example.test.dto.CalculatedCartDTO;
import com.example.test.dto.CartDTO;

public interface ICartService {
    CalculatedCartDTO calculateCart(CartDTO cartDTO);
}
