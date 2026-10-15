package com.springboot.helpdesk.dto.response;

import com.springboot.helpdesk.enums.PlanType;

import java.time.LocalDate;

public record PlanInfoDto(
        String CustomeruserName,
        PlanType planType,
        double price,
        double amountPaid,
        LocalDate endDate
) {
}
