package gr.example.boot.securityexample.repository;

import gr.example.boot.securityexample.model.User;
import gr.example.boot.securityexample.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    Optional<User> findByName(String name);
    List<User> findByRole(UserRole role);
}
