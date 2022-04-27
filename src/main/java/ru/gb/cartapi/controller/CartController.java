package ru.gb.cartapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.cartapi.dto.CartDto;
import ru.gb.cartapi.dto.ProductDto;
import ru.gb.cartapi.service.CartService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/create")
    public CartDto createCart(@RequestBody CartDto cartDto) {
        cartService.createCart(cartDto);
        return cartDto;
    }

    @GetMapping
    public List<ProductDto> getProductListInCart() {
        return cartService.allProductInCart();
    }

    @DeleteMapping("/deleteCart")
    void deleteCart() {
        cartService.deleteCart();
    }

    @PostMapping("/add")
    public ResponseEntity<ProductDto> addProductInCart(@RequestBody ProductDto productDto) {
        ProductDto prodDto = productDto;
        if (productDto != null) {
            cartService.addProductInCart(productDto);
            return new ResponseEntity<>(productDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{productId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductFromCart(@PathVariable("productId") Long id) {
        cartService.deleteFromCartById(id);
    }

}
