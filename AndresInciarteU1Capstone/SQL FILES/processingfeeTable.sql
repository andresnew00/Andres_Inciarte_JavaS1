SELECT * FROM game_store_test.processing_fee;
-- this will add the values to the processing fee table 
INSERT INTO `game_store`.`processing_fee` (`product_type`, `fee`) VALUES ('consoles', '14.99');
INSERT INTO `game_store`.`processing_fee` (`product_type`, `fee`) VALUES ('T-shirts', '1.98');
INSERT INTO `game_store`.`processing_fee` (`product_type`, `fee`) VALUES ('Games', '1.49');