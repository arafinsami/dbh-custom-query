package com.dbh.repository;

import com.dbh.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    //Method one
    //List<AppUser> findByHobby(String hobby);

    //Method Two
    /*@Query("select app from AppUser app where app.hobby= :hobby")
    List<AppUser> findByHobby(@Param("hobby") String hobby);*/

    //Method Three
    /*@Query(value = "select * from app_user where hobby= :hobby", nativeQuery = true)
    List<AppUser> findByHobby(@Param("hobby") String hobby);*/
}
