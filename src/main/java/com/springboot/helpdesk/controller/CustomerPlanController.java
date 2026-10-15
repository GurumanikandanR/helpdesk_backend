package com.springboot.helpdesk.controller;

import com.springboot.helpdesk.dto.request.CustomerPlanDto;
import com.springboot.helpdesk.dto.response.PlanInfoDto;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.Plan;
import com.springboot.helpdesk.service.CustomerPlanService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerPlanController {
    private final CustomerPlanService customerPlanService;

    //API to add customer buys plan record in customer_plan table with all relevant fields
    @PostMapping("/api/CustomerPlan/add/{customerId}/{planId}")
    public void addCustomerPlan(@RequestBody CustomerPlanDto customerPlanDto, @PathVariable Long customerId, @PathVariable Long planId){
        customerPlanService.addCustomerPlan(customerPlanDto,customerId,planId);
    }

    /*
     * GET API : to fetch all plans based on customer username.
     * */
    @GetMapping("/api/CustomerPlan/plans/{customerUsername}")
    public List<PlanInfoDto> fetchPlansByCustomerUsername(@PathVariable String customerUsername){
        return customerPlanService.fetchPlansByCustomerUsername(customerUsername);

    }

}
