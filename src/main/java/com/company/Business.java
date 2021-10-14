package com.company;

import com.company.AccesoDatos.CRUDProduct;
import com.company.AccesoDatos.CRUDProductInterface;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Business implements BusinessInterface{
    private final CRUDProduct crudProduct = new CRUDProduct();

    public void listProduct(){

    }
    public void addProduct(){
        //Mirar si la pelicula no esta la añadimos
    }
    public void restartCataleg() {
        crudProduct.deleteAllINFOonTABLE();
    }
    public void searchProduct(){

    }
}
