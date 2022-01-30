package unibook.unibookExample.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import unibook.unibookExample.entity.Class;
import unibook.unibookExample.entity.Student;
import unibook.unibookExample.repository.ClassRepository;

import java.util.HashSet;
import java.util.List;

@Configuration
public class ClassConfiguration {

    @Bean
    CommandLineRunner commandLineRunner(ClassRepository classRepository) {
        return args -> {
            Class class1 = new Class("School 4", new HashSet<>());
            Class class2 = new Class("School 5", new HashSet<>());
            Class class3 = new Class("School 7", new HashSet<>());
            classRepository.saveAll(List.of(class1, class2, class3));
        };
    }

}
