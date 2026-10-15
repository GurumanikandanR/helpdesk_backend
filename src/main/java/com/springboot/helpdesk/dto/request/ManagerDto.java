package com.springboot.helpdesk.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ManagerDto(
        @NotNull(message = "Name can't be null")
        @NotBlank(message = "Name can't be empty")
        String name,

        @NotNull(message = "Username can't be null")
        @NotBlank(message = "Username can't be empty")
        String username,

        @NotNull(message = "Password can't be null")
        @NotBlank(message = "Password can't be empty")
        String password
) {
}
