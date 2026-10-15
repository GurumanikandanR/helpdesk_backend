package com.springboot.helpdesk.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomerDto(
        //add validation annotations
        @NotBlank(message = "Name is required")
        @NotNull(message = "Name is required")
        String name,

        String city,
        @Email(message = "")
        String email,
        String username,
        String password
) {}