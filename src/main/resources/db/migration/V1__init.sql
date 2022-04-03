create table products (id bigserial primary key, title varchar(255), price int);

insert into products (title, price) values
('Acana', 1300),
('Sanabelle', 1100),
('Royal Canin', 900),
('Whiskas', 600),
('Orijen', 1500);

create table cart(id bigserial primary key, product_id int);