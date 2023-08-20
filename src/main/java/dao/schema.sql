
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


 
 
 CREATE TABLE IF NOT EXISTS Product (
     ProductId varchar unique,
     Name varchar(50) not null,
     Description varchar(100) not null,
     Category varchar(50) not null,
     ListPrice numeric(6,2) not null,
     QuantityInStock integer not null,
     constraint Product_PK primary key (ProductId)
 );
