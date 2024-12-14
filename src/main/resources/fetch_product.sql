SELECT product_name
FROM CLIENT.client_data
         JOIN CLIENT.ORDERS ON CLIENT.client_data.id = CLIENT.ORDERS.customer_id
WHERE LOWER(CLIENT.client_data.name) = LOWER(:name);
