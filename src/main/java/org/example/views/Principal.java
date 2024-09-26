package org.example.views;

import org.example.JdbcUtil;
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

        table1.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        String[] headers = {"id","title","platform","year","description"};
        tableModel = new DefaultTableModel(headers,0);
        table1.setModel(tableModel);

        // Eventos de componentes

        cargarDatosButton.addActionListener( (ActionEvent e) -> doButton(e) );
    }

    private void doButton(ActionEvent e) {
        var dao = new GameDAO(JdbcUtil.getConnection());
        var juegos = dao.findAll();
        tableModel.setRowCount(0);
        for(Game g:juegos){
            tableModel.addRow(g.toArrayObj());
        }
    }
}
