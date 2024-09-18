package org.example.cicd.cicd_demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
//@AllArgsConstructor
@Getter
@Setter
@Entity
public class ApplicationUser {
    
    @Id @GeneratedValue
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    public ApplicationUser(String name){
        this.name = name;
    }

}
