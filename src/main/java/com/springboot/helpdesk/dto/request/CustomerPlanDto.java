package com.springboot.helpdesk.dto.request;

import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.Plan;

import java.time.LocalDate;

public record CustomerPlanDto(
        LocalDate activationDate,
        LocalDate endDate,
        String coupon,
        double amountPaid
) {}
