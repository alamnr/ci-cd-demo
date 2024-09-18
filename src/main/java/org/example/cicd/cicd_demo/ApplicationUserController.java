package org.example.cicd.cicd_demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class ApplicationUserController {
    
    private final ApplicationUserRepository applicationUserRepository;

    public ApplicationUserController(ApplicationUserRepository applicationUserRepository){
        this.applicationUserRepository = applicationUserRepository;
    }

    @GetMapping
    public List<ApplicationUser> getAllUser(){
        return applicationUserRepository.findAll();
    }

}
