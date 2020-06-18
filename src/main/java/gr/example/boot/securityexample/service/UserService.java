package gr.example.boot.securityexample.service;

import gr.example.boot.securityexample.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(User user);
    Optional<User> findByEmail(String email);
    boolean userExists(String email);
    Optional<User> findByName(String name);
    int getLoggedInUserId();
    boolean isAdmin();
    User findById(int id);
    void delete(User user);
    void deleteById(int userId);
    List<User> findAll();
}
