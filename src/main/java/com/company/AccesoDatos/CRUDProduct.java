package com.company.AccesoDatos;

import com.company.Main;
import com.company.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDProduct implements CRUDProductInterface{

    String login = "andres5";
    String password = "andres12345A_";
    String url = "jdbc:mysql://localhost:3306/productos?allowPublicKeyRetrieval=true&useUnicode=true&characterEncoding=utf8&useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, login, password);
    }

    public void insert(Product product) {
        Connection conn = null;

        try {
            conn = connection();

            if (conn != null) {
                System.out.println("Connexion a base de dates ... Ok");
                Statement sta = conn.createStatement();
                sta.executeUpdate("INSERT INTO producto (namePro,descriptPro,pricePro)"+" VALUES ('"+product.getNamePro()+"','"+product.getDescriptPro()+"',"+product.getPricePro()+")");
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    public List<Product> readAll(){
        Connection conn = null;
        List<Product> products = new ArrayList<>();

        try {
            conn = connection();

            if (conn != null) {
                System.out.println("Conexión a base de datos ... Ok");
                Statement sta = conn.createStatement();
                ResultSet result = sta.executeQuery("SELECT * FROM producto");
                while(result.next()){
                    Product product = new Product(result.getInt("idPro"),result.getString("namePro"), result.getString("descriptPro"), result.getDouble("pricePro"));
                    products.add(product);
                }
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }

        return products;
    }

    public Product readById(int id){
        Connection connection = null;

        try {
            connection = connection();

            if (connection != null) {
                System.out.println("Conexión a base de datos ... Ok");
                Statement sta = connection.createStatement();
                ResultSet result = sta.executeQuery("SELECT * FROM producto where idPro=\""+id+"\"");
                result.next();
                Product product = new Product(result.getInt("idPro"), result.getString("namePro"), result.getString("descriptPro"), result.getDouble("pricePro"));
                connection.close();
                return product;
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
        return new Product("Vacio");
    }
    public void updateById(Product product, int id){
        Connection conn = null;

        try {
            conn = connection();

            if (conn != null) {
                System.out.println("Connexion a base de dates ... Ok");
                String query = "update producto set namePro = '"+product.getNamePro()+"', descriptPro = '"+product.getDescriptPro()+"', pricePro = '"+product.getPricePro()+"' where idPro= '"+id+"'";
                Statement sta = conn.createStatement();
                sta.executeUpdate(query);
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
    public void deleteById(int id){
        Connection conn = null;

        try {
            conn = connection();

            if (conn != null) {
                System.out.println("Connexion a base de dates ... Ok");
                String query = "delete from producto where idPro= '"+id+"'";
                Statement sta = conn.createStatement();
                sta.executeUpdate(query);
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    public void deleteAllINFOonTABLE(){
        try {
            Connection conn = connection();

            if (conn != null) {
                System.out.println("Connexion a base de dates ... Ok");
                Statement sta = conn.createStatement();
                sta.executeUpdate("DELETE FROM Productos");
                conn.close();
            }
        } catch(SQLException ex) {
            System.out.println(ex);
        }
    }
}
