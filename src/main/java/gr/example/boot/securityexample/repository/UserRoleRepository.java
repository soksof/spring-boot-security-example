package gr.example.boot.securityexample.repository;

import gr.example.boot.securityexample.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    UserRole findByRole(String role);
}
