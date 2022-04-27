package ru.gb.cartapi.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.cartapi.dto.CartDto;
import ru.gb.cartapi.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CartService {

    private CartDto cartDto;

    public CartDto createCart(CartDto cartDto) {
        return this.cartDto = cartDto;
    }

    public List<ProductDto> allProductInCart() {
        if (cartDto == null) {
            return new ArrayList<>();
        }
        return cartDto.getProductsDto();
    }

    public ProductDto addProductInCart(ProductDto productDto) {

        if (cartDto.getProductsDto() != null) {
            cartDto.getProductsDto().add(productDto);
        } else {
            cartDto.setProductsDto(new ArrayList<>());
            cartDto.getProductsDto().add(productDto);
        }
        return productDto;
    }

    public void deleteFromCartById(Long id) {
        for (ProductDto prod : cartDto.getProductsDto()) {
            if (prod.getId().equals(id)) {
                cartDto.getProductsDto().remove(prod);
                return;
            }
        }
    }

    public void deleteCart() {
        cartDto = null;
    }
}
