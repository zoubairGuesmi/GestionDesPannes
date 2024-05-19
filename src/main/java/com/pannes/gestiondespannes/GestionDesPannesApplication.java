package com.pannes.gestiondespannes;

import com.pannes.gestiondespannes.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = "com.pannes.gestiondespannes")
public class GestionDesPannesApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionDesPannesApplication.class, args);
    }

    @Bean
    CommandLineRunner init(PatientRepository patientRepository) {
        return args -> {
//            userRepository.save(User.builder()
//                            .id(null)
//                            .nom("ameni")
//                            .prenom("guesmi")
//                            .email("ameni@gmail.com")
//                            .password("12384")
//                    .build());

            patientRepository.findAll().forEach(patient ->
                    System.out.println(patient.getNom()));
        };
    }

}
