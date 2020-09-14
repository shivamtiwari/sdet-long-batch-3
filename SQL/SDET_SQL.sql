create database QA_activities;
 
 use QA_activities;
 
 -- Create table
create table salesman(
salesman_id int primary key,
name varchar(20),
city varchar(20),
commission int
); 


-- Insert data
insert into salesman values 
(5001, 'James Hoog', 'New York', 15),
(5002, 'Nail Knite', 'Paris', 13),
(5005, 'Pit Alex', 'London', 11),
(5006, 'McLyon', 'Paris', 14),
(5007, 'Paul Adam', 'Rome', 13),
(5003, 'Lauson Hen', 'San Jose', 12);

-- View Data
SELECT * FROM salesman;

describe salesman;

-- Show data from the salesman_id and city columns
select salesman_id, city from salesman;

-- Show data of salesman from Paris
select * from salesman where city='Paris';

-- Show salesman_id and commission of Paul Adam
select salesman_id,commission from salesman where name='Paul Adam';

-- Add new column
alter table salesman add grade1 int;

-- update values in grade column
update salesman set grade1=200 where name='Paul Adam';

-- display data
select * from salesman;


select * from salesman;
-- Update the grade score of salesmen from Rome to 200
update salesman set grade=200 where salesman_id='5003';

-- Update the grade score of James Hoog to 300
update salesman set grade=300 where name='James Hoog';

-- Update the name McLyon to Pierre
update salesman set name='Pierre' where name='McLyon';

-- Create a table named orders
create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

-- Add values to the table
insert into orders values
(70001, 150.5, '2012-10-05', 3005, 5002), (70009, 270.65, '2012-09-10', 3001, 5005),
(70002, 65.26, '2012-10-05', 3002, 5001), (70004, 110.5, '2012-08-17', 3009, 5003),
(70007, 948.5, '2012-09-10', 3005, 5002), (70005, 2400.6, '2012-07-27', 3007, 5001),
(70008, 5760, '2012-08-15', 3002, 5001), (70010, 1983.43, '2012-10-10', 3004, 5006),
(70003, 2480.4, '2012-10-10', 3009, 5003), (70012, 250.45, '2012-06-27', 3008, 5002),
(70011, 75.29, '2012-08-17', 3003, 5007), (70013, 3045.6, '2012-04-25', 3002, 5001);

select * from orders;
 
-- Get all salesman ids without any repeated values
select distinct salesman_id from orders;

-- Display the order number ordered by date in ascending order
select order_no from orders order by order_date ASC;

-- Display the order number ordered by purchase amount in descending order
select order_no from orders order by purchase_amount DESC;

-- Display the full data of orders that have purchase amount less than 500.
select * from orders where purchase_amount <500;

-- Display the full data of orders that have purchase amount between 1000 and 2000.
select * from orders where purchase_amount between 1000 and 2000;

select * from orders;
-- statement to find the total purchase amount of all orders.
select sum(purchase_amount) as 'Total' from orders;

-- statement to find the average purchase amount of all orders.
select avg(purchase_amount) as 'Average' from orders;

-- statement to get the maximum purchase amount of all the orders.
select max(purchase_amount) as 'Maximum' from orders;

-- statement to get the minimum purchase amount of all the orders.
select min(purchase_amount) as 'Minimum' from orders;

-- statement to find the number of salesmen listed in the table.
select Count(distinct salesman_id) as 'Number of Salesman' from orders;

select * from orders;

-- find the highest purchase amount ordered by the each customer with their ID and highest purchase amount
select customer_id, max(purchase_amount) as 'Highest Purchase Amount' from orders group by customer_id;

-- find the highest purchase amount on '2012-08-17' for each salesman with their ID
select salesman_id, order_date, max(purchase_amount) as 'Highest Purchase Amount' from orders 
where order_date='2012-08-17' group by salesman_id, order_date;

-- find the highest purchase amount with their ID and order date, for only those customers who have a higher purchase amount within the list [2030, 3450, 5760, 6000].
select customer_id, order_date, max(purchase_amount) as 'Maximum order' from orders 
group by customer_id, order_date
having max(purchase_amount) in (2030, 3450, 5760, 6000);

-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
insert into customers values 
(3002, 'Nick Rimando', 'New York', 100, 5001), (3007, 'Brad Davis', 'New York', 200, 5001),
(3005, 'Graham Zusi', 'California', 200, 5002), (3008, 'Julian Green', 'London', 300, 5002),
(3004, 'Fabian Johnson', 'Paris', 300, 5006), (3009, 'Geoff Cameron', 'Berlin', 100, 5003),
(3003, 'Jozy Altidor', 'Moscow', 200, 5007), (3001, 'Brad Guzan', 'London', 300, 5005);

-- select query
select * from customers;
select* from salesman;
-- SQL statement to know which salesman are working for which customer
select c.customer_name as "Customer Name", c.city as "City", s.name as "Salesman Name", s.commission as "Commission" 
from customers c inner join salesman s
on c.salesman_id = s.salesman_id;

-- Make a list in ascending order for the customer who holds a grade less than 300 and works either through a salesman
select c.customer_name as "Customer Name", c.grade as "Grade", s.name as "Salesman Name"
from customers c left join salesman s
on c.salesman_id= s.salesman_id
where c.grade < 300 order by c.customer_id;

-- Find the list of customers who appointed a salesman for their jobs who gets a commission from the company is more than 12%
select c.customer_name as "Customer Name", c.city as "City", s.name as "Salesman Name", s.commission as "Commission"
from customers c right join salesman s
on c.salesman_id = s.salesman_id
where s.commission >12; 

-- Find the details of a order i.e. order number, order date, amount of order, which customer gives the order
-- and which salesman works for that customer and commission rate he gets for an order
select * from orders;
select o.order_no as "OrderNo", o.order_date as "OrderDate", o.purchase_amount as "OrderAmount",
c.customer_name as "CustomerName", s.name as "SalesmanName", s.commission as "Commission"
from orders o 
inner join customers c on o.customer_id = c.customer_id
inner join salesman s on o.salesman_id = s.salesman_id;