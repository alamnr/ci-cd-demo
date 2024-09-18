package org.example.cicd.cicd_demo;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserInitializaer implements CommandLineRunner {

    private final ApplicationUserRepository applicationUserRepository;
    private Logger logger = LoggerFactory.getLogger(ApplicationUserInitializaer.class);

    public ApplicationUserInitializaer(ApplicationUserRepository applicationUserRepository)
    {
        this.applicationUserRepository = applicationUserRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        applicationUserRepository.saveAll(
            List.of(new ApplicationUser("duke"),new ApplicationUser("github"),new ApplicationUser("action"))            
        );
        logger.info("Successfully initialized default application user");
    }
    
}
