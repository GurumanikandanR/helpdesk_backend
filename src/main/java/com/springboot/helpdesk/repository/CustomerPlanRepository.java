package com.springboot.helpdesk.repository;

import com.springboot.helpdesk.dto.response.PlanInfoDto;
import com.springboot.helpdesk.model.CustomerPlan;
import com.springboot.helpdesk.model.Plan;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerPlanRepository extends JpaRepository<CustomerPlan,Long> {

    @Query("""
    select new com.springboot.helpdesk.dto.response.PlanInfoDto(c.name,p.planType,p.price,cp.amountPaid,cp.endDate)
    from CustomerPlan cp
    Join cp.customer c
    Join cp.plan p
    where c.name=?1
""")
    List<PlanInfoDto> fetchPlansByCustomerUsername(String customerUsername);
}
