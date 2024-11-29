
package com.redberyl.ordermanagemnt.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "users")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Schema(description = "Username of the User", example = "Saurabh")
    @NotEmpty(message = "Username cannot be null or empty")
    private String username;

    @Schema(description = "Email address of the User", example = "saurabh@gmail.com")
    @NotEmpty(message = "Email address cannot be null or empty")
    @Email(message = "Email address should be valid")
    @Column(nullable = false, unique = true)
    private String email;

    @Schema(description = "Mobile Number of the User", example = "9345432123")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    @NotEmpty(message = "Mobile Number cannot be null or empty")
    private String mobile;

    @NotEmpty(message = "Password cannot be null or empty")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Column(nullable = false)
    private String password;
}
