package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dto.RegisterDto;
import com.example.demo.model.User;

/**
 * The class is the main entry point for the Blog Portal Spring Boot
 * application. It initializes and runs the Spring Boot application.

 * @author Ashutosh Tigga.
 */
@SpringBootApplication
public class BlogPortalApplication {

  /**
   * The main method that starts the Spring Boot application.
   *
   *@param args array of string.
   */
  public static void main(final String[] args) {
    SpringApplication.run(BlogPortalApplication.class, args);
    User user=new User();
    System.out.println(user.hashCode());
    System.out.println(new RegisterDto().hashCode());
  }
}
