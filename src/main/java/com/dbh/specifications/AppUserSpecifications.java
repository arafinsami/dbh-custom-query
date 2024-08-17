package com.dbh.specifications;

import com.dbh.entity.AppUser;
import org.springframework.data.jpa.domain.Specification;

public class AppUserSpecifications {

    public static Specification<AppUser> hasHobby(String hobby) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("hobby"), hobby);
    }
}
