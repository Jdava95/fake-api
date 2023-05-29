package com.example.fakeapi.configurations;

import com.example.fakeapi.DTO.User;
import com.example.fakeapi.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository) {
        return args -> {
            User javid = new User("Javid", "511100Ss!",LocalDate.of(2019, Month.AUGUST, 19));
            User jamil = new User("Jamil", "RichestMan", LocalDate.of(2017, Month.MAY, 10));

            repository.saveAll(
                    List.of(javid, jamil)
            );
        };
    }
}
