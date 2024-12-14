package org.example.demo_jdbc_api.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;



@Repository
public class ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    public  final String fetchProductSql;


    //автоматически создается  спрингом NamedParameterJdbcTemplate и передается в конструктор
    @Autowired
    public ProductRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.fetchProductSql = read("fetch_product.sql");
    }

//метод для извлечения имени продукта из базы данных на основе переданного имени.
    public String getProductName(String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        try {
            return jdbcTemplate.queryForObject(fetchProductSql, params, String.class);
        } catch (DataAccessException e) {
            // Логирование ошибки
            e.printStackTrace();
            throw new RuntimeException("Ошибка при выполнении запроса к базе данных", e);
        }
    }

    //используется для чтения содержимого файла с SQL запросом и возвращения его в виде строки
    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))){
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
