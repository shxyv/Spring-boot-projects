package unibook.unibookExample.config;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import unibook.unibookExample.entity.Class;
import unibook.unibookExample.entity.Student;
import unibook.unibookExample.repository.StudentRepository;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;


@Configuration
public class StudentConfiguration {

    @Bean
    CommandLineRunner commandLineRunner2(StudentRepository studentRepository){
        return args -> {

            Student student1=new Student("Ilgar",18,LocalDate.of(2003, 5, 3)
                    , new HashSet<>(),new HashSet<>());

            Student student2=new Student("Nazim",19,LocalDate.of(2002,2,3)
                    ,new HashSet<>(),new HashSet<>());

            Student student3=new Student("Senan",20,LocalDate.of(2002,2,23)
                    ,new HashSet<>(),new HashSet<>());
            studentRepository.saveAll(List.of(student1,student2,student3));
        };
    }
}
