package org.example.cicd.cicd_demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CicdDemoAppIT {
    
    @Autowired private WebTestClient webTestClient;
    @Container
    static PostgreSQLContainer database = new PostgreSQLContainer("postgres:12")
                                                .withDatabaseName("springboot")
                                                .withPassword("springboot")
                                                .withUsername("springboot");

    @DynamicPropertySource
    static void setDataSourceProperties(DynamicPropertyRegistry propertyRegistry){
        propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
        propertyRegistry.add("spring.datasource.password", database::getPassword);
        propertyRegistry.add("spring.datasource.username", database::getUsername);
    }

  @Test
  void shouldReturnThreeDefaultUser() {
    this.webTestClient
        .get()
        .uri("/api/users")
        .exchange()
        .expectStatus()
        .isOk()
        .expectBody()
        .jsonPath("$.length()")
        .isEqualTo(3);
  }
}
