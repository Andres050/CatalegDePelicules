package com.company;

import com.company.AccesoDatos.CRUDProduct;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Grafic extends JFrame{
    private JButton INSERTARProductButton;
    private JButton LEERAllButton;
    private JButton LEEROnlyIDButton;
    private JButton UPDATEProductButton;
    private JButton DELETEProductOnlyIDButton;
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTable table1;
    private JTextField textField4;
    private JTextField textField5;
    private JButton DELETEALLTABLEButton;
    private JTextField textField6;
    private JTextField textFieldUserName;
    private JTextField textFieldPassword;
    private JTextField textFieldDataBase;
    private JTextField textFieldTable;
    private JButton GETTABLEButton;

    private final Business business = new Business();
    private final CRUDProduct crudProduct = new CRUDProduct();

    public Grafic(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.setSize(1000, 400);
        this.pack();

        table1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        table1.setEnabled(true);
        table1.getTableHeader().setReorderingAllowed(false);

        INSERTARProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                crudProduct.insert(createProductGUI());
                JOptionPane.showMessageDialog(null, "Operation finished!!!");
            }
        });
        LEERAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.listProduct(newModel());
                JOptionPane.showMessageDialog(null, "Operation finished!!!");
            }
        });
        LEEROnlyIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.searchProduct(textField4, newModel());
                JOptionPane.showMessageDialog(null, "Operation finished!!!");
            }
        });
        UPDATEProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.updateProduct(textField6, newModel(), createProductGUI());
                JOptionPane.showMessageDialog(null, "Operation finished!!!");
            }
        });
        //NO TERMINADO DESDE AQUI
        DELETEProductOnlyIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.deleteID(textField5);
                JOptionPane.showMessageDialog(null, "Operation finished!!!");
            }
        });
        DELETEALLTABLEButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int confirmado = JOptionPane.showConfirmDialog(
                        null,
                        "¿Lo confirmas?");
                if (JOptionPane.OK_OPTION == confirmado) {
                    business.restartCataleg();
                }
                JOptionPane.showMessageDialog(null, "Operation finished!!!");
            }
        });
    }

    public DefaultTableModel newModel() {
        DefaultTableModel model;
        model = new DefaultTableModel();
        table1.setModel(model);
        model.addColumn("ID Product");
        model.addColumn("Name Product");
        model.addColumn("Description");
        model.addColumn("Price");
        //model.addRow(new Object[]{"ID Product", "Name Product", "Description", "Price"});
        return model;
    }

    public Product createProductGUI(){
        String name = "", descript = "";
        double price = 0;
        if (Product.isString(textField1.getText(), 30)) {
            name = textField1.getText();
        }
        if (Product.isString(textField2.getText(), 50)) {
            descript = textField2.getText();
        }
        try {
            Double.parseDouble(textField3.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Price is not a number!!");
            return new Product();
        }
        price = Product.isDouble(textField3.getText());

        return new Product(name,descript,price);
    }
}
