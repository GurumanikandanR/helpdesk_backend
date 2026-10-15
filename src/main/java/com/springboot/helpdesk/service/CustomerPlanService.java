package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.CustomerPlanDto;
import com.springboot.helpdesk.dto.response.PlanInfoDto;
import com.springboot.helpdesk.exception.ResourceNotFoundException;
import com.springboot.helpdesk.mapper.CustomerPlanMapper;
import com.springboot.helpdesk.model.Customer;
import com.springboot.helpdesk.model.CustomerPlan;
import com.springboot.helpdesk.model.Plan;
import com.springboot.helpdesk.repository.CustomerPlanRepository;
import com.springboot.helpdesk.repository.CustomerRepository;
import com.springboot.helpdesk.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerPlanService {
    private final CustomerPlanRepository customerPlanRepository;
    private final CustomerRepository customerRepository;
    private final PlanRepository planRepository;

    public void addCustomerPlan(CustomerPlanDto customerPlanDto,Long customerId,Long planId) {

        Optional<Customer> optional=customerRepository.findById(customerId);
        if(optional.isEmpty())
            throw new ResourceNotFoundException("Customer Id Not Valid");
        Customer customer=optional.get();

        Optional<Plan> optional1=planRepository.findById(planId);
        if(optional1.isEmpty())
            throw new ResourceNotFoundException("Customer Id Not Valid");
        Plan plan=optional1.get();


        CustomerPlan customerPlan= CustomerPlanMapper.convertDtoToEntity(customerPlanDto);

        customerPlan.setCustomer(customer);
        customerPlan.setPlan(plan);

        customerPlanRepository.save(customerPlan);
    }

    public List<PlanInfoDto> fetchPlansByCustomerUsername(String customerUsername) {

        return customerPlanRepository.fetchPlansByCustomerUsername(customerUsername);
    }
}
