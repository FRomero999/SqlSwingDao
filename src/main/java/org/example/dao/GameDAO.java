package org.example.dao;

import org.example.JdbcUtil;
import org.example.models.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements DAO<Game>{
    @Override
    public List<Game> findAll() {
        var salida = new ArrayList<Game>();

        try {
            var st = JdbcUtil.getConnection().createStatement();
            ResultSet rs = st.executeQuery("select * from games");
            while (rs.next()) {
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setTitle(rs.getString("title"));
                game.setDescription(rs.getString("description"));
                game.setYear(rs.getInt("year"));
                game.setPlatform(rs.getString("platform"));
                salida.add(game);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return salida;
    }
}
