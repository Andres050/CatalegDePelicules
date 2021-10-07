package com.company.AccesoDatos;

import com.company.Product;

import java.sql.SQLException;

public interface CRUDProductInterface {

    void insert(Product product);
    void realAll();
    void readById(int id);
    void updateById(Product product, int id);
    void deleteById(int id);

}
