package com.example.fswebs19challenge.service;

import com.example.fswebs19challenge.entity.User;
import com.example.fswebs19challenge.repository.TweetRepository;
import com.example.fswebs19challenge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RuntimeException("Bu e-posta adresi zaten kullanımda!");
        }

        if (user.getFullName() == null || user.getEmail() == null) {
            throw new RuntimeException("Lütfen tüm alanları doldurun");
        }

        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Böyle bir kullanıcı bulunamadı! ID: " + id));
    }
}
