package com.springboot.helpdesk.dto.request;

import com.springboot.helpdesk.enums.JobTitle;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ExecutiveDto(
        @NotBlank(message="Name is Required")
        @NotNull(message = "Name is Required")
        String name,

        @NotBlank(message = "Email is required")
        @NotNull(message = "Email is required")
        @Email(message = "Email is Invalid")
        String email,

        @NotBlank(message = "Contact is required")
        @NotNull(message = "Contact is required")
        @Size(min = 10, max = 10, message = "Contact should be 10 digit mobile number")
        String contact,

        @NotBlank
        @NotNull
        @Size(min = 3, max = 15)
        String username,

        @NotBlank
        @NotNull
        String password,
        JobTitle jobTitle
) {
}
