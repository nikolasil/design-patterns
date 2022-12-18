package com.example.designpatterns.builder;

import org.springframework.stereotype.Component;

@Component
public class BuilderPattern {
    public void example0(){
        User basicUser = new User.Director()
                .makeBasicUser()
                .firstName("Alexis")
                .lastName("Panousis")
                .age(18)
                .build();
        System.out.println("Basic " + basicUser);

        User intermediateUser = new User.Director()
                .makeIntermediateUser()
                .firstName("Alexis")
                .lastName("Panousis")
                .age(18)
                .build();
        System.out.println("Intermediate " + intermediateUser);

        User adminUser = new User.Director()
                .makeAdminUser()
                .firstName("Alexis")
                .lastName("Panousis")
                .age(18)
                .build();
        System.out.println("Admin " + adminUser);
    }

    public void example1(){
        User.Director.Builder builder = new User.Director.Builder()
                .firstName("Alexis")
                .lastName("Panousis")
                .age(18);

        User basicUser = new User.Director(builder)
                .makeBasicUser()
                .build();
        System.out.println("Basic " + basicUser);

        User intermediateUser = new User.Director(builder)
                .makeIntermediateUser()
                .build();
        System.out.println("Intermediate " + intermediateUser);

        User adminUser = new User.Director(builder)
                .makeAdminUser()
                .build();
        System.out.println("Admin " + adminUser);
    }
}
