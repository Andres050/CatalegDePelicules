package com.company;

import com.company.AccesoDatos.CRUDProduct;

import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        CRUDProduct crudProduct = new CRUDProduct();
        //crudProduct.updateById(new Product("update","funciona bien suuu", 65), 3);
        //crudProduct.insert(new Product("Andres","Esta avanzando",100));
        System.out.println(crudProduct.readById(3));
        //crudProduct.deleteById(2);
        ArrayList<Product> products = (ArrayList<Product>) crudProduct.readAll();
        for (Product product : products) {
            System.out.println(product);
        }
        /*
        Product productOnlyName = new Product("PlayStation 4");
        Product productOnlyId = new Product("Nintendo Switch
        ");
        Product productWithAll = new Product("Amoung Us", "Una historia basada en hechos reales",5);

        System.out.println("ANTES: ");
        System.out.println(productOnlyName);
        System.out.println(" ");

        productOnlyName.setNamePro("PlayStation 5");

        System.out.println("DESPUES: ");
        System.out.println(productOnlyName);
        System.out.println(" ");

        System.out.println("SOLO PRECIO:");
        System.out.println(productWithAll.getPricePro());

        System.out.println("RESTO:");
        System.out.println(productOnlyId);
        System.out.println(productWithAll);

        System.out.println(" ");
        System.out.println("LISTA DE PRODUCTOS:");
        listProduct = new Product[10];

        addProduct(productWithAll);
        addProduct(productOnlyId);
        addProduct(productOnlyName);

        showList();

        Random random = new Random();
        int randomPosition = random.nextInt(10);
        System.out.println(" ");
        System.out.println("SHOW PRODUCT:"+randomPosition);
        System.out.println(getProductWithID(randomPosition));
         */
    }
}
