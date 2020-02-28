DROP TABLE IF EXISTS user;
CREATE TABLE user(id integer PRIMARY KEY,
   username VARCHAR (50) UNIQUE NOT NULL,
   password VARCHAR (50) NOT NULL,
   number_of_logins integer NOT NULL
);
DROP TABLE IF EXISTS product_group;
CREATE TABLE product_group(
   id integer PRIMARY KEY,
   name VARCHAR (50) UNIQUE NOT NULL
);
DROP TABLE IF EXISTS product;
CREATE TABLE product
(
  id integer PRIMARY KEY,
  name VARCHAR (50),
  user_id integer NOT NULL,
  product_group_id integer NOT NULL,
CONSTRAINT user_id_fkey FOREIGN KEY (user_id)
      REFERENCES user(id) ,
CONSTRAINT product_group_id_fkey FOREIGN KEY (product_group_id)
      REFERENCES product_group(id)
);
DROP TABLE IF EXISTS product_details;
CREATE TABLE product_details
(
  id integer PRIMARY KEY,
  product_id integer NOT NULL,
  account VARCHAR (50),
  balance integer,
  number_of_hits integer,
  interest_rate NUMERIC (5, 2),
  interest_earned NUMERIC (5, 2),
  CONSTRAINT product_id_fkey FOREIGN KEY (product_id)
      REFERENCES product(id)
);