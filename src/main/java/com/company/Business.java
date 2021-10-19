package com.company;

import com.company.AccesoDatos.CRUDProduct;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Business {
    private final CRUDProduct crudProduct = new CRUDProduct();
    private final Product product = new Product();

    //VERSION TERMINAL
    /*public void doSomething() {
        CRUDProduct crudProduct = new CRUDProduct();

        while (true) {
            Operations.options();
            Scanner scanner = new Scanner(System.in);
            System.out.print("Select the option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    //INSERT
                    addProduct();
                    System.out.println("Operation finished!!!");
                    break;
                case 2:
                    //READ ALL
                    listProduct();
                    System.out.println("Operation finished!!!");
                    break;
                case 3:
                    //READ BY ID
                    searchProduct();
                    System.out.println("Operation finished!!!");
                    break;
                case 4:
                    //UPDATE ID
                    System.out.print("Select the ID of the product: ");
                    int optionIDUpdate = scanner.nextInt();
                    System.out.println("NEW PRODUCT... ");
                    Product product = new Product();
                    Product newProduct = product.createProduct();
                    crudProduct.updateById(newProduct, optionIDUpdate);
                    System.out.println("Operation finished!!!");
                    break;
                case 5:
                    //DELETE ID
                    System.out.print("Select the ID of the product: ");
                    int optionIDDelete = scanner.nextInt();
                    crudProduct.deleteById(optionIDDelete);
                    System.out.println("Operation finished!!!");
                    break;
                case 6:
                    //DELETE ALL
                    restartCataleg();
                    System.out.println("Operation finished!!!");
                    break;
            }
        }
    }*/

    public void listProduct(){
        ArrayList<Product> productsArray = (ArrayList<Product>) crudProduct.readAll();
        for (Product products : productsArray) {
            System.out.println(products);
        }
    }
    public void addProduct(){
        Product newProduct = product.createProduct();
        crudProduct.insert(newProduct);
    }
    public void restartCataleg() {
        crudProduct.deleteAllINFOonTABLE();
    }
    public void searchProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select the ID of the product: ");
        int optionIDRead = scanner.nextInt();
        Product product1 = crudProduct.readById(optionIDRead);
        if (Objects.equals(product1.getNamePro(), "Vacio") && product1.getIdPro() == 0) {
            System.out.println("The ID selected doesnt exit!!");
        } else {
            System.out.println(crudProduct.readById(optionIDRead));
        }
    }

    public void updateProduct(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select the ID of the product: ");
        int optionIDUpdate = scanner.nextInt();
        System.out.println("NEW PRODUCT... ");
        Product product = new Product();
        Product newProduct = product.createProduct();
        crudProduct.updateById(newProduct, optionIDUpdate);
    }
}
