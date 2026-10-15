package com.springboot.helpdesk.service;

import com.springboot.helpdesk.dto.request.ExecutiveDto;
import com.springboot.helpdesk.enums.Role;
import com.springboot.helpdesk.mapper.ExecutiveMapper;
import com.springboot.helpdesk.model.Executive;
import com.springboot.helpdesk.model.Manager;
import com.springboot.helpdesk.model.User;
import com.springboot.helpdesk.repository.ExecutiveRepository;
import com.springboot.helpdesk.repository.ManagerRepository;
import com.springboot.helpdesk.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExecutiveService {
    private final ExecutiveRepository executiveRepository;
    private final UserRepository userRepository;
    private final ManagerRepository managerRepository;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public Executive add(@Valid ExecutiveDto executiveDto, String managerUsername) {
        // Step 0: Fetch manager from DB using managerUsername
        Manager manager =  managerRepository.getByUsername(managerUsername);


        // Step 1: Prepare User object and save it in DB
        /*
        Executive
            User user <-- User must go in DB first and then Executive next
        * */
        User user = userService.getUserObj(  // <-- this is a full created user obj with id
                executiveDto.username(),
                executiveDto.password(),
                Role.EXECUTIVE
        );

        // Step 1.5 Encode password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        // Step Map ExecutiveDto to Executive entity

        Executive executive= ExecutiveMapper.mapToDto(executiveDto);

        // Step 3: Attach the Manager & User to Executive
        executive.setManager(manager);
        executive.setUser(user);

        // Step 4: Save executive and return
        return  executiveRepository.save(executive);
    }
}
