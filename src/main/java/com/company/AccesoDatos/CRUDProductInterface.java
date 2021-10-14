package com.company.AccesoDatos;

import com.company.Product;

import java.sql.SQLException;
import java.util.List;

public interface CRUDProductInterface {

    void insert(Product product);
    List readAll();
    Product readById(int id);
    void updateById(Product product, int id);
    void deleteById(int id);
    void deleteAllINFOonTABLE();

}
