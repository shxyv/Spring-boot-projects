package unibook.unibookExample.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "classes")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @JsonBackReference
    @ManyToMany(mappedBy = "classes")
    Set<Student> students;


    public Class(String name) {
        this.name = name;
    }

    public Class(String name, Set<Student> students) {
        this.name = name;
        this.students = students;
    }
}
