INSERT INTO user (id, username, password, number_of_logins) values (1,'mockUser1','mockPass1',0);
INSERT INTO user (id, username, password, number_of_logins) values (2,'mockUser2','mockPass2',0);
INSERT INTO user (id, username, password, number_of_logins) values (3,'mockUser3','mockPass3',0);
INSERT INTO user (id, username, password, number_of_logins) values (4,'mockUser4','mockPass4',0);

INSERT INTO product_group (id, name) values (1,'mockSavings');
INSERT INTO product_group (id, name) values (2,'mockPayments');
INSERT INTO product_group (id, name) values (3,'mockMortgage');


INSERT INTO product (id, name, user_id, product_group_id) values (1, 'mock Orange savings account', 1, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (2, 'mock Child savings account', 1, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (3, 'mock Orange savings for unicef', 1, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (4, 'mock Orange savings account', 2, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (5, 'mock Child savings account', 2, 1);
INSERT INTO product (id, name, user_id, product_group_id) values (6, 'mock Orange savings account', 3, 1);


INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (1, 1, 'NL21INGB1234567001', 1201, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (2, 2, 'NL21INGB1234567002', 1202, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (3, 3, 'NL21INGB1234567003', 1203, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (4, 4, 'NL21INGB1234567004', 1204, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (5, 5, 'NL21INGB1234567005', 1205, 0);
INSERT INTO product_details (id, product_id, account, balance,number_of_hits) values (6, 6, 'NL21INGB1234567006', 1206, 0);
commit;