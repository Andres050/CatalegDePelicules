package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grafic extends JFrame{
    private JButton INSERTARProductButton;
    private JButton LEERAllButton;
    private JButton LEEROnlyIDButton;
    private JButton UPDATEProductButton;
    private JButton DELETEProductOnlyIDButton;
    private JPanel mainPanel;

    private Business business = new Business();

    public Grafic(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        INSERTARProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.addProduct();
                JOptionPane.showMessageDialog(null,"Operation finished!!!");
            }
        });
        LEERAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.listProduct();
                JOptionPane.showMessageDialog(null,"Operation finished!!!");
            }
        });
        LEEROnlyIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.searchProduct();
                JOptionPane.showMessageDialog(null,"Operation finished!!!");
            }
        });
        UPDATEProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.updateProduct();
                JOptionPane.showMessageDialog(null,"Operation finished!!!");
            }
        });
        DELETEProductOnlyIDButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                business.restartCataleg();
                JOptionPane.showMessageDialog(null,"Operation finished!!!");
            }
        });
    }
}
