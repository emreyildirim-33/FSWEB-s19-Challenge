package com.example.fswebs19challenge.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;

    @NotBlank(message = "İsim alanı boş bırakılamaz!")
    @Column(name = "full_name")
    private String fullName;

    @NotBlank(message = "Email alanı boş bırakılamaz!")
    @Email(message = "Lütfen geçerli bir email giriniz!")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Şifre boş bırakılamaz!")
    @Size(min = 6, message = "Şifre en az 6 karakter olmalıdır!")
    private String password;
}
