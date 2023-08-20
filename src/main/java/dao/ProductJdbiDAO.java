/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Customer;
import domain.Product;
import java.util.Collection;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

/**
 *
 * @author dyrellumiwes
 */
public interface ProductJdbiDAO extends ProductDAO{

    @Override
    @SqlQuery("select * from Product where ProductId = :productId")
    @RegisterBeanMapper(Product.class)
    public Product searchById(String id);

    @Override
    @SqlUpdate("insert into Product(ProductId, Name, Description, Category, ListPrice, QuantityInStock) values(:productId,:name,:description,:category,:listPrice,:quantityInStock)")
    public void saveProduct(@BindBean Product product);
//
//    
//         ProductId varchar unique,
//     name varchar(50) not null,
//     Description varchar(100) not null,
//     Category varchar(50) not null,
//     ListPrice numeric(6,2) not null,
//     QuantityInStock integer not null,
//     constraint Product_PK primary key (ProductId)
//    
    
//              this.productId = productId;
//		this.name = name;
//		this.description = description;
//		this.category = category;
//		this.listPrice = listPrice;
//		this.quantityInStock = quantityInStock;
    @Override
    @SqlUpdate("delete from Product where ProductId = :productId")
    public void removeProduct(@BindBean Product product);

    @Override
    @SqlQuery("select * from Product")
    @RegisterBeanMapper(Product.class) 
    public Collection<Product> getProducts();

    @Override
    @SqlQuery("select Category from Product")
    public Collection<String> getCategories();

    @Override
    @SqlQuery("select * from Product where Category = :category")
    @RegisterBeanMapper(Product.class) 
    public Collection<Product> filterByCategory(@Bind("category")String category);
   
}
    