package gr.example.boot.securityexample.service;

import gr.example.boot.securityexample.model.UserRole;
import gr.example.boot.securityexample.repository.UserRoleRepository;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    public UserRoleServiceImpl(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRole findByRole(String role) {
        return this.userRoleRepository.findByRole(role);
    }
}
