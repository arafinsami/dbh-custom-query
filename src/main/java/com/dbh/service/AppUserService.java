package com.dbh.service;

import com.dbh.entity.AppUser;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppUserService {

    //private final AppUserRepository appUserRepository;

    private final EntityManager entityManager;

    private final NamedParameterJdbcTemplate parameterJdbcTemplate;

    private final JdbcTemplate jdbcTemplate;

    /*@Transactional(readOnly = true)
    public List<AppUser> findAll(String hobby) {
        return appUserRepository.findByHobby(hobby);
    }*/

    //Method Four
    /*@Transactional(readOnly = true)
    public List<AppUser> findAll(String hobby) {
        String sql = "select app from AppUser app where app.hobby = :hobby";
        TypedQuery<AppUser> query = entityManager.createQuery(sql, AppUser.class);
        query.setParameter("hobby", hobby);
        return query.getResultList();
    }*/

    //Method Five
    /*@Transactional(readOnly = true)
    public List<AppUser> findAll(String hobby) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<AppUser> criteriaQuery = criteriaBuilder.createQuery(AppUser.class);
        Root<AppUser> root = criteriaQuery.from(AppUser.class);
        Predicate predicate = criteriaBuilder.equal(root.get("hobby"), hobby);
        criteriaQuery.where(predicate);
        TypedQuery<AppUser> typedQuery = entityManager.createQuery(criteriaQuery);
        return typedQuery.getResultList();
    }*/

    //Method Six
    /*@Transactional(readOnly = true)
    public List<AppUser> findAll(String hobby) {
        String sql = "select * from app_user where hobby = :hobby";
        Map<String, Object> params = Map.of("hobby", hobby);
        return parameterJdbcTemplate.query(sql, params, new AppUserMapper());
    }

    private static class AppUserMapper implements RowMapper<AppUser> {
        @Override
        public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            AppUser appUser = new AppUser();
            appUser.setId(rs.getLong("id"));
            appUser.setName(rs.getString("name"));
            appUser.setEmail(rs.getString("email"));
            appUser.setHobby(rs.getString("hobby"));
            return appUser;
        }
    }*/

    //Method Seven
    @Transactional(readOnly = true)
    public List<AppUser> findAll(String hobby) {
        String sql = "select * from app_user where hobby= ?";
        return jdbcTemplate.query(sql, new Object[]{hobby}, new AppUserMapper());
    }

    private static class AppUserMapper implements RowMapper<AppUser> {
        @Override
        public AppUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            AppUser appUser = new AppUser();
            appUser.setId(rs.getLong("id"));
            appUser.setName(rs.getString("name"));
            appUser.setEmail(rs.getString("email"));
            appUser.setHobby(rs.getString("hobby"));
            return appUser;
        }
    }
}
