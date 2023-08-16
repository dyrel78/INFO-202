
CREATE TABLE IF NOT EXISTS Customer (
    CustomerID integer AUTO_INCREMENT (1000) unique,
    Username varchar(50) not null unique,
    FirstName varchar(50) not null,
    Surname varchar(50) not null,
    EmailAddress varchar(100) not null,
    ShippingAddress varchar(100) not null,
    Password varchar(50) not null,
    constraint Customer_PK primary key (customerID)    
);


-- 
-- 
-- CREATE TABLE IF NOT EXISTS Product (
--     productID varchar unique,
--     name varchar(50) not null,
--     description varchar(100) not null,
--     category varchar(50) not null,
--     listPrice numeric(6,2) not null,
--     quantityInStock integer not null,
--     constraint Product_PK primary key (productID)
-- );
