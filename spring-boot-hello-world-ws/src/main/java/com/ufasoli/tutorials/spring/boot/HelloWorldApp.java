package com.ufasoli.tutorials.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.vaadin.spring.EnableVaadin;

/**
 * Created with IntelliJ IDEA.
 * User: Ulises Fasoli
 * Date: 04.02.14
 * Time: 11:39
 *
 */
@ComponentScan // spring standard component scan
// spring boot autoconfiguration will bootstrap your Spring
//application while attempting to configure the beans you need
// it will also bootstrap an in-memory database if a driver is found
// in the classpath and no datasource is defined
@EnableAutoConfiguration
@EnableJpaRepositories
//@EnableVaadin
public class HelloWorldApp {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(HelloWorldApp.class, args);

    }
}
