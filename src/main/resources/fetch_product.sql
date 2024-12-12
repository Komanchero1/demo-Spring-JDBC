SELECT product_name -- поиск продукта по имени покупателя
FROM USER1.ORDERS
WHERE LOWER(product_name) = LOWER(:name);