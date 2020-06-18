package gr.example.boot.securityexample.service;

import gr.example.boot.securityexample.model.UserRole;

public interface UserRoleService {
    UserRole findByRole(String role);
}
