create table categories (
  id     bigserial primary key,
  title  varchar(255),
  created_at timestamp default current_timestamp,
  updated_at timestamp default current_timestamp
);

create table products (
  id         bigserial primary key,
  title      varchar(255),
  price      numeric(8, 2),
  category_id bigint references categories (id),
  created_at timestamp default current_timestamp,
  updated_at timestamp default current_timestamp
  );

insert into categories (title) values
('Эконом класс'),
('Премиум класс'),
('Cупер-премиум класс'),
('Холистик');

insert into products (title, price, category_id) values
('Acana', 1300.00, 4),
('Sanabelle', 1100.00, 3),
('Royal Canin', 900.00, 2),
('Whiskas', 600.00, 1),
('Orijen', 1500.00, 4);
