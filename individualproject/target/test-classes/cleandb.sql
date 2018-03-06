DELETE FROM Pictures WHERE id > 0;
DELETE FROM Restaurant WHERE id > 0;
INSERT INTO Restaurant (id, name, location, phone_number)VALUES (1,"restaurant1", "restaurant location", "phonenumber");
INSERT INTO Restaurant (id, name, location, phone_number)VALUES (2,"restaurant2", "restaurant location", "phonenumber");
INSERT INTO Restaurant (id, name, location, phone_number)VALUES (3,"restaurant3", "restaurant location", "phonenumber");
INSERT INTO Pictures (id, picture, restaurant_id, user_id) VALUES (1,"picture1.jpg", 1, 2);
INSERT INTO Pictures (id, picture, restaurant_id, user_id) VALUES (2,"picture2.jpg", 1, 2);
INSERT INTO Pictures (id, picture, restaurant_id, user_id) VALUES (3,"picture3.jpg", 1, 2);