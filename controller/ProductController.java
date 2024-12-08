package org.example.demo_jdbc_api.controller;

import org.example.demo_jdbc_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController { //класс для обработки запросов

    private final ProductRepository productRepository;//экземпляр класса ProductRepository

    @Autowired
    public ProductController(ProductRepository productRepository) { //внедрение в конструктор зависимости ProductRepository
        this.productRepository = productRepository; //открываются возможности использования методов репозитория
    }

    @GetMapping("/products/fetch-product") // указывает что по этому запросу будет вызван метод fetchProducts
    public String fetchProducts(@RequestParam String name) {
        return productRepository.getProductName(name); // будет возвращено имя продукта
    }
}
