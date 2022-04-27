package ru.gb.cartapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class CartApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(CartApiApplication.class, args);
    }

}
