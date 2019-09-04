### northwind

-- What are the categories of products in the database?
SELECT products.category FROM northwind.products;
-- What products are made by Dell?
SELECT * FROM northwind.products WHERE product_name LIKE '%Dell%';
-- List all the orders shipped to Pennsylvania.
SELECT * FROM northwind.orders WHERE ship_state = 'Pennsylvania';
-- List the first name and last name of all employees with last names that start with w
SELECT * FROM northwind.employees WHERE last_name LIKE 'W%';
-- List all customers from zipcodes that start with 55
SELECT * FROM northwind.customers WHERE postal_code LIKE '55%';
-- List all customers from zipcodes that end with 0
SELECT * FROM northwind.customers WHERE postal_code LIKE '%0';
-- List the first name, last name, and email for all customers with a .org email address
SELECT first_name, last_name, email FROM northwind.customers WHERE email LIKE '%.org';
-- List the first name, last name, and phone number for all customers from the 202 area code
SELECT first_name, last_name, phone FROM northwind.customers WHERE phone LIKE '%202%';
-- List the order id for each order placed by George Wilson
SELECT orders.id
FROM northwind.orders 
INNER JOIN northwind.customers ON orders.customer_id = customers.id
WHERE customers.first_name = 'George' AND customers.last_name = 'Wilson'; 
-- List all the products and quantities associated with order 4003
SELECT products.product_name, order_details.quantity
FROM northwind.products
INNER JOIN order_details ON order_details.product_id = products.id
WHERE order_details.order_id = '4003';


### car_lot

-- Add the following cars to inventory:
    -- 2012 Red Honda Accord
    INSERT INTO car_lot.car (id, make, model, model_year, color)
	VALUES (34, 'Honda', 'Accord', '2012', 'Red'),
	-- 2017 Black Chevy Impala
	 (35, 'Chevy', 'Impala', '2017', 'Black'),
    -- 2019 Siver Ford F-150
	 (36, 'Ford', 'F-150', '2019', 'Silver'),
    -- 2020 White Subaru Outback
	 (37, 'Subaru', 'Outback', '2020', 'White'),
    -- 2015 Silver Ford Mustang
	 (38, 'Ford', 'Mustang', '2015', 'Silver'),
    -- 2018 Blue Honda Ridgeline
	 (39, 'Honda', 'Ridgeline', '2018', 'Blue'),
    -- 2017 Gray Chevy Silverado
	 (40, 'Chevy', 'Silverado', '2017', 'Gray');
-- Make the following updates to the database:
    -- Change all Hondas to Black
    UPDATE car_lot.car SET color = 'Black' WHERE car.make = 'Honda';
    -- Change 'Chevy' to 'Chevrolet'
    UPDATE car_lot.car SET make = 'Chevrolet' WHERE car.make = 'Chevy';
    -- Change all 2020 model years to 2019
    UPDATE car_lot.car SET model_year = '2019' WHERE car.model_year = '2020';
-- Delete the following:
    -- Delete all blue inventory
    DELETE FROM car_lot.car WHERE color = 'Blue';
    -- Delete all Fords
    DELETE FROM car_lot.car WHERE make = 'Ford';
    -- Delete all cars from 2012 and 2017
    DELETE FROM car_lot.car WHERE model_year BETWEEN 2012 AND 2017;



 