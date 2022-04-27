package ru.gb.cartapi.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDto {

    private Long cartId;
    private String status = "not empty";
    private List<ProductDto> productsDto;
}
