package com.dbh.service;

import com.dbh.entity.AppUser;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class GenericStoredProcedure {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public SimpleJdbcCall simpleJdbcCall(String procedureName) {
        return new SimpleJdbcCall(namedParameterJdbcTemplate.getJdbcTemplate())
                .withProcedureName(procedureName)
                .returningResultSet("result", new RowMapper<AppUser>() {
            @Override
            public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                AppUser appUser = new AppUser();
                appUser.setId(rs.getLong("id"));
                appUser.setName(rs.getString("name"));
                appUser.setEmail(rs.getString("email"));
                appUser.setHobby(rs.getString("hobby"));
                return appUser;
            }
        });
    }
}
