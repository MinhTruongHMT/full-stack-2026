package com.howtojava.demo.cruddemo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;


@Schema(description = "Thông tin tạo mới sinh viên")
public class StudentCreateDTO {
    @Schema(
            description = "Tên",
            example = "Truong",
            required = true
    )
    @NotBlank
    private String firstName;

    @Schema(
            description = "Họ",
            example = "Tran",
            required = true
    )
    @NotBlank
    private String lastName;

    @Schema(
            description = "Email",
            example = "truong@gmail.com",
            required = true
    )
    @Email
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
