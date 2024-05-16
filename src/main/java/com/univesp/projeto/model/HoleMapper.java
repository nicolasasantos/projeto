package com.univesp.projeto.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoleMapper implements RowMapper<Hole> {

    @Override
    public Hole mapRow(ResultSet rs, int rowNum) throws SQLException {

        return new Hole(rs.getLong("id"),
                rs.getString("name"),
                rs.getDate("date"),
                rs.getString("latitude"),
                rs.getString("longitude"),
                rs.getString("obs"),
                rs.getBoolean("fixed"),
                rs.getString("foto_id"));
    }
}
