package org.example.views;

import org.example.dao.GameDAO;
import org.example.models.Game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JTable table1;
    private JPanel panel1;
    private JButton cargarDatosButton;

    private DefaultTableModel tableModel;

    public Principal() {

        setTitle("Datos de juegos");
        setContentPane(panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600,400);
        setResizable(false);

        String[] headers = {"id","title","platform","year","description"};
        tableModel = new DefaultTableModel(headers,0);
        table1.setModel(tableModel);

        cargarDatosButton.addActionListener( (ActionEvent e)->{
            var dao = new GameDAO();
            var juegos = dao.findAll();
            tableModel.setRowCount(0);
            for(Game g:juegos){
                tableModel.addRow(new Object[]{
                   g.getId(),
                   g.getTitle(),
                   g.getPlatform(),
                   g.getYear(),
                   g.getDescription()
                });
            }

        });
    }
}
