package com.app.knowtes.model;

import com.app.knowtes.utils.Patterns;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotBlank(message = "Username is requires")
    @Size(min = 3, max = 15, message = "Username must be between 3 and 15 characters")
    private String username;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters")
    @Pattern(regexp = Patterns.PASSWORD_REGEX,
            message = "Password must be 8-20 characters long, contain at least one" +
                    " uppercase letter, one lowercase letter, one digit, and one special" +
                    " character (@$!%*?&).")
    private String password;

    @NotBlank(message = "FirstName is required")
    @Pattern(
            regexp = Patterns.NAME_REGEX,
            message = "First name must only contain letters, hyphens, or spaces"
    )
    private String firstName;

    @NotBlank(message = "LastName is required")
    @Pattern(
            regexp = Patterns.NAME_REGEX,
            message = "Last name must only contain letters, hyphens, or spaces"
    )
    private String lastName;

}
