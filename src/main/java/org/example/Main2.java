package org.example;

import org.example.dao.DAO;
import org.example.dao.GameDAO;
import org.example.models.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main2 {

    public static void main(String[] args) {

        var dao = new GameDAO();
        dao.findAll().forEach(System.out::println);

    }

}
