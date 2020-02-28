INSERT INTO user (id, username, password, number_of_logins) values (1,'test1','test1',0);
INSERT INTO user (id, username, password, number_of_logins) values (2,'test2','test2',0);
INSERT INTO user (id, username, password, number_of_logins) values (3,'test3','test3',0);
INSERT INTO user (id, username, password, number_of_logins) values (4,'test4','test4',0);

INSERT INTO product_group (id, name) values (1,'Savings');
INSERT INTO product_group (id, name) values (2,'Payments');
INSERT INTO product_group (id, name) values (3,'Mortgage');


INSERT INTO product (id, name, user_id, product_group_id) values (1, 'Orange savings account', 1, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (2, 'Child savings account', 1, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (3, 'Orange savings for unicef', 1, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (4, 'Orange savings account', 2, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (5, 'Child savings account', 2, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (6, 'Orange savings account', 3, 1);


INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (1, 1, 'NL21INGB1234567890', 3456, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (2, 2, 'NL21INGB2234567890', 4456, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (3, 3, 'NL21INGB3234567890', 5456, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (4, 4, 'NL21INGB4234567890', 6456, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (5, 5, 'NL21INGB5234567890', 7456, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (6, 6, 'NL21INGB6234567890', 8456, 0);
commit;