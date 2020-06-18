package gr.example.boot.securityexample.service;

import gr.example.boot.securityexample.model.User;
import gr.example.boot.securityexample.repository.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean userExists(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        return user != null;    }

    @Override
    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public int getLoggedInUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal() instanceof gr.example.boot.securityexample.model.User) {
            return ((User) authentication.getPrincipal()).getId();
        }
        return -1;
    }

    @Override
    public boolean isAdmin() {
        UserDetails details = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return details.getAuthorities().contains(new SimpleGrantedAuthority("ADMIN"));
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(User user) {
        this.userRepository.delete(user);
    }

    @Override
    public void deleteById(int id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }
}
