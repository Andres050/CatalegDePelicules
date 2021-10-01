package com.company;

import java.util.Random;

public class Main {

    public static Product[] listProduct;

    public static void main(String[] args) {
        Product productOnlyName = new Product("PlayStation 4");
        Product productOnlyId = new Product("Nintendo Switch");
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
    }

    public static void addProduct (Product product) {
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i] == null) {
                product.setIdPro(i);
                listProduct[i] = product;
                return;
            }
        }
    }

    public static Product getProductWithID (int idPro) {
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i].getIdPro() == idPro) {
                return listProduct[i];
            }
        }
        return null;
    }

    public static void changeProductWithID (int idPro) {

    }

    public static void deleteProductWithID (int idPro){

    }

    public static void showList () {
        for (int i = 0; i < listProduct.length; i++) {
            if (listProduct[i] != null) {
                System.out.println(i + " " + listProduct[i]);
            } else {
                System.out.println(i + " " + "PRODUCT NOT EXIST");
            }
        }
    }
}
