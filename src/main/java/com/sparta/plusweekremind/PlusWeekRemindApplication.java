package com.sparta.plusweekremind;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PlusWeekRemindApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlusWeekRemindApplication.class, args);
    }

}
