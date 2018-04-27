DELETE FROM Pictures WHERE id > 0;
DELETE FROM Restaurant WHERE id > 0;
INSERT INTO Restaurant (id, name, location, phone_number)VALUES (1,"restaurant1", "restaurant location", "phonenumber");
INSERT INTO Restaurant (id, name, location, phone_number)VALUES (2,"restaurant2", "restaurant location", "phonenumber");
INSERT INTO Restaurant (id, name, location, phone_number)VALUES (3,"restaurant3", "restaurant location", "phonenumber");
INSERT INTO Pictures (id, picture, restaurant_id, user_id, comment) VALUES (1,"https://upload.wikimedia.org/wikipedia/commons/thumb/3/34/Meatball_pizza.jpg/1200px-Meatball_pizza.jpg", 1, 2, "comment");
INSERT INTO Pictures (id, picture, restaurant_id, user_id, comment) VALUES (2,"https://www.fooduciary.com/images/raw-pad-thai-with-kelp-noodles.jpg", 1, 2, "comment");
INSERT INTO Pictures (id, picture, restaurant_id, user_id, comment) VALUES (3,"https://static.olocdn.net/menu/chilis/7c80251dc318055715aa8b25cd5c3517.jpg", 1, 2, "comment");