/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import domain.Product;
import java.util.Collection;

/**
 *
 * @author dyrellumiwes
 */
public interface ProductJdbiDAO extends ProductDAO{

    @Override
    public Product searchById(String id);

    @Override
    public void saveProduct(Product product);

    @Override
    public void removeProduct(Product product);

    @Override
    public Collection<Product> getProducts();

    @Override
    public Collection<String> getCategories();

    @Override
    public Collection<Product> filterByCategory(String category);
    
}
