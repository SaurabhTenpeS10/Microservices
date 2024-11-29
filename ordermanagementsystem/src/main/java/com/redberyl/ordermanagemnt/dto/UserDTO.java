package com.redberyl.ordermanagemnt.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Email(message = "Invalid email format")
    private String email;

    @Pattern(regexp = "\\d{10}", message = "Mobile number must be 10 digits")
    private String mobile;
    
    @NotBlank(message = "Address cannot be blank")
    private String address;

}

