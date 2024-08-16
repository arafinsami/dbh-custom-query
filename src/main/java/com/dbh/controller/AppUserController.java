package com.dbh.controller;

import com.dbh.dto.AppUserHobbyDTO;
import com.dbh.entity.AppUser;
import com.dbh.service.AppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "users")
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping
    public ResponseEntity<List<AppUser>> findAll(@RequestBody AppUserHobbyDTO dto) {
        List<AppUser> appUsers = appUserService.findAll(dto.getHobby());
        return new ResponseEntity<>(appUsers, HttpStatus.OK);
    }
}
