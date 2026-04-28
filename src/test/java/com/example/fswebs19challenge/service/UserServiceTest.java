package com.example.fswebs19challenge.service;

import com.example.fswebs19challenge.entity.User;
import com.example.fswebs19challenge.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @Test
    void findById_ShouldReturnUser_WhenUserExists() {
        User mockUser = new User();
        mockUser.setId(1L);
        mockUser.setFullName("Yunus Emre");
        mockUser.setEmail("yunus@gmail.com");

        when(userRepository.findById(1L)).thenReturn(Optional.of(mockUser));

        User result = userService.findById(1L);

        assertNotNull(result);
        assertEquals("Yunus Emre", result.getFullName());
        assertEquals("yunus@gmail.com", result.getEmail());


        verify(userRepository).findById(1L);
    }


    @Test
    void save_ShouldEncodePasswordAndSaveUser_WhenEmailIsUnique() {

        User newUser = new User();
        newUser.setFullName("Kobe Bryant");
        newUser.setEmail("mamba@gmail.com");
        newUser.setPassword("123456");


        when(userRepository.findByEmail("mamba@gmail.com")).thenReturn(Optional.empty());


        when(passwordEncoder.encode("123456")).thenReturn("GIZLI_KOD_XYZ");


        when(userRepository.save(newUser)).thenReturn(newUser);


        User savedUser = userService.save(newUser);


        assertNotNull(savedUser);
        assertEquals("GIZLI_KOD_XYZ", savedUser.getPassword());


        verify(userRepository).findByEmail("mamba@gmail.com");
        verify(passwordEncoder).encode("123456");
        verify(userRepository).save(newUser);
    }
    }
