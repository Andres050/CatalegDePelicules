package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.Random;

public class Main {

    public static Product[] listProduct;
    static String login = "andres5";
    static String password = "andres12345A_";
    static String url = "jdbc:mysql://localhost:3306/productos?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public static void main(String[] args) throws SQLException {
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
        Connection conn = null;

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            conn = DriverManager.getConnection(url,login,password);

            if (conn != null)
            {
                System.out.println("Conexión a base de datos "+url+" ... Ok");
                usarConn(conn);
                conn.close();
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex);
        }
        catch(ClassNotFoundException | InstantiationException | IllegalAccessException ex)
        {
            System.out.println(ex);
        }
    }

    public static void usarConn(Connection conn) throws SQLException {
        Statement sta = conn.createStatement();
        ResultSet result = sta.executeQuery("SELECT * FROM producto");
        while(result.next()){
            Product product = new Product(result.getInt("idPro"), result.getString("namePro"), result.getString("descriptPro"), result.getDouble("pricePro"));
            System.out.println(product.toString());
        }
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
