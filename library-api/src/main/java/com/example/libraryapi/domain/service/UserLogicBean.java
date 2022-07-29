package com.example.libraryapi.domain.service;

import com.example.libraryapi.infrastructure.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component

public class UserLogicBean {

// A Spring Data JPA repo

    private final BookRepository repo;

    public UserLogicBean(BookRepository repo) {
        this.repo = repo;
    }

    public boolean hasPermission(String username, PermissionEntity permission) {

        return retrieveUserPermissions(username).contains(permission);

    }

    @Transactional(readOnly = true)

    public List<PermissionEntity> retrieveUserPermissions(String username) {

        return repo.findByUsername(username).getPermissions();

    }

}